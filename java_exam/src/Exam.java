
import java.util.Scanner;

public class Exam {
    public static void main(String[] args) {
        //키보드입력을 준비
        Scanner keyboard=new Scanner(System.in);
        //입력을 유도하는 명령어 출력
        System.out.print("당신의 이름은? ");
        //문자를 키보드로 입력받음
        String str=keyboard.nextLine();
        //입력한 후 저장한 문자를 출력함
        System.out.println("안녕하세요 "+str+'님');
        //입력을 유도하는 메시지 출력
        System.out.println("당신은 스파게티를 좋아한다는데, 진짜인가요? ");
        //true or false 를 저장할 변수 생성
        boolean isTrue=keyboard.nextBoolean();
        if(isTrue==true)
            System.out.println("오~ 좋아하는군ㅎ");
        else
            System.out.println("이런 아니었군ㅎ");
        System.out.println("당신과 동생의 키는 어떻게 되나요?");
        double num1=keyboard.nextDouble();
        double num2=keyboard.nextDouble();
        double diff=num1-num2;
        if(diff>0)
            System.out.println("당신이 "+diff+"만큼 크군요");
        else
            System.out.println("당신이 "+diff+"만큼 작군요.");
    }
}


