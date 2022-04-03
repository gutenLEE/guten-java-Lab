package observerpattern.handson;

import javax.swing.*;
import java.text.SimpleDateFormat;

public class SimpleObserverExample {

    JFrame jFrame;

    public static void main(String[] args) {
        SimpleObserverExample example = new SimpleObserverExample();
        example.go();
    }

    public void go() {
        jFrame = new JFrame();

        JButton button = new JButton("할까 말까?");
        button.addActionListener(new AngelListener());
        button.addActionListener(new DevilListener());
    }
}
