import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JPanel implements ActionListener {
    public JTextField input = new JTextField("0");
    public double result = 0;
    public String op = "=";
    public boolean calculating = true;


    public Calculator() {
        this.setLayout(new BorderLayout());
        input.setEditable(false);
        input.setPreferredSize(new Dimension(70, 70));
        add(input, "North");

        Font bigFont = input.getFont().deriveFont(Font.PLAIN, 25f);
        input.setFont(bigFont);

        JPanel numpad = new JPanel();
        numpad.setLayout(new GridLayout(5,4));

        String buttons = "⇐C%+789-456*123/0.±=";

        for (int i =0; i < buttons.length(); i++) {
            JButton b = new JButton(buttons.substring(i, i + 1));
            b.setFont(bigFont);
            numpad.add(b);
            b.addActionListener(this);
        }
        add(numpad, "Center");

    }
    public void calculate(double n) {
        if (this.op.equals("+"))
            result += n;
        else if (this.op.equals("-"))
            result -= n;
        else if (this.op.equals("*"))
            result *= n;
        else if (this.op.equals("/"))
            result /= n;
        else if (this.op.equals("="))
            result = n;
        input.setText("" + result);
    }
    @Override
    public void actionPerformed(ActionEvent evt) {
        String cmd = evt.getActionCommand();
        if ('0' <= cmd.charAt(0) && cmd.charAt(0) <= '9' || cmd.equals(".")) {
            if (this.calculating)
                this.input.setText(cmd);
            else
                this.input.setText(this.input.getText() + cmd);
            this.calculating = false;
        } else {
            if (this.calculating) {
                if (cmd.equals("-")) {
                    this.input.setText(cmd);
                    this.calculating = false;
                } else
                    this.op = cmd;
            } else {
                double x = Double.parseDouble(this.input.getText());
                this.calculate(x);
                this.op = cmd;
                this.calculating = true;
            }
        }
    }
}
