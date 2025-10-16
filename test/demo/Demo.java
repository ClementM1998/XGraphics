package test.demo;

import static graphics.Graphics.*;

public class Demo {
    public static void main(String[] args) {

        createWindow("Demo");

        boolean running = true;
        int mx, my;
        int vert = 0, hori = 0;
        int boxL = 50, boxT = 50, boxR = getScreenWidth() - 120, boxB = getScreenHeight() - 140;

        int colorCircle1 = Green;
        int colorBox = Blue;

        setFontSize(12);
        setFontStyle(Bold);
        //setFilled(true);
        while (running) {
            mx = mousex();
            my = mousey();
            //if (ismouse_button()) running = false;

            if (iskey(KEY_Q)) running = false;

            // single handle
            if (iskey(KEY_LEFT)) vert-=6;
            if (iskey(KEY_RIGHT)) vert+=6;
            if (iskey(KEY_UP)) hori-=6;
            if (iskey(KEY_DOWN)) hori+=6;

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
            text("key: " + getch(), 0, 0);
            text("mouse: " + mousex() + " , " + mousey(), 0, 15);
            text("move: " + (100 + vert) + " , " + (100 + hori), 0, 15 * 2);

            delay(16);
            clearWindow();
        }
        clearWindow();
        System.exit(0);

    }
}
