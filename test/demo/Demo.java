package test.demo;

import java.awt.*;

import static graphics.Graphics.*;

public class Demo {
    public static void main(String[] args) {

        createWindow("Demo");

        boolean running = true;
        int mx, my;
        int vert = 0, hori = 0;
        int boxL = 50, boxT = 50, boxR = getScreenWidth() - 70, boxB = getScreenHeight() - 90;

        Color colorCircle1 = Green;
        Color colorBox = Blue;

        setFontSize(12);
        setFontStyle(Font.BOLD);
        //setFilled(true);
        while (running) {
            mx = getMousePos().x;
            my = getMousePos().y;
            //if (ismouse_button()) running = false;

            if (isKey(VK_Q)) running = false;

            // single handle
            if (isKey(VK_LEFT)) vert-=6;
            if (isKey(VK_RIGHT)) vert+=6;
            if (isKey(VK_UP)) hori-=6;
            if (isKey(VK_DOWN)) hori+=6;

            if (boxL > (boxL + vert + 50) || boxT > (boxT + hori + 50) || (boxR + 50) < (boxL + vert + 50) || (boxB + 50) < (boxT + hori + 50)) {
                colorCircle1 = Red;
                colorBox = Red;
            } else {
                colorCircle1 = Green;
                colorBox = Blue;
            }

            setFilled(true);
            setColor(80, colorBox);
            rectangle(boxL, boxT, boxR, boxB);
            setFilled(false);
            setColor(colorBox);
            rectangle(boxL, boxT, boxR, boxB);

            setFilled(true);
            setColor(80, colorCircle1);
            circle(boxL + vert, boxT + hori, 50);
            setFilled(false);
            setColor(colorCircle1);
            circle(boxL + vert, boxT + hori, 50);

            setFilled(true);
            setColor(80, Red);
            circle((mx - (25 / 2)), (my - (25 / 2)), 25);
            setFilled(false);
            setColor(Red);
            circle((mx - (25 / 2)), (my - (25 / 2)), 25);

            setColor(White);
            text("key: " + getKeyText(), 0, 0);
            text("mouse: " + getMousePos().x + " , " + getMousePos().y, 0, 15);
            text("move: " + (100 + vert) + " , " + (100 + hori), 0, 15 * 2);

            delay(60);
            clearWindow();
        }
        clearWindow();
        System.exit(0);
        
    }

}
