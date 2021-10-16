package ultimateTTT;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ultimateTTT.Position;
import ultimateTTT.PosScores;

public class NMove {
	
	List<Position> openPositions;
	List<PosScores> AllScores;
	
	
	Scanner scan = new Scanner(System.in);
	
	char [][][] board = new char[9][3][3]; // Array to store the 9 board values
	
	char [][] WinBoard = new char[3][3];  // Array to store winner of each board
	
     NMove() {
    	 
     }
     
     //Method to save the board winner in the WinBoard array
     
     public void recordwin ( char player,int Boardnum)
 	{
 		
 			int k = 0 ;
 			int l = 0 ;
 		
 			if  ( Boardnum < 3 )
 				 
 			  l = Boardnum  ;
 			
 			else {
 				
 				k  = Boardnum / 3;
 				l = Boardnum % 3;
 			}
 		
 			
 			if (WinBoard[k][l] == ' ')	// if is new win only	
 			   WinBoard[k][l] = player ;
 	}
 	
     
     // Method to print or display the 9 board's with current status
 	
 	public  void printGame () {
 		
 		//StringBuilder outerStringArray = new StringBuilder();
 	
 			
 			System.out.println("\n ---------WELCOME TO ULTIMATE BOARD GAME------");
 			System.out.println("");
 			System.out.println("           -------           -------           -------");
 			
 			
 		
 			
 			int index = 0 ;
 			
 			while ( index < 7)
 			{
 			
 			for(int i = 0 ; i <  3 ; i++) {
 		
 			
 				
 				for ( int j = index ; j < index+3; j++)
 				{
 					
 			     if ( i == 0) 
 					  System.out.print(" BOARD #"+ j+ "  |");
 				else
 					 System.out.print("           |");
 									
 				     for(int k=0; k< 3; k++) 				
 					   System.out.print(board[j][i][k]+ "|");
 				  }
 								
 				System.out.println(" ");
 				System.out.println("           -------           -------           -------");	
 		         
 			}
 			
 			
 			index = index + 3;
 			}		 
 			
 	}
 	
 	// Method to initialize the both arrays ( board as well as WinBoard )
 	
 	public void Boardinit(){
 		
 		  
 		  
 		  for ( int i = 0 ; i < 9 ; i++)
 			  for ( int j = 0 ; j < 3 ; j++)
 				  for ( int k = 0 ; k < 3 ; k++)
 					  board[i][j][k] = ' ';	
 		
 		 for ( int i = 0 ; i < 3 ; i++)
			  for ( int j = 0 ; j < 3 ; j++)
				  WinBoard[i][j] = ' ';
 		
 	}
 	
 	
 	// Method to return Row and Column based the position played
 	
 	public Position findrowcol(int postion)
 	{
 		int Row = 0, Col= 0 ;
 		
 		if (postion < 3)
			Col = postion ;
		else {
			Row = postion / 3;
		    Col = postion % 3;
		    }		
 		return new Position(Row, Col);
 	}
 	
 	
 	// Method to check if the individual board is won
 	
 	 public char chkboardwin(int boardnum) {
 		 
 		 char winner = ' ';
 		 
 		 
 		 // check diagnal winner
    	 
     	 if (( 
     			 (board[boardnum][0][0] == board[boardnum][1][1]) && 
     			 (board[boardnum][0][0] == board[boardnum][2][2])
     		  && (board[boardnum][1][1] == board[boardnum][2][2] )) 
   				|| ((board[boardnum][0][2] == board[boardnum][1][1])
   				&& (board[boardnum][0][2] == board[boardnum][2][0])
   				&& (board[boardnum][1][1] == board[boardnum][2][0]))) {
   			
   			    return board[boardnum][1][1];
   			    
   		}
     	 
     	 // Check if the board is won by row or column
   		for (int i = 0; i < 3; i++) {
   			if (
   					(board[boardnum][i][0] == board[boardnum][i][1]) &&  
   					(board[boardnum][i][0] == board[boardnum][i][2] )
   					  && ( board[boardnum][i][1] == board[boardnum][i][2] ))
   					{
   					    return  board[boardnum][i][0] ;
   					}
   					
   					if ( (board[boardnum][0][i] == board[boardnum][1][i]) && 
   					(board[boardnum][0][i] == board[boardnum][2][i]) && 
   					(board[boardnum][1][i] == board[boardnum][2][i] )) 
   			        {
				    return board[boardnum][0][i] ;
				    }
				
   		}
   		
   		
   		return winner;
   	}
 	
 	 
 	 // Mothod to Check if the Game Over and display the result message
 	
     public Boolean GameOver() {
 	
 	    // Check who is the winner based on diagnal values
  		if ( ( (WinBoard[0][0] == WinBoard[1][1]) &&  (WinBoard[0][0] == WinBoard[2][2]) & (WinBoard[1][1] == WinBoard[2][2])  && WinBoard[0][0] != ' ' )
  				|| ( (WinBoard[0][2] == WinBoard[1][1]) &&  (WinBoard[0][2] == WinBoard[2][0]) && (WinBoard[2][0] == WinBoard[1][1] ) && WinBoard[1][1] != ' '))
  		{
  			 if ( WinBoard[0][0] == 'O' || WinBoard[2][0] == 'O') {
  				System.out.println("") ;
  				 System.out.println(" You LOST the game !!!") ;
  			 }
  			 else if ( WinBoard[0][0] == 'X') {
  				System.out.println("") ;
  				 System.out.println(" You WON the game !!!") ;
  			 }
  			return true;
  		}
  		
  		// Check who is the winner based on rows or columns
  		for (int i = 0; i < 3; i++) {
  			if (  ( (WinBoard[i][0] == WinBoard[i][1]) && (WinBoard[i][0] == WinBoard[i][2] )
  					&& (WinBoard[i][1] == WinBoard[i][2] ) &&  WinBoard[i][0] != ' ')
  				||  ( (WinBoard[0][i] == WinBoard[1][i]) && (WinBoard[0][i] == WinBoard[2][i]) && 
  						WinBoard[1][i] == WinBoard[2][i]  )  && WinBoard[0][i] != ' ') {
  				
  				
  				if ( WinBoard[i][0] == 'O' || WinBoard[0][i] == 'O')
  				{
  					System.out.println("") ;
  	 				 System.out.println(" You LOST the game !!!") ;
  				}
  	 			 else
  	 			 {
  	 				System.out.println("") ;
  	 				 System.out.println(" You WON the game !!!") ;
  	 			 }
  				return true;
  			}
  		}
  		
  		// check if the Game is over without a winner
  		 int flag = 0 ;
  		for ( int i = 0 ; i < 3; i++) {
  			for ( int j = 0 ; j < 3; j++) {
  				if (WinBoard[i][j] == ' ' )
  					flag = 1 ;
  			}
  			}
  		
  		   if (flag == 0 ) {
  			  System.out.println("") ;
  			  System.out.println(" IT'S A TIE, Thank you for playing  !!!") ;	 
  			  return true ;
  		   }
  		 
  		
  		return false;
  	}

     
//  Method to Check if the board is ever played?
 
 public boolean checkNewBoard( int Boardnum ) {
		
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 3; ++j) {
				if (board[Boardnum][i][j] !=  ' ') {
					return false;
				}
			}
		}
		return true;
	}
 

     
    // Method to check if the Player win - used by minmax
 
     public boolean isPlayerWin(int boardnum) {
    	 
    	 
    	 if ((
    			 (board[boardnum][0][0] == board[boardnum][1][1]) 
    		  && (board[boardnum][0][0] == board[boardnum][2][2])
    		 // && (board[boardnum][1][1] == board[boardnum][2][2]) 
    		  &&  board[boardnum][0][0] == 'O') 
  				
    			 || ( (board[boardnum][0][2] == board[boardnum][1][1])
  				   && (board[boardnum][0][2] == board[boardnum][2][0])
  				//&& (board[boardnum][1][1] == board[boardnum][2][0]) 
    			&& board[boardnum][0][2] == 'O' )) {
  			//System.out.println("X Diagonal Win");
  			return true;
  		}
  		for (int i = 0; i < 3; i++) {
  			if ((
  					(board[boardnum][i][0] == board[boardnum][i][1]) &&  
  					(board[boardnum][i][0] == board[boardnum][i][2] )
  					//  && ( board[boardnum][i][1] == board[boardnum][i][2] )
  					&& board[boardnum][i][0] == 'O' )
  					|| ( (board[boardnum][0][i] == board[boardnum][1][i]) && 
  					(board[boardnum][0][i] == board[boardnum][2][i]) 
  					// &&(board[boardnum][1][i] == board[boardnum][2][i] )
  							&& board[boardnum][0][i] == 'O') )
  			{
  				//System.out.println("X Row or Column win");
  				return true;
  			}
  		}
  		return false;
  	}
     
     
  // Method to check if the computer win - used by the minmax
     
     public boolean isComputerW1n(int boardnum) {
    	 
    	 if ((
    			 (board[boardnum][0][0] == board[boardnum][1][1]) && 
    			 (board[boardnum][0][0] == board[boardnum][2][2])
    		//  && (board[boardnum][1][1] == board[boardnum][2][2] )
    		  &&  board[boardnum][0][0] == 'X') 
  				|| ((board[boardnum][0][2] == board[boardnum][1][1])
  				&& (board[boardnum][0][2] == board[boardnum][2][0])
  				//&& (board[boardnum][1][1] == board[boardnum][2][0]) 
  				&& board[boardnum][0][2] == 'X' )) {
  			//System.out.println("X Diagonal Win");
  			return true;
  		}
  		for (int i = 0; i < 3; i++) {
  			if ((
  					(board[boardnum][i][0] == board[boardnum][i][1]) &&  
  					(board[boardnum][i][0] == board[boardnum][i][2] )
  					 // && ( board[boardnum][i][1] == board[boardnum][i][2] )
  					&& board[boardnum][i][0] == 'X' )
  					|| ( (board[boardnum][0][i] == board[boardnum][1][i]) && 
  					(board[boardnum][0][i] == board[boardnum][2][i])  
  					// && (board[boardnum][1][i] == board[boardnum][2][i] )
  							&& board[boardnum][0][i] == 'X') )
  			{
  				//System.out.println("X Row or Column win");
  				return true;
  			}
  		
  		
 		}
 		return false;
  	}
 
     
     // Method to populate all the available positions in the board into a List
     
     public List<Position> availbePostion( int Boardnum ) {
 		openPositions = new ArrayList<>();
 		for (int i = 0; i < 3; ++i) {
 			for (int j = 0; j < 3; ++j) {
 				if (board[Boardnum][i][j] ==  ' ') {
 					openPositions.add(new Position(i, j));
 				}
 			}
 		}
 		return openPositions;
 	}
 	
 	
     
 	
     // Method to save the postion in the array
     
     public void recordPlay(Position position, char player, int Boardnum) {
    	 board[Boardnum][position.Row][position.Col] = player;
     }
	
     // Method the return the best move
     
     
     public Position BestMove() {
 		int MAX = -100000;
 		int best = -1;

 		
 		for (int i = 0; i < AllScores.size(); ++i) {

 			if (MAX < AllScores.get(i).score) {
 				MAX = AllScores.get(i).score;
 				best = i;
 			}
 		}
 		//System.out.println("Best - "+rootsChildrenScores.get(best).point);

 		return AllScores.get(best).position;
 	}
	
     
	
	public int MaxRet(List<Integer> score) {
		int max = -1000000;
		int index = -1;
		for (int i = 0; i <score.size(); ++i) {
				
			if (score.get(i) > max) {
				max = score.get(i);
				index = i;
			}
		}
		return score.get(index);
	}
	
	
	
	public int MinRet(List<Integer> score) {
		int min = 10000000;
		int index = -1;
		for (int i = 0; i < score.size(); ++i) {
			
			if (score.get(i) < min) {		
				
				min = score.get(i);
				index = i;
				
			}
		}
		return score.get(index);
	}
	
	
	
	

	// Method that call from the boardgame invoke minmax

	public void callAI(int depth, int turn, int Boardnum){
		
			
		AllScores = new ArrayList<>();	
		minimax(depth, turn, Boardnum);
	
	}
	
	
	
	// Method to populate all the position wins for player and computer

	public int minimax(int depth, int turn,  int Boardnum) {
		
		
		Position pnt = findrowcol(Boardnum);
		
		//System.out.println( "B"+Boardnum+ " " + pnt.Row+ " "+pnt.Col);
		
		if (WinBoard[pnt.Row][pnt.Col] == ' '){
			
			 if (isComputerW1n(Boardnum)) {
					
					return -1;}
			
			
		     if (isPlayerWin(Boardnum)) 
			      return +1;
		}
		
		     
		List<Position> availablePos = availbePostion( Boardnum);
	
		if (availablePos.isEmpty()) 
			return 0;

		List<Integer> scores  = new ArrayList<>();
		
		for (int i = 0; i < availablePos.size(); ++i) {
			Position position = availablePos.get(i);

			if (turn == 1) { // O's turn select the highest from below minimax() call
				
				
				recordPlay(position, 'O',Boardnum);
				
				int currentScore = minimax(depth + 1, 2, Boardnum);
				
				scores.add(currentScore);

				if (depth == 0)
					AllScores.add(new PosScores(currentScore, position));
				
			}
			else if ( turn == 2)
			{
				
				recordPlay(position, 'X',Boardnum);
				
				scores.add(minimax(depth + 1 , 1, Boardnum));
				
			}
			board[Boardnum][position.Row][position.Col] = ' '; //Reset this point
		}
	
		
		return  turn == 1 ? MaxRet(scores) : 
			MinRet(scores) ;
	}


}
