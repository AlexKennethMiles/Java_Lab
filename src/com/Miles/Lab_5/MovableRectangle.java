package com.Miles.Lab_5;

public class MovableRectangle extends Rectangle{

    Rectangle rectangle = new Rectangle();
    MovablePoint topLeft = new MovablePoint(0,0);
    MovablePoint botRight = new MovablePoint(0,0);

    public MovableRectangle(double x1, double y1, double x2, double y2){
        topLeft.setX(x1);
        topLeft.setY(y1);
        botRight.setX(x2);
        botRight.setY(y2);
        rectangle.setWidth(y1-y2);
        rectangle.setLength(x2-x1);
    }


    @Override
    public String toString() {
        return "MovableRectangle{" +
                "rectangle=" + rectangle +
                "," + "\n" + "topLeft=" + topLeft +
                "," + "\n" + "botRight=" + botRight +
                '}';
    }
}
