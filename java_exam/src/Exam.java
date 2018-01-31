
import java.util.Scanner;

public class Exam {
    public static void main(String[] args) {
        //반지름의 길이를 입력받아 넓이를 출력하는 프로그램 01/31
        //사용자가 입력한 숫자를 저장하는 변수
        int num1;
        //사용자로 키보드 입력준비
        Scanner kb = new Scanner(System.in);
        // 사용자로부터 숫자 입력
        System.out.println("반지름을 입력하세요.");
        num1 = kb.nextInt();

        System.out.println("원의넓이는 ?");
        System.out.println(area(num1));

    }
//01.31 순서도 area()함수 프로그램
    public static double area(int radian){
        //반지름*반지름을 저장할 변수
        double temp;
        //원주율을 저장할 변수
        double result;

        temp= multi(radian, radian);
        result = multi(temp, 3.14);
        //result = radian*radian*3.14
        return result;
    }

//   01.30 순서도 area() 함수 프로그램
//    public static double area(int radian){
//        double temp;
//        double result;
//
//        result = radian*radian*3.14;
//        return result;
//    }

    public static double multi(double num1, double num2){
        double result;
        //곱셈연산 실행
        result = num1 * num2;
        //곱셈한 결과 값을 리턴(도출)
        return result;
    }
}


