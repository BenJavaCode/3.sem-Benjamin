import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe  {


    State[][] gameArray;

    public TicTacToe(State[][] gameArray) {
        this.gameArray = gameArray;
    }

    public enum State{
        EMPTY,CROSS,CIRCLE;
    }

    public void initBoard(State[][] SA){

        for(int  i = 0; i < SA.length; i++){
            for (int j = 0; j<SA[i].length; j++){
                SA[i][j] = State.EMPTY;
            }
        }
    }

    public void makeMove(int player, State[][] SA) throws InputMismatchException {

        System.out.println("it is player " + player + "'s turn" + "press 1-6, you can only press empty tiles!");

        //Logic
        State currentPlayer;
        if(player == 1){
            currentPlayer = State.CIRCLE;
        }else {
            currentPlayer = State.CROSS;
        }

        boolean x = false;

        while (!x){
            Scanner scanner = new Scanner(System.in);
            Scanner scanner2 = new Scanner(System.in);

                String in = scanner.next();
                String in2 = scanner2.next();

                try {
                    int inp = Integer.parseInt(in);
                    inp --;
                    int inp2 = Integer.parseInt(in2);
                    inp2--;
                    if(inp >= 0 && inp<3 && inp2 >= 0 && inp2<3 && SA[inp][inp2] == State.EMPTY){
                        SA[inp][inp2] = currentPlayer;
                        x = true;
                    }else {
                        System.out.println("Dette træk er ikke lovligt, prøv igen :(");
                    }
                }catch (Exception idiot){
                    System.out.println("Indtast et gyldigt nmr.. prøv igen");
                }





        }

    }

    public int check(State[][] SA){

        //Horizontal
        for(int i = 0; i<SA.length; i++ ){
           if(SA[i][0]==SA[i][1] && SA[i][0] == SA[i][2] && SA[i][0] != State.EMPTY){
               if (SA[i][0] == State.CIRCLE){
                   return 2;
               }
               if (SA[i][0] == State.CROSS){
                   return 3;
               }
           }
        }

        //Vertical
        for(int i = 0; i<SA.length; i++){
            if(SA[0][i]==SA[1][i] && SA[2][i] == SA[0][i] && SA[i][0] != State.EMPTY){

                if (SA[0][i] == State.CIRCLE){
                    return 4;
                }
                if (SA[0][i] == State.CROSS){
                    return 5;
                }
            }
        }

        //Cross
        if(SA[0][0]==SA[1][1] && SA[0][0] == SA[2][2] && SA[0][0] != State.EMPTY){

            if (SA[0][0] == State.CIRCLE){
                return 6;
            }
            if (SA[0][0] == State.CROSS){
                return 7;
            }

        }else if(SA[0][2]==SA[1][1] && SA[0][2] == SA[2][0] && SA[0][2] != State.EMPTY){

            if (SA[0][2] == State.CIRCLE){
                return 6;
            }
            if (SA[0][2] == State.CROSS){
                return 7;
            }
        }

        //draw
        for(int i = 0; i < SA.length; i++){
            for(int j = 0; j<SA[i].length; j++){
                if (SA[i][j] == State.EMPTY){
                    return 1;
                }
            }
            return 8;
        }

        return 1;
    }


    public void printBoard(State[][] SA){

        for(int  i = 0; i < SA.length; i++){
            System.out.print("| ");
            for (int j = 0; j<SA[i].length; j++){


                System.out.print(SA[i][j]);
                System.out.print(" |");
            }
            System.out.println("");

        }
    }




    public static void main(String [] args){
        //init

        State[][] arr = new State[3][3];
        TicTacToe board = new TicTacToe(arr);

        Scanner scan = new Scanner(System.in);

        int player = 1;
        int play = 1;
        //game init


        String playGame = "ja";


        while (!playGame.equals("nej") ){

            board.initBoard(arr);

            if(playGame.equals("nej") ){
                play=1;
            }

            while(play==1){
                //play game
                board.printBoard(arr);


                board.makeMove(player,arr);
                play = board.check(arr);
                if(player == 1){
                    player = 2;
                }else if (player == 2){
                    player = 1;
                }

                if (play == 2){
                    System.out.println("Circle wins horizontally!");
                }
                if (play == 3){
                    System.out.println("CRoSS wins horizontally!");
                }
                if (play == 4){
                    System.out.println("Circle wins Vertically!");
                }
                if (play == 5){
                    System.out.println("CROSS wins Vertically!");
                }
                if (play == 6){
                    System.out.println("Circle wins Diagonally!");
                }
                if (play == 7){
                    System.out.println("CRoss wins Diagonally!");
                }
                if (play == 8){
                    System.out.println("Its a draaaaw :()..");
                }

            }

            System.out.println("Spil igen? tast 'nej' for at stoppe spillet.");
            playGame = scan.next();

        }

        }

}
