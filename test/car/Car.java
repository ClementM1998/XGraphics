package test.car;

import java.awt.*;

import static graphics.Graphics.*;

public class Car {
    public static void main(String[] args) {

        createWindow("Demo");

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
        
    }

}
