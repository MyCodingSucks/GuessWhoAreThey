import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class GuessWhoAreThey {
    public static void main(String[] args) {

        JFrame win = new JFrame("Guess who the lucky dogs are?   by kunihiro");
        win.setSize(450, 180);
        ImageIcon icon = new ImageIcon("icon.png");
        win.setIconImage(icon.getImage());
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        win.add(panel);
        panel.setLayout(null);

        JLabel text1 = new JLabel("总人数 :");
        text1.setBounds(20, 20, 200, 25);
        text1.setFont(new Font("" , 0 , 18));
        panel.add(text1);


        JTextField userText = new JTextField("");
        userText.setBounds(90, 20, 30, 25);
        panel.add(userText);

        JLabel text2 = new JLabel("抽取人数 :");
        text2.setBounds(20, 65, 230, 25);
        text2.setFont(new Font("" , 0 , 18));
        panel.add(text2);

        JTextField userText1 = new JTextField("");
        userText1.setBounds(110, 65, 30, 25);
        panel.add(userText1);

        JButton draw = new JButton("DRAW! (Alt + Enter)");
        draw.setFont(new Font("" , 0 , 12));
        draw.setBounds(200, 65, 150, 25);
        draw.setMnemonic(KeyEvent.VK_ENTER);
        draw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int PeopleNumber = Integer.parseInt(userText.getText().trim());
                int DrawNumber = Integer.parseInt(userText1.getText().trim());
                Random rand = new Random();
                HashSet<Integer> set = new HashSet<>();

                while (set.size() < DrawNumber) {
                    set.add(rand.nextInt(PeopleNumber) + 1);
                }
                Integer[] temp =  set.toArray(new Integer[] {});
                int[] value = new int[temp.length];
                for (int i = 0; i < temp.length; i++) {
                    value[i] = temp[i].intValue();
                }
                Arrays.sort(value);

                String result_s = Arrays.toString(value);

                JFrame num_win = new JFrame("RESULT");
                num_win.setSize(650 , 400);
                num_win.setIconImage(icon.getImage());
                num_win.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

                JPanel num_panel = new JPanel();
                num_win.add(num_panel);
                num_panel.setLayout(null);

                //（强烈谴责改号数的行为）
                JLabel a = new JLabel("RESULT :  ");
                a.setBounds(20, 10, 150, 30);
                Font font = new Font("", 0, 19);
                a.setFont(font);
                num_panel.add(a);

                JTextArea result = new JTextArea(result_s);
                result.setLayout(null);
                result.setLineWrap(true);
                result.setBounds(20, 50, 590, 300);
                Font font_t = new Font("", 0, 25);
                result.setFont(font_t);
                result.setEditable(false );
                num_panel.add(result);

                num_win.setVisible(true);

            }
        });

        panel.add(draw);

        win.setVisible(true);
    }
}
