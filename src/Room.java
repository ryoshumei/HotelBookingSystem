//MAKING INSTANCE OF THIS CLASS IS NOT RECOMMENDED
//PLZ USING THE SUB CLASS EXP SingleRoom

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

public class Room {
    private int price;
    private boolean isEmpty = true;
    private int maxGuests;
    private int roomNum;
    private int roomType = -1;
    private boolean isSeaside;

    private ArrayList<LocalDate> stayDate = new ArrayList<LocalDate>();

    //private LocalDate startDay;//
    //private LocalDate endDay;

    //constructor

    public Room() {

    }


    //getter&setter


    public ArrayList<LocalDate> getStayDate() {
        return stayDate;
    }


    public void setPrice(int p){
        price = p;
    }
    public int getPrice(){

        return price;
    }
    public void setIsEmpty(boolean e){
        isEmpty = e;
    }
    public boolean getIsempty(){
        return isEmpty;
    }

    public int getMaxGuests() {
        return maxGuests;
    }

    public void setMaxGuests(int maxGuests) {
        this.maxGuests = maxGuests;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public int getRoomType() {
        return roomType;
    }

    public void setRoomType(int roomType) {
        this.roomType = roomType;
    }

    public boolean isSeaside() {
        return isSeaside;
    }

    public void setSeaside(boolean seaside) {
        isSeaside = seaside;
    }


}
