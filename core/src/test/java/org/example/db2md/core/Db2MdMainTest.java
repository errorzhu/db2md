package org.example.db2md.core;

/**
 * @Author example
 * @Date 2023/4/10 16:28
 * @PackageName:org.example.db2md.core
 * @ClassName: Db2MdMainTest
 * @Description: test
 */
public class Db2MdMainTest {

    public static void main(String[] args) throws Exception {

        Db2MdMain.main(new String []{
                "--help"
        });



        Db2MdMain.main(new String []{
                "--host","192.168.1.1",
                "--port","3306",
                "--user","root",
                "--password","123456",
                "--database","mysql",
                "--type","mysql"
        });


    }

}
