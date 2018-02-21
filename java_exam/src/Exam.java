import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Scanner;

public class Exam {
    public static void main(String[] args) {
        // frame 객체 생성
        JFrame frame = new JFrame("title");
        // frame 크기 설정
        frame.setBounds(120,120,250,270);
        // 프레임 안에 배치될 버튼들의 배치 방식 설정
        frame.setLayout(new FlowLayout());

        JCheckBox cb1 = new JCheckBox("수박");
        JCheckBox cb2 = new JCheckBox("딸기");
        JCheckBox cb3 = new JCheckBox("사과");

        CheckBoxHandler cbHandler1 = new CheckBoxHandler(cb1);
        CheckBoxHandler cbHandler2 = new CheckBoxHandler(cb2);
        CheckBoxHandler cbHandler3 = new CheckBoxHandler(cb3);
        cb1.addItemListener(cbHandler1);
        cb2.addItemListener(cbHandler2);
        cb3.addItemListener(cbHandler3);
        frame.add(cb1);
        frame.add(cb2);
        frame.add(cb3);

        JRadioButton rb1 = new JRadioButton("미국");
        JRadioButton rb2 = new JRadioButton("한국");
        JRadioButton rb3 = new JRadioButton("중국");

        RadioHandler radioHandler1 = new RadioHandler(rb1);
        RadioHandler radioHandler2 = new RadioHandler(rb2);
        RadioHandler radioHandler3 = new RadioHandler(rb3);
        rb1.addItemListener(radioHandler1);
        rb2.addItemListener(radioHandler2);
        rb3.addItemListener(radioHandler3);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);
        bg.add(rb3);

        frame.add(rb1);
        frame.add(rb2);
        frame.add(rb3);
        // 프레임을 화면에 보여줌
        frame.setVisible(true);
    }
}