package ubc.cosc322;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import sfs2x.client.entities.Room;
import ygraph.ai.smartfox.games.Amazon;
import ygraph.ai.smartfox.games.BaseGameGUI;
import ygraph.ai.smartfox.games.GameClient;
import ygraph.ai.smartfox.games.GamePlayer;
import ygraph.ai.smartfox.games.amazons.AmazonsGameMessage;
import ygraph.ai.smartfox.games.amazons.HumanPlayer;

/**
 * An example illustrating how to implement a GamePlayer
 * 
 * @author Yong Gao (yong.gao@ubc.ca) Jan 5, 2021
 *
 */
public class COSC322Test extends GamePlayer {

	private GameClient gameClient = null;
	private BaseGameGUI gamegui = null;

	private String userName = null;
	private String passwd = null;
	
	private MinMax minMax = new MinMax();

	private int[][] board = {{0,0,0,2,0,0,2,0,0,0},
							{0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,0,0},
							{2,0,0,0,0,0,0,0,0,2},
							{0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,0,0},
							{1,0,0,0,0,0,0,0,0,1},
							{0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,0,0},
							{0,0,0,1,0,0,1,0,0,0},};

	private int type;  // 1 black, 2 white
	/**
	 * The main method
	 * 
	 * @param args for name and passwd (current, any string would work)
	 */
	public static void main(String[] args) {
		COSC322Test player = new COSC322Test("12311111", "456");
		// HumanPlayer player = new HumanPlayer();
		if (player.getGameGUI() == null) {
			player.Go();

		} else {
			BaseGameGUI.sys_setup();
			java.awt.EventQueue.invokeLater(new Runnable() {
				public void run() {
					player.Go();
				}
			});
		}

	}

	/**
	 * Any name and passwd
	 * 
	 * @param userName
	 * @param passwd
	 */
	public COSC322Test(String userName, String passwd) {
		this.userName = userName;
		this.passwd = passwd;
		this.gamegui = new BaseGameGUI(this);
		// To make a GUI-based player, create an instance of BaseGameGUI
		// and implement the method getGameGUI() accordingly

	}

	@Override
	public void onLogin() {
		userName = gameClient.getUserName();
		if (gamegui != null) {
			gamegui.setRoomInformation(gameClient.getRoomList());

		}
	}

	@Override
    public boolean handleGameMessage(String messageType, Map<String, Object> msgDetails) {
    	//This method will be called by the GameClient when it receives a game-related message
    	//from the server.
	
    	//For a detailed description of the message types and format, 
    	//see the method GamePlayer.handleGameMessage() in the game-client-api document. 
    	//System.out.println("1321!!!!!!!"+AmazonsGameMessage.GAME_STATE_BOARD);
    	//System.out.println("??!!!!!!!"+msgDetails.get(AmazonsGameMessage.GAME_STATE));
    	
    	if (messageType.equals(AmazonsGameMessage.GAME_STATE_BOARD)) {
	    	
	    	System.out.println("Message Type: "+messageType+"\nDetail: "+msgDetails.get(AmazonsGameMessage.GAME_STATE));
	    	gamegui.setGameState((ArrayList<Integer>)msgDetails.get(AmazonsGameMessage.GAME_STATE));
		}

		if(messageType.equals(AmazonsGameMessage.GAME_ACTION_START)){
			System.out.println("Message Type: "+messageType
	    				+"\nGame State: "+msgDetails.get(AmazonsGameMessage.GAME_STATE)
	    				+"\nBlack ID: "+msgDetails.get(AmazonsGameMessage.PLAYER_BLACK)
	    				+"\nWhite ID: "+msgDetails.get(AmazonsGameMessage.PLAYER_WHITE));
	    		
	    		//---------Check if the first player
	    	if(userName.equals(msgDetails.get(AmazonsGameMessage.PLAYER_BLACK))) {
	    		System.out.println("I'm the black player");
	    		type=2;
	    		move(board, type);
	    			
	    	}else {
	    		System.out.println("I'm the white player");
	    		type=1;
	    		}
		}
	    	
	    if(messageType.equals(AmazonsGameMessage.GAME_ACTION_MOVE)){
			System.out.println("Message Type: "+messageType +" \nopponent:"
	    				+"\nCurrent Position: "+msgDetails.get(AmazonsGameMessage.QUEEN_POS_CURR)
	    				+"\nNew Position: "+msgDetails.get(AmazonsGameMessage.QUEEN_POS_NEXT)
	    				+"\nArrow Position: "+msgDetails.get(AmazonsGameMessage.ARROW_POS));
	    	
			ArrayList<Integer> qPostion=(ArrayList<Integer>)msgDetails.get(AmazonsGameMessage.QUEEN_POS_CURR);
	    	ArrayList<Integer> qNewPostion=(ArrayList<Integer>)msgDetails.get(AmazonsGameMessage.QUEEN_POS_NEXT);
	    	ArrayList<Integer> qArrow=(ArrayList<Integer>)msgDetails.get(AmazonsGameMessage.ARROW_POS);
			gamegui.updateGameState(qPostion,qNewPostion,qArrow);
			System.out.println("Star Run---------------------------------------------");
			long startTime=System.currentTimeMillis();
			
			updateBoard(qPostion, qNewPostion, qArrow);
			move(board, type);

			
			
			long endTime=System.currentTimeMillis();
        	System.out.println("Run time: "+(endTime-startTime)+"ms-----------------------------------------------");
		
			
			
			
			
				
	    		/* if(queen_Key.equals("black")) {
	    			updateInfo(queen_pos_curr,queen_pos_next,arrow_pos,"white");//the Opposite player is white
	    		}else {
	    			updateInfo(queen_pos_curr,queen_pos_next,arrow_pos,"black");//the Opposite player is black
	    		} */
	    		
				
			
		}		
	    		

	return true;

	}

	@Override
    public String userName() {
    	return userName;
    }

	@Override
	public GameClient getGameClient() {
		// TODO Auto-generated method stub
		return this.gameClient;
	}

	@Override
	public BaseGameGUI getGameGUI() {
		// TODO Auto-generated method stub
		return this.gamegui;
	}

	@Override
	public void connect() {
		// TODO Auto-generated method stub
		gameClient = new GameClient(userName, passwd, this);
	}



	public void move(int[][] b, int type) {


		System.out.println("Move method satr-------------------------"); 
		long startTime=System.currentTimeMillis();
		
		ArrayList<ArrayList<Integer>> bestQueenMoveArrow = minMax.findBestMove(b, type);

		
		
		
		ArrayList <Integer>qPostion = new ArrayList<>();
		ArrayList <Integer>qNewPostion = new ArrayList<>();
		ArrayList <Integer>qArrow = new ArrayList<>();

		qPostion.add(10-bestQueenMoveArrow.get(0).get(0));
		qPostion.add(bestQueenMoveArrow.get(0).get(1)+1);
		
		

		qNewPostion.add(10-bestQueenMoveArrow.get(1).get(0));
		qNewPostion.add(bestQueenMoveArrow.get(1).get(1)+1);

		qArrow.add(10-bestQueenMoveArrow.get(2).get(0));
		qArrow.add(bestQueenMoveArrow.get(2).get(1)+1);

		

		getGameClient().sendMoveMessage(qPostion, qNewPostion, qArrow);
		getGameGUI().updateGameState(qPostion, qNewPostion, qArrow);
		
		updateBoard(qPostion, qNewPostion, qArrow);

		

		long endTime=System.currentTimeMillis();
        System.out.println("Move time: "+(endTime-startTime)+"ms --------------------------------"); 

		
	}

	public void updateBoard(ArrayList<Integer> qPostion,ArrayList<Integer> qNewPostion,ArrayList<Integer> qArrow){// client postion
	
		
		
		int type = board[10 - qPostion.get(0)][qPostion.get(1)-1]; 
		
		if(type == 1){
			board[10 - qPostion.get(0)][qPostion.get(1)-1]= 0;
			board[10 - qNewPostion.get(0)][qNewPostion.get(1)-1] = 1;
			board[10 - qArrow.get(0)][qArrow.get(1)-1] = -1;
		}
		else{
			board[10 - qPostion.get(0)][qPostion.get(1)-1]= 0;
			board[10 - qNewPostion.get(0)][qNewPostion.get(1)-1] = 2;
			board[10 - qArrow.get(0)][qArrow.get(1)-1] = -1;
		}

		printBoard();
		
	}
	public void printBoard(){
		
		
	
		for(int i =0; i < 10;i++){ // make all spot to 0
			for(int j=0; j<10;j++){
				System.out.print(board[i][j]+", ");
			}
			System.out.print("\n");
		}
	}

}// end of class