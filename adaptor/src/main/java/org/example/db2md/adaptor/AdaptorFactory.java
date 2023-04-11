package org.example.db2md.adaptor;

import org.example.db2md.adaptor.impl.MySQLAdaptor;
import org.example.db2md.model.Db2MdParameters;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author example
 * @Date 2023/4/10 15:58
 * @PackageName:org.example.db2md.adaptor
 * @ClassName: AdaptorFactory
 * @Description: get adaptor instance by config
 */
public class AdaptorFactory {


    private static Map<String, Class> adaptors = new HashMap() {{
        put("mysql", MySQLAdaptor.class);
    }};

    public static DBAdaptor getInstance(Db2MdParameters parameters) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        if (adaptors.containsKey(parameters.getType())) {
            DBAdaptor dbAdaptor = (DBAdaptor) adaptors.get(parameters.getType()).getConstructor(Db2MdParameters.class)
                    .newInstance(parameters);
            return dbAdaptor;

        } else {
            throw new IllegalArgumentException("不支持的数据库类型");
        }

    }
}
