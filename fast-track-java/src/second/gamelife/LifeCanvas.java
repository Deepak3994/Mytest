import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.WindowConstants;
import javax.swing.JFrame;

public class LifeCanvas extends Canvas {
    private int width, height;
    private JFrame frame;

    public static LifeCanvas create(int width, int height) {
        assert(width > 0 && width <= 512 && height > 0 && height <= 512);
        JFrame frame = new JFrame();
        LifeCanvas lc = new LifeCanvas();
 
        frame.setSize(width, height);
        frame.add(lc);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

        lc.setFrame(frame);
        lc.setDimensions(width, height);
        return lc;
    }

    public LifeCanvas() {
        this.frame = null;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public void setDimensions(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void close() {
        this.frame.setVisible(false);
        this.frame.dispose();
        this.frame = null;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for(int x = 0; x < this.width; x++) {
            for(int y = 0; y < this.height; y++) {
                g.setColor(Color.ORANGE);
                g.drawLine(x, y, x, y);
            }
        }
    }

    public static void main(String[] args) {
        LifeCanvas lc = create(512, 512);
    }
}
