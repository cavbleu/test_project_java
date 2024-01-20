import java.util.ArrayList;
import java.util.List;

/**
 * @author cavbleu
 * @project test_project_java
 * @create 2024-01-20 10:09
 */
public class Parser {
    private String _path = "";
    private String _prefix = "";
    private boolean statS = false, statF = false;

    private boolean rewrite = false;
    private List<String> dataList = new ArrayList<>();

    public Parser (String[] args) {

        int i = 0;
//        try {
            while (i < args.length) {
                switch (args[i]) {
                    case ("-o"): {
                        if (CheckValid.checkValidPath(args[i + 1])) {
                            System.out.println("Path valid");
                            this._path = args[i + 1];
                            i += 2;
                            break;
                        } else {
                            System.out.println("Path no valid \n Error args\n");
                            break;
                        }
                    }
                    case ("-p"): {
                        if (CheckValid.checkValidPrefix(args[i + 1])) {
                            System.out.println("Prifix valid");
                            this._prefix = args[i + 1];
                            i += 2;
                            break;
                        } else {
                            System.out.println("Prifix no valid \n Error args\n");
                            break;
                        }
                    }
                    case ("-s"): {
                        this.statS = true;
                        i++;
                        break;
                    }
                    case ("-f"): {
                        this.statF = true;
                        i++;
                        break;
                    }
                    case ("-a"): {
                        this.rewrite = true;
                        i++;
                        break;
                    }
                    case ("--help"): {
                        System.out.println("Справочная информация по аргументам\n" +
                                "\t -a \tПараметр добавления данных в существующие файлы\n" +
                                "\t -p prefix \tДобавляет префикс вначале к выводным данным\n" +
                                "\t -o <\\path\\>\tУказывает размещение выводных данных\n" +
                                "\t -s \tВыводит сокращенную версию собранных данных\n" +
                                "\t -f \tВыводит полную информацию по собранным данным\n");
                    }
                    default: {
                        if (CheckValid.checkFilename(args[i])) {
                            this.dataList.add(args[i]);
                            i++;
                            break;
                        } else {
                            System.out.println("Не  вверные параметры входных файлов");
                            i++;
                            break;
                        }
                    }
                }
            }
//        } catch (ArrayIndexOutOfBoundsException e) {
//            System.out.println("Конец выполнения программы");
//        }
    }

    public String getPath() {
        return _path;
    }

    public String getPrefix() {
        return _prefix;
    }

    public boolean isStatS() {
        return statS;
    }

    public boolean isStatF() {
        return statF;
    }

    public List<String> getData() {
        return dataList;
    }

    public boolean getReWrite() {
        return rewrite;
    }

    public boolean getIsEmpty()
    {
        return dataList.isEmpty();
    }
}
