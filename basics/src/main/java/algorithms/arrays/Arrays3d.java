package algorithms.arrays;


import java.util.HashMap;
import java.util.Map;

public class Arrays3d {
    private static final String player1 = "user";
    private static final String player2 = "computer";

    //finalGameResult will temporary store the actual moved position of the two players and keep storing them.
    private Character [][] finalGameResults = new Character [3][3];

    //finalGameMap will store the game result and also board value, 0,1,2,3,4,5,6,7,8 after a player has won the BOX.
    private Map<Integer,Character[][]> finalGameMap = new HashMap<Integer,Character[][]>();

    private static boolean isGameStillAvailable = true;

    private static char [][] previousPositionPlayed = new char[3][3];

    public static String checkWinner (String line) {
        String playerWon = "";

        if (line.toLowerCase().equals("xxx")) {
            playerWon = "X";
        } else if (line.toLowerCase().equals("ooo")) {
            playerWon = "O";
        }

        return playerWon;
    }

    public static Integer[][] evaluateBox (char [][] arr2d) {
        StringBuilder line = new StringBuilder();

        return null;
    }

    //this method will return the board number to play next.
    // If Game won return X or O. If draw return null.
    // If boards still available, return the board number
    public static String evaluateGame (char [][] currentBoardPlayed) {

        // 1.0 call evaluateBox (currentBoardPlayed). This will return if the current box is won or still available

        // 1.1 if available, return next board # to play, else evaluateBox (finalGameResults) and return the next board# to play

        return null;
    }

    public static void printBoxes (char [][] arr2d1, char [][] arr2d2, char [][] arr2d3) {

        for (int i = 0; i < arr2d1.length; i++) {
            System.out.println("\n----------------------------------");
            System.out.format("%s | ",arr2d1[i][0]);
            System.out.format("%s | ",arr2d1[i][1]);
            System.out.format("%s | ",arr2d1[i][2]);

            System.out.format("%s | ",arr2d2[i][0]);
            System.out.format("%s | ",arr2d2[i][1]);
            System.out.format("%s | ",arr2d2[i][2]);

            System.out.format("%s | ",arr2d3[i][0]);
            System.out.format("%s | ",arr2d3[i][1]);
            System.out.format("%s ",arr2d3[i][2]);
        }
    }

    public static void printGame (char [][][] arr3d) {

        for (int i =0 ; i < arr3d.length; i++) {
            char [][] arr2d1,arr2d2,arr2d3;
            int val1 = i;
            int val2 = ++i;
            int val3 = ++i;
            arr2d1 = arr3d[val1];
            arr2d2 = arr3d[val2];
            arr2d3 = arr3d[val3];
            System.out.format("\n\nBoard %d\t\tBoard %d\t\tBoard %d",val1,val2,val3);
            //System.out.println("\n------------------------------------------");
            printBoxes(arr2d1,arr2d2,arr2d3);
        }
    }

    public static char [][][] createSample3dArray () {
        char [][][] arry3d = new char[9][3][3];

        //construct the game here.
        char arry1r [] = {'x','o','x'};
        char arry2r [] = {'o','x','o'};
        char arry3r [] = {'x','o','x'};

        arry3d[0][0] = arry1r;
        arry3d[0][1] = arry2r;
        arry3d[0][2] = arry3r;

        arry3d[1][0] = arry1r;
        arry3d[1][1] = arry2r;
        arry3d[1][2] = arry3r;

        arry3d[2][0] = arry1r;
        arry3d[2][1] = arry2r;
        arry3d[2][2] = arry3r;

        arry3d[3][0] = arry1r;
        arry3d[3][1] = arry2r;
        arry3d[3][2] = arry3r;

        arry3d[4][0] = arry1r;
        arry3d[4][1] = arry2r;
        arry3d[4][2] = arry3r;

        arry3d[5][0] = arry1r;
        arry3d[5][1] = arry2r;
        arry3d[5][2] = arry3r;

        arry3d[6][0] = arry1r;
        arry3d[6][1] = arry2r;
        arry3d[6][2] = arry3r;

        arry3d[7][0] = arry1r;
        arry3d[7][1] = arry2r;
        arry3d[7][2] = arry3r;

        arry3d[8][0] = arry1r;
        arry3d[8][1] = arry2r;
        arry3d[8][2] = arry3r;

        return arry3d;
    }


    public static void main(String[] args) {
        char [][][] arr3d = createSample3dArray();
        printGame(arr3d);
    }
}
