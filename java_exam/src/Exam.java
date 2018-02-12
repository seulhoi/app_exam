
import java.util.Scanner;

public class Exam {
    public static void main(String[] args) {
        Vender myVender = new Vender();
        Vender myVender2 = new Vender();

        //돈 입력
        myVender.inputMoney();
        //커피 선택
        myVender.selectTea();
        //커피 만들기
        myVender.makeTea(myVender.tea);
        //잔돈 계산하기
        int return_money = myVender.returnMoney(myVender.tea, myVender.user_money);
        //잔돈 출력하기
        System.out.println(return_money);

    }
}



