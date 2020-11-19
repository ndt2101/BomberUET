package uet.oop.bomberman;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import uet.oop.bomberman.entities.AirEntity;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.Map;
import uet.oop.bomberman.entities.airEntities.Bomber;
import uet.oop.bomberman.entities.bomb.Flames;
import uet.oop.bomberman.graphics.Sprite;
import javafx.animation.AnimationTimer;
import javafx.application.Application;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hello on 11/12/2020.
 */

public class BomberManGame extends Application{
    public int SCALE_SIZE = Sprite.SCALED_SIZE;
    public static int WIDTH;
    public static int HEIGHT ;

    public GraphicsContext gc;
    public Canvas canvas;
    public Group root;

    public static Map map = new Map();

    private Bomber player = null;

    public static List<AirEntity> entities = new ArrayList<>();
    public static List<Entity> stillObjects = new ArrayList<>();
    public static List<Flames> flames = new ArrayList<>();

    private int timeOut = 60;

    private AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long now) {
            if(player.isDead()) {
                if(timeOut == 0){
                    gameOver("Game over!");
                }
                else {
                    render();
                    update();
                    timeOut--;
                }

            }
            else {
                render();
                update();
            }


        }
    };

    public void createContent(){

        timer.start();
    }

    public void update(){
        entities.forEach(entity -> {
            entity.update();
            switch (entity.getType()){
                case "Balloon":{
                    if(entity.toString().equals(player.toString())){
                        player.remove();
                    }
                    break;
                }
                case "Oneal":{
                    if(entity.toString().equals(player.toString())){
                        player.remove();
                    }
                    break;
                }
                case "Doll":{
                    if(entity.toString().equals(player.toString())){
                        player.remove();
                    }
                    break;
                }
                case "BombItem":{
                    if(entity.toString().equals(player.toString())){
                        entity.remove();
                        player.increseBomb();
                    }
                    break;
                }
                case "FlameItem":{
                    if(entity.toString().equals(player.toString())){
                        entity.remove();
                        player.increaseFlams();
                    }
                    break;
                }
                case "SpeedItem":{
                    if(entity.toString().equals(player.toString())){
                        entity.remove();
                        player.increaseSpeed();
                    }
                    break;
                }
            }

        });

        entities.removeIf(entity -> {
            return entity.isDead();
        });

        flames.forEach(flame -> {
            flame.update();
        });

        flames.removeIf(flame ->{
            return flame.isDead();
        });

        map.portals.forEach(portal -> {
            if(portal.toString().equals(player.toString())){
                boolean emptyEnemy = true;
                for(int i = 0; i < entities.size(); i++){
                    if(entities.get(i).getType().equals("Balloon") || entities.get(i).getType().equals("Oneal") || entities.get(i).getType().equals("Doll")){
                        emptyEnemy = false;
                    }
                }
                if(emptyEnemy) gameOver("You win!");
            }
        });
    }

    public void render(){
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        stillObjects.forEach(g -> g.render(gc));
        entities.forEach(g -> g.render(gc));
        flames.forEach(g -> g.render(gc));
    }

    public void gameOver(String text){
        System.out.println("!gameover");
        timer.stop();

        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        //set background color
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        //set text
        gc.setFill(Color.WHITE);
        gc.setFont(Font.font(100));

        gc.setStroke(Color.WHITE);
        gc.setTextAlign(TextAlignment.CENTER);
        gc.strokeText( text , canvas.getWidth() / 2, canvas.getHeight() / 2);
    }

    public void nextMap() {

    }

    @Override
    public void start(Stage primaryStage) {

        WIDTH = map.colum;
        HEIGHT = map.row;

        canvas = new Canvas(WIDTH * SCALE_SIZE, HEIGHT * SCALE_SIZE);
        gc = canvas.getGraphicsContext2D();
        root = new Group();

        root.getChildren().add(canvas);

        Scene scene = new Scene(root);

        primaryStage.setTitle("B O O M");
        primaryStage.setScene(scene);
        primaryStage.show();

        createContent();

        map.loadStillObjects(stillObjects);
        map.loadEntities(entities);

        player =(Bomber) entities.get(0);

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()){
                    case W:
                        player.moveUp();
                        break;
                    case S:
                        player.moveDown();
                        break;
                    case A:
                        player.moveLeft();
                        break;
                    case D:
                        player.moveRight();
                        break;
                    case UP:
                        player.moveUp();
                        break;
                    case DOWN:
                        player.moveDown();
                        break;
                    case LEFT:
                        player.moveLeft();
                        break;
                    case RIGHT:
                        player.moveRight();
                        break;
                    case DIGIT1:
                        player.increaseSpeed();
                        break;
                    case DIGIT2:
                        player.increaseFlams();
                        break;
                    case DIGIT3:
                        player.increseBomb();
                        break;
                    case SPACE:{
                        player.shoot();
                        break;
                    }
                    case DIGIT0:{
                        entities.forEach(airEntity -> {
                            if(airEntity.getType().equals("Brick")){
                                airEntity.remove();
                            }
                        });
                        entities.removeIf(airEntity -> {
                            return airEntity.isDead();
                        });
                        break;
                    }
                    case ENTER:{
                        entities.forEach(airEntity -> {
                            if(airEntity.getType().equals("Balloon") || airEntity.getType().equals("Oneal")){
                                airEntity.remove();
                            }
                        });
                        entities.removeIf(airEntity -> {
                            return airEntity.isDead();
                        });
                        break;
                    }

                }
            }
        });

    }

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void init() throws IOException {
    }

    @Override
    public void stop(){

    }
}
