import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Scanner;

public class Exam {
    public static void main(String[] args) {
      //frame 객체 생성
       JFrame frame = new JFrame("title");
       //frame 크기 설정(화면의 x좌표,y좌표,창 너비,창 높이)
       frame.setBounds(120,120,400,100);
       //프레임안에 배치될 버튼들의 배치방식 설정
        frame.setLayout(new FlowLayout());

        //닫기 버튼 동작을 ㅜ이한 리스너 설정 및 등록
        WindowListener listener = new WindowAdapter() {
            public void windowClosing(WindowEvent we){
                System.exit(0);
            }
            public void windowOpened(WindowEvent we){
                System.out.println("프로그램이 수행 되었습니다.");
            }
        };

        frame.addWindowListener(listener);

        MouseEventHandler meHandler = new MouseEventHandler();


        //버튼 객체를 생성
        JButton btn1 = new JButton("Btn");
        JButton btn2 = new JButton("Btn");
        JButton btn3 = new JButton("Btn");

        //버튼을 프레임 안에 추가
        frame.add(btn1);
        frame.add(btn2);
        frame.add(btn3);

        //프레임을 화면에 보여줌
        frame.setVisible(true);




    }
}



