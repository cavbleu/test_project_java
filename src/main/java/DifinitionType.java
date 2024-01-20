import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author cavbleu
 * @project test_project_java
 * @create 2024-01-18 21:17
 */
public class DifinitionType {
    private static String intRegex = "[0-9]+";
    private List<String> listString = new ArrayList<>();
    private List<Integer> listInt = new ArrayList<>();
    private List<Float> listFloat = new ArrayList<>();

    private int countData = 0;

    private int countInt = 0;
    private int countFloat = 0;
    private int countStr = 0;

    private int minInt = Integer.MAX_VALUE;
    private int maxInt = Integer.MIN_VALUE;
    private int sumInt = 0;
    private float avrInt = 0;

    private float minFloat = Float.MAX_VALUE;
    private float maxFloat = Float.MIN_VALUE;
    private float sumFloat = 0;
    private float avrFloat = 0;

    private int minlengthStr = Integer.MAX_VALUE;
    private int maxlengthStr = 0;

    public DifinitionType (List<String> list)
    {
        for (String s : list)
            difinitionSet(s);
        this.avrInt = (float) sumInt/countInt;
        this.avrFloat = sumFloat/countFloat;
    }

    public List<String> getListString() {
        return listString;
    }

    public List<Integer> getListInt() {
        return listInt;
    }

    public List<Float> getListFloat() {
        return listFloat;
    }

    public String getTextInt (){
        return listInt.stream().map(Object::toString)
                .collect(Collectors.joining("\n"));
    }

    public String getTextFloat (){
        return listFloat.stream().map(Object::toString)
                .collect(Collectors.joining("\n"));
    }

    public String getTextString (){
        return listString.stream().map(Object::toString)
                .collect(Collectors.joining("\n"));
    }
    public int getCountInt() {
        return countInt;
    }

    public int getCountFloat() {
        return countFloat;
    }

    public int getCountStr() {
        return countStr;
    }

    public int getMinInt() {
        return minInt;
    }

    public int getMaxInt() {
        return maxInt;
    }

    public int getSumInt() {
        return sumInt;
    }

    public float getAvrInt() {
        return avrInt;
    }

    public float getMinFloat() {
        return minFloat;
    }

    public float getMaxFloat() {
        return maxFloat;
    }

    public float getSumFloat() {
        return sumFloat;
    }

    public float getAvrFloat() {
        return avrFloat;
    }

    public int getMinlengthStr() {
        return minlengthStr;
    }

    public int getMaxlengthStr() {
        return maxlengthStr;
    }

    public int getCountData() {
        return countData;
    }

    private void difinitionSet(String s)
    {
        String s1 = s;
        try {
            if (s.toLowerCase().contains("e") || s.toLowerCase().contains(".") || s.toLowerCase().contains("E") ) {
                float f = Float.parseFloat(s1);
                this.listFloat.add(f);
                calcFloat(f);
                countFloat++;
                countData++;
            }
        else if (s1.matches(intRegex)){
            int num = Integer.parseInt(s1);
            this.listInt.add(num);
            calcInteger(num);
            countInt++;
            countData++;
            }
        }
        catch(NumberFormatException e) {
            this.listString.add(s1);
            calcString(s1);
            countStr++;
            countData++;
        }
    }

    private void calcString(String s)
    {
        int count = s.length();
        if (count > this.maxlengthStr)
            this.maxlengthStr = count;
        if (count < this.minlengthStr)
            this.minlengthStr = count;

    }

    private void calcInteger(int num)
    {
        if (num < this.minInt)
            this.minInt = num;
        if (num > this.maxInt)
            this.maxInt = num;
        this.sumInt += num;
    }

    private void calcFloat(float num)
    {
        if (num < this.minFloat)
            this.minFloat = num;
        if (num > this.maxFloat)
            this.maxFloat = num;
        this.sumFloat += num;
    }

    @Override
    public String toString() {
        return "DifinitionType{" +
                "countFloat=" + countFloat +
                ", countStr=" + countStr +
                ", minInt=" + minInt +
                ", maxInt=" + maxInt +
                ", sumInt=" + sumInt +
                '}';
    }

    public String statisticInt ()
    {
        return "Данные по типу INT:\n " +
                "\tвсего чисел: " + countInt +
                "\n\tмаксимальное число: " + maxInt +
                "\n\tминимальное число: " + minInt +
                "\n\tсумма чисел: " + sumInt +
                "\n\tсреднее по типу INT: " + avrInt + "\n";
    }

    public String statisticFloat ()
    {
        return "Данные по типу Float:\n " +
                "\tвсего чисел: " + countFloat +
                "\n\tмаксимальное число: " + maxFloat +
                "\n\tминимальное число: " + minFloat +
                "\n\tсумма чисел: " + sumFloat +
                "\n\tсреднее по типу Float: " + avrFloat + "\n";
    }

    public String statisticString ()
    {
        return "Данные по типу String:\n " +
                "\tвсего слов: " + countStr +
                "\n\tмаксимальная днина строки: " + maxlengthStr +
                "\n\tминимальная днина строки: " + minlengthStr + "\n";
    }

    public void printStatistic (boolean _s, boolean _f)
    {
        if (_s == true)
            System.out.printf("Всего данных записано: %s\n",  getCountData());
        if ((_f == true && _s==true) || (_f == true && _s==false))
            System.out.printf("Полная статистика данных:\n\tКол-во данных: %s\n%s%s%s\n",
                    getCountData(),
                    statisticInt(),
                    statisticFloat(),
                    statisticString());
    }

}
