import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class MouseEventHandler implements MouseListener {
// 마우스버튼이 클릭되었을때 호출
    public void mouseClicked(MouseEvent e){
        JButton button=(JButton)e.getComponent();
        button.setText("Clicked");
        System.out.println("Clicked Button"+e.getButton());
        System.out.println("마우스 버튼 눌렸다 풀림");
    }

// 마우스 커서가 버튼위에 올라가면 호출
    public void mouseEntered(MouseEvent e){
        System.out.println("커서 버튼 위 진입");
    }
    //마우스 커서가 버튼을 빠져나가면 호출
    public void mouseExited(MouseEvent e){
        System.out.println("커서 버튼 탈출");
    }
    //마우스 버튼이 눌리는 순간 호출
    public void mousePressed(MouseEvent e){
        System.out.println("마우스 버튼이 눌림");
    }
    //마우스 버튼이 풀리는 순간 호출
    public void mouseReleased(MouseEvent e){
        System.out.println("마우스 버튼 풀림");
    }
}
