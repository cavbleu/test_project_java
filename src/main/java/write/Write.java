package write;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;


/**
 * @author cavbleu
 * @project test_project_java
 * @create 2024-01-18 19:17
 */
public class Write implements WriteFiles{
    private String path = System.getProperty("user.dir"), prefix = "";
    public Write(String path, String prefix)
    {
        this.path += path;
        this.prefix = prefix;
    }

    private boolean checkPath(String path)
    {
        try
        {
            Paths.get(path);
            return true;
        }
        catch (InvalidPathException ex) {
            System.err.format("Директории не найдено");
            newDir(path);
            return false;
        }
    }
    @Override
    public void write(String name, String text, boolean rewrite) {
        if (!text.isEmpty()) {
            Path _path = Paths.get(path, prefix + name + ".txt");
            checkPath(path);
            try {
                FileWriter fileWriter = new FileWriter(_path.toString(),rewrite);
                fileWriter.write(text);
                fileWriter.write("\n");
                fileWriter.close();
            } catch (IOException e) {
                System.err.format("Ошибка ввода вывода: %s%n", e);
                e.printStackTrace();
            }
        }
        else
        {
            System.out.printf("Файл %.txt не на печатан, нечего записывать", name);
        }
    }
    private void newDir (String path)
    {
        File f = new File(path);
        if (f.mkdir()) {
            System.out.println("Создана новая директория по пути:\t" + path);
        }
        else {
            System.err.format("Не могу создать новую директорию");
        }
    }
}
