package uet.oop.bomberman.entities.enemy;

import javafx.scene.image.Image;
import uet.oop.bomberman.BomberManGame;
import uet.oop.bomberman.entities.AirEntity;

/**
 * Created by hello on 11/12/2020.
 */
public abstract class Enemy extends AirEntity {
    public Enemy(int x, int y, String type, Image img) {
        super(x, y, type, img);
    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    public abstract void animate();

    public void remove() {
        BomberManGame.map.mesh[getY()][getX()] = 0;
        dead = true;

    }

    protected int moveSize = SCALE_SIZE / 2;
    public void moveUp(){
    if(BomberManGame.map.mesh[getY() - 1][getX()] == 0 || BomberManGame.map.mesh[getY() - 1][getX()] == 1) {
        x = getX() * SCALE_SIZE;
        y -= moveSize;
    }
    else if(y % SCALE_SIZE != 0){
        y = getY() * SCALE_SIZE;
    }
}

    public void moveDown(){
        if(BomberManGame.map.mesh[getY() + 1][getX()] == 0 || BomberManGame.map.mesh[getY() + 1][getX()] == 1) {
            x = getX() * SCALE_SIZE;
            y += moveSize;
        }
        else if(y % SCALE_SIZE != 0){
            y = getY() * SCALE_SIZE;
        }
    }

    public void moveLeft(){

        if(BomberManGame.map.mesh[getY()][getX() - 1] == 0 || BomberManGame.map.mesh[getY()][getX() - 1] == 1) {
            y = getY() * SCALE_SIZE;
            x -= moveSize;
        }
        else if(x % SCALE_SIZE != 0){
            x = getX() * SCALE_SIZE;
        }
    }

    public void moveRight(){
        if(BomberManGame.map.mesh[getY()][getX() + 1] == 0 || BomberManGame.map.mesh[getY()][getX() + 1] == 1){
            y = getY() * SCALE_SIZE;
            x += moveSize;
        }
        else if(x % SCALE_SIZE != 0){
            x = getX() * SCALE_SIZE;
        }
    }

    @Override
    public int getX(){
        if(x % SCALE_SIZE < 16){
            return(int) Math.floor(x / SCALE_SIZE);
        }
        else{
            return (int) Math.floor(x / SCALE_SIZE) + 1;
        }
    }

    @Override
    public int getY(){
        if(y % SCALE_SIZE < 16){
            return(int) Math.floor(y / SCALE_SIZE);
        }
        else{
            return (int) Math.floor(y / SCALE_SIZE) + 1;
        }
    }
}
