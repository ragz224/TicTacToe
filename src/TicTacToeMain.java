import Controllers.GameController;
import Design_Pattern.BotPlayerStrategy.BotPlayingStrategy;
import Design_Pattern.BotPlayerStrategy.EasyBotPlayingStrategy;
import Design_Pattern.WinningStrategy.WinningStrategy;
import Design_Pattern.WinningStrategy.colWinningStrategy;
import Design_Pattern.WinningStrategy.diagonalWinningStrategy;
import Design_Pattern.WinningStrategy.rowWinningStrategy;
import Models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeMain {
    public static void main(String[] args) throws Exception {

        GameController gameController = new GameController();
        Scanner scn = new Scanner(System.in);
//        System.out.println("Enter the dimension you want");
//        int n =scn.nextInt();
        int dimension =3;
        int noOfplayers = dimension-1;
        List<Player> players = new ArrayList<>();
        players.add(new Player("Raghu", new Symbol('x'), PlayerType.Human));
//        players.add(new Player("bot", new Symbol('0'), PlayerType.Bot));
        players.add(new bot("bot",new Symbol('O'),PlayerType.Bot,
                new EasyBotPlayingStrategy(),BotDifficultyLevel.Easy));

        List<WinningStrategy> winningStrategies = new ArrayList<>();
        winningStrategies.add(new rowWinningStrategy());
        winningStrategies.add(new colWinningStrategy());
        winningStrategies.add(new diagonalWinningStrategy());

//         start the game

        Game game = gameController.startGame(dimension,players,winningStrategies);

//      start playing the game

        while(gameController.getGameStatus(game).equals(GameStatus.In_Progress)) {
            //Display the board.
            System.out.println("This is the current state of Board");
           gameController.displayBoard(game);

            //Do you want to UNDO ? If yes, call the UNDO functionality else call the makeMove.

            gameController.makeMove(game);
        }

        if(gameController.getGameStatus(game).equals(GameStatus.Completed)) {
            System.out.println("winner is "+ gameController.getWinner(game).getName());
        }
        else {
            System.out.println("game has drawn");
        }


    }
}