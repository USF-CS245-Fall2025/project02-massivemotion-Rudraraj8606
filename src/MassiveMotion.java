import Space.Comet;
import Space.SpaceObject;
import Space.Star;
import helper.Helper;
import utils.*;
import utils.List;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

public class MassiveMotion extends JPanel implements ActionListener {
    List<SpaceObject> objects;
    protected Timer tm;
    static private Properties p = new Properties();
    private Random random = new Random();

    // reads config file
    private static void readFile(String fileName) throws IOException {
        if(fileName == null){
            System.out.println("reading from default file");
            try {
                FileReader reader = new FileReader("MassiveMotion.txt");
                p.load(reader);
            } catch (FileNotFoundException e) {
                System.err.println("Error: The default file 'MassiveMotion.txt' " + " was not found.");
            }
        }
        try {
            assert fileName != null;
            FileReader reader = new FileReader(fileName);
            p.load(reader);
        } catch (FileNotFoundException e) {
            System.err.println("Error: The file '" + fileName + "' was not found.");
        }
    }


    // constructor
    public MassiveMotion(){
        tm = new Timer(Helper.toInteger(p.getProperty("timer_delay")), this); // TODO: Replace the first argument with delay with value from config file.
        String list = p.getProperty("list");
        if (list.equals("arraylist")) {
            objects = new ArrayList<>();
        } else if (list.equals("single")) {
            objects = new LinkedList<>();
        } else if (list.equals("double")) {
            objects = new DoublyLinkedList<>();
        } else if (list.equals("dummyhead")) {
            objects = new DummyHeadLinkedList<>();
        }
    }

    public void maybeSpawnComets() {
        double gen_X = Helper.toDouble(p.getProperty("gen_x"));
        double gen_Y = Helper.toDouble(p.getProperty("gen_y"));
        int cometSize = Helper.toInteger(p.getProperty("body_size"));
        int width = Helper.toInteger(p.getProperty("window_size_x"));
        int height = Helper.toInteger(p.getProperty("window_size_y"));
        int velo = Helper.toInteger(p.getProperty("body_velocity"));
        int starPosx = Helper.toInteger(p.getProperty("star_position_x"));
        int starPosY = Helper.toInteger(p.getProperty("star_position_y"));
        int starSize = Helper.toInteger(p.getProperty("star_size"));
        int starVelox = Helper.toInteger(p.getProperty("star_velocity_x"));
        int starVeloY = Helper.toInteger(p.getProperty("star_velocity_y"));

        objects.add(new Star(starSize, Color.RED,starPosx,starPosY,starVelox,starVeloY));

        if (random.nextDouble() < gen_X) {
            int x = random.nextBoolean() ? 0 : (width - cometSize);
            int y = random.nextInt(Math.max(1, height - cometSize));
            int vx = nonZeroVelocity(velo);
            int vy = nonZeroVelocity(velo);
            objects.add(new Comet(x, y, vx,vy, cometSize, Color.BLACK));
        }

        if (random.nextDouble() < gen_Y) {
            int x = random.nextInt(Math.max(1, width - cometSize));
            int y = random.nextBoolean() ? 0 : (height - cometSize);
            int vx = nonZeroVelocity(velo);
            int vy = nonZeroVelocity(velo);
            objects.add(new Comet(x, y, vx,vy, cometSize, Color.BLACK));
        }
    }

    private int nonZeroVelocity(int bodyVelocity) {
        int v;
        do {
            v = random.nextInt(2 * bodyVelocity + 1) - bodyVelocity;
        } while (v == 0);
        return v;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g); // Probably best you leave this as is.

        for (int i = 0; i < objects.size(); i++) {
            SpaceObject obj = objects.get(i); // or Comet, Celestials depending on your class
            obj.draw(g);
        }

        // Recommend you leave the next line as is
        tm.start();
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int width = Helper.toInteger(p.getProperty("window_size_x"));
        int height = Helper.toInteger(p.getProperty("window_size_y"));

        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).move();
        }

        maybeSpawnComets();

        // Keep this at the end of the function (no matter what you do above):
        repaint();
    }

    public static void main(String[] args) throws IOException {
        readFile(args[1]);
        System.out.println("Massive Motion starting...");
        // MassiveMotion mm = new MassiveMotion(args[0]);
        MassiveMotion mm = new MassiveMotion();

        JFrame jf = new JFrame();
        jf.setTitle("Massive Motion");
        jf.setSize(Helper.toInteger(p.getProperty("window_size_x")), Helper.toInteger(p.getProperty("window_size_y")));
        jf.add(mm);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
