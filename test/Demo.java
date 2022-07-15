package test;

import graphics.Graphics;

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
        
        /*
        var center = new Point(getScreenWidth() / 2, getScreenHeight() / 2);
        var radius = Math.min(getScreenWidth() / 2, getScreenHeight() / 2) - 5;
        var diameter = radius * 2;
        var innerRadius = (int) (radius * 0.9);
        var innerDiameter = innerRadius * 2;
        var barWidth = (int) (innerRadius * 1.4);
        var barHeight = (int) (innerRadius * 0.35);

        setColor(Color.white);
        setFilled(true);
        oval(center.x - radius, center.y - radius, diameter, diameter);
        setColor(Color.red);
        setFilled(true);
        oval(center.x - innerRadius, center.y - innerRadius, innerDiameter, innerDiameter);
        setColor(Color.white);
        setFilled(true);
        rectangle(center.x - barWidth / 2, center.y - barHeight / 2, barWidth , barHeight);
         */

        /*
        setBackColor(Color.white);

        setColor(Color.red);

        text("Hello", 40, 40);

        setFilled(true);
        rectangle(130, 30, 100, 80);

        setFilled(false);
        oval(30, 130, 50, 60);

        setFilled(true);
        oval(130, 130, 50, 60);

        setFilled(false);
        arc(30, 200, 40, 50, 90, 60);

        setFilled(true);
        arc(30, 130, 40, 50, 180, 40);
         */

        /*
        // draw a car

        createPath();

        moveTo(60, 120);
        lineTo(80, 120);
        quadTo(90, 140, 100, 120);
        lineTo(160, 120);
        quadTo(170, 140, 180, 120);
        lineTo(200, 120);
        curveTo(195, 100, 200, 80, 160, 80);
        lineTo(110, 80);
        lineTo(90, 100);
        lineTo(60, 100);
        lineTo(60, 120);

        closePath();
        drawPath();
        */

        /*
        int[] xpoint = { -20, 0, +20, 0 };
        int[] ypoint = { 20, 10, 20, -20 };
        double x = 50.0, y = 50.0;

        setColor(Color.green);
        setFilled(true);
        polygon(xpoint, ypoint);

        translate(x, y);
        setScale(1.2);
        setFilled(true);
        polygon(xpoint, ypoint);

        for (int i = 0;i < 5;i++) {
            translate(50.0, 5.0);
            setColor(Color.blue);
            setFilled(true);
            polygon(xpoint, ypoint);
            rotate(Math.toRadians(15.0));
            setColor(Color.red);
            setFilled(true);
            polygon(xpoint, ypoint);
        }
        */

        /*
        int i = 0;
        int mx, my;

        while (i == 0) {
            mx = mousex();
            my = mousey();
            setFilled(false);
            setColor(Color.white);
            text(String.format("mouse[%d,%d]", (mx - 10), (my - 10)), 0, 0);
            rectangle(20, 20, 610, 350);

            if (20 < (mx - 10) && 610 > (mx - 10) && 20 < (my - 10) && 350 > (my - 10)) {
                if (ismouse_button()) i = 1;
            }

            setColor(100, 200, 250);
            setFilled(true);
            circle(mx - 10, my - 10, 20);
            delay(50);
            clearWindow();
        }

        System.out.println("Exit");
        closeWindow();
        */
    }

}
