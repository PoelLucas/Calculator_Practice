import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Frame frame = new Frame();
        Container contentPane = frame.getContentPane();
        contentPane.add(new Calculator());
        frame.show();
    }
}