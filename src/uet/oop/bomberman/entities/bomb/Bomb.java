package uet.oop.bomberman.entities.bomb;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.entities.AirEntity;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

import java.util.Collection;

/**
 * Created by hello on 11/10/2020.
 */
public class Bomb extends AirEntity {
    public int timeOut = 120;

    public Bomb(int x, int y, Image image){
        super(x, y, image);
    }

    @Override
    public void update() {
        if(timeOut > 0){
            timeOut--;
        }
        else{

            explode();
        }
    }

    @Override
    public void remove() {
        BombermanGame.entities.remove(0);
    }

    public void explode(){
        img = Sprite.bomb_exploded.getFxImage();
    }
}