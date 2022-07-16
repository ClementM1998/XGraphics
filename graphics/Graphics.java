package graphics;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.GeneralPath;
import java.awt.image.*;
import java.util.Random;
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
    private static float stroke = 1.2f;
    private static String fontName = "Courier New";
    private static int fontStyle = Font.PLAIN;
    private static int fontSize = 12;
    private static double scalex = 1.2;
    private static double scaley = 1.2;

    public static final int Plain = Font.PLAIN;
    public static final int Bold = Font.BOLD;
    public static final int ITALIC = Font.ITALIC;
    public static final int RomanBaseline = Font.ROMAN_BASELINE;
    public static final int CenterBaseline = Font.CENTER_BASELINE;
    public static final int HangingBaseline = Font.HANGING_BASELINE;

    private static Drawing drawing;
    private static Graphics2D graphics;

    public static final Color White = Color.white;
    public static final Color LightGray = Color.lightGray;
    public static final Color Gray = Color.gray;
    public static final Color DarkGray = Color.darkGray;
    public static final Color Black = Color.black;
    public static final Color Red = Color.red;
    public static final Color Pink = Color.pink;
    public static final Color Orange = Color.orange;
    public static final Color Yellow = Color.yellow;
    public static final Color Green = Color.green;
    public static final Color Magenta = Color.magenta;
    public static final Color Cyan = Color.cyan;
    public static final Color Blue = Color.blue;

    public static final int VK_ENTER = KeyEvent.VK_ENTER;
    public static final int VK_BACK_SPACE = KeyEvent.VK_BACK_SPACE;
    public static final int VK_TAB = KeyEvent.VK_TAB;
    public static final int VK_CANCEL = KeyEvent.VK_CANCEL;
    public static final int VK_CLEAR = KeyEvent.VK_CLEAR;
    public static final int VK_SHIFT = KeyEvent.VK_SHIFT;
    public static final int VK_CONTROL = KeyEvent.VK_CONTROL;
    public static final int VK_ALT = KeyEvent.VK_ALT;
    public static final int VK_PAUSE = KeyEvent.VK_PAUSE;
    public static final int VK_CAPS_LOCK = KeyEvent.VK_CAPS_LOCK;
    public static final int VK_ESCAPE = KeyEvent.VK_ESCAPE;
    public static final int VK_SPACE = KeyEvent.VK_SPACE;
    public static final int VK_PAGE_UP = KeyEvent.VK_PAGE_UP;
    public static final int VK_PAGE_DOWN = KeyEvent.VK_PAGE_DOWN;
    public static final int VK_END = KeyEvent.VK_END;
    public static final int VK_HOME = KeyEvent.VK_HOME;
    public static final int VK_LEFT = KeyEvent.VK_LEFT;
    public static final int VK_UP = KeyEvent.VK_UP;
    public static final int VK_RIGHT = KeyEvent.VK_RIGHT;
    public static final int VK_DOWN = KeyEvent.VK_DOWN;
    public static final int VK_COMMA = KeyEvent.VK_COMMA;
    public static final int VK_MINUS = KeyEvent.VK_MINUS;
    public static final int VK_PERIOD = KeyEvent.VK_PERIOD;
    public static final int VK_SLASH = KeyEvent.VK_SLASH;
    public static final int VK_0 = KeyEvent.VK_0;
    public static final int VK_1 = KeyEvent.VK_1;
    public static final int VK_2 = KeyEvent.VK_2;
    public static final int VK_3 = KeyEvent.VK_3;
    public static final int VK_4 = KeyEvent.VK_4;
    public static final int VK_5 = KeyEvent.VK_5;
    public static final int VK_6 = KeyEvent.VK_6;
    public static final int VK_7 = KeyEvent.VK_7;
    public static final int VK_8 = KeyEvent.VK_8;
    public static final int VK_9 = KeyEvent.VK_9;
    public static final int VK_SEMICOLON = KeyEvent.VK_SEMICOLON;
    public static final int VK_A = KeyEvent.VK_A;
    public static final int VK_B = KeyEvent.VK_B;
    public static final int VK_C = KeyEvent.VK_C;
    public static final int VK_D = KeyEvent.VK_D;
    public static final int VK_E = KeyEvent.VK_E;
    public static final int VK_F = KeyEvent.VK_F;
    public static final int VK_G = KeyEvent.VK_G;
    public static final int VK_H = KeyEvent.VK_H;
    public static final int VK_I = KeyEvent.VK_I;
    public static final int VK_J = KeyEvent.VK_J;
    public static final int VK_K = KeyEvent.VK_K;
    public static final int VK_L = KeyEvent.VK_L;
    public static final int VK_M = KeyEvent.VK_M;
    public static final int VK_N = KeyEvent.VK_N;
    public static final int VK_O = KeyEvent.VK_O;
    public static final int VK_P = KeyEvent.VK_P;
    public static final int VK_Q = KeyEvent.VK_Q;
    public static final int VK_R = KeyEvent.VK_R;
    public static final int VK_S = KeyEvent.VK_S;
    public static final int VK_T = KeyEvent.VK_T;
    public static final int VK_U = KeyEvent.VK_U;
    public static final int VK_V = KeyEvent.VK_V;
    public static final int VK_W = KeyEvent.VK_W;
    public static final int VK_X = KeyEvent.VK_X;
    public static final int VK_Y = KeyEvent.VK_Y;
    public static final int VK_Z = KeyEvent.VK_Z;
    public static final int VK_OPEN_BRACKET = KeyEvent.VK_OPEN_BRACKET;
    public static final int VK_BACK_SLASH = KeyEvent.VK_BACK_SLASH;
    public static final int VK_CLOSE_BRACKET = KeyEvent.VK_CLOSE_BRACKET;
    public static final int VK_NUMPAD0 = KeyEvent.VK_NUMPAD0;
    public static final int VK_NUMPAD1 = KeyEvent.VK_NUMPAD1;
    public static final int VK_NUMPAD2 = KeyEvent.VK_NUMPAD2;
    public static final int VK_NUMPAD3 = KeyEvent.VK_NUMPAD3;
    public static final int VK_NUMPAD4 = KeyEvent.VK_NUMPAD4;
    public static final int VK_NUMPAD5 = KeyEvent.VK_NUMPAD5;
    public static final int VK_NUMPAD6 = KeyEvent.VK_NUMPAD6;
    public static final int VK_NUMPAD7 = KeyEvent.VK_NUMPAD7;
    public static final int VK_NUMPAD8 = KeyEvent.VK_NUMPAD8;
    public static final int VK_NUMPAD9 = KeyEvent.VK_NUMPAD9;
    public static final int VK_MULTIPLY = KeyEvent.VK_MULTIPLY;
    public static final int VK_ADD = KeyEvent.VK_ADD;
    public static final int VK_SEPARATER = KeyEvent.VK_SEPARATER;
    public static final int VK_SEPARATOR = KeyEvent.VK_SEPARATOR;
    public static final int VK_SUBTRACT = KeyEvent.VK_SUBTRACT;
    public static final int VK_DECIMAL = KeyEvent.VK_DECIMAL;
    public static final int VK_DIVIDE = KeyEvent.VK_DIVIDE;
    public static final int VK_DELETE = KeyEvent.VK_DELETE;
    public static final int VK_NUM_LOCK = KeyEvent.VK_NUM_LOCK;
    public static final int VK_SCROLL_LOCK = KeyEvent.VK_SCROLL_LOCK;
    public static final int VK_F1 = KeyEvent.VK_F1;
    public static final int VK_F2 = KeyEvent.VK_F2;
    public static final int VK_F3 = KeyEvent.VK_F3;
    public static final int VK_F4 = KeyEvent.VK_F4;
    public static final int VK_F5 = KeyEvent.VK_F5;
    public static final int VK_F6 = KeyEvent.VK_F6;
    public static final int VK_F7 = KeyEvent.VK_F7;
    public static final int VK_F8 = KeyEvent.VK_F8;
    public static final int VK_F9 = KeyEvent.VK_F9;
    public static final int VK_F10 = KeyEvent.VK_F10;
    public static final int VK_F11 = KeyEvent.VK_F11;
    public static final int VK_F12 = KeyEvent.VK_F12;
    public static final int VK_F13 = KeyEvent.VK_F13;
    public static final int VK_F14 = KeyEvent.VK_F14;
    public static final int VK_F15 = KeyEvent.VK_F15;
    public static final int VK_F16 = KeyEvent.VK_F16;
    public static final int VK_F17 = KeyEvent.VK_F17;
    public static final int VK_F18 = KeyEvent.VK_F18;
    public static final int VK_F19 = KeyEvent.VK_F19;
    public static final int VK_F20 = KeyEvent.VK_F20;
    public static final int VK_F21 = KeyEvent.VK_F21;
    public static final int VK_F22 = KeyEvent.VK_F22;
    public static final int VK_F23 = KeyEvent.VK_F23;
    public static final int VK_F24 = KeyEvent.VK_F24;
    public static final int VK_PRINTSCREEN = KeyEvent.VK_PRINTSCREEN;
    public static final int VK_INSERT = KeyEvent.VK_INSERT;
    public static final int VK_HELP = KeyEvent.VK_HELP;
    public static final int VK_META = KeyEvent.VK_META;
    public static final int VK_BACK_QUOTE = KeyEvent.VK_BACK_QUOTE;
    public static final int VK_QUOTE = KeyEvent.VK_QUOTE;
    public static final int VK_KP_UP = KeyEvent.VK_KP_UP;
    public static final int VK_KP_DOWN = KeyEvent.VK_KP_DOWN;
    public static final int VK_KP_LEFT = KeyEvent.VK_KP_LEFT;
    public static final int VK_KP_RIGHT = KeyEvent.VK_KP_RIGHT;
    public static final int VK_AT = KeyEvent.VK_AT;
    public static final int VK_COLON = KeyEvent.VK_COLON;
    public static final int VK_CIRCUMFLEX = KeyEvent.VK_CIRCUMFLEX;
    public static final int VK_DOLLAR = KeyEvent.VK_DOLLAR;
    public static final int VK_EURO_SIGN = KeyEvent.VK_EURO_SIGN;
    public static final int VK_EXCLAMATION_MARK = KeyEvent.VK_EXCLAMATION_MARK;
    public static final int VK_INVERTED_EXCLAMATION_MARK = KeyEvent.VK_INVERTED_EXCLAMATION_MARK;
    public static final int VK_LEFT_PARENTHESIS = KeyEvent.VK_LEFT_PARENTHESIS;
    public static final int VK_RIGH_PARENTHESIS = KeyEvent.VK_RIGHT_PARENTHESIS;
    public static final int VK_NUMBER_SIGN = KeyEvent.VK_NUMBER_SIGN;
    public static final int VK_PLUS = KeyEvent.VK_PLUS;
    public static final int VK_UNDERSCORE = KeyEvent.VK_UNDERSCORE;
    public static final int VK_WINDOWS = KeyEvent.VK_WINDOWS;
    public static final int VK_CONTEXT_MENU = KeyEvent.VK_CONTEXT_MENU;
    public static final int VK_FINAL = KeyEvent.VK_FINAL;
    public static final int VK_CONVERT = KeyEvent.VK_CONVERT;
    public static final int VK_NONCONVERT = KeyEvent.VK_NONCONVERT;
    public static final int VK_ACCEPT = KeyEvent.VK_ACCEPT;
    public static final int VK_MODECHANGE = KeyEvent.VK_MODECHANGE;
    public static final int VK_KANA = KeyEvent.VK_KANA;
    public static final int VK_KANJI = KeyEvent.VK_KANJI;
    public static final int VK_ALPHANUMERIC = KeyEvent.VK_ALPHANUMERIC;
    public static final int VK_CUT = KeyEvent.VK_CUT;
    public static final int VK_COPY = KeyEvent.VK_COPY;
    public static final int VK_PASTE = KeyEvent.VK_PASTE;
    public static final int VK_UNDO = KeyEvent.VK_UNDO;
    public static final int VK_AGAIN = KeyEvent.VK_AGAIN;
    public static final int VK_FIND = KeyEvent.VK_FIND;
    public static final int VK_PROPS = KeyEvent.VK_PROPS;
    public static final int VK_STOP = KeyEvent.VK_STOP;
    public static final int VK_COMPOSE = KeyEvent.VK_COMPOSE;
    public static final int VK_ALT_GRAPH = KeyEvent.VK_ALT_GRAPH;
    public static final int VK_BEGIN = KeyEvent.VK_BEGIN;
    public static final int VK_UNDEFINED = KeyEvent.VK_UNDEFINED;

    protected Graphics() {}

    // create window

    public static void createWindow(String title) {
        createWindow(title, screenWidth, screenHeight);
    }

    public static void createWindow(int width, int height) {
        createWindow("Graphics", width, height);
    }

    public static void createWindow(String title, int width, int height) {
        createWindow(title, 0, 0, width, height);
    }

    public static void createWindow(int posx, int posy, int width, int height) {
        createWindow("Graphics", posx, posy, width, height);
    }

    public static void createWindow(String title, int posx, int posy, int width, int height) {
        Graphics.title = title;
        Graphics.posx = posx;
        Graphics.posy = posy;
        Graphics.width = width;
        Graphics.height = height;

        initWindow();
    }

    private static void initWindow() {
        window.setTitle(title);
        //window.setSize(width, height);
        window.setLocation(posx, posy);
        window.setResizable(false);

        JPanel panel = new JPanel(new GridBagLayout());
        drawing = new Drawing(width, height);
        window.setContentPane(panel);
        window.add(drawing);

        // handle key, mouse, mousemotion
        window.addKeyListener(drawing);
        window.addMouseListener(drawing);
        window.addMouseMotionListener(drawing);

        graphics = drawing.getGraphics();

        window.pack();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    public static int getScreenWidth() {
        return window.getWidth();
    }

    public static int getScreenHeight() {
        return window.getHeight();
    }

    public static void delay(long msec) {
        try {
            Thread.sleep(msec);
        } catch (InterruptedException e) {}
    }

    public static int random() {
        return new Random().nextInt();
    }

    public static int random(int bounds) {
        return new Random().nextInt(bounds);
    }

    public static void closeWindow() {
        if (window != null) System.exit(0);
        else System.exit(1);
    }

    public static void setBackColor(int red, int green, int blue) {
        Color color = new Color(red, green, blue);
        setBackColor(color);
    }

    public static void setBackColor(Color color) {
        Graphics.backColor = color;
        graphics.setColor(backColor);
        graphics.fillRect(0, 0, width, height);
    }

    public static void setScale(double s) {
        setScale(s, s);
    }

    public static void setScale(double sx, double sy) {
        Graphics.scalex = sx;
        Graphics.scaley = sy;
    }

    public static void clearWindow() {
        graphics.setColor(backColor);
        graphics.fillRect(0, 0, width, height);
    }

    public static void refreshWindow() {
        window.repaint();
    }

    // draw graphics

    public static void setAntialias(boolean antialias) {
        Graphics.antialias = antialias;
    }

    public static void setStroke(float weight) {
        Graphics.stroke = weight;
    }

    public static void setColor(int alpha, int red, int green, int blue) {
        Color color = new Color(red, green, blue, alpha);
        setColor(color);
    }

    public static void setColor(int red, int green, int blue) {
        Color color = new Color(red, green, blue);
        setColor(color);
    }

    public static void setColor(Color color) {
        Graphics.color = color;
    }

    public static Color createColor(int red, int green, int blue) {
        return new Color(red, green, blue);
    }

    public static void setColor(int alpha, Color color) {
        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();
        setColor(new Color(r, g, b, alpha));
    }

    public static void setFilled(boolean filled) {
        Graphics.filled = filled;
    }

    public static void setFont(String name, int style, int size) {
        setFontName(name);
        setFontStyle(style);
        setFontSize(size);
    }

    public static void setFontName(String name) {
        if (name == null || name.equals("")) name = "Courier New";
        Graphics.fontName = name;
    }

    public static void setFontStyle(int style) {
        Graphics.fontStyle = style;
    }

    public static void setFontSize(int size) {
        Graphics.fontSize = size;
    }

    public static Font getFont() {
        return graphics.getFont();
    }

    public static FontMetrics getFontMetrics() {
        return getFontMetrics(getFont());
    }

    public static FontMetrics getFontMetrics(Font font) {
        return graphics.getFontMetrics(font);
    }

    public static void arc(int x, int y, int width, int height, int startangle, int sweepangle) {
        graphics.setRenderingHints(getRendering(antialias));
        graphics.setStroke(new BasicStroke(stroke));
        graphics.setColor(color);
        if (Graphics.filled) {
            graphics.fillArc(x, y, width, height, startangle, sweepangle);
        } else {
            graphics.drawArc(x, y, width, height, startangle, sweepangle);
        }
        window.repaint();
    }

    public static void circle(int x, int y, int radius) {
        graphics.setRenderingHints(getRendering(antialias));
        graphics.setStroke(new BasicStroke(stroke));
        graphics.setColor(color);
        if (Graphics.filled) {
            graphics.fillOval(x, y, radius, radius);
        } else {
            graphics.drawOval(x, y, radius, radius);
        }
        window.repaint();
    }

    public static void point(int x, int y) {
        graphics.setRenderingHints(getRendering(antialias));
        graphics.setStroke(new BasicStroke(stroke));
        graphics.setColor(color);
        graphics.drawLine(x, y, x, y);
        window.repaint();
    }

    public static void line(int x1, int y1, int x2, int y2) {
        graphics.setRenderingHints(getRendering(antialias));
        graphics.setStroke(new BasicStroke(stroke));
        graphics.setColor(color);
        graphics.drawLine(x1, y1, x2, y2);
        window.repaint();
    }

    public static void rectangle(int x, int y, int width, int height) {
        graphics.setRenderingHints(getRendering(antialias));
        graphics.setStroke(new BasicStroke(stroke));
        graphics.setColor(color);
        int[] xpoint = new int[] {x, width, width, x, x};
        int[] ypoint = new int[] {y, y, height, height, y};
        if (Graphics.filled) {
            //polygon(xpoint, ypoint);
            graphics.fillRect(x, y, width, height);
        } else {
            //polyline(xpoint, ypoint);
            graphics.drawRect(x, y, width, height);
        }
        window.repaint();
    }

    public static void triangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        graphics.setRenderingHints(getRendering(antialias));
        graphics.setStroke(new BasicStroke(stroke));
        graphics.setColor(color);
        int[] xpoint = new int[] {x1, x2, x3};
        int[] ypoint = new int[] {y1, y2, y2};
        if (Graphics.filled) {
            polygon(xpoint, ypoint);
        } else {
            polygon(xpoint, ypoint);
        }
    }

    public static void ellipse(int x, int y, int width, int height) {
        graphics.setRenderingHints(getRendering(antialias));
        graphics.setStroke(new BasicStroke(stroke));
        graphics.setColor(color);
        if (Graphics.filled) {
            graphics.fillOval(x, y, width, height);
        } else {
            graphics.drawOval(x, y, width, height);
        }
    }

    public static void square(int x, int y, int size) {
        graphics.setRenderingHints(getRendering(antialias));
        graphics.setStroke(new BasicStroke(stroke));
        graphics.setColor(color);
        if (Graphics.filled) {
            graphics.fillRect(x, y, size, size);
        } else {
            graphics.drawRect(x, y, size, size);
        }
        window.repaint();
    }

    public static void polygon(int[] xpoints, int[] ypoints) {
        graphics.setRenderingHints(getRendering(antialias));
        graphics.setStroke(new BasicStroke(stroke));
        if (xpoints.length != ypoints.length) throw new IndexOutOfBoundsException("x point and y point must have a same size");
        int npoint = xpoints.length;
        graphics.setColor(color);
        if (Graphics.filled) {
            graphics.fillPolygon(xpoints, ypoints, npoint);
        } else {
            graphics.drawPolygon(xpoints, ypoints, npoint);
        }
        window.repaint();
    }

    public static void polyline(int[] xpoints, int[] ypoints) {
        graphics.setRenderingHints(getRendering(antialias));
        graphics.setStroke(new BasicStroke(stroke));
        if (xpoints.length != ypoints.length) throw new IndexOutOfBoundsException("x point and y point must have a same size");
        int npoint = xpoints.length;
        graphics.setColor(color);
        graphics.drawPolyline(xpoints, ypoints, npoint);
        window.repaint();
    }

    public static void text(String text, int x, int y) {
        graphics.setRenderingHints(getRendering(antialias));
        graphics.setStroke(new BasicStroke(stroke));
        Font font = new Font(fontName, fontStyle, fontSize);
        graphics.setFont(font);
        graphics.setColor(color);

        FontMetrics fm = graphics.getFontMetrics();
        graphics.drawString(text, x, (y + fm.getAscent()));
        window.repaint();
    }

    public static void image(String res, int x, int y) {
        ImageIcon image = new ImageIcon(res);
        graphics.drawImage(image.getImage(), x, y, null);
        window.repaint();
    }

    public static void image(String res, int x, int y, int w, int h) {
        ImageIcon image = new ImageIcon(res);
        graphics.drawImage(image.getImage(), x, y, w, h, null);
        window.repaint();
    }

    private static RenderingHints getRendering(boolean b) {
        RenderingHints hints = new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        if (b) {
            hints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            hints.put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        } else {
            hints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
            hints.put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
        }
        return hints;
    }

    public static boolean ismouse_button() {
        return drawing.mouse_button;
    }

    public static boolean ismouse_available() {
        return drawing.mouse_available;
    }

    public static boolean ismouse_move() {
        return drawing.mouse_moved;
    }

    public static boolean ismouse_dragged() {
        return drawing.mouse_dragged;
    }

    public static Point getMousePos() {
        return drawing.mousePos;
    }

    public static int mousex() {
        return getMousePos().x;
    }

    public static int mousey() {
        return getMousePos().y;
    }

    public static boolean iskey_down() {
        return drawing.key_down;
    }

    public static boolean iskey_up() {
        return drawing.key_up;
    }

    /*
    public static char getKeyChar() {
        return drawing.getKeyChar();
    }
     */

    public static int getKeyCode() {
        return drawing.getKeyCode();
    }

    public static String getKeyText() {
        return drawing.getKeyText();
    }

    public static boolean isKey(char key) {
        return drawing.isKey((int) key);
    }

    public static boolean isKey(int code) {
        return drawing.isKey(code);
    }

    public static boolean isPopupTrigger() {
        return drawing.isPopupTrigger;
    }

    public static boolean isActionKey() {
        return drawing.isActionKey;
    }

    public static boolean isAltDown() {
        return drawing.isAltDown;
    }

    public static boolean isAltGraphDown() {
        return drawing.isAltGraphDown;
    }

    public static boolean isConsumed() {
        return drawing.isConsumed;
    }

    public static boolean isControlDown() {
        return drawing.isControlDown;
    }

    public static boolean isMetaDown() {
        return drawing.isMetaDown;
    }

    public static boolean isShiftDown() {
        return drawing.isShiftDown;
    }

    public static void translate(double x, double y) {
        graphics.translate(x, y);
    }

    public static void shear(double shx, double shy) {
        graphics.shear(shx, shy);
    }

    public static void rotate(double rotate) {
        graphics.rotate(rotate);
    }

    private static GeneralPath path = null;

    public static void createPath() {
        if (path == null) path = new GeneralPath();
    }

    public static void moveTo(double x, double y) {
        if (path == null) throw new NullPointerException("path is null");
        path.moveTo(x, y);
    }

    public static void lineTo(double x, double y) {
        if (path == null) throw new NullPointerException("path is null");
        path.lineTo(x, y);
    }

    public static void quadTo(double x1, double y1, double x2, double y2) {
        if (path == null) throw new NullPointerException("path is null");
        path.quadTo(x1, y1, x2, y2);
    }

    public static void curveTo(double x1, double y1, double x2, double y2, double x3, double y3) {
        if (path == null) throw new NullPointerException("path is null");
        path.curveTo(x1, y1, x2, y2, x3, y3);
    }

    public static void closePath() {
        if (path == null) throw new NullPointerException("path is null");
        path.closePath();
    }

    public static void drawPath() {
        graphics.setRenderingHints(getRendering(antialias));
        graphics.setStroke(new BasicStroke(stroke));
        graphics.setColor(color);
        graphics.draw(path);
        window.repaint();
    }

    static class Drawing extends JPanel implements MouseListener, MouseMotionListener, KeyListener {
        private Dimension size;
        private Graphics2D graphics;
        private BufferedImage image;
        private Point mousePos = new Point();
        private int keyCode = 0;
        //private char keyChar = '\0';

        /* mousePressed > mouseReleased > mouseClicked */
        public boolean mouse_button = false;

        /* mouseEntered > mouseExited */
        public boolean mouse_available = false;

        public boolean mouse_dragged = false;
        public boolean mouse_moved = false;

        /* keyPressed > keyTyped > keyReleased */
        public boolean key_down = false;
        public boolean key_up = false;

        /*
         * // in mouse handle
         * e.isPopupTrigger();
         *
         * // in key handle
         *
         * e.isActionKey();
         *
         * // standard is
         * e.isAltDown();
         * e.isAltGraphDown();
         * e.isConsumed();
         * e.isControlDown();
         * e.isMetaDown();
         * e.isShiftDown();
         */

        public boolean isPopupTrigger = false;
        public boolean isActionKey = false;

        public boolean isAltDown = false;
        public boolean isAltGraphDown = false;
        public boolean isConsumed = false;
        public boolean isControlDown = false;
        public boolean isMetaDown = false;
        public boolean isShiftDown = false;

        public Drawing(int width, int height) {
            size = new Dimension(width, height);
            setPreferredSize(size);
            setMaximumSize(size);
            setMinimumSize(size);

            setFocusable(true);
            addKeyListener(this);
            addMouseListener(this);
            addMouseMotionListener(this);

            image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            graphics = (Graphics2D) image.getGraphics();
            graphics.setRenderingHints(getRendering(true));
        }

        @Override
        public void paint(java.awt.Graphics g) {
            super.paint(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHints(getRendering(true));
            g2.drawImage(image, 0, 0, null);
        }

        public Dimension getSize() {
            return size;
        }

        public Graphics2D getGraphics() {
            return graphics;
        }

        public Point getMousePosition() {
            return mousePos;
        }

        /*
        public char getKeyChar() {
            return keyChar;
        }
         */

        public int getKeyCode() {
            return keyCode;
        }

        /*
        public boolean isKey(char key) {
            return getKeyChar() == key;
        }
         */

        public boolean isKey(int code) {
            return getKeyCode() == code;
        }

        public String getKeyText() {
            return KeyEvent.getKeyText(getKeyCode());
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            mouse_button = false;
            //System.out.println("mouseClicked: " + e.getX() + "," + e.getY());
            mousePos.x = e.getX();
            mousePos.y = e.getY();
            isPopupTrigger = e.isPopupTrigger();

            isAltDown = e.isAltDown();
            isAltGraphDown = e.isAltGraphDown();
            isConsumed = e.isConsumed();
            isControlDown = e.isControlDown();
            isMetaDown = e.isMetaDown();
            isShiftDown = e.isShiftDown();
        }

        @Override
        public void mousePressed(MouseEvent e) {
            mouse_button = true;
            //System.out.println("mousePressed: " + e.getX() + "," + e.getY());
            mousePos.x = e.getX();
            mousePos.y = e.getY();
            isPopupTrigger = e.isPopupTrigger();

            isAltDown = e.isAltDown();
            isAltGraphDown = e.isAltGraphDown();
            isConsumed = e.isConsumed();
            isControlDown = e.isControlDown();
            isMetaDown = e.isMetaDown();
            isShiftDown = e.isShiftDown();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            mouse_button = true;
            //System.out.println("mouseReleased: " + e.getX() + "," + e.getY());
            mousePos.x = e.getX();
            mousePos.y = e.getY();
            isPopupTrigger = e.isPopupTrigger();

            isAltDown = e.isAltDown();
            isAltGraphDown = e.isAltGraphDown();
            isConsumed = e.isConsumed();
            isControlDown = e.isControlDown();
            isMetaDown = e.isMetaDown();
            isShiftDown = e.isShiftDown();
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            mouse_available = true;
            //System.out.println("mouseEntered: " + mouse_available + " : " + e.getX() + "," + e.getY());
            mousePos.x = e.getX();
            mousePos.y = e.getY();
            isPopupTrigger = e.isPopupTrigger();

            isAltDown = e.isAltDown();
            isAltGraphDown = e.isAltGraphDown();
            isConsumed = e.isConsumed();
            isControlDown = e.isControlDown();
            isMetaDown = e.isMetaDown();
            isShiftDown = e.isShiftDown();
        }

        @Override
        public void mouseExited(MouseEvent e) {
            mouse_available = false;
            mouse_moved = false;
            //System.out.println("mouseExited: " + mouse_available + " : " + e.getX() + "," + e.getY());
            mousePos.x = e.getX();
            mousePos.y = e.getY();
            isPopupTrigger = e.isPopupTrigger();

            isAltDown = e.isAltDown();
            isAltGraphDown = e.isAltGraphDown();
            isConsumed = e.isConsumed();
            isControlDown = e.isControlDown();
            isMetaDown = e.isMetaDown();
            isShiftDown = e.isShiftDown();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            mouse_dragged = true;
            //System.out.println("mouseDragged: " + mouse_dragged + " : " + e.getX() + "," + e.getY());
            mousePos.x = e.getX();
            mousePos.y = e.getY();
            isPopupTrigger = e.isPopupTrigger();

            isAltDown = e.isAltDown();
            isAltGraphDown = e.isAltGraphDown();
            isConsumed = e.isConsumed();
            isControlDown = e.isControlDown();
            isMetaDown = e.isMetaDown();
            isShiftDown = e.isShiftDown();
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            mouse_moved = true;
            //System.out.println("mouseMoved: " + mouse_moved + " : " + e.getX() + "," + e.getY());
            mousePos.x = e.getX();
            mousePos.y = e.getY();
            isPopupTrigger = e.isPopupTrigger();

            isAltDown = e.isAltDown();
            isAltGraphDown = e.isAltGraphDown();
            isConsumed = e.isConsumed();
            isControlDown = e.isControlDown();
            isMetaDown = e.isMetaDown();
            isShiftDown = e.isShiftDown();
        }

        @Override
        public void keyTyped(KeyEvent e) {
            /*
            key_down = true;
            key_up = false;
            System.out.println("keyTyped: " + e.getKeyChar());
            keyCode = e.getKeyCode();
            //keyChar = e.getKeyChar();
            isActionKey = e.isActionKey();

            isAltDown = e.isAltDown();
            isAltGraphDown = e.isAltGraphDown();
            isConsumed = e.isConsumed();
            isControlDown = e.isControlDown();
            isMetaDown = e.isMetaDown();
            isShiftDown = e.isShiftDown();
             */
        }

        @Override
        public void keyPressed(KeyEvent e) {
            key_down = true;
            key_up = false;
            //System.out.println("keyPressed: " + e.getKeyChar());
            keyCode = e.getKeyCode();
            //keyChar = e.getKeyChar();
            isActionKey = e.isActionKey();

            isAltDown = e.isAltDown();
            isAltGraphDown = e.isAltGraphDown();
            isConsumed = e.isConsumed();
            isControlDown = e.isControlDown();
            isMetaDown = e.isMetaDown();
            isShiftDown = e.isShiftDown();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            key_down = false;
            key_up = true;
            //System.out.println("keyReleased: " + e.getKeyChar());
            keyCode = 0;
            //keyChar = e.getKeyChar();
            isActionKey = e.isActionKey();

            isAltDown = e.isAltDown();
            isAltGraphDown = e.isAltGraphDown();
            isConsumed = e.isConsumed();
            isControlDown = e.isControlDown();
            isMetaDown = e.isMetaDown();
            isShiftDown = e.isShiftDown();
        }
    }

}
