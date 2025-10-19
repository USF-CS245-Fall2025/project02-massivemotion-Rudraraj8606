package Space;

import java.awt.*;
import java.util.Random;

public class Comet extends SpaceObject{
    private int x, y;
//    private int bodyVelocity;

    public Comet(int x, int y, int bodyVelocity, int size, Color color) {
        super(x, y, size,bodyVelocity, color);
        this.x = x;
        this.y = y;
//        this.bodyVelocity = bodyVelocity;
    }

    public double x() {
        return x;
    }

    public double y() {
        return y;
    }

//    public void move(){
//        this.x+=bodyVelocity;
//        this.y+=bodyVelocity;
//    }
}
