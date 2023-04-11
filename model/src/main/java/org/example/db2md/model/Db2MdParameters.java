package org.example.db2md.model;

import com.beust.jcommander.Parameter;

/**
 * @Author example
 * @Date 2023/4/10 13:30
 * @PackageName:org.example.db2md.core.cli
 * @ClassName: Db2MdParameters
 * @Description: cli parameters
 */
public class Db2MdParameters {

    @Parameter(names = {"-h", "--help"}, description = "the usage of the db2md")
    private boolean help = false;

    @Parameter(names = {"-t", "--type"}, description = "the type of the database <mysql>")
    private String type;

    @Parameter(names = {"-H", "--host"}, description = "the host of the database")
    private String host;

    @Parameter(names = {"-P", "--port"}, description = "the port of the database")
    private int port;

    @Parameter(names = {"-d", "--database"}, description = "the name of the database ")
    private String database;

    @Parameter(names = {"-u", "--user"}, description = "the user of the database")
    private String user;

    @Parameter(names = {"-p", "--password"}, description = "the password of the database ")
    private String password;

    @Parameter(names = {"-o", "--output"}, description = "the directory of the output markdown file ")
    private String output = ".";

    public boolean isHelp() {
        return help;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getType() {
        return type;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getDatabase() {
        return database;
    }

    public String getOutput() {
        return output;
    }


    public void check() {
        if(isHelp()){
            return;
        }
        if(getType() == null){
            throw new IllegalArgumentException("以下选项是必须的: [-t | --type]");
        }
    }
}
