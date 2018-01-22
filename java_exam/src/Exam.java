import javax.sound.midi.SysexMessage;

/*
      작성자:남슬기
      작성일:2018.01.10
      작성이유: 자바 출력 연습하기!!
      여러줄을 주석표시 하고싶을땐
    */
public class Exam {
    public static void main(String[] args) {
/*
     int num = 11;

     if(num>0){
         System.out.println("num은 0 보다 큽니다.");
     }
     if((num%2)==0){
         System.out.println("num은 짝수입니다.");
     }else{
         System.out.println("num은 홀수입니다.");
     }

        System.out.println("=========== else if문 ==============");

     int score =88;

     if(score >= 90) {
         System.out.println("성적은 수 입니다.");
     }else if (score >= 80)
     {
             System.out.println("성적은 우 입니다.");
         }
         else if(score >=70){
             System.out.println("성적은 미 입니다.");
         }
         else if(score >=60){
             System.out.println("성적은 양 입니다.");
         }else{
             System.out.println("성적은 가 입니다.");
         }

        System.out.println("=========== switch문 ==============");

        int n=3;

        switch (n){
            case 1:
                System.out.println("Simple JAVA");
                break;
            case 2:
                System.out.println("Funny JAVA");
                break;
            case 3:
                System.out.println("Fantastic JAVA");
                break;
            default:
                System.out.println("The best programming language");
        }
        System.out.println("Do you like coffee?");


        System.out.println("=========== switch문 예제 ==============");

        String str ="원숭이";

        switch(str) {
            case "고양이":
                System.out.println("cat");
                break;
            case "강아지":
                System.out.println("dog");
                break;
            case "쥐":
                System.out.println("mouse");
                break;
            default:
                System.out.println("단어가 없습니다.");
        }

        System.out.println("=========== while문 ==============");

        int num1 = 0;

        while(num1<5) {
            System.out.println("I like JAVA" + num1);
            num1++;
        }


//        System.out.println("=========== while문 예제1 안녕하세요를 100번 출력하라 ==============");
//        int num2 = 0;
//        while(num2<100){
//            System.out.println("안녕하세요"+num2);
//            num2++;
//        }
       System.out.println("=========== while문 예제2 1~10까지 더한값을 출력하라 ==============");

        int ten =0;
        int sum=0;

        while(ten<10){

            ten=ten+1;
            sum=sum+ten;
        }
        System.out.println("1부터 10까지 더한 값은? "+sum);
*/
        System.out.println("=========== while문 예제3 구구단 2단을 출력하라 =============");

        int num3 = 0;

        while(num3<9){
            num3=num3+1;
            System.out.println("2" +"x"+ num3 +" = "+ 2*num3);
        }
       System.out.println("곱셈종료");

       System.out.println("=========== while문 예제4  3단을 3*12 까지 출력하라 =============");

        int num4 =0;

        while(num4<12) {
            num4 = num4 + 1;
            System.out.println("3" + "x" + num4 + "= " + 3 * num4);
        }
        System.out.println("3단 곱셈종료");
    }
}


