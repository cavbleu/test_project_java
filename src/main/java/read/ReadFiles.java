package read;

import java.io.IOException;
import java.util.List;

/**
 * @author cavbleu
 * @project test_project_java
 * @create 2024-01-18 19:17
 */
public interface ReadFiles {

    public List<String> ReadDATA (String name);
    public List<String> ReadAllDATA();
    public void SearchFiles () throws IOException;
}
