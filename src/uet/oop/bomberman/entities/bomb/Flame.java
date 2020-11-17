package uet.oop.bomberman.entities.bomb;

import uet.oop.bomberman.entities.AirEntity;
import uet.oop.bomberman.entities.Entity;
import javafx.scene.image.Image;

/**
 * Created by hello on 11/12/2020.
 */
public class Flame extends AirEntity {

    public Flame(int x, int y, String type, Image img) {
        super(x, y, type, img);
    }

    public Flame() {
        super();
    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    public void animate() {

    }

    @Override
    public void remove() {
        dead = true;
    }
}
