import read.ReadFiles;
import read.Read;
import write.WriteFiles;
import write.Write;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cavbleu
 * @project test_project_java
 * @create 2024-01-18 19:16
 */
public class MainClass {
    public static void main(String[] args) {
        System.out.println("Запущена программа фильтрации файлов!");
        List<String> data = new ArrayList<>();
//        Парсинг аргументов
        Parser parser = new Parser(args);
//        Получение имен файлов
        ReadFiles readFiles = new Read();
        if (!parser.getIsEmpty())
        for (String filename : parser.getData())
            data = readFiles.ReadDATA(filename);
        else
            data = readFiles.ReadAllDATA();
//      Парсинг данных из файлов
        DifinitionType difinitionType = new DifinitionType(data);
        difinitionType.printStatistic(parser.isStatS(), parser.isStatF());
//        Вывод информации
        WriteFiles writeFiles = new Write(parser.getPath(), parser.getPrefix());
        writeFiles.write("integer", difinitionType.getTextInt(), parser.getReWrite());
        writeFiles.write("float", difinitionType.getTextFloat(), parser.getReWrite());
        writeFiles.write("string", difinitionType.getTextString(), parser.getReWrite());

        System.out.println("Программа выполнела свою работу");
    }



}
