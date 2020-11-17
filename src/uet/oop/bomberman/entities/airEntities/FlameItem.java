package uet.oop.bomberman.entities.airEntities;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.AirEntity;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.Map;

/**
 * Created by hello on 11/10/2020.
 */
public class FlameItem extends AirEntity {
    public FlameItem(int x, int y, String type, Image img) {
        super(x, y, type, img);
        item = true;
        HP = 1;
    }

    @Override
    public void update() {

    }

    @Override
    public void animate() {

    }

    @Override
    public void remove() {
        if(HP == 0){
            Map.mesh[getY()][getX()] = 0;
            dead = true;
        }
        else HP--;
    }
}
