package graphics;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class Graphics {
    private static JFrame window = new JFrame();
    private static String title = "";
    private static int screenWidth = 640;
    private static int screenHeight = 480;
    private static int width = screenWidth;
    private static int height = screenHeight;
    private static int posx = 0;
    private static int posy = 0;
    private static Color color = Color.white;
    private static Color backColor = Color.black;
    private static boolean filled = false;
    private static boolean antialias = true;
}
