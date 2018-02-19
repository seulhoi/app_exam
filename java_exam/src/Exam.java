
import java.util.Scanner;

public class Exam {
    public static void main(String[] args) {
        //5개의 정수를 입력받은 후
        // 첫번째와 세번째와 다섯번째 정수를 더한 값을 출력하는 프로그램
        int[] arr = new int[5];
        Scanner kb = new Scanner (System.in);

        arr[0] = kb.nextInt();
        arr[1] = kb.nextInt();
        arr[2] = kb.nextInt();
        arr[3] = kb.nextInt();
        arr[4] = kb.nextInt();

        int result = arr[0] + arr[2] + arr[4];
        System.out.println(result);
    }
}



