import java.util.ArrayList;
import java.util.Iterator;

public class GetFromSQL {
    public static void main(String[] args) {
        ArrayList<Guest> testing = MySQLDatabaseManagement.getGuestsFromDatabase();
        Iterator iterator = testing.iterator();
         while(iterator.hasNext()){
             Guest obj = (Guest) iterator.next();
            System.out.println(obj.getName());
         }

        System.out.println(testing.size());
    }
}
