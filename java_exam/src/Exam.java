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
       //프레임안에 배치될 버튼들의 배치방식 설정 그리드레이아웃 (행,열,세로선 간격,가로선 간격)
        frame.setLayout(new GridLayout(3,2));

        //버튼 객체를 생성
        JLabel label1 = new JLabel("ID");
        JLabel label2 = new JLabel("Password");
        JLabel label3 = new JLabel("e-mail");

        //JTextField :문자열 출력을 위한 컴포넌트
        JTextField textField1 = new JTextField(10);
        //JPasswordField : 비밀번호입력시 가려져서 출력
        JPasswordField textField2 = new JPasswordField(10);
        JTextField textField3 = new JTextField();

        PWHandler pwHandler = new PWHandler (textField1, textField2);
        textField1.addActionListener(pwHandler);
        textField2.addActionListener(pwHandler);

        //버튼을 프레임 안에 추가
        frame.add(label1);
        frame.add(textField1);
        frame.add(label2);
        frame.add(textField2);
        frame.add(label3);
        frame.add(textField3);

        //프레임을 화면에 보여줌
        frame.setVisible(true);

    }
}



