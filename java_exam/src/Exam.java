
import java.util.Scanner;

public class Exam {
    public static void main(String[] args) {
        //배열
        String[] strArray = new String[3];
        strArray[0] = new String("Java");
        strArray[1] = new String("Flex");
        strArray[2] = new String("Ruby");

        //for(초기값; 비교; 증가)
        for(int i = 0; i < strArray.length; i++){
            System.out.println(strArray[i]);
        }
    }
}



