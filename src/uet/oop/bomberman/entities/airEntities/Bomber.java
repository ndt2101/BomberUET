package uet.oop.bomberman.entities.airEntities;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.entities.AirEntity;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.bomb.Bomb;
import uet.oop.bomberman.graphics.Sprite;

import java.util.ArrayList;
import java.util.List;

public class Bomber extends AirEntity {
    public int[][] mesh;
    public int SCALE_SIZE = Sprite.SCALED_SIZE;

    public Bomber(int x, int y, Image img) {
        super( x, y, img);
        mesh = BombermanGame.mesh;
    }

    @Override
    public void update() {

    }

    @Override
    public void remove() {

    }

//    @Override
//    public void moveUp(){
//        img = Sprite.player_up.getFxImage();
//        if(y > SCALE_SIZE && mapChar.get(y/SCALE_SIZE - 1).get(x/SCALE_SIZE) == ' ') y -= SCALE_SIZE;
//    }
//
//    @Override
//    public void moveDown(){
//        img = Sprite.player_down.getFxImage();
//        if(mapChar.get(y/SCALE_SIZE + 1).get(x/SCALE_SIZE) == ' ') y += SCALE_SIZE;
//    }
//
//    @Override
//    public void moveLeft(){
//        img = Sprite.player_left.getFxImage();
//        if(x > SCALE_SIZE && mapChar.get(y/SCALE_SIZE).get(x/SCALE_SIZE - 1) == ' ') x -= SCALE_SIZE;
//    }
//
//    @Override
//    public void moveRight(){
//        img = Sprite.player_right.getFxImage();
//        if(x < 1000 && mapChar.get(y/SCALE_SIZE).get(x/SCALE_SIZE + 1) == ' ') x += SCALE_SIZE;
//    }

    @Override
    public void moveUp(){
        img = Sprite.player_up.getFxImage();
        if(y > SCALE_SIZE && mesh[y/SCALE_SIZE - 1][x/SCALE_SIZE] == 0) y -= SCALE_SIZE;
    }

    @Override
    public void moveDown(){
        img = Sprite.player_down.getFxImage();
        if(mesh[y/SCALE_SIZE + 1][x/SCALE_SIZE] == 0) y += SCALE_SIZE;
    }

    @Override
    public void moveLeft(){
        img = Sprite.player_left.getFxImage();
        if(x > SCALE_SIZE && mesh[y/SCALE_SIZE][x/SCALE_SIZE - 1] == 0) x -= SCALE_SIZE;
    }

    @Override
    public void moveRight(){
        img = Sprite.player_right.getFxImage();
        if(mesh[y/SCALE_SIZE][x/SCALE_SIZE + 1] == 0) x += SCALE_SIZE;
    }

    public void shoot(){
        Entity object = new Bomb(x/SCALE_SIZE, y/SCALE_SIZE, Sprite.bomb.getFxImage());
        BombermanGame.entities.add(0, object);
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
}
