package Models;

import java.util.Map;
import java.util.Scanner;

public class Player {
    private String name;
    private Symbol Symbol;
    private PlayerType playerType;
//    private long id;

    public Player(String name, Symbol symbol, PlayerType playerType) {
        this.name = name;
        this.Symbol = symbol;
        this.playerType = playerType;
//        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbol getSymbol() {
        return Symbol;
    }

    public void setSymbol(Models.Symbol symbol) {
        Symbol = symbol;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Move makeMove(Board board) {
        Scanner scn = new Scanner(System.in);

        //Ask the Player to provide the index to make a move.
        System.out.println("Please tell the row index to make a move");
        int rowNumber = scn.nextInt();

        System.out.println("Please tell the col index to make a move");
        int colNumber = scn.nextInt();

        return new Move(new Cell(rowNumber, colNumber),this);


    }
}
