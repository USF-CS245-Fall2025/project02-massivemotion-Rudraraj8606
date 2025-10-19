package Space;

import java.awt.*;

public class Comet extends SpaceObject{
    private int x, y;

    public Comet(int x, int y, int vx, int vy, int size, Color color) {
        super(x, y, size, vx, vy, color);
        this.x = x;
        this.y = y;
    }

    public double x() {
        return x;
    }

    public double y() {
        return y;
    }
}
