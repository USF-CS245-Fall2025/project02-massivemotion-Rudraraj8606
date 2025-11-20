/**
 * parent class for all space objects (stars, comets) in the simulation.
 * Encapsulates position, size, color, and velocity properties.
 * Provides basic movement and rendering capabilities.
 */

package Space;

import java.awt.*;

public class SpaceObject {
    private int x, y;
    private int size;
    private Color color;
    private int vx;
    private int vy;

    public SpaceObject(int x, int y, int size, int veloX,int veloY, Color color) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
        this.vx = veloX;
        this.vy = veloY;
    }

    public SpaceObject(){}

    /**
     * the function to help move the space objects
     * by adding the vx and vy
     */
    public void move(){
        x += vx;
        y += vy;
    }

    /**
     * draws the object as a filled oval
     * @param g the graphic context on which to draw
     */
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, size, size);
    }

    /**
     * checks whether the object is outside the visible screen bounds
     * @param windowWidth
     * @param windowHeight
     * @return boolean
     */
    public boolean isOffScreen(int windowWidth, int windowHeight) {
        return x < -size || x > windowWidth || y < -size || y > windowHeight;
    }
}
