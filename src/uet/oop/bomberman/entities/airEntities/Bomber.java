package uet.oop.bomberman.entities.airEntities;

import uet.oop.bomberman.BomberManGame;
import uet.oop.bomberman.entities.AirEntity;
import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.Map;
import uet.oop.bomberman.entities.bomb.Bomb;
import uet.oop.bomberman.graphics.Sprite;

/**
 * Created by hello on 11/12/2020.
 */
public class Bomber extends AirEntity {
    public static int speedRange = 1;
    public static int flameRange = 1;
    public static int bombRange = 1;
    public int moveSize = SCALE_SIZE / 3;

    public Bomber(int x, int y, String type, Image img) {
        super(x, y, type, img);
    }

    @Override
    public void update() {
        stateClock++;
        super.update();
    }

    public void increaseSpeed(){
        speedRange++;
        moveSize += SCALE_SIZE/5;
    }
    public void increaseFlams(){
        flameRange++;
    }
    public void increseBomb(){
        bombRange++;
    }

    public void moveUp(){
        img = Sprite.movingSprite(Sprite.player_up, Sprite.player_up_1, Sprite.player_up_2, stateClock, 20).getFxImage();
        if(BomberManGame.map.mesh[getY() - 1][getX()] == 0 || BomberManGame.map.mesh[getY() - 1][getX()] == 1) {
            x = getX() * SCALE_SIZE;
            y -= moveSize;
        }
        else if(y % SCALE_SIZE != 0);
        System.out.println(getX() + " " + getY());
    }

    public void moveDown(){
        img = Sprite.movingSprite(Sprite.player_down, Sprite.player_down_1, Sprite.player_down_2, stateClock, 20).getFxImage();
        if(BomberManGame.map.mesh[getY() + 1][getX()] == 0 || BomberManGame.map.mesh[getY() + 1][getX()] == 1) {
            x = getX() * SCALE_SIZE;
            y += moveSize;
        }
        else if(y % SCALE_SIZE != 0);
        System.out.println(getX() + " " + getY());
    }

    public void moveLeft(){
        img = Sprite.movingSprite(Sprite.player_left, Sprite.player_left_1, Sprite.player_left_2, stateClock, 20).getFxImage();

        if(BomberManGame.map.mesh[getY()][getX() - 1] == 0 || BomberManGame.map.mesh[getY()][getX() - 1] == 1) {
            y = getY() * SCALE_SIZE;
            x -= moveSize;
        }
        else if(x % SCALE_SIZE != 0);
        System.out.println(getX() + " " + getY());
    }

    public void moveRight(){
        img = Sprite.movingSprite(Sprite.player_right, Sprite.player_right_1, Sprite.player_right_2, stateClock, 20).getFxImage();
        if(BomberManGame.map.mesh[getY()][getX() + 1] == 0 || BomberManGame.map.mesh[getY()][getX() + 1] == 1){
            y = getY() * SCALE_SIZE;
            x += moveSize;
        }
        else if(x % SCALE_SIZE != 0);
        System.out.println(getX() + " " + getY());
    }

    public void shoot(){
        if(bombRange > 0){
            AirEntity bomb = new Bomb(getX(), getY(), "Bomb", Sprite.bomb.getFxImage());
            BomberManGame.entities.add(0, bomb);
            bombRange--;
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

    @Override
    public void remove() {
        dead = true;
    }

    public void animate(){
        img = Sprite.movingSprite(Sprite.player_dead1, Sprite.player_dead2, Sprite.player_dead3, timeOut, 60).getFxImage();
    }
}
