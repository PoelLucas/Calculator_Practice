import javax.swing.*;
import java.util.Objects;

public class Frame extends JFrame {
    private final ImageIcon logo;
    Frame() {
        this.setDefaultLookAndFeelDecorated(false);
        this.setTitle("The best Calculator ever");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        logo = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/resource/logo.png")));
        this.setIconImage(logo.getImage());
        this.setSize(400, 500);

        this.setVisible(true);

    }
}
