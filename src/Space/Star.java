/**
 * Represents a star object within the simulation, extending the generic SpaceObject.
 * Maintains position, velocity, and color specific to stars.
 */

package Space;

import java.awt.*;

public class Star extends SpaceObject {
    private int posX;
    private int posY;
    private int veloX;
    private int veloY;

    public Star(int size, Color color, int posX, int posY, int veloX, int veloY) {
        super(posX, posY, size, veloX, veloY, color);
        this.posX = posX;
        this.posY = posY;
        this.veloX = veloX;
        this.veloY = veloY;
    }

    @Override
    public void move() {
        posX += veloX;
        posY += veloY;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public double getVeloX() {
        return veloX;
    }

    public double getVeloY() {
        return veloY;
    }
}
