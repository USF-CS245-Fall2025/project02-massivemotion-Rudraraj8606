package Space;

import java.awt.*;

public class SpaceObject {
    private int x, y;
    private int size;
    private Color color;
    private int velo;

    public SpaceObject(int x, int y, int size, int velo, Color color) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
        this.velo = velo;
    }

    public SpaceObject(){}

    public void move(){
        x += velo;
        y += velo;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, size, size);
    }

    public boolean isOffScreen(int windowWidth, int windowHeight) {
        return x < -size || x > windowWidth || y < -size || y > windowHeight;
    }
}
