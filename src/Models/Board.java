package Models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int dimension;
    private List<List<Cell>> board;

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }

    public Board(int n) {
        this.dimension = n;
        board = new ArrayList<>(); // rows

        for(int i=0;i<n;i++) {
            board.add(new ArrayList<>()); // cols
            for(int j=0;j<n;j++) {
                board.get(i).add(new Cell(i,j));
            }
        }
    }

//    public void displayBoard() {
//        for(int i=0;i<dimension;i++) {
//            for(int j=0;j<dimension;j++) {
//                Cell cell = board.get(i).get(j);
//
//                if(cell.getCellState().equals(CellState.Empty)) {
//                    System.out.println("| |");
//                }
//                else {
//                    System.out.println("| " + cell.getPlayer().getSymbol().getSymbol() + " ");
//                }
//            }
//            System.out.println();
//        }
//    }



    public void displayBoard() {
        for(int i = 0; i < dimension; i++) {
            for(int j = 0; j < dimension; j++) {
                Cell cell = board.get(i).get(j);

                // Add a null check for cell.getCellState()
//                if (cell.getCellState() == null) {
//                    System.out.println(" ");
//                } else

             if (cell.getCellState().equals(CellState.Empty)) {
                    System.out.print(" <  > ");
                } else {
                    System.out.print(" <" + cell.getPlayer().getSymbol().getSymbol() + "> ");
                }
            }
            System.out.println();
        }
    }



}
