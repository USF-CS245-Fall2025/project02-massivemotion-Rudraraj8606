/**
 * Represents a comet object within the simulation, extending SpaceObject.
 * Maintains comet position and provides movement logic for comets.
 */

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
