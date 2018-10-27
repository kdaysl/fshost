import java.util.Random;
import java.util.Scanner;
import static java.lang.System.exit;
import static java.lang.System.out;
import static java.lang.System.setOut;
/*
* Encoded by kdaysl
* */
public class mass {
    public static boolean go=true;
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
    public static long time=0;
    public static int inResult = 0;
    public static int corResult = 0;
    public static long endTime=0;
    public static long startTime =System.currentTimeMillis();
    public static String[] errorSymbol=new String[30];
    public static Random random = new Random();
    public static Scanner inputNumber = new Scanner(System.in);
    public static void out(){
        out.print("一共答对了" + correct + "道题\n" + "其中错误的题和其正确答案为：\n");
        for (int m = 0; m < j; m++) {
            out.print(errorId[m] + ".  " + errorSymbol[m] + "  ");
            out.print("\n");
        }
    }
    public static void timeOut(){
        out.println("timeout 请确认");
        Scanner input = new Scanner(System.in);
        int qq=input.nextInt();
        out.print("一共答对了" + correct + "道题\n" + "其中错误的题和其正确答案为：\n");
        for (int m = 0; m < j; m++) {
            out.print(errorId[m] + ".  " + errorSymbol[m] + "  ");
            out.print("\n");
        }
    }
    public static  long factorial(int n){
        if (n==0){
            return 1;
        }
        else {
            long num=n * factorial(n-1);
            return num;
        }
    }
    public static void calculate(int i,int number){
        Scanner input = new Scanner(System.in);
        switch (sSymbol){
            case 0:{
                out.print(i + 1 + ".  " + front + "-" + back +"+"+end+ "=");
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
                out.print(i + 1 + ".  " + front + "-" + back +"-"+end+ "=");
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
                out.print(i + 1 + ".  " + front + "-" + back +"*"+end+ "=");
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
                out.print(i + 1 + ".  " + front + "-" + back +"/"+end+ "=");
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
            case 4:
            {
                out.print(i + 1 + ".  " + front + "!" + "=");
                inResult = input.nextInt();
                long count = factorial(front);
                if (inResult == count)
                    correct++;
                else {
                    errorSymbol[j] = ( front + "!" +  "="+count);
                    errorId[k] = i + 1;
                    j++;
                    k++;
                }
                break;
            }
        }
        long continuTime = System.currentTimeMillis();
        endTime=continuTime-startTime;
        time=endTime/1000;
        out.println("已花费时间"+time+'s');
        if(time>=120){
            timeOut();
            exit(0);
        }
        if (i==number-1){
            out.println("你本次答题花费的总时间为"+time+'s');
            out();
        }
    }
    public static void main(String[] agrs) {
        out.println("你有120s的时间作答");
        while (go) {
            out.println("请输入题目数：");
            int number = 0;
            number = inputNumber.nextInt();
            for (int i = 0; i < number; i++) {
                front = random.nextInt(100);
                back = random.nextInt(100);
                symbol = random.nextInt(5);
                switch (symbol) {
                    case 0:
                    {
                        sSymbol = random.nextInt(4);
                        end = random.nextInt(100);
                        calculate(i,number);
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
                        calculate(i,number);
                        break;
                    }
                    case 2:
                    {
                        sSymbol = random.nextInt(4);
                        end = random.nextInt(100);
                        calculate(i,number);
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
                        calculate(i,number);
                        break;
                    }
                    case 4:
                    {
                        if (front==0){
                            front=random.nextInt(9)+1;
                        }
                        else if (front>10){
                            front=random.nextInt(9)+1;
                        }
                        sSymbol=4;
                        calculate(i,number);
                    }
                }
            }
        }
    }
}
