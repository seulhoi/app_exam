import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PWHandler implements ActionListener{
    JTextField id;
    JPasswordField pw;

    public PWHandler(JTextField id, JPasswordField pw) {
        this.id = id;
        this.pw = pw;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("ID"+id.getText());
        System.out.println("PW"+new String(pw.getPassword()));
        id.setText("");
        pw.setText("");
    }
}
