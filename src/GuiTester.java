import javax.swing.*;

public class GuiTester {
    Boolean a;

    public static void main(String[] args){

        JFrame jFrame = new JFrame();
        JPanel mainPanel = new JPanel();
        jFrame.getContentPane().add(mainPanel);
        jFrame.setVisible(true);
        jFrame.setSize(240,240);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String text =  "<html>ボタン表示文字列<br>" + "改行表示する";
        int test1 = 123;
        JButton button2 = new JButton("<html>" + test1 + " DoubleRooms : <br>" + "Available  ");
        mainPanel.add(new JButton("<html>" + test1 + " DoubleRooms : <br>" + "Available  "));
        //gui.button2.setText("<html>ボタン表示文字列<br>" + "改行表示する");


        System.out.println(new GuiTester().a);
    }
}
