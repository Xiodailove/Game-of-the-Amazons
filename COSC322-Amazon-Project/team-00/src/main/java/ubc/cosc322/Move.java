package ubc.cosc322;

import java.util.ArrayList;

public class Move {
    public  Move() {
    
    }
    

    public int[] goUp(int x, int y){
        int[] goUp = new int[2];
        goUp[0]= x+1;
        goUp[1]= y;
 
        return goUp;


    }
    
    public int[] goUpRight(int x, int y){
        int[] goUpRight = new int[2];
        goUpRight[0]= x+1;
        goUpRight[1]= y+1;
 
        return goUpRight;
    }
    
    public int[] goUpLeft(int x, int y){
        int[] goUpLeft = new int[2];
        goUpLeft[0]= x+1;
        goUpLeft[1]= y-1;
 
        return goUpLeft;
    }
    
    public int[] goDown(int x, int y){
        int[] goDown = new int[2];
        goDown[0]= x-1;
        goDown[1]= y;
 
        return goDown;
    }
    
    public int[] goDownLeft(int x, int y){
        int[] goDownLeft = new int[2];
        goDownLeft[0]= x-1;
        goDownLeft[1]= y-1;
 
        return goDownLeft;
    }
    
    public int[] goDownRight(int x, int y){
        int[] goDownRight = new int[2];
        goDownRight[0]= x-1;
        goDownRight[1]= y+1;
 
        return goDownRight;
    }
    
    public int[] goLeft(int x, int y){
        int[] goLeft = new int[2];
        goLeft[0]= x;
        goLeft[1]= y-1;
 
        return goLeft;
    }

    public int[] goRight(int x, int y){
        int[] goRight = new int[2];
        goRight[0]= x;
        goRight[1]= y+1;
 
        return goRight;
    }

    public int[] convertPostion(int x){
        int[] convertPostion = new int[2];
        convertPostion[1] = x%10;
        convertPostion[0] = (x-convertPostion[1])/10;
        return convertPostion;
    }


   
}
