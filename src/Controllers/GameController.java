package Controllers;

import Design_Pattern.WinningStrategy.WinningStrategy;
import Models.Board;
import Models.GameStatus;
import Models.Player;
import Models.Game;

import java.util.List;

public class GameController {

//    public Game Startgame(int Boarddimension List<Player> player,
//                          List<WinningStrategy> winningStrategy){
//        return Game.getBuilder().setBoardDimension(Boarddimension)
//                .setPlayers(player)
//                .setWinningStrategy(winningStrategy)
//                .Build();
//    }

    public Game startGame(int boardDimension, List<Player> players,
                          List<WinningStrategy> winningStrategies) throws Exception {
        return Game.getBuilder()
                .setDimension(boardDimension)
                .setPlayers(players)
                .setWinningStrategies(winningStrategies)
                .Build();
    }



    public void makeMove(Game game) {
        game.makeMove(game.getBoard());
    }
    public void displayBoard(Game game) {
        game.printBoard();
    }

    public  Player getWinner(Game game) {
        return game.getWinner();
    }

    public void GetUndo(Game game) {
        game.undo();
    }

    public GameStatus getGameStatus(Game game) {
        return game.getGameStatus();
    }



}
