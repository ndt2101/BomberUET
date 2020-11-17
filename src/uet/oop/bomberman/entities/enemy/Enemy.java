package uet.oop.bomberman.entities.enemy;

import javafx.scene.image.Image;
import uet.oop.bomberman.BomberManGame;
import uet.oop.bomberman.entities.AirEntity;
import uet.oop.bomberman.entities.Map;
import uet.oop.bomberman.graphics.Sprite;

/**
 * Created by hello on 11/12/2020.
 */
public abstract class Enemy extends AirEntity {
    public Enemy(int x, int y, String type, Image img) {
        super(x, y, type, img);
        item = true;
    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    public abstract void animate();

    @Override
    public void remove() {
        Map.mesh[getY()][getX()] = 0;
        dead = true;
    }

    @Override
    public void moveUp(){
        if(y > SCALE_SIZE && Map.mesh[y/SCALE_SIZE - 1][x/SCALE_SIZE] == 0){
//            Map.mesh[getY()][getX()] = 0;
//            Map.mesh[y/SCALE_SIZE - 1][x/SCALE_SIZE] = 1;
            y -= SCALE_SIZE;
        }
    }

    @Override
    public void moveDown(){
        if(Map.mesh[y/SCALE_SIZE + 1][x/SCALE_SIZE] == 0 ){
//            Map.mesh[getY()][getX()] = 0;
//            Map.mesh[y/SCALE_SIZE + 1][x/SCALE_SIZE] = 1;
            y += SCALE_SIZE;
        }
    }

    @Override
    public void moveLeft(){
        if(x > SCALE_SIZE && Map.mesh[y/SCALE_SIZE][x/SCALE_SIZE - 1] == 0 ) {
//            Map.mesh[getY()][getX()] = 0;
//            Map.mesh[y/SCALE_SIZE][x/SCALE_SIZE - 1] = 1;
            x -= SCALE_SIZE;
        }
    }

    @Override
    public void moveRight(){
        if(Map.mesh[y/SCALE_SIZE][x/SCALE_SIZE + 1] == 0 ) {
//            Map.mesh[getY()][getX()] = 0;
//            Map.mesh[y/SCALE_SIZE][x/SCALE_SIZE + 1] = 1;
            x += SCALE_SIZE;
        }
    }

}
