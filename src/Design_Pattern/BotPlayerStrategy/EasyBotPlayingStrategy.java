package Design_Pattern.BotPlayerStrategy;

import Models.*;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayingStrategy {

    @Override
    public Move makeMove(Board board) {
        for(List<Cell> row : board.getBoard()) {
            for(Cell cell: row) {
                if(cell.getCellState().equals(CellState.Empty)) {
                    return new Move(cell,new bot("bot", new Symbol('O'),PlayerType.Bot,
                            new EasyBotPlayingStrategy(),BotDifficultyLevel.Easy));
                }
            }
        }
        return null;


        //        for (int i = 0; i < board.getDimension(); i++) {
//            for (int j = 0; j < board.getDimension(); j++) {
//                Cell cell = board.getBoard().get(i).get(j);
//                if (cell.getCellState().equals(CellState.EMPTY)) {
//                    //make a move.
//                }
//            }
//        }
    }
}
