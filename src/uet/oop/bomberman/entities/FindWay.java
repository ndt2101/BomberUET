package uet.oop.bomberman.entities;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import java.nio.file.DirectoryNotEmptyException;
import java.util.ArrayList;
import java.util.Set;

import uet.oop.bomberman.entities.Map.*;

/**
 * cui bap: dung distance
 * cai tien: dung union find + BFS
 */

public class FindWay {
    static class Distance {
        String next;
        double distance;

        Distance(String next, double distance){
            this.next = next;
            setDistance(distance);
        }

        Distance(Distance x){
            this.next = x.getNext();
            setDistance(x.getDistance());
        }

        public void setDistance(double distance) {
            this.distance = Math.ceil(distance * 1000)/1000;
        }

        public void setNext(String next) {
            this.next = next;
        }

        public double getDistance() {
            return distance;
        }

        public String getNext() {
            return next;
        }

        public String toString(){
            return next + " " + distance;
        }
    }

    public static double distance(int x1, int y1, int x2, int y2){
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    public static String calculateWay(int playerX, int playerY, int enemyX, int enemyY){
        ArrayList<Distance> distances = new ArrayList<>();

        double up = distance(playerX, playerY, enemyX, enemyY - 1);
        double down = distance(playerX, playerY, enemyX, enemyY + 1);
        double left = distance(playerX, playerY, enemyX - 1, enemyY);
        double right = distance(playerX, playerY, enemyX + 1, enemyY);

        Distance up1 = new Distance("up" , up);
        Distance down1 = new Distance("down", down);
        Distance left1 = new Distance("left", left);
        Distance right1 = new Distance("right", right);
        distances.add(up1); distances.add(down1); distances.add(left1); distances.add(right1);

        for(int i = 0; i < 4; i++){
            double min = distances.get(i).getDistance();
            int index = i;
            for (int j = i; j < 4; j++){
                if(min > distances.get(j).getDistance()){
                    min = distances.get(j).getDistance();
                    index = j;
                }
            }
            Distance temp = new Distance(distances.get(i));
            distances.set(i, distances.get(index));
            distances.set(index, temp);

        }

//        for(int i = 0; i < 4; i ++){
//            System.out.println(distances.get(i).toString());
//        }
//        System.out.println();



        return canMove(distances, enemyX, enemyY);
    }

    public static String canMove(ArrayList<Distance> distances, int enemyX, int enemyY){
        boolean canMove = false;
        String next = "";
        int i = 0;
        do{
            next = distances.get(i).getNext();
            switch (next){
                case "up": {
                    if(Map.mesh[enemyY - 1][enemyX] != 0){
                        i++;
                    }
                    else{
                        canMove = true;
                    }
                    break;
                }
                case "down": {
                    if(Map.mesh[enemyY + 1][enemyX] != 0){
                        i++;
                    }
                    else{
                        canMove = true;
                    }
                    break;
                }
                case "left": {
                    if(Map.mesh[enemyY ][enemyX - 1] != 0){
                        i++;
                    }
                    else{
                        canMove = true;
                    }
                    break;
                }
                case "right": {
                    if(Map.mesh[enemyY ][enemyX + 1] != 0){
                        i++;
                    }
                    else{
                        canMove = true;
                    }
                    break;
                }
            }
        }
        while (!canMove || i >= 4);

        return next;
    }


    public static void main(String[] strings){
        FindWay findWay = new FindWay();
//        System.out.println(findWay.distance(0, 0, 1, 1));
        findWay.calculateWay(1, 1, 2, 1);
    }

}
