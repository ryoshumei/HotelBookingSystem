import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class MySQLDatabaseManagement {



    public static void addGuestToDatabase(Guest guest){
        String name = guest.getName();
        int age = guest.getAge();
        int gender = guest.getGender();
        LocalDate checkinDay = guest.getStartDay();
        LocalDate checkOutDay = guest.getEndDay();
        int roomNumToStay = guest.getRoomNumToStay();




        System.out.println("get information: " + name + " " + age + " " + gender + " " + checkinDay + " " + checkOutDay + " " + roomNumToStay);
        
        //System.out.println("Hello Java");
        String url = DatabaseAccInfo.URL;
        //jdbc:mysql://[ホスト名]:[ポート番号]/[データベース名]
        String username = DatabaseAccInfo.USERNAME;
        String password = DatabaseAccInfo.PASSWORD;

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected!");

            Statement statement = connection.createStatement();
            String sql = "INSERT INTO guests (name, age, gender, checkin_date, checkout_date,room_num) " + "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setInt(2,age);
            preparedStatement.setInt(3,gender);
            preparedStatement.setString(4,checkinDay.toString());
            preparedStatement.setString(5,checkOutDay.toString());
            preparedStatement.setInt(6,roomNumToStay);


            int addedRows = preparedStatement.executeUpdate();
            System.out.println(addedRows + " added ");

            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }

    public static ArrayList<Guest> getGuestsFromDatabase(){
        ArrayList<Guest> guests = new ArrayList<>();

        String url = "jdbc:mysql://localhost:3306/my_hotel";
        //jdbc:mysql://[ホスト名]:[ポート番号]/[データベース名]
        String username = "root";
        String password = "testing";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected!");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select  * from guests");

            while(resultSet.next()){
                Guest aGuest = new Guest();
                aGuest.setIdInDatabase(resultSet.getInt("id"));
                aGuest.setName(resultSet.getString("name"));
                aGuest.setAge(resultSet.getInt("age"));
                try{
                    aGuest.setGender(resultSet.getInt("gender"));
                } catch (Exception e){
                    e.printStackTrace();
                }
                aGuest.setStartDay(LocalDate.parse(resultSet.getString("checkin_date")));
                aGuest.setEndDay(LocalDate.parse(resultSet.getString("checkout_date")));
                aGuest.setRoomNumToStay(resultSet.getInt("room_num"));

                guests.add(aGuest);
            }


            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }


        return guests;
    }

    public static void addDataToTable(DefaultTableModel tableModel){
        ArrayList<Guest> guestsInDatabase = MySQLDatabaseManagement.getGuestsFromDatabase();
        tableModel.setRowCount(0);
        //String column[]={"ID","NAME","AGE", "GENDER", "CHECK-IN", "CHECK-OUT", "ROOM-NUMBER"};
        for(int i = 0; i < guestsInDatabase.size(); i++){
            String[] row = {Integer.toString(guestsInDatabase.get(i).getIdInDatabase()),
                            guestsInDatabase.get(i).getName(),
                            Integer.toString(guestsInDatabase.get(i).getAge()),
                            MySQLDatabaseManagement.genderToString(guestsInDatabase.get(i).getGender()),
                            guestsInDatabase.get(i).getStartDay().toString(),
                            guestsInDatabase.get(i).getEndDay().toString(),
                            Integer.toString(guestsInDatabase.get(i).getRoomNumToStay())
            };

            tableModel.addRow(row);
        }


    }

    public static void deleteGuestById(int id){
        String url = "jdbc:mysql://localhost:3306/my_hotel";
        //jdbc:mysql://[ホスト名]:[ポート番号]/[データベース名]
        String username = "root";
        String password = "testing";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected!");

            Statement statement = connection.createStatement();
            String sql = "delete from guests where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            statement.close();
            connection.close();


        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }

    public static String genderToString(int genderIndex){
        String gender;
        if(genderIndex == 0){
            gender = "male";
        } else if(genderIndex == 1){
            gender = "female";
        } else if(genderIndex == 2 ){
            gender = "others";
        } else {
            gender = "invalid";
        }
        return gender;
    }
}
