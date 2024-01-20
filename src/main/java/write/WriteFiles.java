package write;

import java.nio.file.Path;

/**
 * @author cavbleu
 * @project test_project_java
 * @create 2024-01-18 19:18
 */
public interface WriteFiles {
    public void write(String name, String text, boolean rewrite);
}
