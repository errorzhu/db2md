package org.example.db2md.core.writer;

import org.example.db2md.model.DbSchema;
import org.example.db2md.model.SchemaRow;
import org.example.db2md.model.TableInfo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

/**
 * @Author example
 * @Date 2023/4/10 13:29
 * @PackageName:org.example.db2md.core.writer
 * @ClassName: MdWriter
 * @Description: markdown writer
 */
public class MdWriter {

    private Long index = 1l;
    private String header = "| 序号 | 名称 | 描述 | 类型 | 键 | 为空 | 额外 | 默认值 |";
    String rowSplitter = "| :--: | :--: | :--: | :--: | :--: | :--: | :--: | :--: |";


    public void write(DbSchema schema, String output) throws IOException {

        StringBuilder mdContent = new StringBuilder();

        for (Map.Entry<TableInfo, List<SchemaRow>> schemaEntry : schema.getSchemas().entrySet()) {

            TableInfo tableInfo = schemaEntry.getKey();
            String table = "## " + index + ". " + tableInfo.getName();
            mdContent.append(table);
            mdContent.append("\n");
            mdContent.append("\n");
            mdContent.append(header);
            mdContent.append("\n");
            mdContent.append(rowSplitter);
            mdContent.append("\n");
            List<SchemaRow> rows = schemaEntry.getValue();
            for (SchemaRow row : rows) {
                mdContent.append(
                        String.format("| %s | `%s` | %s | %s | %s | %s | %s | %s |",
                                row.getSN(),
                                row.getName(),
                                row.getDescription(),
                                row.getType(),
                                row.getKey(),
                                row.getIsNull(),
                                row.getExtra(),
                                row.getDefaultValue()
                        )
                );
                mdContent.append("\n");
            }
            mdContent.append("\n");

            index++;
        }

        File file = Paths.get(output, "tables.md").toFile();
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(mdContent.toString());
        bw.close();

    }
}
