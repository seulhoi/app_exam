
import java.util.Scanner;

public class Exam {
    public static void main(String[] args) {
/*        //키보드입력을 준비
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
        if(isTrue==true) {
            System.out.println("오~ 좋아하는군ㅎ");
        else
            System.out.println("이런 아니었군ㅎ");
        }

        //실수입력을
        System.out.println("당신과 동생의 키는 어떻게 되나요?");
        double num1=keyboard.nextDouble();
        double num2=keyboard.nextDouble();
        double diff=num1-num2;
        if(diff>0) {
            System.out.println("당신이 " + diff + "만큼 크군요");
        else
            System.out.println("당신이 " + diff + "만큼 작군요.");
        }

        //while문
        System.out.println("========= while문 ===========");
        int num=0;

        while(num<5){
            System.out.println("Java"+num);
            num++;
        }
        //do while
        System.out.println("========= do while문 ===========");
        int num1=0;
        do{
            System.out.println("Java"+num1);
            num1++;
        }
        while(num1<5);

        //for문을 활용한 반복 출력
        System.out.println("========= for문 ===========");
        for(int num3=0; num3<3; num3++)
        {
            System.out.println("java"+num3);
        }

        //반복제어문 예제)문자를 입력받아 20번 반복하여 출력하라
        String str;

        Scanner keyboard = new Scanner(System.in);
        str = keyboard.nextLine();
        System.out.println(str);
        for(int num=0; num<20; num++){
            System.out.println(str);
        }

        //반복제어문 예제2) 10부터 20까지 출력하라
        int a=10;

        for(int num=0; num<11; num++){
            System.out.println(a);
            a=a+1;
        }
 */
      //반복제어문 예제3) 한개의 자연수를 입력받아 그 수의 배수를 차례로 10개 출력하라
          //입력을 받기 위해 준비
            int a;
          //사용자로부터 입력을 받아 변수저장
            Scanner kb = new Scanner(System.in);
              a = kb.nextInt();

        for(int num=1; num<=10; num++){
            System.out.println(a*num+"  ");
        }


     /*
            int num=0;
            //10번 반복하여 출력
            while(num<10) {
                num++;
                System.out.println(num*a + "  ");
            }

*/


    }
}


