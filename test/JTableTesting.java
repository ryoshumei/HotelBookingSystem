import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class JTableTesting {
    public static void main(String[] args) {
        JFrame f;

            f=new JFrame();
            String data[][]={ {"101","Amit","670000"},
                    {"102","Jai","780000"},
                    {"101","Sachin","700000"}};
            String column[]={"ID","NAME","SALARY"};
        DefaultTableModel tableModel = new DefaultTableModel(data, column);
            JTable jt=new JTable(tableModel);
            jt.setBounds(30,40,200,300);
            JScrollPane sp=new JScrollPane(jt);
            f.add(sp);
            f.setSize(300,400);
            f.setVisible(true);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
}
