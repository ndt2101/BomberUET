package uet.oop.bomberman.entities.enemy;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.entities.AirEntity;
import uet.oop.bomberman.graphics.Sprite;

/**
 * Created by hello on 11/12/2020.
 */
public class Oneal extends AirEntity {
    public int[][] mesh;
    public int SCALE_SIZE = Sprite.SCALED_SIZE;
    public double time = 30;
    public Oneal(int x, int y, Image image){
        super(x, y, image);
        mesh = BombermanGame.mesh;
    }

    @Override
    public void update() {
        if(time > 0){
            time--;
        }
        else{
            randomMove();
            time = 30;
        }
    }

    @Override
    public void remove() {

    }

    private void randomMove(){
        double rand = Math.random();
        if(rand < 0.25){
            moveUp();
        }
        else if(rand < 0.5){
            moveDown();
        }
        else if(rand < 0.75){
            moveLeft();
        }
        else {
            moveRight();
        }
    }

    @Override
    public void moveUp(){
        img = Sprite.oneal_right1.getFxImage();
        if(y > SCALE_SIZE && mesh[y/SCALE_SIZE - 1][x/SCALE_SIZE] == 0) y -= SCALE_SIZE;
    }

    @Override
    public void moveDown(){
        img = Sprite.oneal_left1.getFxImage();
        if(mesh[y/SCALE_SIZE + 1][x/SCALE_SIZE] == 0) y += SCALE_SIZE;
    }

    @Override
    public void moveLeft(){
        img = Sprite.oneal_left2.getFxImage();
        if(x > SCALE_SIZE && mesh[y/SCALE_SIZE][x/SCALE_SIZE - 1] == 0) x -= SCALE_SIZE;
    }

    @Override
    public void moveRight(){
        img = Sprite.oneal_right2.getFxImage();
        if(mesh[y/SCALE_SIZE][x/SCALE_SIZE + 1] == 0) x += SCALE_SIZE;
    }
}
