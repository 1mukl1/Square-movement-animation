import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        JFrame jFrame = getFrame();
        jFrame.add(new ImageComponent());
    }

    static class ImageComponent extends JComponent {
        private int x = 0;
        private int y = 0;
        private int counter = 0;
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            Timer timer = new Timer(100, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    repaint();
                }
            });
            try {
                URL url = new URL("https://s1.iconbird.com/ico/0612/iconslandtransport/w32h321339250814ExecutiveCarBlack5.png");
                Image image = new ImageIcon(url).getImage();
                g2.drawImage(image, x, y, null);
                timer.start();
                if (counter == 0 && y == 0){
                    x++;
                }
                if (x == 452 && y == 0){
                    counter++;
                }
                if (counter == 1){
                    y++;
                }
                if (y == 432 && x == 452){
                    counter++;
                }
                if (counter == 2){
                    x--;
                }
                if (x == 0 && y == 432){
                    counter++;
                }
                if (x == 0 && counter == 3){
                    y--;
                }
                if (x == 0 && y == 0){
                    counter = 0;
                }
            } catch (MalformedURLException ex){
                ex.printStackTrace();
            }
        }
    }

    static JFrame getFrame() {
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setBounds(dimension.width / 2 - 250, dimension.height / 2 - 250, 500, 500);
        jFrame.setTitle("Движение по квадрату");
        try {
            URL url = new URL("https://s1.iconbird.com/ico/0612/iconslandtransport/w32h321339250814ExecutiveCarBlack5.png");
            Image image = new ImageIcon(url).getImage();
            jFrame.setIconImage(image);
        } catch (MalformedURLException ex){
            ex.printStackTrace();
        }
        jFrame.setVisible(true);
        return jFrame;
    }
}