package uet.oop.bomberman.entities.enemy;

import javafx.scene.image.Image;
import uet.oop.bomberman.BomberManGame;
import uet.oop.bomberman.entities.AirEntity;
import uet.oop.bomberman.entities.Map;
import uet.oop.bomberman.graphics.Sprite;

/**
 * Created by hello on 11/12/2020.
 */
public class Balloon extends Enemy {
    public double time = 30;

    public Balloon(int x, int y, String type, Image img) {
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
//        if (check) {
//            animate();
//            timeOut--;
//            if(timeOut == 0) {
//
//            }
//        }
    }

    private void randomMove(){
        double rand = Math.random();
        if(rand < 0.25){
            moveUp();
            img = Sprite.balloom_left2.getFxImage();
        }
        else if(rand < 0.5){
            img = Sprite.balloom_right2.getFxImage();
            moveDown();
        }
        else if(rand < 0.75){
            img = Sprite.balloom_left1.getFxImage();
            moveLeft();
        }
        else {
            img = Sprite.balloom_right1.getFxImage();
            moveRight();
        }
    }

    public void check() {
        check = true;
    }

    public void animate(){
        if(timeOut % 30 == 0){
            img = Sprite.balloom_dead.getFxImage();
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

}
