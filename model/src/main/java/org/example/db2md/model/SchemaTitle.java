package org.example.db2md.model;

/**
 * @Author example
 * @Date 2023/4/10 17:13
 * @PackageName:org.example.db2md.model
 * @ClassName: SchemaTitle
 * @Description: TODO
 */
public class SchemaTitle {

    //| 序号 | 名称 | 描述 | 类型 | 键 | 为空 | 额外 | 默认值 |

    private static String SN = "序号";
    private static String name = "名称";
    private static String description = "描述";
    private static String type = "类型";
    private static String key = "键";
    private static String isNull = "为空";
    private static String extra = "额外";
    private static String defaultValue = "默认值";

    public static String[] getSchemaTitle() {
        return new String[]{SN, name, description, type, key, isNull, extra, defaultValue};
    }


}
