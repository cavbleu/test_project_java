import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

/**
 * @author cavbleu
 * @project test_project_java
 * @create 2024-01-19 20:27
 */
public class CheckValid {
    public static boolean checkValidPath (String path)
    {
        try {
            Paths.get(path);
        } catch (InvalidPathException | NullPointerException ex) {
            return false;
        }
        return true;
    }

    public static boolean checkValidPrefix(String prfx)
    {
        String regex = "^[a-zA-Z0-9._ -]+";
        if (prfx.matches(regex))
            return true;
        else
            return false;
    }

    public static boolean checkFilename(String filename)
    {
        String regex = "^[a-zA-Z0-9._ -]+\\.(txt)$";
        if (filename.matches(regex))
            return true;
        else
            return false;
    }

    private boolean checkOutPath(String uri)
    {
        try
        {
            Paths.get(uri);
            return true;
        }
        catch (InvalidPathException ex) {
            return false;
        }
    }
}
