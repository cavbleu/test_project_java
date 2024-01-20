package read;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author cavbleu
 * @project test_project_java
 * @create 2024-01-18 19:16
 */
public class Read implements ReadFiles{
    private static Charset charset = Charset.forName("UTF-8");

    private List<String> dataInFiles = new ArrayList<>();

    @Override
    public List<String> ReadAllDATA ()
    {
        try {
            SearchFiles();
        }
        catch (IOException e)
        {
            System.err.println("Ошибка ввода вывода\n\tВыполнение невозможно");
            return null;
        }
        return dataInFiles;
    }

    @Override
    public List<String> ReadDATA (String filename)
    {
        ReadTextInFiles(Paths.get(filename));
        return dataInFiles;
    }

    private void ReadTextInFiles(Path filename){
        try (BufferedReader reader = Files.newBufferedReader(filename, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty())
                this.dataInFiles.add(line);
//                System.out.println(line);
            }
        }
        catch (NoSuchFileException e) {
            System.err.println("Не существует файл\n" );
//            ReadAllDATA();
        }
        catch (IOException e)
        {
            System.err.println("Не существует файл\n" );
//            ReadAllDATA();
        }
    }

    @Override
    public void SearchFiles () throws IOException
    {
        Path path = Paths.get("");
        try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(path, "*.{txt}")) {
            for (Path entry : dirStream) {
//                System.out.printf("%-5s: %s%n", "entry", entry.getFileName());
                ReadTextInFiles(entry);
            }
        } catch (IOException e) {
            System.err.println("Ошибка ввода/вывода");
        }
    }


}
