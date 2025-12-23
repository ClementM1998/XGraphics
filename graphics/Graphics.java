package graphics;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.GeneralPath;
import java.awt.image.*;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
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
    private static int color = Graphics.White;
    private static int backColor = Graphics.Black;
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
    public static final int Italic = Font.ITALIC;
    public static final int RomanBaseline = Font.ROMAN_BASELINE;
    public static final int CenterBaseline = Font.CENTER_BASELINE;
    public static final int HangingBaseline = Font.HANGING_BASELINE;

    private static Drawing drawing;
    private static Graphics2D graphics;

    public static final int White     = 0xFFFFFFFF; // (255, 255, 255)
    public static final int LightGray = 0xFFCCCCCC; // (204, 204, 204)
    public static final int Gray      = 0xFF888888; // (136, 136, 136)
    public static final int DarkGray  = 0xFF444444; // (68, 68, 68)
    public static final int Black     = 0xFF000000; // (0, 0, 0)
    public static final int Red       = 0xFFFF0000; // (255, 0, 0)
    public static final int Pink      = 0xFFFFC0CB; // (255, 192, 203)
    public static final int Orange    = 0xFFFFA500; // (255, 165, 0)
    public static final int Yellow    = 0xFFFFFF00; // (255, 255, 0)
    public static final int Green     = 0xFF00FF00; // (0, 255, 0)
    public static final int Magenta   = 0xFFFF00FF; // (255, 0, 255)
    public static final int Cyan      = 0xFF00FFFF; // (0, 255, 255)
    public static final int Blue      = 0xFF0000FF; // (0, 0, 255)

    public static final int KEY_ENTER = KeyEvent.VK_ENTER;
    public static final int KEY_BACK_SPACE = KeyEvent.VK_BACK_SPACE;
    public static final int KEY_TAB = KeyEvent.VK_TAB;
    public static final int KEY_CANCEL = KeyEvent.VK_CANCEL;
    public static final int KEY_CLEAR = KeyEvent.VK_CLEAR;
    public static final int KEY_SHIFT = KeyEvent.VK_SHIFT;
    public static final int KEY_CONTROL = KeyEvent.VK_CONTROL;
    public static final int KEY_ALT = KeyEvent.VK_ALT;
    public static final int KEY_PAUSE = KeyEvent.VK_PAUSE;
    public static final int KEY_CAPS_LOCK = KeyEvent.VK_CAPS_LOCK;
    public static final int KEY_ESCAPE = KeyEvent.VK_ESCAPE;
    public static final int KEY_SPACE = KeyEvent.VK_SPACE;
    public static final int KEY_PAGE_UP = KeyEvent.VK_PAGE_UP;
    public static final int KEY_PAGE_DOWN = KeyEvent.VK_PAGE_DOWN;
    public static final int KEY_END = KeyEvent.VK_END;
    public static final int KEY_HOME = KeyEvent.VK_HOME;
    public static final int KEY_LEFT = KeyEvent.VK_LEFT;
    public static final int KEY_UP = KeyEvent.VK_UP;
    public static final int KEY_RIGHT = KeyEvent.VK_RIGHT;
    public static final int KEY_DOWN = KeyEvent.VK_DOWN;
    public static final int KEY_COMMA = KeyEvent.VK_COMMA;
    public static final int KEY_MINUS = KeyEvent.VK_MINUS;
    public static final int KEY_PERIOD = KeyEvent.VK_PERIOD;
    public static final int KEY_SLASH = KeyEvent.VK_SLASH;
    public static final int KEY_0 = KeyEvent.VK_0;
    public static final int KEY_1 = KeyEvent.VK_1;
    public static final int KEY_2 = KeyEvent.VK_2;
    public static final int KEY_3 = KeyEvent.VK_3;
    public static final int KEY_4 = KeyEvent.VK_4;
    public static final int KEY_5 = KeyEvent.VK_5;
    public static final int KEY_6 = KeyEvent.VK_6;
    public static final int KEY_7 = KeyEvent.VK_7;
    public static final int KEY_8 = KeyEvent.VK_8;
    public static final int VK_9 = KeyEvent.VK_9;
    public static final int KEY_SEMICOLON = KeyEvent.VK_SEMICOLON;
    public static final int KEY_A = KeyEvent.VK_A;
    public static final int KEY_B = KeyEvent.VK_B;
    public static final int KEY_C = KeyEvent.VK_C;
    public static final int KEY_D = KeyEvent.VK_D;
    public static final int KEY_E = KeyEvent.VK_E;
    public static final int KEY_F = KeyEvent.VK_F;
    public static final int KEY_G = KeyEvent.VK_G;
    public static final int KEY_H = KeyEvent.VK_H;
    public static final int KEY_I = KeyEvent.VK_I;
    public static final int KEY_J = KeyEvent.VK_J;
    public static final int KEY_K = KeyEvent.VK_K;
    public static final int KEY_L = KeyEvent.VK_L;
    public static final int KEY_M = KeyEvent.VK_M;
    public static final int KEY_N = KeyEvent.VK_N;
    public static final int KEY_O = KeyEvent.VK_O;
    public static final int KEY_P = KeyEvent.VK_P;
    public static final int KEY_Q = KeyEvent.VK_Q;
    public static final int KEY_R = KeyEvent.VK_R;
    public static final int KEY_S = KeyEvent.VK_S;
    public static final int KEY_T = KeyEvent.VK_T;
    public static final int KEY_U = KeyEvent.VK_U;
    public static final int KEY_V = KeyEvent.VK_V;
    public static final int KEY_W = KeyEvent.VK_W;
    public static final int KEY_X = KeyEvent.VK_X;
    public static final int KEY_Y = KeyEvent.VK_Y;
    public static final int KEY_Z = KeyEvent.VK_Z;
    public static final int KEY_OPEN_BRACKET = KeyEvent.VK_OPEN_BRACKET;
    public static final int KEY_BACK_SLASH = KeyEvent.VK_BACK_SLASH;
    public static final int KEY_CLOSE_BRACKET = KeyEvent.VK_CLOSE_BRACKET;
    public static final int KEY_NUMPAD0 = KeyEvent.VK_NUMPAD0;
    public static final int KEY_NUMPAD1 = KeyEvent.VK_NUMPAD1;
    public static final int KEY_NUMPAD2 = KeyEvent.VK_NUMPAD2;
    public static final int KEY_NUMPAD3 = KeyEvent.VK_NUMPAD3;
    public static final int KEY_NUMPAD4 = KeyEvent.VK_NUMPAD4;
    public static final int KEY_NUMPAD5 = KeyEvent.VK_NUMPAD5;
    public static final int KEY_NUMPAD6 = KeyEvent.VK_NUMPAD6;
    public static final int KEY_NUMPAD7 = KeyEvent.VK_NUMPAD7;
    public static final int KEY_NUMPAD8 = KeyEvent.VK_NUMPAD8;
    public static final int KEY_NUMPAD9 = KeyEvent.VK_NUMPAD9;
    public static final int KEY_MULTIPLY = KeyEvent.VK_MULTIPLY;
    public static final int KEY_ADD = KeyEvent.VK_ADD;
    public static final int KEY_SEPARATER = KeyEvent.VK_SEPARATER;
    public static final int KEY_SEPARATOR = KeyEvent.VK_SEPARATOR;
    public static final int KEY_SUBTRACT = KeyEvent.VK_SUBTRACT;
    public static final int KEY_DECIMAL = KeyEvent.VK_DECIMAL;
    public static final int KEY_DIVIDE = KeyEvent.VK_DIVIDE;
    public static final int KEY_DELETE = KeyEvent.VK_DELETE;
    public static final int KEY_NUM_LOCK = KeyEvent.VK_NUM_LOCK;
    public static final int KEY_SCROLL_LOCK = KeyEvent.VK_SCROLL_LOCK;
    public static final int KEY_F1 = KeyEvent.VK_F1;
    public static final int KEY_F2 = KeyEvent.VK_F2;
    public static final int KEY_F3 = KeyEvent.VK_F3;
    public static final int KEY_F4 = KeyEvent.VK_F4;
    public static final int KEY_F5 = KeyEvent.VK_F5;
    public static final int KEY_F6 = KeyEvent.VK_F6;
    public static final int KEY_F7 = KeyEvent.VK_F7;
    public static final int KEY_F8 = KeyEvent.VK_F8;
    public static final int KEY_F9 = KeyEvent.VK_F9;
    public static final int KEY_F10 = KeyEvent.VK_F10;
    public static final int KEY_F11 = KeyEvent.VK_F11;
    public static final int KEY_F12 = KeyEvent.VK_F12;
    public static final int KEY_F13 = KeyEvent.VK_F13;
    public static final int KEY_F14 = KeyEvent.VK_F14;
    public static final int KEY_F15 = KeyEvent.VK_F15;
    public static final int KEY_F16 = KeyEvent.VK_F16;
    public static final int KEY_F17 = KeyEvent.VK_F17;
    public static final int KEY_F18 = KeyEvent.VK_F18;
    public static final int KEY_F19 = KeyEvent.VK_F19;
    public static final int KEY_F20 = KeyEvent.VK_F20;
    public static final int KEY_F21 = KeyEvent.VK_F21;
    public static final int KEY_F22 = KeyEvent.VK_F22;
    public static final int KEY_F23 = KeyEvent.VK_F23;
    public static final int KEY_F24 = KeyEvent.VK_F24;
    public static final int KEY_PRINTSCREEN = KeyEvent.VK_PRINTSCREEN;
    public static final int KEY_INSERT = KeyEvent.VK_INSERT;
    public static final int KEY_HELP = KeyEvent.VK_HELP;
    public static final int KEY_META = KeyEvent.VK_META;
    public static final int KEY_BACK_QUOTE = KeyEvent.VK_BACK_QUOTE;
    public static final int KEY_QUOTE = KeyEvent.VK_QUOTE;
    public static final int KEY_KP_UP = KeyEvent.VK_KP_UP;
    public static final int KEY_KP_DOWN = KeyEvent.VK_KP_DOWN;
    public static final int KEY_KP_LEFT = KeyEvent.VK_KP_LEFT;
    public static final int KEY_KP_RIGHT = KeyEvent.VK_KP_RIGHT;
    public static final int KEY_AT = KeyEvent.VK_AT;
    public static final int KEY_COLON = KeyEvent.VK_COLON;
    public static final int KEY_CIRCUMFLEX = KeyEvent.VK_CIRCUMFLEX;
    public static final int KEY_DOLLAR = KeyEvent.VK_DOLLAR;
    public static final int KEY_EURO_SIGN = KeyEvent.VK_EURO_SIGN;
    public static final int KEY_EXCLAMATION_MARK = KeyEvent.VK_EXCLAMATION_MARK;
    public static final int KEY_INVERTED_EXCLAMATION_MARK = KeyEvent.VK_INVERTED_EXCLAMATION_MARK;
    public static final int KEY_LEFT_PARENTHESIS = KeyEvent.VK_LEFT_PARENTHESIS;
    public static final int KEY_RIGH_PARENTHESIS = KeyEvent.VK_RIGHT_PARENTHESIS;
    public static final int KEY_NUMBER_SIGN = KeyEvent.VK_NUMBER_SIGN;
    public static final int KEY_PLUS = KeyEvent.VK_PLUS;
    public static final int KEY_UNDERSCORE = KeyEvent.VK_UNDERSCORE;
    public static final int KEY_WINDOWS = KeyEvent.VK_WINDOWS;
    public static final int KEY_CONTEXT_MENU = KeyEvent.VK_CONTEXT_MENU;
    public static final int KEY_FINAL = KeyEvent.VK_FINAL;
    public static final int KEY_CONVERT = KeyEvent.VK_CONVERT;
    public static final int KEY_NONCONVERT = KeyEvent.VK_NONCONVERT;
    public static final int KEY_ACCEPT = KeyEvent.VK_ACCEPT;
    public static final int KEY_MODECHANGE = KeyEvent.VK_MODECHANGE;
    public static final int KEY_KANA = KeyEvent.VK_KANA;
    public static final int KEY_KANJI = KeyEvent.VK_KANJI;
    public static final int KEY_ALPHANUMERIC = KeyEvent.VK_ALPHANUMERIC;
    public static final int KEY_CUT = KeyEvent.VK_CUT;
    public static final int KEY_COPY = KeyEvent.VK_COPY;
    public static final int KEY_PASTE = KeyEvent.VK_PASTE;
    public static final int KEY_UNDO = KeyEvent.VK_UNDO;
    public static final int KEY_AGAIN = KeyEvent.VK_AGAIN;
    public static final int KEY_FIND = KeyEvent.VK_FIND;
    public static final int KEY_PROPS = KeyEvent.VK_PROPS;
    public static final int KEY_STOP = KeyEvent.VK_STOP;
    public static final int KEY_COMPOSE = KeyEvent.VK_COMPOSE;
    public static final int KEY_ALT_GRAPH = KeyEvent.VK_ALT_GRAPH;
    public static final int KEY_BEGIN = KeyEvent.VK_BEGIN;
    public static final int KEY_UNDEFINED = KeyEvent.VK_UNDEFINED;

    public static final int MOUSE_BUTTON_LEFT = MouseEvent.BUTTON1;
    public static final int MOUSE_BUTTON_MIDDLE = MouseEvent.BUTTON2;
    public static final int MOUSE_BUTTON_RIGHT = MouseEvent.BUTTON3;

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
        backColor = ((red & 0xFF) << 16) | ((green & 0xFF) << 8) | ((blue & 0xFF));
        graphics.setColor(new Color(red, green, blue));
        graphics.fillRect(0, 0, width, height);
    }

    public static void setBackColor(int color) {
        Graphics.backColor = color;
        int red = (color >> 16) & 0xFF;
        int green = (color >> 8) & 0xFF;
        int blue = color & 0xFF;
        graphics.setColor(new Color(red, green, blue));
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
        int red = (backColor >> 16) & 0xFF;
        int green = (backColor >> 8) & 0xFF;
        int blue = backColor & 0xFF;
        graphics.setColor(new Color(red, green, blue));
        graphics.fillRect(0, 0, width, height);
        Toolkit.getDefaultToolkit().sync();
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
        color = ((alpha & 0xFF) << 24) | ((red & 0xFF) << 16) | ((green & 0xFF) << 8) | ((blue & 0xFF));
        setColor(color);
    }

    public static void setColor(int red, int green, int blue) {
        int alpha = 255;
        color = ((alpha & 0xFF) << 24) | ((red & 0xFF) << 16) | ((green & 0xFF) << 8) | ((blue & 0xFF));
        setColor(color);
    }

    public static void setColor(int color) {
        Graphics.color = color;
        int alpha = (color >> 24) & 0xFF;
        int red = (color >> 16) & 0xFF;
        int green = (color >> 8) & 0xFF;
        int blue = color & 0xFF;

        if (alpha == 0x00) alpha = 0xFF;

        graphics.setColor(new Color(red, green, blue, alpha));
    }

    public static Color createColor(int red, int green, int blue) {
        return new Color(red, green, blue);
    }

    public static void setColor(int alpha, int color) {
        int r = (color >> 16) & 0xFF;
        int g = (color >> 8) & 0xFF;
        int b = color & 0xFF;
        graphics.setColor(new Color(r, g, b, alpha));
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
        graphics.drawLine(x, y, x, y);
        window.repaint();
    }

    public static void line(int x1, int y1, int x2, int y2) {
        graphics.setRenderingHints(getRendering(antialias));
        graphics.setStroke(new BasicStroke(stroke));
        graphics.drawLine(x1, y1, x2, y2);
        window.repaint();
    }

    public static void rectangle(int x, int y, int width, int height) {
        graphics.setRenderingHints(getRendering(antialias));
        graphics.setStroke(new BasicStroke(stroke));
        int[] xpoint = new int[] {x, width, width, x, x};
        int[] ypoint = new int[] {y, y, height, height, y};
        if (Graphics.filled) {
            graphics.fillRect(x, y, width, height);
        } else {
            graphics.drawRect(x, y, width, height);
        }
        window.repaint();
    }

    public static void triangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        graphics.setRenderingHints(getRendering(antialias));
        graphics.setStroke(new BasicStroke(stroke));
        //graphics.setColor(color);
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
        if (Graphics.filled) {
            graphics.fillOval(x, y, width, height);
        } else {
            graphics.drawOval(x, y, width, height);
        }
    }

    public static void square(int x, int y, int size) {
        graphics.setRenderingHints(getRendering(antialias));
        graphics.setStroke(new BasicStroke(stroke));
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
        graphics.drawPolyline(xpoints, ypoints, npoint);
        window.repaint();
    }

    public static void text(String text, int x, int y) {
        graphics.setRenderingHints(getRendering(antialias));
        graphics.setStroke(new BasicStroke(stroke));
        Font font = new Font(fontName, fontStyle, fontSize);
        graphics.setFont(font);

        FontMetrics fm = graphics.getFontMetrics();
        graphics.drawString(text, x, (y + fm.getAscent()));
        window.repaint();
    }

    public static void text(String text) {
        graphics.setRenderingHints(getRendering(antialias));
        graphics.setStroke(new BasicStroke(stroke));
        Font font = new Font(fontName, fontStyle, fontSize);
        graphics.setFont(font);

        FontMetrics fm = graphics.getFontMetrics();
        //graphics.drawString(text, x (y + fm.getAscent()));
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

    public static boolean iskey(char key) {
        return drawing.iskey((int) key);
    }

    public static boolean iskey(int code) {
        return drawing.iskey(code);
    }

    public static boolean iskb() {
        return drawing.iskb();
    }

    public static char getch() {
        return drawing.getch();
    }

    public static boolean ismousebutton(int code) {
        return drawing.ismousebutton(code);
    }

    public static int mousex() {
        return drawing.getmousex();
    }

    public static int mousey() {
        return drawing.getmousey();
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
        graphics.draw(path);
        window.repaint();
    }

    static class Drawing extends JPanel implements MouseListener, MouseMotionListener, KeyListener {
        private Dimension size;
        private Graphics2D graphics;
        private BufferedImage image;

        private final boolean[] keyDown = new boolean[256];
        private final Set<Integer> keyPressed = new HashSet<>();
        private final Set<Integer> keyReleased = new HashSet<>();
        private volatile char lastchar = '\0';

        private volatile int mousex = 0;
        private volatile int mousey = 0;
        private final boolean[] mouseDown = new boolean[8];
        private final Set<Integer> mousePressed = new HashSet<>();
        private final Set<Integer> mouseReleased = new HashSet<>();

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

        public char getch() {
           char c = lastchar;
           return c;
        }

        public boolean iskb() {
            for (boolean kd : keyDown) if (kd) return true;
            if (!keyPressed.isEmpty() || !keyReleased.isEmpty()) return true;
            return false;
        }

        public boolean iskey(int code) {
            return keyDown[code & 0xFF];
        }

        public int getmousex() {
            return mousex;
        }

        public int getmousey() {
            return mousey;
        }

        public boolean ismousebutton(int button) {
            return (button >= 0 && button < mouseDown.length) && mouseDown[button];
        }

        @Override
        public void mouseClicked(MouseEvent e) {}

        @Override
        public void mousePressed(MouseEvent e) {
            int b = e.getButton();
            if (b >= 0 && b < mouseDown.length) {
                if (!mouseDown[b]) mousePressed.add(b);
                mouseDown[b] = true;
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            int b = e.getButton();
            if (b >= 0 && b < mouseDown.length) {
                mouseDown[b] = false;
                mouseReleased.add(b);
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            mousex = e.getX();
            mousey = e.getY();
        }

        @Override
        public void mouseExited(MouseEvent e) {
            mousex = e.getX();
            mousey = e.getY();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            mousex = e.getX();
            mousey = e.getY();
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            mousex = e.getX();
            mousey = e.getY();
        }

        @Override
        public void keyTyped(KeyEvent e) {}

        @Override
        public void keyPressed(KeyEvent e) {
            lastchar = e.getKeyChar();
            int code = e.getKeyCode() & 0xFF;
            if (!keyDown[code]) keyPressed.add(code);
            keyDown[code] = true;
        }

        @Override
        public void keyReleased(KeyEvent e) {
            lastchar = '\0';
            int code = e.getKeyCode() & 0xFF;
            keyDown[code] = false;
            keyReleased.add(code);
        }
    }

}
