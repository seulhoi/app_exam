
import java.util.Scanner;

public class Exam {
    public static void main(String[] args) {
        /* 숫자를 입력받아 그의 배수를 열번 출력하는 함수를 사용하는 프로그램*/
    //입력 값을 저장할 변수 선언
        int a;
        //입력을 받기 위해 준비
        Scanner kb = new Scanner(System.in);
        a = kb.nextInt();
        //횟수를 저장하는 변수 num 생성 후 횟수를 0으로 저장
        int num = 0;
        //10번 반복하여 출력
        while (num < 10){
            num++;
            System.out.println(num*a+" ");
        }
    }
}


