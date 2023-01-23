import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Iterator;

import com.github.lgooddatepicker.components.CalendarPanel;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.optionalusertools.CalendarListener;
import com.github.lgooddatepicker.optionalusertools.PickerUtilities;
import com.github.lgooddatepicker.zinternaltools.CalendarSelectionEvent;
import com.github.lgooddatepicker.zinternaltools.YearMonthChangeEvent;


public class Admin {
    //This demo hotel has 6 floors
    //F1 is roby and there is no room for guest
    //
    //F2 has 8 SingleRooms
    //F3 has 6 DoubleRooms
    //F4 has 6 TwinRooms
    //F5 has 3 DoubleRooms and 3 TwinRooms
    //F6 has 3 DoubleRooms and 3 TwinRooms
    ArrayList<SingleRoom> f2 = new ArrayList<SingleRoom>();
    ArrayList<DoubleRoom> f3 = new ArrayList<DoubleRoom>();
    ArrayList<TwinRoom> f4 = new ArrayList<TwinRoom>();
    ArrayList<Room> f5 = new ArrayList<Room>();
    ArrayList<Room> f6 = new ArrayList<Room>();

    JPanel mainPanel;
    JFrame frame;
    JTable guestsList;

    ArrayList<JButton> f2Buttons = new ArrayList<JButton>();
    ArrayList<JButton> f3Buttons = new ArrayList<JButton>();
    ArrayList<JButton> f4Buttons = new ArrayList<JButton>();
    ArrayList<JButton> f5Buttons = new ArrayList<JButton>();
    ArrayList<JButton> f6Buttons = new ArrayList<JButton>();

    Box f2Box = new Box(BoxLayout.X_AXIS);
    Box f3Box = new Box(BoxLayout.X_AXIS);
    Box f4Box = new Box(BoxLayout.X_AXIS);
    Box f5Box = new Box(BoxLayout.X_AXIS);
    Box f6Box = new Box(BoxLayout.X_AXIS);

    DefaultTableModel tableModel;

    LocalDate curDate;

    public static void main(String[] args){
        //prevent CN/JP/.. IME BUG
        System.setProperty("sun.java2d.noddraw", "true");
        //
        new Admin().go();
    }
    public void go(){
        buildRooms();
        renewDataFromDatabase();
        buildGui();
        updateAllRooms(LocalDate.now());
    }

    private void renewDataFromDatabase() {
        clearAllRoomsDate();
        ArrayList<Guest> guestsInDatabase = MySQLDatabaseManagement.getGuestsFromDatabase();
        Iterator iterator = guestsInDatabase.iterator();
        while(iterator.hasNext()){
            Guest guest = (Guest) iterator.next();
            //System.out.println(obj.getName());
            Iterator roomF2 = f2.iterator();
            Iterator roomF3 = f3.iterator();
            Iterator roomF4 = f4.iterator();
            Iterator roomF5 = f5.iterator();
            Iterator roomF6 = f6.iterator();
            while (roomF2.hasNext()){
                Room room = (Room) roomF2.next();
                if(room.getRoomNum() == guest.getRoomNumToStay()){
                    for(LocalDate i = guest.getStartDay(); i.compareTo(guest.getEndDay()) < 0; i = i.plusDays(1)){
                        room.getStayDate().add(i);
                    }

                }
            }
            while (roomF3.hasNext()){
                Room room = (Room) roomF3.next();
                if(room.getRoomNum() == guest.getRoomNumToStay()){
                    //System.out.println("MATCHED");
                    for(LocalDate i = guest.getStartDay(); i.compareTo(guest.getEndDay()) < 0; i = i.plusDays(1)){

                        room.getStayDate().add(i);
                    }


                }
            }
            while (roomF4.hasNext()){
                Room room = (Room) roomF4.next();
                if(room.getRoomNum() == guest.getRoomNumToStay()){
                    for(LocalDate i = guest.getStartDay(); i.compareTo(guest.getEndDay()) < 0; i = i.plusDays(1)){
                        room.getStayDate().add(i);
                    }

                }
            }
            while (roomF5.hasNext()){
                Room room = (Room) roomF5.next();
                if(room.getRoomNum() == guest.getRoomNumToStay()){
                    for(LocalDate i = guest.getStartDay(); i.compareTo(guest.getEndDay()) < 0; i = i.plusDays(1)){
                        room.getStayDate().add(i);
                    }

                }
            }
            while (roomF6.hasNext()){
                Room room = (Room) roomF6.next();
                if(room.getRoomNum() == guest.getRoomNumToStay()){
                    for(LocalDate i = guest.getStartDay(); i.compareTo(guest.getEndDay()) < 0; i = i.plusDays(1)){
                        room.getStayDate().add(i);
                    }

                }
            }
        }
    }

    private void clearAllRoomsDate() {
        Iterator roomF2 = f2.iterator();
        Iterator roomF3 = f3.iterator();
        Iterator roomF4 = f4.iterator();
        Iterator roomF5 = f5.iterator();
        Iterator roomF6 = f6.iterator();
        while (roomF2.hasNext()){
            Room room = (Room) roomF2.next();
            room.getStayDate().clear();
            //test
            //System.out.println("after clear all date" + room.getStayDate().size());
            //end test
        }
        while (roomF3.hasNext()){
            Room room = (Room) roomF3.next();
            room.getStayDate().clear();
            //test
            //System.out.println("after clear all date" + room.getStayDate().size());
            //end test
        }
        while (roomF4.hasNext()){
            Room room = (Room) roomF4.next();
            room.getStayDate().clear();
            //test
            //System.out.println("after clear all date" + room.getStayDate().size());
            //end test
        }
        while (roomF5.hasNext()){
            Room room = (Room) roomF5.next();
            room.getStayDate().clear();
            //test
            //System.out.println("after clear all date" + room.getStayDate().size());
            //end test
        }
        while (roomF6.hasNext()){
            Room room = (Room) roomF6.next();
            room.getStayDate().clear();
            //test
            //System.out.println("after clear all date" + room.getStayDate().size());
            //end test
        }
    }

    private void buildRooms() {
        for(int i = 0; i <8; i++){
            SingleRoom room = new SingleRoom();
            room.setRoomNum(2*100+i+1);
            f2.add(room);
            //System.out.println(f2.get(i).getRoomNum());
        }

        for(int i = 0; i < 6; i++){
            DoubleRoom doubleRoom = new DoubleRoom();
            doubleRoom.setRoomNum(3*100+i+1);
            f3.add(doubleRoom);
        }
        for(int i = 0; i < 6; i++){
            TwinRoom twinRoom = new TwinRoom();
            twinRoom.setRoomNum(4*100+i+1);
            f4.add(twinRoom);
        }
        for(int i = 0; i < 3; i++){

            f5.add(new DoubleRoom());
            f5.get(i).setRoomNum(5*100+i+1);
            f6.add(new TwinRoom());
            f6.get(i).setRoomNum(6*100+i+1);
        }
        for(int i = 3; i < 6; i++){
            f5.add(new DoubleRoom());
            f5.get(i).setRoomNum(5*100+i+1);
            f6.add(new TwinRoom());
            f6.get(i).setRoomNum(6*100+i+1);
        }
    }

    private void buildGui(){

        frame = new JFrame("Admin System");


        mainPanel = new JPanel();
        frame.getContentPane().add(BorderLayout.CENTER,mainPanel);

        Box all = new Box(BoxLayout.Y_AXIS);
        all.setBorder(new LineBorder(Color.BLACK));

        for(int i = 0; i <8; i++){
            String available;
            if(f2.get(i).getIsempty()){
                available = "Available";
            } else {
                available = "X";
            }
            f2Buttons.add(new JButton("<html>" + f2.get(i).getRoomNum() + " SingleRoom<br>" + available));
            f2Box.add(f2Buttons.get(i));
            f2Buttons.get(i).addActionListener(new BookListener(f2.get(i),this));
            //f2Box.add(new JButton("<html>ボタン表示文字列<br>" + "改行表示する"));

        }

        for(int i = 0; i < 6; i++){
            String available;
            if(f3.get(i).getIsempty()){
                available = "Available";
            } else {
                available = "X";
            }
            f3Buttons.add(new JButton("<html>" + f3.get(i).getRoomNum() + " DoubleRoom<br>" + available));
            f3Box.add(f3Buttons.get(i));
            f3Buttons.get(i).addActionListener(new BookListener(f3.get(i),this));
        }
        for(int i = 0; i < 6; i++){
            String available;
            if(f4.get(i).getIsempty()){
                available = "Available";
            } else {
                available = "X";
            }
            f4Buttons.add(new JButton("<html>" + f4.get(i).getRoomNum() + " TwinRoom<br>" + available));
            f4Box.add(f4Buttons.get(i));
            f4Buttons.get(i).addActionListener(new BookListener(f4.get(i),this));
        }
        for(int i = 0; i < 3; i++){
            String available;
            if(f5.get(i).getIsempty()){
                available = "Available";
            } else {
                available = "X";
            }
            f5Buttons.add(new JButton("<html>" + f5.get(i).getRoomNum() + " DoubleRoom<br>" + "" + available));
            f5Box.add(f5Buttons.get(i));//"<html>ボタン表示文字列<br>" + "改行表示する"
            f5Buttons.get(i).addActionListener(new BookListener(f5.get(i),this));
            if(f6.get(i).getIsempty()){
                available = "Available";
            } else {
                available = "X";
            }
            f6Buttons.add(new JButton("<html>" + f6.get(i).getRoomNum() + " DoubleRoom<br>" + "" + available));
            f6Box.add(f6Buttons.get(i));
            f6Buttons.get(i).addActionListener(new BookListener(f6.get(i),this));
        }
        for(int i = 3; i < 6; i++){
            String available;
            if(f5.get(i).getIsempty()){
                available = "Available";
            } else {
                available = "X";
            }
            f5Buttons.add(new JButton("<html>" + f5.get(i).getRoomNum() + " TwinRoom<br>" + "" + available));
            f5Box.add(f5Buttons.get(i));
            f5Buttons.get(i).addActionListener(new BookListener(f5.get(i),this));
            if(f6.get(i).getIsempty()){
                available = "Available";
            } else {
                available = "X";
            }
            f6Buttons.add(new JButton("<html>" + f6.get(i).getRoomNum() + " TwinRoom<br>" + "" + available));
            f6Box.add(f6Buttons.get(i));
            f6Buttons.get(i).addActionListener(new BookListener(f6.get(i),this));
        }


        all.add(f6Box);
        all.add(Box.createRigidArea(new Dimension(0, 20)));
        all.add(f5Box);
        all.add(Box.createRigidArea(new Dimension(0, 20)));
        all.add(f4Box);
        all.add(Box.createRigidArea(new Dimension(0, 20)));
        all.add(f3Box);
        all.add(Box.createRigidArea(new Dimension(0, 20)));
        all.add(f2Box);

        JLabel roomInfo = new JLabel("Rooms' Information");
        roomInfo.setHorizontalAlignment(JLabel.CENTER);
        frame.getContentPane().add(BorderLayout.NORTH,roomInfo);

        // This section creates an independent CalendarPanel.
        // This CalendarPanel includes a calendar selection listener and a border.
        DatePickerSettings settings = new DatePickerSettings();
        CalendarPanel calendarPanel = new CalendarPanel(settings);
        calendarPanel.setSelectedDate(LocalDate.now());
        calendarPanel.addCalendarListener(new SampleCalendarListener());
        calendarPanel.setBorder(new LineBorder(Color.lightGray));

        curDate = calendarPanel.getSelectedDate();
        //System.out.println(curDate);

        //setup Jtable

        String column[]={"ID","NAME","AGE", "GENDER", "CHECK-IN", "CHECK-OUT", "ROOM-NUMBER"};
        tableModel = new DefaultTableModel();

        tableModel.setColumnIdentifiers(column);
        MySQLDatabaseManagement.addDataToTable(tableModel);

        guestsList = new JTable(tableModel);
        guestsList.setDefaultEditor(Object.class, null);// Make the JTable can not be changed
        guestsList.setSize(500,300);
        JScrollPane sp=new JScrollPane(guestsList);
        guestsList.setVisible(true);
        JPanel southJPanel = new JPanel();
        southJPanel.setLayout(new BorderLayout());
        southJPanel.add(BorderLayout.CENTER,sp);
        JButton deleteButton = new JButton("Delete");
        JPanel deletePanel = new JPanel();
        deleteButton.addActionListener(new DeleteGuestListener());
        deletePanel.add(deleteButton);
        southJPanel.add(BorderLayout.EAST,deletePanel);

        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        mainPanel.add(BorderLayout.CENTER,all);
        mainPanel.add(BorderLayout.EAST,calendarPanel);
        mainPanel.add(BorderLayout.SOUTH,southJPanel);

        //JPanel calendarPanel = new ACalender().getGuiPanel();
        //frame.getContentPane().add(BorderLayout.EAST,calendarPanel);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500,1000);










    }

    private void renewButton(){

        // if room.Isempty is true then show String "Available" else show "X" on buttons

        for(int i = 0; i <8; i++){
            String available;
            if(f2.get(i).getIsempty()){
                available = "Available";
            } else {
                available = "X";
            }

            JButton tempButton=  f2Buttons.get(i);
            tempButton.setText("<html>" + f2.get(i).getRoomNum() + " SingleRoom<br>" + available);


        }

        for(int i = 0; i < 6; i++){
            String available;
            if(f3.get(i).getIsempty()){
                available = "Available";
            } else {
                available = "X";
            }
            JButton temp= f3Buttons.get(i);
            temp.setText("<html>" + f3.get(i).getRoomNum() + " DoubleRoom<br>" + available);
        }
        for(int i = 0; i < 6; i++){
            String available;
            if(f4.get(i).getIsempty()){
                available = "Available";
            } else {
                available = "X";
            }
            JButton tempButton= f4Buttons.get(i);
            tempButton.setText("<html>" + f4.get(i).getRoomNum() + " TwinRoom<br>" + available);

        }
        for(int i = 0; i < 3; i++){
            String available;
            if(f5.get(i).getIsempty()){
                available = "Available";
            } else {
                available = "X";
            }
            JButton tempButton= f5Buttons.get(i);
            tempButton.setText("<html>" + f5.get(i).getRoomNum() + " DoubleRoom<br>" + "" + available);
            if(f6.get(i).getIsempty()){
                available = "Available";
            } else {
                available = "X";
            }
            tempButton= f6Buttons.get(i);
            tempButton.setText("<html>" + f6.get(i).getRoomNum() + " DoubleRoom<br>" + "" + available);

        }
        for(int i = 3; i < 6; i++){
            String available;
            if(f5.get(i).getIsempty()){
                available = "Available";
            } else {
                available = "X";
            }
            JButton tempButton= f5Buttons.get(i);
            tempButton.setText("<html>" + f5.get(i).getRoomNum() + " TwinRoom<br>" + "" + available);
            if(f6.get(i).getIsempty()){
                available = "Available";
            } else {
                available = "X";
            }
            tempButton= f6Buttons.get(i);
            tempButton.setText("<html>" + f6.get(i).getRoomNum() + " TwinRoom<br>" + "" + available);
        }
    }

    public void updateAllRooms(LocalDate newDate) {
        //System.out.println(newDate + " from updateAllRooms");

        //search every room on each floor
        for(int i = 0; i <8; i++){
            ArrayList<LocalDate> temp = f2.get(i).getStayDate();

            //LocalDate start = f2.get(i).getStartDay();
            //LocalDate end = f2.get(i).getEndDay();

            //debug
            //System.out.println("cur index : " + i + " start: " + start + " end " + end);
            //end debug
            if(!temp.isEmpty()){
                //debug
                //System.out.println("cur index : " + i + " start: " + start + " end " + end);
                //end debug
                //if(newDate.compareTo(start) >= 0 && newDate.compareTo(end) <= 0)
                //System.out.println("if contains: " + temp.contains(newDate));
                if(temp.contains(newDate)){
                    f2.get(i).setIsEmpty(false);
                } else {
                    f2.get(i).setIsEmpty(true);
                }
            } else {
                f2.get(i).setIsEmpty(true);
            }

            //System.out.println(f2.get(i).getRoomNum());
        }

        for(int i = 0; i < 6; i++){
            ArrayList<LocalDate> temp = f3.get(i).getStayDate();

            if(!temp.isEmpty()){
                if(temp.contains(newDate)){
                    f3.get(i).setIsEmpty(false);
                }else {
                    f3.get(i).setIsEmpty(true);
                }
            } else {
                f3.get(i).setIsEmpty(true);
            }
        }
        for(int i = 0; i < 6; i++){
            ArrayList<LocalDate> temp = f4.get(i).getStayDate();
            if(!temp.isEmpty()){
                if(temp.contains(newDate)){
                    f4.get(i).setIsEmpty(false);
                } else {
                    f4.get(i).setIsEmpty(true);
                }
            } else {
                f4.get(i).setIsEmpty(true);
            }

        }
        for(int i = 0; i < 3; i++){

            ArrayList<LocalDate> temp = f5.get(i).getStayDate();

            if(!temp.isEmpty()){
                if(temp.contains(newDate)){
                    f5.get(i).setIsEmpty(false);
                }else {
                    f5.get(i).setIsEmpty(true);
                }
            }else {
                f5.get(i).setIsEmpty(true);
            }

            temp = f6.get(i).getStayDate();

            if(!temp.isEmpty()){
                if(temp.contains(newDate)){
                    f6.get(i).setIsEmpty(false);
                }else {
                    f6.get(i).setIsEmpty(true);
                }
            } else {
                f6.get(i).setIsEmpty(true);
            }


        }
        for(int i = 3; i < 6; i++){
            ArrayList<LocalDate> temp = f5.get(i).getStayDate();

            if(!temp.isEmpty()){
                if(temp.contains(newDate)){
                    f5.get(i).setIsEmpty(false);
                }else {
                    f5.get(i).setIsEmpty(true);
                }
            } else {
                f5.get(i).setIsEmpty(true);
            }

            temp = f6.get(i).getStayDate();

            if(!temp.isEmpty()){
                if(temp.contains(newDate)){
                    f6.get(i).setIsEmpty(false);
                }else {
                    f6.get(i).setIsEmpty(true);
                }
            } else {
                f6.get(i).setIsEmpty(true);
            }

        }
        renewButton();




    }
    private class SampleCalendarListener implements CalendarListener {
        /**
         * selectedDateChanged, This function will be called each time that a date is selected in the
         * independent CalendarPanel. The new and old selected dates are supplied in the event object.
         * These parameters may contain null, which represents a cleared or empty date.
         *
         * <p>By intention, this function will be called even if the user selects the same date value
         * twice in a row. This is so that the programmer can catch all events of interest. Duplicate
         * events can optionally be detected with the function CalendarSelectionEvent.isDuplicate().
         */
        @Override
        public void selectedDateChanged(CalendarSelectionEvent event) {
            LocalDate oldDate = event.getOldDate();
            LocalDate newDate = event.getNewDate();
            curDate = newDate;
            String oldDateString = PickerUtilities.localDateToString(oldDate, "(null)");
            String newDateString = PickerUtilities.localDateToString(newDate, "(null)");
            updateAllRooms(newDate);
        }



        /**
         * yearMonthChanged, This function will be called each time that the displayed YearMonth is
         * changed in the independent CalendarPanel. The new and old selected YearMonths are supplied in
         * the event object. These parameters will never be null.
         *
         * <p>By intention, this function will be called even if the user selects the same YearMonth
         * value twice in a row. This is so that the programmer can catch all events of interest.
         * Duplicate events can optionally be detected with the function
         * YearMonthChangeEvent.isDuplicate().
         */
        @Override
        public void yearMonthChanged(YearMonthChangeEvent event) {
            YearMonth oldYearMonth = event.getOldYearMonth();
            YearMonth newYearMonth = event.getNewYearMonth();
            String oldYearMonthString = oldYearMonth.toString();
            String newYearMonthString = newYearMonth.toString();
            String messageStart = "\nIndependent Calendar Panel:";
            String messagePartTwo = " The displayed YearMonth has changed from '";
            String fullMessage =
                    messageStart
                            + messagePartTwo
                            + oldYearMonthString
                            + "' to '"
                            + newYearMonthString
                            + "'. ";
            fullMessage += (event.isDuplicate()) ? "(Event marked as duplicate.)" : "";
            //if (!panel.messageTextArea.getText().startsWith(messageStart)) {
            //    panel.messageTextArea.setText("");
            //}
            //panel.messageTextArea.append(fullMessage);
        }
    }

    private class BookListener implements ActionListener {
        Room roomForBooking;
        Admin admin;
        public BookListener(Room room, Admin admin) {
            this.admin = admin;
            roomForBooking = room;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Booking booking = new Booking();
            if(roomForBooking.getIsempty()){
                booking.bookARoom(roomForBooking,curDate,admin);

            } else {


                booking.showGuestInfoGUI(roomForBooking,curDate,admin);
            }
        }
    }

    private class DeleteGuestListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int row = guestsList.getSelectedRow();
            int id = Integer.parseInt(tableModel.getValueAt(row,0).toString());
            //System.out.println("ID : " + id + " will be delete");
            MySQLDatabaseManagement.deleteGuestById(id);
            MySQLDatabaseManagement.addDataToTable(tableModel);
            renewDataFromDatabase();
            updateAllRooms(curDate);



        }
    }
}
