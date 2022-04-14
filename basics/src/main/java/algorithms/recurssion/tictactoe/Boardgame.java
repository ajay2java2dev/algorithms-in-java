 package ultimateTTT;

 import java.util.Random;
 import java.util.Scanner;

public class Boardgame 
{
		
	public static void main(String[] args) 
	{
		NMove nMove = new NMove();
			
		int Boardnum = -1;
		Random rand = new Random();
		
		char CurPlayer=' ';
		
		int playerPos = 0;
		
		char winner = ' ';
		
		     nMove.Boardinit();// Initialize the arrays to store Board and winning board
		     
			 nMove.printGame(); //Display the Board
			 
			 Scanner input = new Scanner(System.in);
			 
			 
			 // Decide who should play first. Validate if the user entered the correct options
			
			 while (CurPlayer==' ') 
			 {
			 System.out.println("Who is playing first? (X - Player or O - Computer): ");
			 
			 CurPlayer = input.next().charAt(0);
			 
				 if ( CurPlayer != 'X' && CurPlayer !='O')
				 {
					 System.out.println("Wrong Player option..Please enter X - Player or O - Computer)");
					 CurPlayer = ' ' ;
				 }
	         }
			 
			// if computer playing first find then position at random
			 
			 if(CurPlayer == 'O') 
			 {
				// Random rand = new Random();
				 Boardnum = rand.nextInt(9); // find the board number using random
				 playerPos= rand.nextInt(9); // find the position using random
				 
				 // call the method to initialize the array with the position selected
				 
				 Position pnt = nMove.findrowcol(playerPos);
				 
				 nMove.recordPlay(pnt,CurPlayer, Boardnum); 
				 
				// nMove.PlayerPosition(playerPos,CurPlayer,Boardnum);
				 nMove.printGame();
				 System.out.println("Computer Played..in Board # "+Boardnum+ " Position # "+playerPos);
				 
				 Boardnum = playerPos ;// Player have to play in the board based on which position
				                       // the Computer played.
				 
				 CurPlayer = 'X'; //Change the Player 
				 
			 }
			 
			while( !nMove.GameOver())  // Play till someone win 9 board or tie.
			{
					
		  
			   // If Player plays first or when the Board is full, select the Board and position you want play	
				while ( Boardnum == -1 || nMove.availbePostion(Boardnum).isEmpty())	
				{
				System.out.println("Select Board number: ");
				
				Boardnum = input.nextInt();
				
				
				  if(Boardnum < 0 || Boardnum > 8) 
				  {
					System.out.println("You entered an invalid board number!");
					System.out.println("Please enter between 0 and 8.");
					Boardnum = -1;
				   }
				}
				
			
			
			// Select the postion  for board selected
			
				playerPos = -1 ;
				
				
			
			while(playerPos == -1  )
				
			{
					  
			    System.out.println("Your turn in board # "+Boardnum+"...Select position number 0-8");
			    playerPos = input.nextInt();
			 
				  if(playerPos < 0 || playerPos > 8) 
				  {
					System.out.println("You entered an invalid position!");
					System.out.println("Please enter between 0 and 8.");
					playerPos = -1 ;
				  }
				  else 
				  {
					    // Get the Row and Col
					  Position pnt = nMove.findrowcol(playerPos);
					     
					     // check if the position already played or not. If not played before then save the position in the array
						 // and re-display the board  to reflect the array 	 
						 if ( nMove.board[Boardnum][pnt.Row][pnt.Col] == ' ') {
							 nMove.recordPlay(pnt,CurPlayer, Boardnum); 
						     nMove.printGame();
						 }
						 else
						 {
							   System.out.println("That position is already played.. Please select an empty one");
					 		   playerPos = -1 ;
					      }	
							 
				
			        }
			 }
			
			
			// Check if the Board is won by Player
			
			
			 winner = nMove.chkboardwin(Boardnum) ;
			
			if ( winner != ' '){ 
			    nMove.recordwin ( winner,Boardnum); // Mark the WinBoard array
			}
			
			if (nMove.GameOver()) // if the GamOver exit the program with appropriate message
				break ;
			
			 CurPlayer = 'O'; // change the player to Computer
			  
				
				
		    	// Forcing the Computer to play the board based on your position
				
              Boardnum = playerPos; 
			  
			   // if the Board is already full,  then let the computer select a new board			  
				  
			  while (nMove.availbePostion(Boardnum).isEmpty()) { 
				  System.out.println("The Board # "+Boardnum+" was full... Computer selecting a new board ");
				  Boardnum = rand.nextInt(9);  
			  
			  }
			  
			 
			  
			  // If the board has never played by both player and computer, let the computer select the random position
			  // reather than always playing the position 0.
			  
			  if (nMove.checkNewBoard(Boardnum)) 
			  {
				  
				  
				  playerPos= rand.nextInt(9); // find the position using random
					 
					 // call the method to initialize the array with the position selected
				  
				  Position pnt = nMove.findrowcol(playerPos);
					 
				  nMove.recordPlay(pnt,CurPlayer, Boardnum); 
					 
					 
					 nMove.printGame();
					 System.out.println("Computer Played..in Board # "+Boardnum+ " Position # "+playerPos);
					 
	                 Boardnum = playerPos ;// Player have to play in the board based on which position
					                       // the Computer played.
					 
					 CurPlayer = 'X' ; // change the player 
					 
						// Check if the Board assigned is full? if yes, then display message
						
						if(nMove.availbePostion(Boardnum).isEmpty()) 
							System.out.println("Board is Full!  YOU CAN CHOOSE AY BOARD TO PLAY!!!");
						
						
					    continue; // computer finished playing , let the Player plays now.
				  
			  }
			  
			  
			  
			  // Call the AI/MinMax to find the best move for computer 
			 
			   nMove.callAI(0,1,Boardnum); 
			  
			   Position pnt = nMove.BestMove(); // Return the best move
			    
			   nMove.recordPlay(pnt,CurPlayer, Boardnum); // save the row column in the array
			   
			   winner = nMove.chkboardwin(Boardnum) ;  // check for winner
			   
				
				if ( winner != ' '){ // if the Board is won by Player
					
				    nMove.recordwin ( winner,Boardnum); // Mark the WinBoard array
				  
				}
			   
			   // Display the best postion aavailable
				
			   for (PosScores pas : nMove.AllScores) 
					System.out.println("Position: " + pas.position + " Score: " + pas.score);
			  
				 
				nMove.printGame(); // Re-display the board with the latest play information
				
				
				// Find the Board to play for the Player
				
				int new_board = 0 ;
				
				if (pnt.Row == 0)
				new_board = pnt.Col;
				
				else if ( pnt.Row == 1 )
				new_board = pnt.Row+ pnt.Col+ 2;
				else
					new_board = pnt.Row+pnt.Col+4;
			
				
				System.out.println("Computer Played..in Board # "+Boardnum+ " Position # "+new_board);
			
				
               Boardnum = new_board; // Assign the board to play for the player
				
			  
				
				// Check if the Board assigned is full? if yes, then display message
				
				if(nMove.availbePostion(Boardnum).isEmpty()) 
					System.out.println("Board is Full!  YOU CAN CHOOSE AY BOARD TO PLAY!!!");
				
				CurPlayer = 'X' ;
            }
				
			
			
		}	
	
}
	