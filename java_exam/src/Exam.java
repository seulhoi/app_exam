
import java.util.Scanner;

public class Exam {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        System.out.println("변환할 미터값을 입력하시오");
        double num3 = kb.nextInt();


       double InchNum= num3 *39.37;
       double FeetNum = num3*3.2808;
       double YardNum = num3*1.0936;

        System.out.println("미터(M)를 인치(Inch)로 변환한 결과: "+InchNum);
        System.out.println("미터(M)를 인치(Feet)로 변환한 결과: "+FeetNum);
        System.out.println("미터(M)를 인치(Yard)로 변환한 결과: "+YardNum);
    }
}



