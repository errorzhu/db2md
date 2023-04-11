package org.example.db2md.adaptor;

import org.example.db2md.model.DbSchema;

/**
 * @Author example
 * @Date 2023/4/10 15:57
 * @PackageName:org.example.db2md.adaptor
 * @ClassName: DBAdaptor
 * @Description: interface for database adaptor
 */
public interface DBAdaptor {
    void connect() throws Exception;

    void close();

    DbSchema getSchema() throws  Exception;
}
