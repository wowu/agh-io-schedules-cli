import collision.CollisionDetector;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        CollisionDetector collisionDetector = new CollisionDetector();
        collisionDetector.loadSchedules(args);
        collisionDetector.compareSchedules();
    }

}