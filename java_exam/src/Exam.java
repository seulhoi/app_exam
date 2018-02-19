
import java.util.ArrayList;
import java.util.Scanner;

public class Exam {
    public static void main(String[] args) {
        int[] arr = new int[5];
        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        System.out.println("데이터저장");
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        System.out.println("데이터 읽기");
        System.out.println(arrayList.get(0));
        System.out.println(arrayList.get(1));
        System.out.println(arrayList.get(2));

        System.out.println("데이터 삭제");
        arrayList.remove(0);
        for(int i =0; i< arrayList.size(); i++){
            System.out.println(arrayList.get(i));
        }
    }
}



