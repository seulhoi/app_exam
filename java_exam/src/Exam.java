
import java.util.Scanner;

public class Exam {
    public static void main(String[] args) {
    //사용자가 입력한 숫자를 저장하는 변수
       double num1;
       double num2;

       String operator;

       //사용자 키보드 입력준비
       Scanner kb = new Scanner(System.in);

       System.out.println("첫번째 숫자입력");
       num1 = kb.nextDouble(); //숫자를 입력받는 함수
        //개행문자 제거를 위한 flush 처리
        kb.nextLine();

        System.out.println("a~e 연산지 선택:");
        operator = kb.nextLine();

        System.out.println("두번째 숫자입력");
        num2 = kb.nextDouble();

        switch (operator){
            case "a":
                System.out.println("덧셈한 결과는?");
                System.out.println(adder(num1,num2));
                break;
            case "b":
                System.out.println("곱셈 결과는?");
                System.out.println(multi(num1,num2));
                break;
            case "c":
                System.out.println("나누기 결과는?");
                if (num2 == 0){
                    System.out.println("나눗셈 못함");
                }else{
                    System.out.println(divide(num1,num2));
                }break;
            case "d":
                System.out.println("뺄셈한 결과는?");
                System.out.println(minus(num1,num2));
                break;
            case "e":
                System.out.println("나머지 결과는?");
                System.out.println(modular(num1,num2));
                break;
                default:
                    System.out.println("연산을 잘못입력하였습니다.");
        }
    }

    public static double absolute (double num1){
        double result;
        if(num1 >=0){
            result = num1;
            } else{
            result = num1 * -1;
        } return num1;
    }


    public static double adder(double num1, double num2){
        // 덧셈값을 저장하는 변수 생성
        double result;
        //덧셈실행
        result = num1 + num2;
        //덧셈한 결과값을 리턴(도출)
        return result;
    }
    public static double multi(double num1, double num2){
        //곱셈값을 저장하는 변수 생성
        double result;
        //곱셈연산 실행
        result= num1*num2;
        //곱셈한 결과값을 리턴(도출)
        return result;
    }
    public static double divide(double num1, double num2){
        double result;
        result= num1/num2;
        return result;
    }
    public static double minus(double num1, double num2){
        double result;
        result= num1-num2;
        return result;
    }
    public static double modular(double num1, double num2){
        double result;
        result= num1%num2;
        return result;
    }
}


