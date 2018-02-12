import java.util.Scanner;

//자판기
class Vender {
    //사용자가 선택한 커피
    String tea="";
//    사용자가 넣은 돈을 저장
    int user_money=0;
    //자판기가 가지고 있는 값
    int money = 50000;
    //자판기가 판매하는 커피의 값
    int suger = 200;
    int cream = 100;
    int cocoa = 200;

public void inputMoney(){
    Scanner kb = new Scanner(System.in);

    System.out.println("커피값을 입력하세요.");
    user_money = kb.nextInt();

    System.out.println("커피값"+user_money+"원을 입력받았습니다.");
        }
    //커피 입력하는 부분
    public void selectTea(){
        Scanner kb = new Scanner(System.in);  //키보드 입력준비
        System.out.println("커피를 선택하세요.");
        System.out.println("크림커피, 설탕커피, 코코아");

        tea = kb.nextLine(); //입력받는 코드

        while(true){
            if(tea.equals("크림커피")){
                break;
            }
            else if(tea.equals("설탕커피")){
                break;
            }else if(tea.equals("코코아")){
                break;
            }else{
                System.out.println("잘못된 선택입니다.");
                tea = kb.nextLine();
            }
        }
    }

    //커피를 만드는 함수
    public void makeTea(String aTea){
        String message="";

        switch(aTea)  {
            case "크림커피":
                message = "크림커피가 만들어 졌습니다.";
                break;
            case "설탕커피":
                message = "설탕커피가 만들어 졌습니다.";
                break;
            case "코코아":
                message = "코코아가 만들어 졌습니다.";
                break;
                 }
             System.out.println(message);
        }
//        잔돈을 계산하는 함수
    public int returnMoney(String aTea, int aCharge){
        int return_money = 0;

        switch(aTea){
            case "크림":
                return_money = aCharge - 100;
                break;
            case "설탕": case "코코아":
                return_money = aCharge - 200;
                break;
                }
                return return_money;
              }
}
