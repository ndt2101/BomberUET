package uet.oop.bomberman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by hello on 11/9/2020.
 */
public class Solution {

    public void insertFromFile() throws FileNotFoundException {
        int level;
        int row;
        int colum;
        ArrayList<ArrayList<Character>> map = new ArrayList<>();

        File file = new File("res/levels/Level1.txt");
        Scanner scan = new Scanner(file);
        level = scan.nextInt();
        row = scan.nextInt();
        colum = scan.nextInt();

        scan.nextLine();

        for(int rowIndex = 0; rowIndex < row; rowIndex++){
            String line = scan.nextLine();
            ArrayList<Character> lineChar = new ArrayList<>();
            for(int colIndex = 0; colIndex < colum; colIndex++){
//                map[rowIndex][colIndex] = line.charAt(colIndex);
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

    public void loadMap(ArrayList<ArrayList<Character>> map){
        for(int rowIndex = 0; rowIndex < map.size(); rowIndex++){
            ArrayList<Character> lineChar = map.get(rowIndex);
            for(int colIndex = 0; colIndex < lineChar.size(); colIndex++){
                switch (lineChar.get(colIndex)){
                    case '#':{
                        System.out.print("Wall");
                        break;
                    }
                    case '*':{
                        System.out.print("Brick");
                        break;
                    }
                    case 'x':{
                        System.out.print("Portal");
                        break;
                    }
                    case 'p':{
                        System.out.print("Bomber");
                        break;
                    }
                    case '1':{
                        System.out.print("Balloon");
                        break;
                    }
                    case '2':{
                        System.out.print("Oneal");
                        break;
                    }
                    case 'b':{
                        System.out.print("Bomb Item");
                        break;
                    }
                    case 'f':{
                        System.out.print("Flame Item");
                        break;
                    }
                    case 's':{
                        System.out.print("Speed Item");
                        break;
                    }
                    default:{
                        System.out.print("Grass");
                        break;
                    }
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] strings) throws FileNotFoundException {
        Solution solution = new Solution();
        solution.insertFromFile();
    }
}
