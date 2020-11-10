package uet.oop.bomberman.entities;

import uet.oop.bomberman.graphics.Sprite;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by hello on 11/10/2020.
 */
public class Map {
    public int level;
    public int row;
    public int colum;
    ArrayList<ArrayList<Character>> map = new ArrayList<>();

    public void insertFromFile(){

        File file = new File("res/levels/Level1.txt");
        Scanner scan = null;
        try {
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        level = scan.nextInt();
        row = scan.nextInt();
        colum = scan.nextInt();

        scan.nextLine();

        for(int rowIndex = 0; rowIndex < row; rowIndex++){
            String line = scan.nextLine();
            ArrayList<Character> lineChar = new ArrayList<>();
            for(int colIndex = 0; colIndex < colum; colIndex++){
                lineChar.add(line.charAt(colIndex));
            }
            map.add(lineChar);
        }

        for(int rowIndex = 0; rowIndex < row; rowIndex++){
            ArrayList<Character> lineChar = map.get(rowIndex);
            for(int colIndex = 0; colIndex < colum; colIndex++){
                System.out.print(lineChar.get(colIndex));
            }
            System.out.println();
        }

    }

    public void loadEntities(List<Entity> entities){
        for(int rowIndex = 0; rowIndex < map.size(); rowIndex++){
            ArrayList<Character> lineChar = map.get(rowIndex);
            for(int colIndex = 0; colIndex < lineChar.size(); colIndex++){
                Entity object = null;
                switch (lineChar.get(colIndex)){
                    case '*':{
                        object = new Brick(colIndex, rowIndex, Sprite.brick.getFxImage());
                        break;
                    }
                    case 'p':{
                        object = new Bomber(colIndex, rowIndex, Sprite.player_right.getFxImage());
                        break;
                    }
                    case '1':{
                        object = new Enemy(colIndex, rowIndex, Sprite.balloom_right1.getFxImage());
                        break;
                    }
                    case '2':{
                        object = new Enemy(colIndex, rowIndex, Sprite.oneal_right1.getFxImage());
                        break;
                    }
                    case 'b':{
                        object = new BombItem(colIndex, rowIndex, Sprite.powerup_bombs.getFxImage());
                        break;
                    }
                    case 'f':{
                        object = new FlameItem(colIndex, rowIndex, Sprite.powerup_flames.getFxImage());
                        break;
                    }
                    case 's':{
                        object = new SpeedItem(colIndex, rowIndex, Sprite.powerup_speed.getFxImage());
                        break;
                    }
                    default:{
                        break;
                    }
                }
                if(object != null){
                    entities.add(object);
                }

            }

        }
    }
    public void loadStillObjects(List<Entity> stillObjects ){
        for(int rowIndex = 0; rowIndex < map.size(); rowIndex++){
            ArrayList<Character> lineChar = map.get(rowIndex);
            for(int colIndex = 0; colIndex < lineChar.size(); colIndex++){
                Entity object = null;
                switch (lineChar.get(colIndex)){
                    case '#':{
                        object = new Wall(colIndex, rowIndex, Sprite.wall.getFxImage());
                        break;
                    }
                    case 'x':{
                        object = new Portal(colIndex, rowIndex, Sprite.portal.getFxImage());
                        break;
                    }
                    default:{
                        object = new Grass(colIndex, rowIndex, Sprite.grass.getFxImage());
                        break;
                    }
                }
                stillObjects.add(object);
            }

        }
    }
}
