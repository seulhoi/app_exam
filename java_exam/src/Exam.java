    /*
      작성자:남슬기
      작성일:2018.01.10
      작성이유: 자바 출력 연습하기!!
      여러줄을 주석표시 하고싶을땐
    */
public class Exam {
    public static void main(String[] args) {
        int num1;
        num1=10;

        char A = 'a';
        int num2 = 20;
        int num3 = num1+num2;
        System.out.println(num1+"+"+num2+"="+ num3);
        System.out.println("문자: "+ A);

        System.out.println("===========================");

         long num11 = 10000000000l;
         float num22 = 13.3f;

         System.out.println("long 사용: "+ num11);
         System.out.println("float 사용:" + num22);
        System.out.println("===========================");

         int n1=7;
         int n2 =3;
         int resert = n1+n2;
         System.out.println("n1:"+ n1 +"   n2:"+n2);
         System.out.println("덧셈 연산: "+ resert);

         resert = n1-n2;
         System.out.println("뺄셈 연산: "+ resert);
         System.out.println("곱하기 연산: "+ n1*n2);
         System.out.println("나누기 연산: "+ n1/n2);
         System.out.println("나머지 연산: " + n1%n2);
    }
}

