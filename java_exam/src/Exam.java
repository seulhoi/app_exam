import javax.sound.midi.SysexMessage;

/*
      작성자:남슬기
      작성일:2018.01.10
      작성이유: 자바 출력 연습하기!!
      여러줄을 주석표시 하고싶을땐
    */
public class Exam {
    public static void main(String[] args) {

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
     }

    }


