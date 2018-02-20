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
       frame.setBounds(120,120,250,270);
       //프레임안에 배치될 버튼들의 배치방식 설정 그리드레이아웃 (행,열,세로선 간격,가로선 간격)
        frame.setLayout(new FlowLayout());

        //객체를 생성
        JTextArea textArea = new JTextArea(10,20);
        JButton btn = new JButton("Clear");

        BttonTextHandler btHandler = new BttonTextHandler(textArea);
        btn.addActionListener(btHandler);

        //프레임에 넣어줌
        frame.add(textArea);
        frame.add(btn);

        //프레임을 화면에 보여줌
        frame.setVisible(true);

    }
}



