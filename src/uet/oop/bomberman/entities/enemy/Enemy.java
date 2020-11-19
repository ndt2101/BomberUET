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

    public void moveUp(){
        if(y > SCALE_SIZE && BomberManGame.map.mesh[y/SCALE_SIZE - 1][x/SCALE_SIZE] == 0){
            y -= SCALE_SIZE;
        }
    }

    public void moveDown(){
        if(BomberManGame.map.mesh[y/SCALE_SIZE + 1][x/SCALE_SIZE] == 0 ){
            y += SCALE_SIZE;
        }
    }

    public void moveLeft(){
        if(BomberManGame.map.mesh[y/SCALE_SIZE][x/SCALE_SIZE - 1] == 0 ) {
            x -= SCALE_SIZE;
        }
    }


    public void moveRight(){
        if(BomberManGame.map.mesh[y/SCALE_SIZE][x/SCALE_SIZE + 1] == 0 ) {
            x += SCALE_SIZE;
        }
    }

}
