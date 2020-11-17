package uet.oop.bomberman.entities.airEntities;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.AirEntity;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.Map;
import uet.oop.bomberman.graphics.Sprite;

/**
 * Created by hello on 11/10/2020.
 */
public class Brick extends AirEntity {
    public Brick(int x, int y, String type, Image img) {
        super(x, y, type, img);
    }

    @Override
    public void update() {
//        if(check) {
//            animate();
//            timeOut--;
//            if(timeOut == 0) {
//                remove();
//            }
//        }
        super.update();
    }

    @Override
    public void remove() {
        Map.mesh[getY()][getX()] -= 2;
        dead = true;
    }

//    public void check() {
//        check = true;
//    }

    public void animate(){
        if(timeOut % 30 == 0){
            img = Sprite.brick_exploded2.getFxImage();
        }
        else if (timeOut % 30 == 10){
            img = Sprite.brick_exploded1.getFxImage();
        }
        else if (timeOut % 30 == 20){
            img = Sprite.brick_exploded.getFxImage();
        }
    }
}
