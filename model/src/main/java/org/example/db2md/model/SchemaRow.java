package org.example.db2md.model;

/**
 * @Author example
 * @Date 2023/4/10 17:18
 * @PackageName:org.example.db2md.model
 * @ClassName: SchemaRow
 * @Description: a row of schema
 */
public class SchemaRow {
    private  String SN ;
    private  String name ;
    private  String description ;
    private  String type ;
    private  String key ;
    private  String isNull ;
    private  String extra ;
    private  String defaultValue ;


    public SchemaRow sn(String sn){
        this.SN = sn;
        return this;
    }
    public SchemaRow name(String name){
        this.name = name;
        return this;
    }
    public SchemaRow description(String description){
        this.description = description;
        return this;
    }

    public SchemaRow type(String type){
        this.type = type;
        return this;
    }

    public SchemaRow key(String key){
        this.key = key;
        return this;
    }

    public SchemaRow isNull(String isNull){
        this.isNull = isNull;
        return this;
    }

    public SchemaRow extra(String extra){
        this.extra = extra;
        return this;
    }

    public SchemaRow defaultValue(String defaultValue){
        this.defaultValue = defaultValue;
        return this;
    }

    public String getSN() {
        return SN;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public String getKey() {
        return key;
    }

    public String getIsNull() {
        return isNull;
    }

    public String getExtra() {
        return extra;
    }

    public String getDefaultValue() {
        return defaultValue;
    }
}
