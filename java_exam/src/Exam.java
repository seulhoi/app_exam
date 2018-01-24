
import java.util.Scanner;

public class Exam {
    public static void main(String[] args) {
//break문
        int num = 2;

        while(num < 10){
               if (num%5==0){
                break;
                 }
            System.out.println(num);
            num++;
          }
        System.out.println("============================");
         
//continue문
        int num2 = 2;

        while(num2 < 10){
            if (num2%5==0){
                num2++;
                continue;
            }
            num2++;
            System.out.println(num2);

        }
    }
}


