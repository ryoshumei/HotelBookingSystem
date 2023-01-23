import com.github.lgooddatepicker.components.CalendarPanel;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.demo.FullDemo;
import com.privatejgoodies.forms.factories.CC;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.time.LocalDate;

public class LGDPTester {
    public static void main(String[] args){
        new LGDPTester().buildGUI();


    }
    public void buildGUI(){
        JFrame jFrame = new JFrame("LGDPTester");

        jFrame.setSize(500,500);
        JPanel panel = new JPanel();
        // This section creates an independent CalendarPanel.
        // This CalendarPanel includes a calendar selection listener and a border.
        DatePickerSettings settings = new DatePickerSettings();
        CalendarPanel calendarPanel = new CalendarPanel(settings);
        calendarPanel.setSelectedDate(LocalDate.now());
        //calendarPanel.addCalendarListener(new FullDemo.SampleCalendarListener());
        calendarPanel.setBorder(new LineBorder(Color.lightGray));
        panel.add(calendarPanel, CC.xy(2, 2));


        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.getContentPane().add(BorderLayout.CENTER,panel);

        //jFrame.revalidate();
        jFrame.setVisible(true);
    }
}
