import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Scanner;

public class Exam {
    public static void main(String[] args) {

        //정상적으로 처리가 되면 try안에 구문이 처리되고 나눗셈이 정상적으로 수행되었다는 출력이 나옴
      try{
            int num1 = 10;
            int num2 = 0;

            double result = num1/num2;
            System.out.println("결과 :"+ result);
        }
        //try구문이 정상처리 되지 않았을경우 에러발생 출력
        catch(Exception e){
          System.out.println("안내: 에러발생!");
          e.printStackTrace();
      }


       System.out.println("프로그램이 정상적으로 수행되었습니다.");
      

    }
}