
import java.util.Scanner;

public class Exam {
    public static void main(String[] args) {
        //숫자를 저장하는 변수
        int num=1;
        //1씩 증가시키면서 6의 배수 이고 14의 배수인지 반복하여 무한루프로 검사
        while(true){
             //6의 나머지가 0이고 14의 나머지가 0이어야 if부분이 true
            if(num%6==0 && num%14==0){
             //무한 루프 탈출
                break;
            }
             //숫자 1증가
            num++;
        }
        //6과 14의 공배수 출력
        System.out.println(num);
    }
}


