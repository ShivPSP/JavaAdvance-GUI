package chatclient;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class UtilityFunctions {
    public static Point getCenter(JFrame f){
        Dimension d1 = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension d2 = f.getSize();
        int x = (d1.width-d2.width)/2;
        int y = (d1.height-d2.height)/2;
        Point p = new Point(x,y);
        return p;
    }
}
