import com.sun.javafx.css.Size;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static int time=120;
    public static Scanner inputNumber = new Scanner(System.in);
    public static void main(String[] agrs) {
        testframe f=new testframe();
    }

    static class testframe extends JFrame{


        int number;
        int result;
        String[] timu=new String[5];
        String error;
        String[] errorId=new String[5];
        int[] daan=new int[5];
        int d1,d2,d3,d4,d5;
        Long timec;

        int tnumber;
        JLabel aa=new JLabel("题目：");
        JLabel bb=new JLabel("题目数量：");
        JLabel cc=new JLabel("做对的题目数：");
        JLabel T1=new JLabel("");
        JLabel T2=new JLabel("");
        JLabel T3=new JLabel("");
        JLabel T4=new JLabel("");
        JLabel T5=new JLabel("");
        JLabel time=new JLabel("所用时间:");
        JTextField K1=new JTextField(8);
        JTextField K2=new JTextField(8);
        JTextField K3=new JTextField(8);
        JTextField K4=new JTextField(8);
        JTextField K5=new JTextField(8);
        JTextArea K6=new JTextArea(20,300);
        JTextField Tnum=new JTextField(8);
        JButton starButton=new JButton("开始");
        JButton endButton=new JButton("确认");
        JButton changButton=new JButton("改变颜色");

        JMenuBar jMenuBar=new JMenuBar();
        JMenu jMenu=new JMenu();

        JPanel p1=new JPanel();
        testframe(){
            this.setTitle("四则运算");
            this.setSize(800,800);
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.setVisible(true);
            this.setResizable(false);
            this.add(p1);
            aa.setFont(new Font("宋体",Font.BOLD,18));
            bb.setFont(new Font("宋体",Font.BOLD,18));
            cc.setFont(new Font("宋体",Font.BOLD,18));
            T1.setFont(new Font("宋体",Font.BOLD,18));
            T2.setFont(new Font("宋体",Font.BOLD,18));
            T3.setFont(new Font("宋体",Font.BOLD,18));
            T4.setFont(new Font("宋体",Font.BOLD,18));
            T5.setFont(new Font("宋体",Font.BOLD,18));
            time.setFont(new Font("宋体",Font.BOLD,20));
            starButton.setFont(new Font("宋体",Font.BOLD,20));
            endButton.setFont(new Font("宋体",Font.BOLD,20));
            changButton.setFont(new Font("宋体",Font.BOLD,15));
            p1.setLayout(null);
            aa.setBounds(50,50,150,150);
            bb.setBounds(50,20,150,150);
            cc.setBounds(50,500,150,80);
            cc.setForeground(Color.red);
            time.setBounds(80,20,600,80);
            time.setForeground(Color.red);
            //题目
            T1.setBounds(100,100,150,80);
            T2.setBounds(100,150,150,80);
            T3.setBounds(100,200,150,80);
            T4.setBounds(100,250,150,80);
            T5.setBounds(100,300,150,80);
            //按钮
            starButton.setBounds(100,400,100,30);
            endButton.setBounds(300,400,100,30);
            changButton.setBounds(500,400,100,30);
            //文本框
            K1.setBounds(300,130,100,30);
            K2.setBounds(300,180,100,30);
            K3.setBounds(300,230,100,30);
            K4.setBounds(300,280,100,30);
            K5.setBounds(300,330,100,30);
            K6.setBounds(200,450,300,300);
            Tnum.setBounds(300,80,100,30);
            //添加
            JScrollPane scrollPaneN=new JScrollPane(K6);
            K6.setLineWrap(true);
            add(scrollPaneN,BorderLayout.SOUTH);
            p1.add(aa);
            p1.add(bb);
            p1.add(cc);
            p1.add(time);
            p1.add(T1);
            p1.add(T2);
            p1.add(T3);
            p1.add(T4);
            p1.add(T5);
            p1.add(K1);
            p1.add(K2);
            p1.add(K3);
            p1.add(K4);
            p1.add(K5);
            p1.add(K6);
            p1.add(Tnum);
            p1.add(starButton);
            p1.add(endButton);
            p1.add(changButton);


            starButton.addActionListener(new B());
            endButton.addActionListener(new B());
            changButton.addActionListener(new B());
        }

        class B implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource()==starButton){
                    //点击开始按钮做的事情
                    Long startTime=System.currentTimeMillis();
                    timec=startTime;
                    tnumber=(int) Double.parseDouble(Tnum.getText());
                    if (tnumber>5||tnumber<1){
                        JOptionPane.showMessageDialog(null,"题目数量不能大于5或者等于0");
                    }else{
                        for (int i=0;i<tnumber;i++){
                            int num1=new Random().nextInt(100)+1;
                            int num2=new Random().nextInt(100)+1;
                            int num3=new Random().nextInt(100)+1;
                            int num4=new Random().nextInt(10)+1;
                            int operator1=new Random().nextInt(5)+1;
                            int operator2=new Random().nextInt(4)+1;
                            if (operator1==1)//加法
                            {
                                String a=num1+"+"+num2;
                                if (operator2==1){
                                    result=num1+num2+num3;
                                    a=a+"+"+num3+"=";
                                }
                                else if (operator2==2){
                                    result=num1+num2;
                                    while(result<num3){
                                        num3=new Random().nextInt(100)+1;
                                    }
                                    result=result-num3;
                                    a=a+"-"+num3+"=";
                                }
                                else if (operator2==3){
                                    result=num2*num3;
                                    result=result+num1;
                                    a=a+"*"+num3+"=";
                                }
                                else if (operator2==4){
                                    result=num2/num3;
                                    result=result+num1;
                                    a=a+"/"+num3+"=";
                                }
                                daan[i]=result;
                                timu[i]=a;
                            }

                            if (operator1==2)//减法
                            {
                                if (operator2==1){
                                    result=num1-num2+num3;
                                    String a=num1+"-"+num2+"+"+num3+"=";
                                    timu[i]=a;
                                    daan[i]=result;
                                }
                                else if (operator2==2) {
                                    while ((num1-num2)<num3){
                                        num1=new Random().nextInt(100)+1;
                                        num2=new Random().nextInt(100)+1;
                                        num3=new Random().nextInt(100)+1;
                                    }
                                    result=num1-num2-num3;
                                    String a=num1+"-"+num2+"-"+num3+"=";
                                    //a=a+"-"+num3+"="+result;
                                    timu[i]=a;
                                    daan[i]=result;
                                }
                                else if (operator2==3){
                                    while (num1<(num2*num3)){
                                        num1=new Random().nextInt(100)+1;
                                        num2=new Random().nextInt(100)+1;
                                        num3=new Random().nextInt(100)+1;
                                    }
                                    result=num2*num3;
                                    result=num1-result;
                                    String a=num1+"-"+num2+"*"+num3+"=";
                                    //a=a+"*"+num3+"="+result;
                                    timu[i]=a;
                                    daan[i]=result;
                                }
                                else if (operator2==4){
                                    while (num1<(num2/num3)){
                                        num1=new Random().nextInt(100)+1;
                                        num2=new Random().nextInt(100)+1;
                                        num3=new Random().nextInt(100)+1;
                                    }
                                    result=num2/num3;
                                    result=num1-result;
                                    String a=num1+"-"+num2+"/"+num3+"=";
                                    //a=a+"/"+num3+"="+result;
                                    timu[i]=a;
                                    daan[i]=result;
                                }
                            }

                            if (operator1==3)//乘法
                            {
                                String a=num1+"*"+num2;
                                result=num1*num2;
                                if (operator2==1) {
                                    result=result+num3;
                                    a=a+"+"+num3+"=";
                                }
                                else if (operator2==2){
                                    while (result<num3){
                                        num3=new Random().nextInt(100)+1;
                                    }
                                    result=result-num3;
                                    a=a+"-"+num3+"=";
                                }
                                else if (operator2==3){
                                    result=result*num3;
                                    a=a+"*"+num3+"=";
                                }
                                else if (operator2==4){
                                    result=result/num3;
                                    a=a+"/"+num3+"=";
                                }
                                timu[i]=a;
                                daan[i]=result;
                            }
                            if (operator1==4)//除法
                            {
                                String a=num1+"/"+num2;
                                result=num1/num2;
                                if (operator2==1){
                                    result=result+num3;
                                    a=a+"+"+num3+"=";
                                }
                                else if (operator2==2){
                                    while (result<num3){
                                        num3=new Random().nextInt(100)+1;
                                    }
                                    result=result-num3;
                                    a=a+"-"+num3+"=";
                                }
                                else if (operator2==3){
                                    result=result*num3;
                                    a=a+"*"+num3+"=";
                                }
                                else if (operator2==4){
                                    result=result/num3;
                                    a=a+"/"+num3+"=";
                                }
                                timu[i]=a;
                                daan[i]=result;
                            }
                            if (operator1==5){
                                timu[i]=num4+"!=";
                                daan[i]= (int) factorial(num4);
                            }
                        }
                        T1.setText(timu[0]);
                        T2.setText(timu[1]);
                        T3.setText(timu[2]);
                        T4.setText(timu[3]);
                        T5.setText(timu[4]);
                    }
                }
                if (e.getSource()==endButton){
                    //点击确认按钮做的事情
                    Long endTime=System.currentTimeMillis();
                    long timeout=(endTime-timec)/1000;
                    time.setText("总共花费的时间为"+timeout+"s");
                    d1=(int) Double.parseDouble(K1.getText());
                    d2=(int) Double.parseDouble(K2.getText());
                    d3=(int) Double.parseDouble(K3.getText());
                    d4=(int) Double.parseDouble(K4.getText());
                    d5=(int) Double.parseDouble(K5.getText());
                    int answerT=0,answerF=0;
                    int count=0;
                    int errCount=0;
                    error="";
                    if (d1==daan[0]){
                        K1.setText(String.valueOf(daan[0]));
                        answerT++;
                        count++;
                    }else{
                        answerF++;
                        count++;
                        error=error+count+":"+timu[0]+daan[0]+"   \n";
                        errCount++;
                    }
                    if (d2==daan[1]){
                        K1.setText(String.valueOf(daan[1]));
                        answerT++;
                        count++;
                    }else{
                        answerF++;
                        count++;
                        error=error+count+":"+timu[1]+daan[1]+"   \n";
                        errCount++;
                    }
                    if (d3==daan[2]){
                        K1.setText(String.valueOf(daan[2]));
                        count++;
                        answerT++;
                    }else{
                        answerF++;
                        count++;
                        error=error+count+":"+timu[2]+daan[2]+"   \n";
                    }
                    if (d4==daan[3]){
                        K1.setText(String.valueOf(daan[3]));
                        count++;
                        answerT++;
                    }else{
                        answerF++;
                        count++;
                        error=error+count+":"+timu[3]+daan[3]+"   \n";
                    }
                    if (d5==daan[4]){
                        K1.setText(String.valueOf(daan[4]));
                        count++;
                        answerT++;
                    }else{
                        answerF++;
                        count++;
                        error=error+count+":"+timu[4]+daan[4]+"   \n";
                    }

                    K6.setText("你一共做对了"+String.valueOf(answerT)+"道题\n"+"错误题目如下 \n"+error);
                }
                if (e.getSource()==changButton){
                    //点击改变颜色按钮事件
                    int color=new Random().nextInt(5);
                    switch (color){
                        case 0:{
                            p1.setBackground(Color.orange);
                            break;
                        }
                        case 1:{
                            p1.setBackground(Color.BLUE);
                            break;
                        }
                        case 2:{
                            p1.setBackground(Color.green);
                            break;
                        }
                        case 3:{
                            p1.setBackground(Color.yellow);
                            break;
                        }
                        case 4:{
                            p1.setBackground(Color.pink);
                            break;
                        }
                    }
                }
            }
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
/*    public void time(){
        while (time>0){
            try {
                Thread.sleep(1000);
                time--;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }*/
}
