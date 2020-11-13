package uet.oop.bomberman.entities.bomb;

import uet.oop.bomberman.BomberManGame;
import uet.oop.bomberman.entities.Map;
import uet.oop.bomberman.graphics.Sprite;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hello on 11/13/2020.
 */
public class Flames extends Flame {
    public int r;
    public int timeOut = 120;
    List<Flame> flames = new ArrayList<>();

    public Flames(int x, int y, Image img) {
        super(x, y, "Flames", img);
    }

    public Flames(int x, int y, int r){

        this.x = x * Sprite.SCALED_SIZE;
        this.y = y * Sprite.SCALED_SIZE;
        this.r = r;

        createFlames();
    }

    public void createFlames(){
        Flame center = new Flame(getX(), getY(), "Flame", Sprite.bomb_exploded.getFxImage());
        flames.add(center);

        for(int i = 1; i <= r; i++){
            if(Map.mesh[getY() - i][getX()] != 0 || i == r){
                Flame top = new Flame(getX(), getY() - i, "Flame", Sprite.explosion_vertical_top_last.getFxImage());
                flames.add(top);
                break;
            }
            else{
                Flame top = new Flame(getX(), getY() - i, "Flame", Sprite.explosion_vertical.getFxImage());
                flames.add(top);
            }
        }
        for(int i = 1; i <= r; i++){
            if(Map.mesh[getY() + i][getX()] != 0 || i == r){
                Flame down = new Flame(getX(), getY() + i, "Flame", Sprite.explosion_vertical_down_last.getFxImage());
                flames.add(down);
                break;
            }
            else{
                Flame down = new Flame(getX(), getY() + i, "Flame", Sprite.explosion_vertical.getFxImage());
                flames.add(down);
            }
        }
        for(int i = 1; i <= r; i++){
            if(Map.mesh[getY()][getX() - i] != 0 || i == r){
                Flame left = new Flame(getX() - i, getY(), "Flame", Sprite.explosion_horizontal_left_last.getFxImage());
                flames.add(left);
                break;
            }
            else{
                Flame left = new Flame(getX() - i, getY(), "Flame", Sprite.explosion_horizontal.getFxImage());
                flames.add(left);
            }
        }
        for(int i = 1; i <= r; i++){
            if(Map.mesh[getY()][getX() + i] != 0 || i == r){
                Flame right = new Flame(getX() + i, getY(), "Flame", Sprite.explosion_horizontal_right_last.getFxImage());
                flames.add(right);
                break;
            }
            else{
                Flame right = new Flame(getX() + i, getY(), "Flame", Sprite.explosion_horizontal.getFxImage());
                flames.add(right);
            }
        }
    }

    @Override
    public void update() {
        if(timeOut == 25){
            kill();
        }
        else if(timeOut == 0){
            remove();
        }
        timeOut--;
    }

    public void kill(){
        BomberManGame.entities.forEach(entity -> {
            if(inRange(entity.getX(), entity.getY())){
                entity.remove();
                if(!entity.isItem()){

                }

            }
        });
    }

    public boolean inRange(int xUnit, int yUnit){

        for(int i = 0; i < flames.size(); i++){
            Flame flame = flames.get(i);
            if(flame.getX() == xUnit && flame.getY() == yUnit) {
                return true;
            }
        }

        return false;
    }

    public void explode(){
        if(timeOut > 40){
            timeOut = 40;
        }
    }


    public void render(GraphicsContext gc){
        if(timeOut < 25){
            flames.forEach(flame -> {
                flame.render(gc);
            });
        }
    }

    @Override
    public void remove() {
        dead = true;
    }
}
