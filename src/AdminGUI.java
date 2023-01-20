import javax.swing.*;

public class AdminGUI {
    private JPanel mainPanel;
    private JPanel roomInfo;
    private JButton button2 = new JButton("<html>ボタン表示文字列<br>" + "改行表示する");
    private JButton button3;
    private JTextField textField1;
    private JComboBox comboBox1;

    public static void main(String[] args){
        AdminGUI gui = new AdminGUI();
        JFrame jFrame = new JFrame();
        jFrame.getContentPane().add(gui.mainPanel);
        jFrame.setVisible(true);
        jFrame.setSize(240,240);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String text =  "<html>ボタン表示文字列<br>" + "改行表示する";
        //gui.button2.setText("<html>ボタン表示文字列<br>" + "改行表示する");
    }
}
