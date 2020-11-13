package uet.oop.bomberman;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * Created by hello on 11/9/2020.
 */
public class Solution {
    public static String ch = "   *f2b   f        x  s        f s     1x ";
    public static String ch2 = "   *fb   f        x  s        f s     x ";
    public static void randomMap() throws IOException {
        Random rd = new Random();
        int row = rd.nextInt(5) + 15;
        int colum = rd.nextInt(10) + 20;
        System.out.println(row + " " + colum);

        char[][] map = new char[row][colum];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < colum; j++){
                if(i == 0 || i == row - 1 || j == 0 || j == colum - 1){
                    map[i][j] = '#';
                }
                else if(i % 2 == 0  && j % 2 == 0){
                    map[i][j] = '#';
                }
                else if( i < 6 && j < 6){
                    int index = rd.nextInt(ch2.length());
                    map[i][j] = ch2.charAt(index);
                }
                else{
                    int index = rd.nextInt(ch.length());
                    map[i][j] = ch.charAt(index);
                }

            }
        }

//        for(int i = 0; i < row; i++){
//            for(int j = 0; j < colum; j++){
//                System.out.print(map[i][j]);
//            }
//            System.out.println();
//        }
        map[1][1] = 'p';

        File file = new File("res/levels/Level0.txt");
        FileWriter  fileWriter = new FileWriter(file);
        fileWriter.write("1 " + row + " " + colum + "\n");
        for(int i = 0; i < row; i++){
            for(int j = 0; j < colum; j++){
                fileWriter.write(map[i][j]);
            }
            fileWriter.write("\n");
        }
        fileWriter.write("\n");
        fileWriter.close();
        return;
    }

    public static void main(String[] strings) throws IOException {
        Solution.randomMap();
    }
}
