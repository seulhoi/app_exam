public class Person {
    private int carID;
    private String address;

    public Person (String aAddress){
        address = aAddress;
        carID = -1;
    }
    public Person(int cID){
        address = "";
        carID= cID;
    }
    public void showInfo(){
        if(carID==-1){
            System.out.println("차량이 없음");
            System.out.println("주소: "+address);
        }else{
            System.out.println("차랑번호: "+carID);
            System.out.println("주소가 없음");
        }
    }
}
