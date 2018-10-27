import java.util.Random;
import java.util.Scanner;

public class mass {
    public static int correct = 0;
    public static int front = 0;
    public static int back = 0;
    public static int end=0;
    public static int[] error = new int[30];
    public static int[] errorId = new int[30];
    public static int symbol;
    public static int sSymbol;
    public static int j = 0;
    public static int k = 0;
    public static int inResult = 0;
    public static int corResult = 0;
    public static int i =0;
    public static String[] errorSymbol=new String[30];
    public static Random random = new Random();
    public static Scanner inputNumber = new Scanner(System.in);
    public static void calculate(int i){
        Scanner input = new Scanner(System.in);
        switch (sSymbol){
            case 0:{
                System.out.print(i + 1 + ".  " + front + "-" + back +"+"+end+ "=");
                corResult = front - back +end;
                inResult = input.nextInt();
                if (inResult == corResult)
                    correct++;
                else {
                    errorSymbol[j] = ( front + "-" + back +"-"+end+ "="+corResult);
                    errorId[k] = i + 1;
                    j++;
                    k++;
                }
                break;
            }
            case 1:{
                System.out.print(i + 1 + ".  " + front + "-" + back +"-"+end+ "=");
                inResult = input.nextInt();
                corResult = front - back -end;
                if (inResult == corResult)
                    correct++;
                else {
                    errorSymbol[j] = ( front +  " - " + back +"-"+end+ "="+corResult);
                    errorId[k] = i + 1;
                    j++;
                    k++;
                }
                break;
            }
            case 2:{
                System.out.print(i + 1 + ".  " + front + "-" + back +"*"+end+ "=");
                inResult = input.nextInt();
                corResult = front - back *end;
                if (inResult == corResult)
                    correct++;
                else {
                    errorSymbol[j] = ( front + "-" + back +"*"+end+ "="+corResult);
                    errorId[k] = i + 1;
                    j++;
                    k++;
                }
                break;
            }
            case 3:{
                if (end == 0) {
                    end = random.nextInt(100);
                }
                while ((front + back)% end != 0) {
                    front = random.nextInt(100);
                    back = random.nextInt(100);
                    end = random.nextInt(99) + 1;
                }
                System.out.print(i + 1 + ".  " + front + "-" + back +"/"+end+ "=");
                inResult = input.nextInt();
                corResult = front - back / end;
                if (inResult == corResult)
                    correct++;
                else {
                    errorSymbol[j] = ( front + "-" + back +"/"+end+ "="+corResult);
                    errorId[k] = i + 1;
                    j++;
                    k++;
                }
                break;
            }
        }
    }
    public static void main(String[] agrs) {
        while (true) {
            System.out.println("请输入题目数：");
            int number = 0;
            number = inputNumber.nextInt();
            for (int i = 0; i < number; i++) {
                front = random.nextInt(100);
                back = random.nextInt(100);
                symbol = random.nextInt(4);
                switch (symbol) {
                    case 0:
                    {
                        sSymbol = random.nextInt(4);
                        end = random.nextInt(100);
                        calculate(i);
                        break;
                    }
                    case 1:
                    {
                        while (front < back) {
                            front = random.nextInt(100);
                            back = random.nextInt(100);
                        }
                        sSymbol = random.nextInt(4);
                        end = random.nextInt(100);
                        calculate(i);
                        break;
                    }
                    case 2:
                    {
                        sSymbol = random.nextInt(4);
                        end = random.nextInt(100);
                        calculate(i);
                        break;
                    }
                    case 3:
                    {
                        if (back == 0) {
                            back = random.nextInt(99) + 1;
                        }
                        while (front % back != 0) {
                            front = random.nextInt(100);
                            back = random.nextInt(99) + 1;
                        }
                        sSymbol = random.nextInt(4);
                        end = random.nextInt(100);
                        calculate(i);
                        break;
                    }
                }
            }
            System.out.print("一共答对了" + correct + "道题\n" + "其中错误的题和其正确答案为：\n");
            for (int m = 0; m < j; m++) {
                System.out.print(errorId[m] + ".  " + errorSymbol[m] + "  ");
                System.out.print("\n");
            }
        }
    }
}
