package org.example.db2md.core;

import org.example.db2md.core.cli.CliProcessor;
import org.example.db2md.model.Db2MdParameters;

/**
 * @Author example
 * @Date 2023/4/10 11:54
 * @PackageName:org.example.db2md.core
 * @ClassName: Db2MdMain
 * @Description: main
 */
public class Db2MdMain {


    public static void main(String[] args) throws Exception {

        CliProcessor cliProcessor = new CliProcessor();
        Db2MdParameters parameters = null;

        try {
            parameters = cliProcessor.parse(args);
        } catch (Exception ex) {
            System.out.println("参数输入错误,请参考帮助:");
            cliProcessor.usage();
            System.exit(1);
        }

        if (parameters != null) {
            parameters.check();
        }else{
            System.exit(1);
        }


        if (parameters.isHelp()) {
            cliProcessor.usage();
            System.exit(0);
        }

        DbSchemaExporter exporter = new DbSchemaExporter(parameters);

        exporter.export();


    }

}
