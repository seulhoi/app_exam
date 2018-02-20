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
       //프레임안에 배치될 버튼들의 배치방식 설정 그리드레이아웃 (행,열)
        frame.setLayout(new GridLayout(3,2));



        //버튼 객체를 생성
        JButton btn1 = new JButton("Btn1");
        JButton btn2 = new JButton("Btn2");
        JButton btn3 = new JButton("Btn3");
        JButton btn4 = new JButton("Btn4");
        JButton btn5 = new JButton("Btn5");
        JButton btn6 = new JButton("Btn6");

        //버튼을 프레임 안에 추가
        frame.add(btn1);
        frame.add(btn2);
        frame.add(btn3);
        frame.add(btn4);
        frame.add(btn5);
        frame.add(btn6);
        //프레임을 화면에 보여줌
        frame.setVisible(true);

    }
}



