import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Scanner;

public class Exam {
    public static void main(String[] args) {
        Man bm = new Man("홍길동");
        System.out.print(bm.getName());
        bm.setName("이몽룡");
        System.out.print(bm.getName());
    }
}