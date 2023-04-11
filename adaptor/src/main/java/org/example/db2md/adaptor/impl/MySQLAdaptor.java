package org.example.db2md.adaptor.impl;

import org.example.db2md.adaptor.AbstractAdaptor;
import org.example.db2md.adaptor.DBAdaptor;
import org.example.db2md.model.Db2MdParameters;
import org.example.db2md.model.DbSchema;
import org.example.db2md.model.SchemaRow;
import org.example.db2md.model.TableInfo;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author example
 * @Date 2023/4/10 15:59
 * @PackageName:org.example.db2md.adaptor.impl
 * @ClassName: MySQLAdaptor
 * @Description: mysql database adaptor
 */
public class MySQLAdaptor extends AbstractAdaptor implements DBAdaptor {

    // 查看数据库所有数据表SQL
    private String sqlTables = "SELECT `table_name`,`table_comment` FROM `information_schema`.`tables` WHERE `table_schema`=?";
    // 查看数据表列信息SQL
    private String sqlTableColumn = "SELECT `ORDINAL_POSITION`,`COLUMN_NAME`,`COLUMN_COMMENT`,`COLUMN_TYPE`,`COLUMN_KEY`,`IS_NULLABLE`,`EXTRA`,`COLUMN_DEFAULT` FROM `information_schema`.`columns` WHERE `table_schema`=? AND `table_name`=? ORDER BY `ORDINAL_POSITION` ASC";


    private String jdbcURLTemplate = "jdbc:mysql://%s:%s/%s?useUnicode=true;characterEncoding=UTF-8";
    private Connection connection = null;

    public MySQLAdaptor(Db2MdParameters parameters) {
        super(parameters);
    }

    @Override
    public void connect() throws SQLException {
        System.out.println("connecting to database ...");
        String jdbcURL = String.format(
                jdbcURLTemplate,
                this.parameters.getHost(),
                this.parameters.getPort(),
                this.parameters.getDatabase());
        connection = DriverManager.getConnection(jdbcURL, this.parameters.getUser(), this.parameters.getPassword());
    }

    @Override
    public void close() {
        if (this.connection != null) {
            try {
                this.connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private List<TableInfo> getTables() throws SQLException {
        List<TableInfo> tables = new LinkedList<>();
        PreparedStatement prepareStatement = connection.prepareStatement(sqlTables);
        prepareStatement.setString(1, this.parameters.getDatabase());
        ResultSet rs = prepareStatement.executeQuery();
        while (rs.next()) {
            tables.add(new TableInfo(rs.getString(1)));
        }
        return tables;

    }


    private List<SchemaRow> getSchemaRows(TableInfo tableInfo) throws Exception {
        System.out.printf("get schema from table: %s\n", tableInfo.getName());
        List<SchemaRow> schemaRows = new LinkedList<>();
        PreparedStatement prepareStatement = connection.prepareStatement(sqlTableColumn);
        prepareStatement.setString(1, this.parameters.getDatabase());
        prepareStatement.setString(2, tableInfo.getName());
        ResultSet rs = prepareStatement.executeQuery();
        while (rs.next()) {
            String sn = String.valueOf(rs.getInt(1));
            String name = rs.getString(2);
            String description = rs.getString(3);
            String type = rs.getString(4);
            String key = rs.getString(5);
            String isNull = rs.getString(6);
            String extra = rs.getString(7);
            String defaultValue = rs.getString(8);

            schemaRows.add(
                    new SchemaRow()
                            .sn(sn)
                            .name(name)
                            .description(description)
                            .type(type)
                            .key(key)
                            .isNull(isNull)
                            .extra(extra)
                            .defaultValue(defaultValue)
            );
        }
        return schemaRows;
    }

    @Override
    public DbSchema getSchema() throws Exception {
        DbSchema schema = new DbSchema();
        List<TableInfo> tables = getTables();
        for (TableInfo table : tables) {
            schema.put(table, getSchemaRows(table));
        }
        return schema;

    }


}
