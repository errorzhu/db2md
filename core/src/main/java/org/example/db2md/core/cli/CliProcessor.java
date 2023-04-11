package org.example.db2md.core.cli;

import com.beust.jcommander.JCommander;
import org.example.db2md.model.Db2MdParameters;

/**
 * @Author example
 * @Date 2023/4/10 13:31
 * @PackageName:org.example.db2md.core.cli
 * @ClassName: CliProcessor
 * @Description: parameter processor
 */
public class CliProcessor {

    private Db2MdParameters parameters = new Db2MdParameters();
    private JCommander commander = JCommander.newBuilder().addObject(parameters).build();


    public void usage(){
        commander.setProgramName("db2md");
        commander.usage();
    }

    public Db2MdParameters parse(String[] argv) {
        commander.parse(argv);
        return parameters;
    }
}
