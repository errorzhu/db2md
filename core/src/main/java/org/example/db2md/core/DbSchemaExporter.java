package org.example.db2md.core;

import org.example.db2md.adaptor.AdaptorFactory;
import org.example.db2md.adaptor.DBAdaptor;
import org.example.db2md.core.writer.MdWriter;
import org.example.db2md.model.Db2MdParameters;
import org.example.db2md.model.DbSchema;

/**
 * @Author example
 * @Date 2023/4/10 16:42
 * @PackageName:org.example.db2md.core
 * @ClassName: DbSchemaExporter
 * @Description: get database schema
 */
public class DbSchemaExporter {

    private Db2MdParameters parameters;


    public DbSchemaExporter(Db2MdParameters parameters) {
        this.parameters = parameters;
    }

    public void export() throws Exception {
        DBAdaptor adaptor = AdaptorFactory.getInstance(parameters);
        DbSchema schema = null;
        adaptor.connect();
        schema = adaptor.getSchema();
        MdWriter writer = new MdWriter();
        writer.write(schema, parameters.getOutput());
        adaptor.close();
    }

}
