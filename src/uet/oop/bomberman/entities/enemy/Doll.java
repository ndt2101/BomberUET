package uet.oop.bomberman.entities.enemy;

import javafx.scene.image.Image;
import uet.oop.bomberman.BomberManGame;
import uet.oop.bomberman.entities.FindWay;
import uet.oop.bomberman.entities.airEntities.Bomber;
import uet.oop.bomberman.graphics.Sprite;

/**
 * Created by hello on 11/19/2020.
 */
public class Doll extends Enemy{

    public double time = 30;

    public Doll(int x, int y, String type, Image img) {
        super(x, y, type, img);
    }

    @Override
    public void update() {
        super.update();
        if(stateClock > 0 || check){
            stateClock--;
        }
        else{
            boolean sameComponent = BomberManGame.map.uf.connected(BomberManGame.map.getUFId(getY(), getX()),
                    BomberManGame.map.getUFId(Bomber.GETY(), Bomber.GETX()));
            if(sameComponent){
                findWay();
            }
            else{
                randomMove();
            }
            stateClock = 10;
        }
    }

    @Override
    public void animate() {
        if(timeOut % 30 == 0){
            img = Sprite.doll_dead.getFxImage();
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
            BomberManGame.map.mesh[getY()][getX()] = 0;
            dead = true;
        }
        else HP--;
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
        img = Sprite.movingSprite(Sprite.doll_left1, Sprite.doll_left2, Sprite.doll_left3, stateClock, 30).getFxImage();
//        y -= SCALE_SIZE;
        super.moveUp();
    }
    @Override
    public void moveDown(){
        img = Sprite.movingSprite(Sprite.doll_right1, Sprite.doll_right2, Sprite.doll_right3, stateClock, 30).getFxImage();
//        y += SCALE_SIZE;
        super.moveDown();
    }
    @Override
    public void moveLeft(){
        img = Sprite.movingSprite(Sprite.doll_left1, Sprite.doll_left2, Sprite.doll_left3, stateClock, 30).getFxImage();
//        x -= SCALE_SIZE;
        super.moveLeft();
    }
    @Override
    public void moveRight(){
        img = Sprite.movingSprite(Sprite.doll_left1, Sprite.doll_left2, Sprite.doll_left3, stateClock, 30).getFxImage();
//        x += SCALE_SIZE;
        super.moveRight();
    }

    String lastMove = "";
    public void findWay(){
        String next = FindWay.calculateWay(Bomber.GETX(), Bomber.GETY(), getX(), getY());

        switch (next){
            case "up": {
                moveUp();
                break;
            }
            case "down": {
                moveDown();
                break;
            }
            case "left": {
                moveLeft();
                break;
            }
            case "right": {
                moveRight();
                break;
            }
        }
    }

}

