package test.graph;

import java.awt.*;

import static graphics.Graphics.*;

public class Graph {
    public static void main(String[] args) {

        createWindow("Demo");

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
        
    }

}
