package org.example.db2md.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author example
 * @Date 2023/4/10 17:52
 * @PackageName:org.example.db2md.model
 * @ClassName: DbSchema
 * @Description: schema
 */
public class DbSchema {

    private String[] title = SchemaTitle.getSchemaTitle();
    private Map<TableInfo, List<SchemaRow>> schemas = new HashMap<>();

    public void put(TableInfo table, List<SchemaRow> schemaRows) {
        schemas.put(table, schemaRows);
    }

    public Map<TableInfo, List<SchemaRow>> getSchemas() {
        return schemas;
    }
}
