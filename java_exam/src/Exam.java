
import java.util.Scanner;

public class Exam {
    public static void main(String[] args) {
    /* 1부터 전달받은 수까지 합을 출력하는 하수를 작성하고
     1000이하의 자연수를 입력받아 작성한 함수로 전달하여 출력하는 프로그램 */

        //사용자가 입력한 숫자를 저장하는 변수
        int num1;
        //사용자가 키보드 입력준비
        Scanner kb = new Scanner(System.in);
        //사용자로부터 숫자 입력받음
        System.out.println("숫자를 입력하세요.");
        num1 = kb.nextInt();

        //type1
        if(num1 > 1000){
            System.out.println("입력한 숫자가 1000 보다 큽니다.");
            return;
        }else{
            System.out.println("1에서 입력한 숫자까지의 합은?");
            System.out.println(addOneToValue(num1));
        }

       /* //type2
        if(num1>1000){
            System.out.println("입력한 숫자가 1000보다 큽니다.");
            return;
        }
        System.out.println("1에서 입력한 숫자까지의 합은?");
        System.out.println(addOneToValue(num1));
    */
    }
    public static int addOneToValue(int num1){
        int temp=1;
        int result = 0;

        while(temp <= num1){
            result = result + temp;
            temp= temp+1;
        }
        return result;
    }
}


