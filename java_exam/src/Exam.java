
import java.util.Scanner;

public class Exam {
    public static void main(String[] args) {
       System.out.println("프로그램의 시작");
       //메소드 실행(호출)방법
       hiEveryone(12);
       hiEveryone(13);
       System.out.println("프로그램의 끝");
    }
                                //매게변수(int age)
    public static void hiEveryone(int age){
        System.out.println("좋은 아침입니다");
        System.out.println("제 나이는"+ age+"세 입니다");
    }
}


