import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CheckBoxHandler implements ItemListener {
    JCheckBox cb1;

    public CheckBoxHandler(JCheckBox cb1) {
        this.cb1 = cb1;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getStateChange() == ItemEvent.SELECTED) {
            System.out.println("선택되었습니다.");
            System.out.println(cb1.getText());
        } else {
            System.out.println("선택이 해제되었습니다.");
        }
    }
}