package Models;

import Design_Pattern.WinningStrategy.WinningStrategy;
import Exceptions.GameInvalidException;

import java.util.ArrayList;
import java.util.List;

public class Game {


    private Board board;
    private Player winner;
    private List<Player> players;
    private List<Move> moves;
    private GameStatus gameStatus;
    private List<WinningStrategy> winningStrategies;
    private int nextmovePlayerIndex;

    public static Builder getBuilder() {
        return new Builder();
    }

//    public void makeMove(List<Move> move) {
//    }


    //Static Inner Builder bClass
    public static class Builder {
        private int dimension;
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;


        private Builder() {
            this.players = new ArrayList<>();
            this.winningStrategies = new ArrayList<>();
            this.dimension = 0;
        }

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }


        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        public boolean validate() {
            //Validations. TODO
            //1. Only one Bot is allowed per game.
            //2. NO 2 players should have the same symbol.
            return true;
        }

        public Game Build() throws Exception {
            //check validation
            if (!validate()) {
                throw new GameInvalidException("Invalid game");
            }
            // create an game object
            return new Game(dimension, players, winningStrategies);
        }
    }

    private Game(int dimension, List<Player> players, List<WinningStrategy> winningStrategies) {
        this.moves = new ArrayList<>();
        this.board = new Board(dimension);
        this.players = players;
        this.nextmovePlayerIndex = 0;
        this.winningStrategies = winningStrategies;
        this.gameStatus = GameStatus.In_Progress;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

//    public List<WinningStrategy> getWinningStrategy() {
//        return winningStrategy;
//    }
//
//    public void setWinningStrategy(List<WinningStrategy> winningStrategy) {
//        this.winningStrategy = winningStrategy;
//    }

    public int getNextmovePlayerIndex() {
        return nextmovePlayerIndex;
    }

    public void setNextmovePlayerIndex(int nextmovePlayerIndex) {
        this.nextmovePlayerIndex = nextmovePlayerIndex;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMove() {
        return moves;
    }

    public void setMove(List<Move> move) {
        this.moves = move;
    }

    public GameStatus getWinningStatus() {
        return gameStatus;
    }

    public void setWinningStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public void printBoard() {
        board.displayBoard();
    }

    public void undo() {

    }



    public boolean validateMove(Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        return row < board.getDimension() && row > 0 && col > 0 && col < board.getDimension() &&
                board.getBoard().get(row).get(col).getCellState().equals(CellState.Empty);

//        if(row >= board.getDimension() || row <= 0 || col <= 0 || col >= board.getDimension() ||
//                !board.getBoard().get(row).get(col).getCellState().equals(CellState.Empty)) {
//            return false;
//        }
    }


//    public boolean validateMove(Move move) {
//        if (move == null || move.getCell() == null || board == null || board.getBoard() == null) {
//            return false;
//        }
//
//        int row = move.getCell().getRow();
//        int col = move.getCell().getCol();
//
//        // Check the conditions for array indices
//        if (row < 0 || row >= board.getSize() || col < 0 || col >= board.getSize() ||
//                !board.getBoard().get(row).get(col).getCellState().equals(CellState.Empty)) {
//            return false;
//        }
//
//        return true;
//    }



    public boolean checkWinner(Board board, Move move) {
        for(WinningStrategy winningStrategy: winningStrategies) {
            if(winningStrategy.checkWinner(move, board)) {
                return true;
            }
        }
        return false;
    }
    public void makeMove(Board board) {
        Player currentPlayer = players.get(nextmovePlayerIndex);
        System.out.println("It is " + currentPlayer.getName() + "'s move.");
        System.out.println("DEBUGGING");
        Move move = currentPlayer.makeMove(this.board);

        System.out.println(currentPlayer.getName() + " has made a move at Row: " + move.getCell().getRow() +
                ", col: " + move.getCell().getCol() + ".");

//         validate the move before we apply the move on boarD

        if (validateMove(move)) {
            System.out.println("Invalid Player Move" + currentPlayer.getName());
        }

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();


        Cell finalCelltomakeMove = board.getBoard().get(row).get(col);
        finalCelltomakeMove.setCellState(CellState.Filled);
        finalCelltomakeMove.setPlayer(currentPlayer);


        Move finalMove = new Move(finalCelltomakeMove, currentPlayer);
        moves.add(finalMove);

        nextmovePlayerIndex+=1;
        nextmovePlayerIndex%= players.size();

//        checking the winner

        if(checkWinner(board, move)){
            gameStatus = GameStatus.Completed;
            winner = currentPlayer;
        }

        else if(moves.size() == board.getDimension()* board.getDimension()) {
            gameStatus = GameStatus.Draw;
        }

    }

}
