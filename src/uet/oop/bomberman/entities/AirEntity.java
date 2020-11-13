package uet.oop.bomberman.entities;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;

/**
 * Created by hello on 11/12/2020.
 */
public abstract class AirEntity {
    protected int HP = 0;
    protected boolean dead = false;
    protected boolean item = false;

    protected String type;
    protected Image img;
    protected int x;
    protected int y;
    protected int SCALE_SIZE = Sprite.SCALED_SIZE;

    public AirEntity(int x, int y, String type, Image img){
        this.x = x * Sprite.SCALED_SIZE;
        this.y = y * Sprite.SCALED_SIZE;

        this.type = type;
        this.img = img;
    }

    public AirEntity() {

    }


    public void update() {

    }

    public void render(GraphicsContext gc) {
        gc.drawImage(img, x, y);
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

    public int getX(){
        return x / Sprite.SCALED_SIZE;
    }
    public int getY(){
        return y / Sprite.SCALED_SIZE;
    }
    public String getType(){
        return type;
    }
    public boolean isDead(){
        return dead;
    }
    public boolean isItem(){
        return item;
    }

    @Override
    public String toString(){
        return "(" + x + ", " + y + ")";
    }

}
