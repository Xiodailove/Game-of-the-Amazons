package ubc.cosc322;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Utility{
    
    
    private Move move = new Move();
    // marked position
    //private int[][] marked = new int[10][10];
   
    private int[][] arrows = new int[10][10];
    public Utility(){

    }

    public int findTotal(int[][] board, int type, int maxmintype){ // find total blank takes one step
        //when we are black
            int total=0; // total blank takes one step
            ArrayList<Integer> tab = new ArrayList<>();
            ArrayList<Integer> sort = new ArrayList<>();
            int [][] currentPostion = new int[4][2];
            if(maxmintype == 1){ // min
                currentPostion = opponentPostion(board, type);
            }

            if(maxmintype == 2){ // max
                currentPostion = currentPostion(board, type);
            }
            
            
            
           /*  int[] a = new int[2];
            a[0] = currentPostion[0][0]; a[1] = currentPostion[0][1];

            int[] b = new int[2];
            b[0] = currentPostion[1][0]; b[1] = currentPostion[1][1];

            int[] c = new int[2];
            c[0] = currentPostion[2][0]; c[1] = currentPostion[2][1];

            int[] d = new int[2];
            d[0] = currentPostion[3][0]; d[1] = currentPostion[3][1]; */
            
            int[] postion = new int[2];
            int[] nextPostion = new int[2];
            
            
            

            //godown    
            for(int i=0;i<4;i++){
                postion[0] = currentPostion[i][0]; postion[1] = currentPostion[i][1];
                for(int j=0;j<9;j++){
                    
                    //System.out.println("bbbbbbbbbbbbbbbbbbb("+postion[0]+", "+postion[1]+")");

                    //System.out.println("("+move.goDown(postion[0], postion[1])[0]+", "+move.goDown(postion[0], postion[1])[1]+")");
                    
                    if(move.goDown(postion[0], postion[1])[0]<0 || move.goDown(postion[0], postion[1])[0]>9 || move.goDown(postion[0], postion[1])[1]<0 || move.goDown(postion[0], postion[1])[1]>9){
                        
                        break;
                        
                    }

                    if(board[move.goDown(postion[0], postion[1])[0]] [move.goDown(postion[0], postion[1])[1]] != 0){
                        break;
                    }
                    
                    nextPostion[0] = move.goDown(postion[0], postion[1])[0];
                    nextPostion[1] = move.goDown(postion[0], postion[1])[1];

                    
                    postion[0] = nextPostion[0];
                    postion[1] = nextPostion[1];

                    // marked positions
                  /*   int x =nextPostion[0];
                    int y =nextPostion[1];
                    marked[x][y] = -1; */
                    int x = nextPostion[0];
                    int y = nextPostion[1];
                    tab.add(x*10+y);

                    //System.out.println("("+nextPostion[0]+", "+nextPostion[1]+")");

                    total++;
                    //System.out.println(" B "+total);
                    
                }    
            }
            //System.out.println(total +", -------------------------------------------");
            //goDownLeft
            for(int i=0;i<4;i++){
                postion[0] = currentPostion[i][0]; postion[1] = currentPostion[i][1]; // get current postion for each chess
                for(int j=0;j<9;j++){

                    // if the next position is out of index, break
                    if(move.goDownLeft(postion[0], postion[1])[0]<0 || move.goDownLeft(postion[0], postion[1])[0]>9 || move.goDownLeft(postion[0], postion[1])[1]<0 || move.goDownLeft(postion[0], postion[1])[1]>9){
                       
                        break;
                        
                    }

                    if(board[move.goDownLeft(postion[0], postion[1])[0]] [move.goDownLeft(postion[0], postion[1])[1]] != 0){
                        break;
                    }
                    
                    // find the next postion
                    nextPostion[0] = move.goDownLeft(postion[0], postion[1])[0];
                    nextPostion[1] = move.goDownLeft(postion[0], postion[1])[1];

                   
                    
                    //update postion
                    postion[0] = nextPostion[0];
                    postion[1] = nextPostion[1];
                    /* int x =nextPostion[0];
                    int y =nextPostion[1];
                    marked[x][y] = -1; */
                    //System.out.println("("+nextPostion[0]+", "+nextPostion[1]+")");
                    int x = nextPostion[0];
                    int y = nextPostion[1];
                    tab.add(x*10+y);
                    total++;                  
                }    
            }
            //System.out.println(total +", ");
            
            //goDownRight
            for(int i=0;i<4;i++){
                postion[0] = currentPostion[i][0]; postion[1] = currentPostion[i][1]; // get current postion for each chess
                for(int j=0;j<9;j++){

                    // if the next position is out of index, break
                    if(move.goDownRight(postion[0], postion[1])[0]<0 || move.goDownRight(postion[0], postion[1])[0]>9 || move.goDownRight(postion[0], postion[1])[1]<0 || move.goDownRight(postion[0], postion[1])[1]>9){
                       
                        break;
                        
                    }

                    if(board[move.goDownRight(postion[0], postion[1])[0]] [move.goDownRight(postion[0], postion[1])[1]] != 0){
                        break;
                    }
                    
                    // find the next postion
                    nextPostion[0] = move.goDownRight(postion[0], postion[1])[0];
                    nextPostion[1] = move.goDownRight(postion[0], postion[1])[1];

                   
                    
                    //update postion
                    postion[0] = nextPostion[0];
                    postion[1] = nextPostion[1];
                    /* int x =nextPostion[0];
                    int y =nextPostion[1];
                    marked[x][y] = -1; */
                    //System.out.println("("+nextPostion[0]+", "+nextPostion[1]+")");
                    int x = nextPostion[0];
                    int y = nextPostion[1];
                    tab.add(x*10+y);
                    total++;                  
                }    
            }
            //System.out.println(total +", ");

            //goLeft
            for(int i=0;i<4;i++){
                postion[0] = currentPostion[i][0]; postion[1] = currentPostion[i][1]; // get current postion for each chess
                for(int j=0;j<9;j++){

                    // if the next position is out of index, break
                    if(move.goLeft(postion[0], postion[1])[0]<0 || move.goLeft(postion[0], postion[1])[0]>9 || move.goLeft(postion[0], postion[1])[1]<0 || move.goLeft(postion[0], postion[1])[1]>9){
                        break;
                        
                    }

                    if(board[move.goLeft(postion[0], postion[1])[0]] [move.goLeft(postion[0], postion[1])[1]] != 0){
                        break;
                    }
                    
                    // find the next postion
                    nextPostion[0] = move.goLeft(postion[0], postion[1])[0];
                    nextPostion[1] = move.goLeft(postion[0], postion[1])[1];

                    
                    
                    //update postion
                    postion[0] = nextPostion[0];
                    postion[1] = nextPostion[1];
                    /* int x =nextPostion[0];
                    int y =nextPostion[1];
                    marked[x][y] = -1; */
                    //System.out.println("("+nextPostion[0]+", "+nextPostion[1]+")");
                    int x = nextPostion[0];
                    int y = nextPostion[1];
                    tab.add(x*10+y);
                    total++;                  
                }    
            }
            //System.out.println(total +", ");

            //goUp
            for(int i=0;i<4;i++){
                postion[0] = currentPostion[i][0]; postion[1] = currentPostion[i][1]; // get current postion for each chess
                for(int j=0;j<9;j++){

                    // if the next position is out of index, break
                    if(move.goUp(postion[0], postion[1])[0]<0 || move.goUp(postion[0], postion[1])[0]>9 || move.goUp(postion[0], postion[1])[1]<0 || move.goUp(postion[0], postion[1])[1]>9){
                        
                        break;
                        
                    }

                    if(board[move.goUp(postion[0], postion[1])[0]] [move.goUp(postion[0], postion[1])[1]] != 0){
                        break;
                    }
                    
                    // find the next postion
                    nextPostion[0] = move.goUp(postion[0], postion[1])[0];
                    nextPostion[1] = move.goUp(postion[0], postion[1])[1];

                    
                    
                    //update postion
                    postion[0] = nextPostion[0];
                    postion[1] = nextPostion[1];
                  /*   int x =nextPostion[0];
                    int y =nextPostion[1];
                    marked[x][y] = -1; */
                    //System.out.println("("+nextPostion[0]+", "+nextPostion[1]+")");
                    int x = nextPostion[0];
                    int y = nextPostion[1];
                    tab.add(x*10+y);
                    total++;                  
                }    
            }
            //System.out.println(total +", ");
            //goUpLeft
            for(int i=0;i<4;i++){
                postion[0] = currentPostion[i][0]; postion[1] = currentPostion[i][1]; // get current postion for each chess
                for(int j=0;j<9;j++){

                    // if the next position is out of index, break
                    if(move.goUpLeft(postion[0], postion[1])[0]<0 || move.goUpLeft(postion[0], postion[1])[0]>9 || move.goUpLeft(postion[0], postion[1])[1]<0 || move.goUpLeft(postion[0], postion[1])[1]>9){
                        
                        break;
                        
                    }

                    if(board[move.goUpLeft(postion[0], postion[1])[0]] [move.goUpLeft(postion[0], postion[1])[1]] != 0){
                        break;
                    }
                    
                    // find the next postion
                    nextPostion[0] = move.goUpLeft(postion[0], postion[1])[0];
                    nextPostion[1] = move.goUpLeft(postion[0], postion[1])[1];

                    
                    
                    //update postion
                    postion[0] = nextPostion[0];
                    postion[1] = nextPostion[1];
                    /* int x =nextPostion[0];
                    int y =nextPostion[1];
                    marked[x][y] = -1; */
                    //System.out.println("("+nextPostion[0]+", "+nextPostion[1]+")");
                    int x = nextPostion[0];
                    int y = nextPostion[1];
                    tab.add(x*10+y);
                    total++;                  
                }    
            }
            //System.out.println(total +", ");

            //goUpRight
            for(int i=0;i<4;i++){
                postion[0] = currentPostion[i][0]; postion[1] = currentPostion[i][1]; // get current postion for each chess
                for(int j=0;j<9;j++){

                    // if the next position is out of index, break
                    if(move.goUpRight(postion[0], postion[1])[0]<0 || move.goUpRight(postion[0], postion[1])[0]>9 || move.goUpRight(postion[0], postion[1])[1]<0 || move.goUpRight(postion[0], postion[1])[1]>9){
                       
                        break;
                        
                    }

                    if(board[move.goUpRight(postion[0], postion[1])[0]] [move.goUpRight(postion[0], postion[1])[1]] != 0){
                        break;
                    }
                    
                    // find the next postion
                    nextPostion[0] = move.goUpRight(postion[0], postion[1])[0];
                    nextPostion[1] = move.goUpRight(postion[0], postion[1])[1];

                    
                    
                    //update postion
                    postion[0] = nextPostion[0];
                    postion[1] = nextPostion[1];
                    /* int x =nextPostion[0];
                    int y =nextPostion[1];
                    marked[x][y] = -1; */
                    //System.out.println("("+nextPostion[0]+", "+nextPostion[1]+")");
                    int x = nextPostion[0];
                    int y = nextPostion[1];
                    tab.add(x*10+y);
                    total++;                  
                }    
            }
            //System.out.println(total +", ");

            //goRight
            for(int i=0;i<4;i++){
                postion[0] = currentPostion[i][0]; postion[1] = currentPostion[i][1]; // get current postion for each chess
                for(int j=0;j<9;j++){

                    // if the next position is out of index, break
                    if(move.goRight(postion[0], postion[1])[0]<0 || move.goRight(postion[0], postion[1])[0]>9 || move.goRight(postion[0], postion[1])[1]<0 || move.goRight(postion[0], postion[1])[1]>9){
                       
                        break;
                        
                    }

                    if(board[move.goRight(postion[0], postion[1])[0]] [move.goRight(postion[0], postion[1])[1]] != 0){
                        break;
                    }
                    
                    // find the next postion
                    nextPostion[0] = move.goRight(postion[0], postion[1])[0];
                    nextPostion[1] = move.goRight(postion[0], postion[1])[1];

                    
                    
                    //update postion
                    postion[0] = nextPostion[0];
                    postion[1] = nextPostion[1];
                    /* int x =nextPostion[0];
                    int y =nextPostion[1];
                    marked[x][y] = -1; */
                    int x = nextPostion[0];
                    int y = nextPostion[1];
                    tab.add(x*10+y);
                    //System.out.println("("+nextPostion[0]+", "+nextPostion[1]+")");
                    total++;                  
                }    
            }

            //System.out.println("before clearing duplicates: "+tab.size());
            // clear duplicates
            for(int i =0;i<tab.size();i++){
                    if(!sort.contains(tab.get(i))){
                        sort.add(tab.get(i));
                    }
            }
            tab.clear();
            
            return sort.size();
    }

    public ArrayList<Integer> findAvailableArrows(int x,int y,int[][] map){
        
        return findAvailableMoves(x,y,map);
    }

    public ArrayList<Integer> findAvailableMoves(int x,int y, int[][] map){
        int[] nextPostion = new int[2];
        ArrayList<Integer> availableMoves = new ArrayList<>();
        
        ArrayList<Integer> sort = new ArrayList<>();

        int initialX =x;
        int initialY =y;
        //goDown
        for(int j=0;j<9;j++){
            if(move.goDown(x, y)[0]<0 || move.goDown(x, y)[0]>9 || move.goDown(x, y)[1]<0 || move.goDown(x, y)[1]>9){                   
                break;                   
            }
            
            if(map[move.goDown(x, y)[0]] [move.goDown(x, y)[1]] != 0){
                break;
            }

            nextPostion[0] = move.goDown(x, y)[0];
            nextPostion[1] = move.goDown(x, y)[1];

           
            
            x = nextPostion[0];
            y = nextPostion[1];

            availableMoves.add(x*10+y);
   
        }
        x = initialX;
        y = initialY;
        //goUp
        for(int j=0;j<9;j++){
            if(move.goUp(x, y)[0]<0 || move.goUp(x, y)[0]>9 || move.goUp(x, y)[1]<0 || move.goUp(x, y)[1]>9){                   
                break;                   
            }
            
            if(map[move.goUp(x, y)[0]] [move.goUp(x, y)[1]] != 0){
                break;
            }

            nextPostion[0] = move.goUp(x, y)[0];
            nextPostion[1] = move.goUp(x, y)[1];

           
            
            x = nextPostion[0];
            y = nextPostion[1];

            availableMoves.add(x*10+y);
   
        }
        x = initialX;
        y = initialY;

        //goUpLeft
        for(int j=0;j<9;j++){
            if(move.goUpLeft(x, y)[0]<0 || move.goUpLeft(x, y)[0]>9 || move.goUpLeft(x, y)[1]<0 || move.goUpLeft(x, y)[1]>9){                   
                break;                   
            }

            if(map[move.goUpLeft(x, y)[0]] [move.goUpLeft(x, y)[1]] != 0){
                break;
            }
                
            nextPostion[0] = move.goUpLeft(x, y)[0];
            nextPostion[1] = move.goUpLeft(x, y)[1];

            
            
            x = nextPostion[0];
            y = nextPostion[1];

            availableMoves.add(x*10+y);
   
        }
        x = initialX;
        y = initialY;

        //goUpRight
        for(int j=0;j<9;j++){
            if(move.goUpRight(x, y)[0]<0 || move.goUpRight(x, y)[0]>9 || move.goUpRight(x, y)[1]<0 || move.goUpRight(x, y)[1]>9){                   
                break;                   
            }
            if(map[move.goUpRight(x, y)[0]] [move.goUpRight(x, y)[1]] != 0){
                break;
            }

            nextPostion[0] = move.goUpRight(x, y)[0];
            nextPostion[1] = move.goUpRight(x, y)[1];

            
            
            x = nextPostion[0];
            y = nextPostion[1];

            availableMoves.add(x*10+y);
   
        }
        x = initialX;
        y = initialY;

        //goLeft
        for(int j=0;j<9;j++){
            if(move.goLeft(x, y)[0]<0 || move.goLeft(x, y)[0]>9 || move.goLeft(x, y)[1]<0 || move.goLeft(x, y)[1]>9){                   
                break;                   
            }

            if(map[move.goLeft(x, y)[0]] [move.goLeft(x, y)[1]] != 0){
                break;
            }
                
            nextPostion[0] = move.goLeft(x, y)[0];
            nextPostion[1] = move.goLeft(x, y)[1];

            
            
            x = nextPostion[0];
            y = nextPostion[1];

            availableMoves.add(x*10+y);
   
        }
        x = initialX;
        y = initialY;

        //goRight
        for(int j=0;j<9;j++){
            if(move.goRight(x, y)[0]<0 || move.goRight(x, y)[0]>9 || move.goRight(x, y)[1]<0 || move.goRight(x, y)[1]>9){                   
                break;                   
            }
            if(map[move.goRight(x, y)[0]] [move.goRight(x, y)[1]] != 0){
                break;
            }
                
            nextPostion[0] = move.goRight(x, y)[0];
            nextPostion[1] = move.goRight(x, y)[1];

           
            
            x = nextPostion[0];
            y = nextPostion[1];

            availableMoves.add(x*10+y);
   
        }
        x = initialX;
        y = initialY;

        //goDownLeft
        for(int j=0;j<9;j++){
            if(move.goDownLeft(x, y)[0]<0 || move.goDownLeft(x, y)[0]>9 || move.goDownLeft(x, y)[1]<0 || move.goDownLeft(x, y)[1]>9){                   
                break;                   
            }
            if(map[move.goDownLeft(x, y)[0]] [move.goDownLeft(x, y)[1]] != 0){
                break;
            }
                
            nextPostion[0] = move.goDownLeft(x, y)[0];
            nextPostion[1] = move.goDownLeft(x, y)[1];

            
            
            x = nextPostion[0];
            y = nextPostion[1];

            availableMoves.add(x*10+y);
   
        }
        x = initialX;
        y = initialY;

        //goDownRight
        for(int j=0;j<9;j++){
            if(move.goDownRight(x, y)[0]<0 || move.goDownRight(x, y)[0]>9 || move.goDownRight(x, y)[1]<0 || move.goDownRight(x, y)[1]>9){                   
                break;                   
            }

            if(map[move.goDownRight(x, y)[0]] [move.goDownRight(x, y)[1]] != 0){
                break;
            }
                
            nextPostion[0] = move.goDownRight(x, y)[0];
            nextPostion[1] = move.goDownRight(x, y)[1];

            
            
            x = nextPostion[0];
            y = nextPostion[1];

            availableMoves.add(x*10+y);
   
        }
        
        for(int i =0;i<availableMoves.size();i++){
            if(!sort.contains(availableMoves.get(i))){
                sort.add(availableMoves.get(i));
            }
        }
        availableMoves.clear();
        
        return sort;
    }

    public int[][] currentPostion(int[][] b, int type){     
        int [][] currentPostion = new int[4][2];
        int count =0;
        if(type ==1){// when we are black
            for(int i=0; i<10;i++){
                for(int j=0;j<10;j++){
                    if( b[i][j] == 1 && count <4 ){
                        currentPostion[count][0] =i; 
                        currentPostion[count][1] =j;
                        //System.out.println("bbbbbbbbbbbbbbbbbbbb("+count);
                        count++;
                    }
                }
            }
        }
        else{//when we are white
            for(int i=0; i<10;i++){
                for(int j=0;j<10;j++){
                    if( b[i][j] == 2 && count <4){
                        currentPostion[count][0] =i;
                        currentPostion[count][1] =j;
                        count++;
                    }
                }
            }
        }
        
        return currentPostion;

    }

    public int[][] opponentPostion(int[][] b, int type){     
        int [][] opponentPostion = new int[4][2];
        int count =0;
        if(type ==1){// when we are black
            for(int i=0; i<10;i++){
                for(int j=0;j<10;j++){
                    if( b[i][j] == 2 && count <4 ){
                        opponentPostion[count][0] =i; 
                        opponentPostion[count][1] =j;
                        //System.out.println("bbbbbbbbbbbbbbbbbbbb("+count);
                        count++;
                    }
                }
            }
        }
        else{//when we are white
            for(int i=0; i<10;i++){
                for(int j=0;j<10;j++){
                    if( b[i][j] == 1 && count <4){
                        opponentPostion[count][0] =i;
                        opponentPostion[count][1] =j;
                        count++;
                    }
                }
            }
        }
        
        return opponentPostion;

    }
}