public class Person {
    private int perID;
    private int milID;

    //군 필자를위한 생성자
    public Person(int pID, int mID){
        perID = pID;
        milID = mID;


    }
    //군 미필자를 위한 생성자
    public Person(int pID){
        perID = pID;
        milID = -1;
    }
    public void showInfo(){
        System.out.println("주민번호: "+perID);
        if(milID == -1){
            System.out.println("군번이 없음");
        }else{
            System.out.println("군번: "+milID);
        }
    }
}
