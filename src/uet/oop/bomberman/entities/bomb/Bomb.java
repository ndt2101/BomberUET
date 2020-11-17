package uet.oop.bomberman.entities.bomb;

import uet.oop.bomberman.BomberManGame;
import uet.oop.bomberman.entities.AirEntity;
import uet.oop.bomberman.entities.Entity;
import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Map;
import uet.oop.bomberman.entities.airEntities.Bomber;
import uet.oop.bomberman.graphics.Sprite;

/**
 * Created by hello on 11/12/2020.
 */
public class Bomb extends AirEntity {
    int timeOut = 120;
    public int flameRange = Bomber.flameRange;
    Flames flames;
    public Bomb(int x, int y, String type, Image img) {
        super(x, y, type, img);
        Map.mesh[getY()][getX()] = 2;
        flames = new Flames(getX(), getY(), flameRange);
        BomberManGame.flames.add(this.flames);
    }

    public void update(){
        animate();

        if(timeOut == 60){

            explode();
            remove();
        }
        timeOut--;
    }

    public void animate(){
        if(timeOut % 60 == 0){
            img = Sprite.bomb_1.getFxImage();
        }
        else if (timeOut % 60 == 40){
            img = Sprite.bomb_2.getFxImage();
        }
        else if (timeOut % 60 == 20){
            img = Sprite.bomb.getFxImage();
        }
    }

    public void explode(){
        flames.explode();
    }

    @Override
    public void remove() {
        if(timeOut > 0) explode();
        Map.mesh[getY()][getX()] = 0;
        Bomber.bombRange++;
        dead = true;
    }

}
