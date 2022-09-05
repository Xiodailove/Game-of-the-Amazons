package ubc.cosc322;

import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        
        int[][] board = {{0,0,0,2,0,0,2,0,0,0},
        {0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0},
        {2,0,0,0,0,0,0,0,0,2},
        {0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0},
        {1,0,0,0,0,0,0,0,0,1},
        {0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0},
        {0,0,0,1,0,0,1,0,0,0},};
        Utility u = new Utility();
        
        Move m = new Move();
        MinMax min = new MinMax();
        
        //System.out.println("aaaaaaaaaaaaaaaaa"+u.findAvailableMoves(6, 0));  

       /*  Move m = new Move();

        int[] convertPostion = m.convertPostion(8);
        System.out.println(convertPostion[0] +", "+convertPostion[1]); */

        /* long startTime=System.currentTimeMillis();
        System.out.println("Run: ");
        MinMax m = new MinMax();
        Board b = new Board();
       
        ArrayList<ArrayList<Integer>> a = m.findBestMove(b.getBorad(), 2);
        System.out.println("1............");
        for(int i=0; i<3;i++){
            System.out.println(a.get(i).get(1)+", "+a.get(i).get(1));
        }
        System.out.println("2............");
        
         a = m.findBestMove(b.getBorad(), 2);
        for(int i=0; i<3;i++){
            System.out.println(a.get(i).get(1)+", "+a.get(i).get(1));
        }
        System.out.println("3............");
        
         a = m.findBestMove(b.getBorad(), 2);
        for(int i=0; i<3;i++){
            System.out.println(a.get(i).get(1)+", "+a.get(i).get(1));
        }
        long endTime=System.currentTimeMillis();
        System.out.println("Run time: "+(endTime-startTime)+"ms");   */


            min.findBestMove(board, 0);
        
        

    }
}
