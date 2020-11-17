package uet.oop.bomberman.entities.enemy;

import javafx.scene.image.Image;
import uet.oop.bomberman.BomberManGame;
import uet.oop.bomberman.entities.AirEntity;
import uet.oop.bomberman.entities.Map;
import uet.oop.bomberman.graphics.Sprite;

/**
 * Created by hello on 11/12/2020.
 */
public class Oneal extends Enemy {
    public double time = 30;
    public int HP = 1;
    public Oneal(int x, int y, String type, Image img) {
        super(x, y, type, img);
    }

    @Override
    public void update() {
        super.update();
        if(time > 0){
            time--;
        }
        else{
            randomMove();
            time = 30;
        }
    }

    @Override
    public void animate() {
        if(timeOut % 30 == 0){
            img = Sprite.oneal_dead.getFxImage();
        }
        else if (timeOut % 30 == 10){
            img = Sprite.mob_dead1.getFxImage();
        }
        else if (timeOut % 30 == 20){
            img = Sprite.mob_dead2.getFxImage();
        }
        else if(timeOut == 5) {

            img = Sprite.mob_dead3.getFxImage();
        }
    }

    @Override
    public void remove() {
        if(HP == 0){
            Map.mesh[getY()][getX()] = 0;
            dead = true;
        }
        else HP--;
    }

    private void randomMove(){
        double rand = Math.random();
        if(rand < 0.25){
            moveUp();
            img = Sprite.oneal_left2.getFxImage();
        }
        else if(rand < 0.5){
            moveDown();
            img = Sprite.oneal_right2.getFxImage();
        }
        else if(rand < 0.75){
            moveLeft();
            img = Sprite.oneal_left1.getFxImage();
        }
        else {
            moveRight();
            img = Sprite.oneal_right1.getFxImage();
        }
    }

}
