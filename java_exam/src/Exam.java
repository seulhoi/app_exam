
import java.util.Scanner;

public class Exam {
    public static void main(String[] args) {
        //정수 10개를 저장할 수 있ㄴ쯘 배열 생성
        int[] arr =new int[10];

        //반복하여 입력받기 위한 횟수를 저장하는 변수 생성
        int num =0;

        //10번 입력받고 정수를 저장하는 반복문
        while(num<10){
            //사용자에게 입력받음
            Scanner kb = new Scanner(System.in);
            //배열에 사용자에게 받은 값 저장
            arr[num] = kb.nextInt();
            //10번 반복해서 반복횟수 증가
            num++;
        }
        //배열의 값을 반복문으로 출력함
        for(int i =0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}



