package dashboard.java.introduction;

import java.util.Scanner;

public class StdinStdout {

    public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            System.out.println("================================");
            for(int i=0;i<3;i++)
            {
                String s1=sc.next();
                int x=sc.nextInt();
                Object[] arg = {s1,x};
                System.out.printf("%-15s%03d", arg);
            }
            System.out.println("================================");
            sc.close();
    }
}