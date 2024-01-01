package Design_Pattern.WinningStrategy;

import Models.Board;
import Models.Move;

public interface WinningStrategy {

    public boolean checkWinner(Move move,Board board) ;
}
