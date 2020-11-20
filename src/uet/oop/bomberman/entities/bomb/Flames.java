package uet.oop.bomberman.entities.bomb;

import uet.oop.bomberman.BomberManGame;
import uet.oop.bomberman.graphics.Sprite;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;
import uet.oop.bomberman.level.*;

/**
 * Created by hello on 11/13/2020.
 */
public class Flames extends Flame {
    public int r;
    public int timeOut = 120;
    List<Flame> flames = new ArrayList<>();
    List<Flame> flames1 = new ArrayList<>();
    List<Flame> flames2 = new ArrayList<>();

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
        Flame center = new Flame(getX(), getY(), "center", Sprite.bomb_exploded.getFxImage());
        flames.add(center);
        Flame center1 = new Flame(getX(), getY(), "Flame", Sprite.bomb_exploded1.getFxImage());
        flames1.add(center1);
        Flame center2 = new Flame(getX(), getY(), "Flame", Sprite.bomb_exploded2.getFxImage());
        flames2.add(center2);
        Audio.playBombExplode();
        for(int i = 1; i <= r; i++){
            if(BomberManGame.map.mesh[getY() - i][getX()] != 0 || i == r){
                Flame top = new Flame(getX(), getY() - i, "top", Sprite.explosion_vertical_top_last.getFxImage());
                flames.add(top);
                Flame top1 = new Flame(getX(), getY() - i, "Flame", Sprite.explosion_vertical_top_last1.getFxImage());
                flames1.add(top1);
                Flame top2 = new Flame(getX(), getY() - i, "Flame", Sprite.explosion_vertical_top_last2.getFxImage());
                flames2.add(top2);
                break;
            }
            else{
                Flame top = new Flame(getX(), getY() - i, "top", Sprite.explosion_vertical.getFxImage());
                flames.add(top);
                Flame top1 = new Flame(getX(), getY() - i, "Flame", Sprite.explosion_vertical1.getFxImage());
                flames1.add(top1);
                Flame top2 = new Flame(getX(), getY() - i, "Flame", Sprite.explosion_vertical2.getFxImage());
                flames2.add(top2);
            }
        }
        for(int i = 1; i <= r; i++){
            if(BomberManGame.map.mesh[getY() + i][getX()] != 0 || i == r){
                Flame down = new Flame(getX(), getY() + i, "down", Sprite.explosion_vertical_down_last.getFxImage());
                flames.add(down);
                Flame down1 = new Flame(getX(), getY() + i, "Flame", Sprite.explosion_vertical_down_last1.getFxImage());
                flames1.add(down1);
                Flame down2 = new Flame(getX(), getY() + i, "Flame", Sprite.explosion_vertical_down_last2.getFxImage());
                flames2.add(down2);
                break;
            }
            else{
                Flame down = new Flame(getX(), getY() + i, "down", Sprite.explosion_vertical.getFxImage());
                flames.add(down);
                Flame down1 = new Flame(getX(), getY() + i, "Flame", Sprite.explosion_vertical1.getFxImage());
                flames1.add(down1);
                Flame down2 = new Flame(getX(), getY() + i, "Flame", Sprite.explosion_vertical2.getFxImage());
                flames2.add(down2);
            }
        }
        for(int i = 1; i <= r; i++){
            if(BomberManGame.map.mesh[getY()][getX() - i] != 0 || i == r){
                Flame left = new Flame(getX() - i, getY(), "left", Sprite.explosion_horizontal_left_last.getFxImage());
                flames.add(left);
                Flame left1 = new Flame(getX() - i, getY(), "Flame", Sprite.explosion_horizontal_left_last1.getFxImage());
                flames1.add(left1);
                Flame left2 = new Flame(getX() - i, getY(), "Flame", Sprite.explosion_horizontal_left_last2.getFxImage());
                flames2.add(left2);
                break;
            }
            else{
                Flame left = new Flame(getX() - i, getY(), "left", Sprite.explosion_horizontal.getFxImage());
                flames.add(left);
                Flame left1 = new Flame(getX() - i, getY(), "Flame", Sprite.explosion_horizontal1.getFxImage());
                flames1.add(left1);
                Flame left2 = new Flame(getX() - i, getY(), "Flame", Sprite.explosion_horizontal2.getFxImage());
                flames2.add(left2);
            }
        }
        for(int i = 1; i <= r; i++){
            if(BomberManGame.map.mesh[getY()][getX() + i] != 0 || i == r){
                Flame right = new Flame(getX() + i, getY(), "right", Sprite.explosion_horizontal_right_last.getFxImage());
                flames.add(right);
                Flame right1 = new Flame(getX() + i, getY(), "Flame", Sprite.explosion_horizontal_right_last1.getFxImage());
                flames1.add(right1);
                Flame right2 = new Flame(getX() + i, getY(), "Flame", Sprite.explosion_horizontal_right_last2.getFxImage());
                flames2.add(right2);
                break;
            }
            else{
                Flame right = new Flame(getX() + i, getY(), "right", Sprite.explosion_horizontal.getFxImage());
                flames.add(right);
                Flame right1 = new Flame(getX() + i, getY(), "Flame", Sprite.explosion_horizontal1.getFxImage());
                flames1.add(right1);
                Flame right2 = new Flame(getX() + i, getY(), "Flame", Sprite.explosion_horizontal2.getFxImage());
                flames2.add(right2);
            }
        }
    }

    @Override
    public void update() {
        stateClock++;

        if(timeOut == 40){
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
                if(entity.isItem()){
                    entity.remove();
                }
                else{
                    entity.check();
                }

            }
        });
        BomberManGame.map.loadUF();
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
        if(timeOut > 60){
            timeOut = 60;
        }
    }


    public void render(GraphicsContext gc){

        if(timeOut <=60 && timeOut >= 40){
            flames.forEach(flame -> {
                flame.render(gc);
            });
        }
        else if(timeOut < 40 && timeOut >= 20) {
            flames1.forEach(flame1 -> {
                flame1.render(gc);
            });
        }
        else if (timeOut < 20 && timeOut >= 1) {
            flames2.forEach(flame2 -> {
                flame2.render(gc);
            });
        }
    }

    @Override
    public void remove() {
        dead = true;
    }
}
