import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

public class Booking{
    private JFrame bookingFrame;
    private JPanel mainPanel;
    private JTextField name;
    private JTextField age;
    private JComboBox gender;
    private JTextField stayDays;
    private JTextField roomNumText;
    private JTextField checkInDay;
    private JTextField checkOutDay;
    private JButton submitButton;
    private JButton clearButton;


    public void bookARoom(Room room, LocalDate localDate, Admin admin){
        Guest newGuest = new Guest();
        bookingFrame = new JFrame("Booking Window");
        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        //BoxLayout boxLayout = new BoxLayout(mainPanel,BoxLayout.Y_AXIS);
        //mainPanel.setLayout(boxLayout);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(10,20,50,25);
        name = new JTextField(10);
        name.setBounds(100,20,80,25);

        JLabel ageLabel = new JLabel("Age");
        ageLabel.setBounds(10,50,50,25);
        age = new JTextField(10);
        age.setBounds(100,50,80,25);

        JLabel stayDaysLabel = new JLabel("Stay-days");
        stayDaysLabel.setBounds(10,80,80,25);
        stayDays = new JTextField(10);
        stayDays.setBounds(100,80,80,25);

        JLabel genderLabel = new JLabel("Gender");
        genderLabel.setBounds(10,110,50,25);
        gender = new JComboBox();
        gender.setBounds(100,110,80,25);
        gender.addItem("Male");
        gender.addItem("Female");
        gender.addItem("Others");




        JLabel roomNumLabel = new JLabel("RoomNumber");
        roomNumLabel.setBounds(10,140,80,25);
        roomNumText = new JTextField(Integer.toString(room.getRoomNum()));
        roomNumText.setEditable(false);
        roomNumText.setBounds(100,140,80,25);

        JLabel checkInDayLabel = new JLabel("CheckIn Day");
        checkInDayLabel.setBounds(10,170,80,25);
        checkInDay = new JTextField(localDate.toString());
        checkInDay.setEditable(false);
        checkInDay.setBounds(100,170,80,25);



        submitButton = new JButton("Submit");
        clearButton = new JButton("Clear");
        submitButton.addActionListener(new SubmitButtonListener(room,localDate,admin));
        clearButton.addActionListener(new ClearButtonListener());


        mainPanel.add(nameLabel);
        mainPanel.add(name);
        mainPanel.add(genderLabel);
        mainPanel.add(gender);
        mainPanel.add(ageLabel);
        mainPanel.add(age);
        mainPanel.add(roomNumLabel);
        mainPanel.add(roomNumText);
        mainPanel.add(checkInDayLabel);
        mainPanel.add(checkInDay);
        mainPanel.add(stayDaysLabel);
        mainPanel.add(stayDays);


        Box buttonBox = new Box(BoxLayout.X_AXIS);
        buttonBox.add(submitButton);
        buttonBox.add(Box.createRigidArea(new Dimension(20,0)));
        buttonBox.add(clearButton);
        buttonBox.setBounds(10,200,160,25);

        mainPanel.add(buttonBox);



        bookingFrame.getContentPane().add(mainPanel);
        bookingFrame.setVisible(true);
        bookingFrame.setSize(500,500);
        //bookingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    //unfinished
    public void showGuestInfoGUI(Room room, LocalDate localDate, Admin admin){
        ArrayList<Guest> guests = MySQLDatabaseManagement.getGuestsFromDatabase();


        //setupGUI
        bookingFrame = new JFrame("Booking Information");
        mainPanel = new JPanel();
        mainPanel.setLayout(null);


        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(10,20,50,25);
        name = new JTextField(10);
        name.setBounds(100,20,80,25);

        JLabel ageLabel = new JLabel("Age");
        ageLabel.setBounds(10,50,50,25);
        age = new JTextField(10);
        age.setBounds(100,50,80,25);

        JLabel checkOutLabel = new JLabel("Check-Out Date");
        checkOutLabel.setBounds(10,80,80,25);
        checkOutDay = new JTextField(10);
        checkOutDay.setBounds(100,80,80,25);



        JLabel genderLabel = new JLabel("Gender");
        genderLabel.setBounds(10,110,50,25);
        gender = new JComboBox();
        gender.setBounds(100,110,80,25);
        gender.addItem("Male");
        gender.addItem("Female");
        gender.addItem("Others");




        JLabel roomNumLabel = new JLabel("RoomNumber");
        roomNumLabel.setBounds(10,140,80,25);
        roomNumText = new JTextField(Integer.toString(room.getRoomNum()));
        roomNumText.setEditable(false);
        roomNumText.setBounds(100,140,80,25);

        JLabel checkInDayLabel = new JLabel("CheckIn Day");
        checkInDayLabel.setBounds(10,170,80,25);
        checkInDay = new JTextField(localDate.toString());
        checkInDay.setEditable(false);
        checkInDay.setBounds(100,170,80,25);




        mainPanel.add(nameLabel);
        mainPanel.add(name);
        mainPanel.add(genderLabel);
        mainPanel.add(gender);
        mainPanel.add(ageLabel);
        mainPanel.add(age);
        mainPanel.add(roomNumLabel);
        mainPanel.add(roomNumText);
        mainPanel.add(checkInDayLabel);
        mainPanel.add(checkInDay);
        mainPanel.add(checkOutLabel);
        mainPanel.add(checkOutDay);

        bookingFrame.getContentPane().add(mainPanel);

        bookingFrame.setSize(500,500);
        //bookingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addGuestInformation(guests, localDate);

        bookingFrame.setVisible(true);


    }

    private void addGuestInformation(ArrayList<Guest> guests, LocalDate curDate) {
        //test
        //System.out.println("Guests Size is " + guests.size());
        //end test
        for(int i = 0; i < guests.size(); i++){

            if(roomNumText.getText().equals(Integer.toString(guests.get(i).getRoomNumToStay())) && guests.get(i).getStartDay().compareTo(curDate) <= 0 && curDate.compareTo(guests.get(i).getEndDay()) < 0){
                System.out.println("Found guest");
                name.setText(guests.get(i).getName());
                name.setEditable(false);
                gender.setSelectedIndex(guests.get(i).getGender());
                gender.setEditable(false);
                gender.setEnabled(false);

                age.setText(Integer.toString(guests.get(i).getAge()));
                age.setEditable(false);
                checkInDay.setText(guests.get(i).getStartDay().toString());
                checkInDay.setEditable(false);
                checkOutDay.setText(guests.get(i).getEndDay().toString());
                checkOutDay.setEditable(false);

            }
        }
    }

    private class SubmitButtonListener implements ActionListener {
        Room roomForBooking;
        LocalDate curDate;
        Admin admin;
        Guest guest;
        public SubmitButtonListener(Room room, LocalDate localDate, Admin admin) {
            roomForBooking = room;
            curDate = localDate;
            this.admin = admin;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            guest = new Guest();

            String guestName = name.getText();
            int guestAge = Integer.parseInt(age.getText());
            //System.out.println("guestAge is " + guestAge);
            //String guestGender = gender.getSelectedItem().toString();
            int guestGenderIndex = gender.getSelectedIndex();
            //System.out.println("guestGenderIndex is " + guestGenderIndex);
            int guestStayDays = Integer.parseInt(stayDays.getText());

            guest.setName(guestName);
            guest.setAge(guestAge);
            try{
                guest.setGender(guestGenderIndex);
            } catch (Exception ex){
                ex.printStackTrace();
            }

            guest.setStartDay(curDate);
            guest.setEndDay(curDate.plusDays(guestStayDays));
            guest.setRoomNumToStay(roomForBooking.getRoomNum());

            //System.out.println("guestAge is " + guest.getAge());
            //System.out.println("guestGenderIndex is " + guest.getGender());

            for(int i = 0; i < guestStayDays ; i++){
                roomForBooking.getStayDate().add(curDate.plusDays(i));
            }
            admin.updateAllRooms(curDate);
            bookingFrame.dispose();

            MySQLDatabaseManagement.addGuestToDatabase(guest);
            MySQLDatabaseManagement.addDataToTable(admin.tableModel);






        }
    }

    private class ClearButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            name.setText("");
            age.setText("");
            stayDays.setText("");
            gender.setSelectedItem("Male");
        }
    }
}
