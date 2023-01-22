import java.time.LocalDate;


public class Guest {
    private int idInDatabase;
    private String name;
    private int age;
    private int gender;
    private LocalDate startDay;// todo need check if startday < now
    private LocalDate endDay;
    private int roomNumToStay;


    //constructor
    public Guest(){

    }

    // not using now 2023/01/13
    public Guest(String n, int a, int g,LocalDate checkinDay, LocalDate checkOutDay) throws Exception {

        name = n;
        age = a;
        if(checkGender(g)){
            gender = g;

        } else {
            System.out.println("INVALID GENDER");
            throw new Exception();
        }

    }

    //setter and getter

    public int getIdInDatabase() {
        return idInDatabase;
    }

    public void setIdInDatabase(int idInDatabase) {
        this.idInDatabase = idInDatabase;
    }

    public void setName(String n){
        name = n;
    }
    public String getName(){
        return name;
    }
    public void setAge(int a){

        age = a;
    }
    public int getAge(){return age;}
    public void setGender(int g) throws Exception {
        //gender can be set among {0,1,2}. Represent {male, female, others}
        if(checkGender(g) ){
            gender = g;
        } else{
            System.out.println("INVALID GENDER");
            throw new Exception();
        }
    }
    public int getGender(){return gender;}
    public void setStartDay(LocalDate c){
        startDay = c;
    }
    public LocalDate getStartDay(){
        return startDay;
    }
    public void setEndDay(LocalDate c){
        endDay = c;
    }
    public LocalDate getEndDay(){
        return endDay;
    }

    //methods
    private boolean checkGender(int g){
        if(g <= 2 && g >=0 ){
            return true;
        } else{
            return false;
        }
    }


    public int getRoomNumToStay() {
        return roomNumToStay;
    }

    public void setRoomNumToStay(int roomNumToStay) {
        this.roomNumToStay = roomNumToStay;
    }
}
