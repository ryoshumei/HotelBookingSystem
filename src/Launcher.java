public class Launcher {
    public static void main(String[] args){

        try{
            Guest guest = new Guest();
            guest.setGender(0);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        System.out.println("END");
        Room room = new Room();
        room.setRoomType(1);
        System.out.println("Room Type is " + room.getRoomType());
        SingleRoom singleRoom = new SingleRoom();
        //singleRoom.setRoomType(1);
        System.out.println("SingleRoom Type is " + singleRoom.getRoomType());

    }
}
