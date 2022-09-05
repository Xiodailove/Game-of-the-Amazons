package ubc.cosc322;

import java.util.ArrayList;

public class MinMax{
    Utility u =new Utility();
    Move m = new Move();
    private int count=0;
   
    public MinMax(){

    } 

    public ArrayList<ArrayList<Integer>> findBestMove(int[][] b, int type){
       
        int[][] currentPostion = u.currentPostion(b,type);
        ArrayList<Integer> availableMoves = new ArrayList<>();
        ArrayList<Integer> availableArrows = new ArrayList<>();
        
        int[] movePosition = new int[2];
        int[] arrowPosition = new int[2];       
        int[][] graph = b;

        int min=9999;
        int max=0;

        ArrayList<Integer> bestQueen = new ArrayList<Integer>();
        ArrayList<Integer> bestMove = new ArrayList<Integer>();
        ArrayList<Integer> bestArrow = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> bestQueenMoveArrow = new ArrayList<>(); // index 0 ->best move, index 1 ->best arrow 
        
        

        
        for(int i=0;i<4;i++){
            
            availableMoves = u.findAvailableMoves(currentPostion[i][0],currentPostion[i][1],b);
            

            for(int j=0; j<availableMoves.size();j++ ){

                movePosition = m.convertPostion(availableMoves.get(j));
                //System.out.println("availableMoves("+movePosition[0]+", "+movePosition[1]+") ");
                availableArrows = u.findAvailableArrows(movePosition[0],movePosition[1],b);

                for(int z=0; z<availableArrows.size(); z++){

                    arrowPosition = m.convertPostion(availableArrows.get(z));
                    graph[arrowPosition[0]][arrowPosition[1]] = -1;
                    
                    //System.out.println("available arrowPosition("+arrowPosition[0]+", "+arrowPosition[1]+") ");
                    //System.out.print("1---"+u.findTotal(graph, type)+",  ");
                    if(count < 7 && u.findTotal(graph, type,1) < min){
                        
                        
                        min = u.findTotal(graph, type,1);


                        bestQueen.add(0,currentPostion[i][0]);
                        bestQueen.add(1,currentPostion[i][1]);
                        //System.out.println("best original position("+bestQueen.get(0)+", "+bestQueen.get(1)+") ");

                        bestMove.add(0,movePosition[0]);
                        bestMove.add(1,movePosition[1]);
                        //System.out.println("best new position("+bestMove.get(0)+", "+bestMove.get(1)+") ");

                        bestArrow.add(0,arrowPosition[0]);
                        bestArrow.add(1,arrowPosition[1]);
                        //System.out.println("best arrow("+bestArrow.get(0)+", "+bestArrow.get(1)+") ");
                    }

                    if(count >= 7 && u.findTotal(graph, type, 2) > max){
                        
                        
                        max = u.findTotal(graph, type,2);


                        bestQueen.add(0,currentPostion[i][0]);
                        bestQueen.add(1,currentPostion[i][1]);
                        //System.out.println("best original position("+bestQueen.get(0)+", "+bestQueen.get(1)+") ");

                        bestMove.add(0,movePosition[0]);
                        bestMove.add(1,movePosition[1]);
                        //System.out.println("best new position("+bestMove.get(0)+", "+bestMove.get(1)+") ");

                        bestArrow.add(0,arrowPosition[0]);
                        bestArrow.add(1,arrowPosition[1]);
                        //System.out.println("best arrow("+bestArrow.get(0)+", "+bestArrow.get(1)+") ");
                    }

                    graph[arrowPosition[0]][arrowPosition[1]] = 0;
                   

                }

            }

        }
        bestQueenMoveArrow.add(bestQueen);
        bestQueenMoveArrow.add(bestMove);
        bestQueenMoveArrow.add(bestArrow);
        count++;
        return bestQueenMoveArrow;
    }

}
