package uet.oop.bomberman;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import uet.oop.bomberman.entities.*;
import uet.oop.bomberman.entities.airEntities.Bomber;
import uet.oop.bomberman.entities.bomb.Bomb;
import uet.oop.bomberman.entities.groundEntities.Grass;
import uet.oop.bomberman.entities.groundEntities.Wall;
import uet.oop.bomberman.graphics.Sprite;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BombermanGame extends Application {

    public static int WIDTH;
    public static int HEIGHT ;
    
    private GraphicsContext gc;
    private Canvas canvas;
    public static List<Entity> entities = new ArrayList<>();
    public static List<Entity> stillObjects = new ArrayList<>();

    public static ArrayList<ArrayList<Character>> mapChar;
    public static int[][] mesh;

    public static void main(String[] args) {
        Application.launch(BombermanGame.class);
    }


    @Override
    public void start(Stage stage) {
        Map map = new Map();
        map.insertFromFile();
        WIDTH = map.colum;
        HEIGHT = map.row;

        // Tao Canvas
        canvas = new Canvas(Sprite.SCALED_SIZE * WIDTH, Sprite.SCALED_SIZE * HEIGHT);
        gc = canvas.getGraphicsContext2D();

        // Tao root container
        Group root = new Group();
        root.getChildren().add(canvas);

        // Tao scene
        Scene scene = new Scene(root);

        // Them scene vao stage
        stage.setScene(scene);
        stage.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                render();
                update();
            }
        };
        timer.start();

        mapChar = map.getMap();
        mesh = map.loadMapInt();
        map.loadStillObjects(stillObjects);
        map.loadEntities(entities);

        Bomber bomberman = (Bomber) entities.get(0);
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()){
                    case UP:{
                        bomberman.moveUp();
                        break;
                    }
                    case DOWN:{
                        bomberman.moveDown();
                        break;
                    }
                    case LEFT:{
                        bomberman.moveLeft();
                        break;
                    }
                    case RIGHT:{
                        bomberman.moveRight();
                        break;
                    }
                    case W:{
                        bomberman.moveUp();
                        break;
                    }
                    case S:{
                        bomberman.moveDown();
                        break;
                    }
                    case A:{
                        bomberman.moveLeft();
                        break;
                    }
                    case D:{
                        bomberman.moveRight();
                        break;
                    }
                    case SPACE:{
                        bomberman.shoot();
                        break;
                    }
                }
            }
        });
    }

    public void createMap() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                Entity object;
                if (j == 0 || j == HEIGHT - 1 || i == 0 || i == WIDTH - 1) {
                    object = new Wall(i, j, Sprite.wall.getFxImage());
                }
                else {
                    object = new Grass(i, j, Sprite.grass.getFxImage());
                }
                stillObjects.add(object);
            }
        }
    }

    public void update() {
        entities.forEach(Entity::update);
    }

    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        stillObjects.forEach(g -> g.render(gc));
        entities.forEach(g -> g.render(gc));
    }
}
