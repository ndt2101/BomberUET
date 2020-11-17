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

    public Bomber(int x, int y, String type, Image img) {
        super(x, y, type, img);
    }

    @Override
    public void update() {
        super.update();
    }

    public void increaseSpeed(){
        speedRange++;
    }
    public void increaseFlams(){
        flameRange++;
    }
    public void increseBomb(){
        bombRange++;
    }

    @Override
    public void moveUp(){
        img = Sprite.player_up.getFxImage();
        if(y > SCALE_SIZE && Map.mesh[y/SCALE_SIZE - 1][x/SCALE_SIZE] == 0 || Map.mesh[y/SCALE_SIZE - 1][x/SCALE_SIZE] == 1) y -= SCALE_SIZE;
    }

    @Override
    public void moveDown(){
        img = Sprite.player_down.getFxImage();
        if(Map.mesh[y/SCALE_SIZE + 1][x/SCALE_SIZE] == 0 || Map.mesh[y/SCALE_SIZE + 1][x/SCALE_SIZE] == 1) y += SCALE_SIZE;
    }

    @Override
    public void moveLeft(){
        img = Sprite.player_left.getFxImage();
        if(x > SCALE_SIZE && Map.mesh[y/SCALE_SIZE][x/SCALE_SIZE - 1] == 0 || Map.mesh[y/SCALE_SIZE][x/SCALE_SIZE - 1] == 1) x -= SCALE_SIZE;
    }

    @Override
    public void moveRight(){
        img = Sprite.player_right.getFxImage();
        if(Map.mesh[y/SCALE_SIZE][x/SCALE_SIZE + 1] == 0 || Map.mesh[y/SCALE_SIZE][x/SCALE_SIZE + 1] == 1) x += SCALE_SIZE;
    }

    public void shoot(){
        if(bombRange > 0){
            AirEntity bomb = new Bomb(getX(), getY(), "Bomb", Sprite.bomb.getFxImage());
            BomberManGame.entities.add(0, bomb);
            bombRange--;
        }
    }

    @Override
    public void remove() {
        dead = true;
    }

    public void animate(){
        if(timeOut % 30 == 0){
            img = Sprite.player_dead1.getFxImage();
        }
        else if (timeOut % 30 == 10){
            img = Sprite.player_dead2.getFxImage();
        }
        else if (timeOut % 30 == 20){
            img = Sprite.player_dead3.getFxImage();
        }
    }
//    public void check() {
//        check = true;
//    }
}
