package uet.oop.bomberman.entities;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * Created by hello on 11/12/2020.
 */
public abstract class AirEntity extends Entity {
    public boolean dead = false;

    public AirEntity(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    @Override
    public void update() {

    }

    public abstract void remove();

    public void moveUp(){

    }
    public void moveDown(){

    }
    public void moveLeft(){

    }
    public void moveRight(){

    }
}
