package tpkzi.labs.lab4;

import tpkzi.labs.lab4.coder.CyclicCoder;

import javax.swing.*;
import java.awt.*;

public class App
{
    public static void main( String[] args )
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                int d = 0b1101;
                int p = 0b1011;

                JFrame frame = new GUI();
                frame.setTitle("Cyclic coder");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);

                CyclicCoder coder = new CyclicCoder();
                int x = coder.encode(d);
                System.out.println(Integer.toBinaryString(x));
                System.out.println(Integer.toBinaryString(coder.decode(0b1100001)));

            }
        });

    }
}

class GUI extends JFrame{
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 400;
    private static final int TEXT_FIELD_COLUMNS = 10;
    //private JTextField in;
    private JButton encode;
    private JButton decode;
    //private JLabel inData;
    //private JLabel labelResult;
    private JTextArea textResult;

    public GUI(){
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        //inData = new JLabel("Input 4 bits");
        //in = new JTextField(TEXT_FIELD_COLUMNS);
        encode = new JButton("Encode!");
        decode = new JButton("Decode!");
        //labelResult = new JLabel("Decoding result");
        textResult = new JTextArea();

        JPanel panel = new JPanel();
        /*GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);*/
        panel.add(new JLabel("Input 4 bits"), new GBC(0, 0).setInsets(25));
        panel.add(new JTextField(TEXT_FIELD_COLUMNS), new GBC(1, 0).setInsets(10));
        panel.add(encode, new GBC(0, 1));
        panel.add(decode, new GBC(1, 1));
        panel.add(new JLabel("Decoding result"), new GBC(0, 3));
        add(panel);

    }
}