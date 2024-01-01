package Design_Pattern.WinningStrategy;

import Models.Board;
import Models.Move;
import Models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class colWinningStrategy implements WinningStrategy{
    private Map<Integer, Map<Symbol, Integer>> colMaps = new HashMap<>();
    @Override
    public boolean checkWinner(Move move, Board board) {

        int col = move.getCell().getCol();
        Symbol symbol = move.getPlayer().getSymbol();

        if(!colMaps.containsKey(col)) {
            colMaps.put(col, new HashMap<>());
        }

        Map<Symbol,Integer> currentColMap = colMaps.get(col);
        if(currentColMap.containsKey(symbol)) {
            currentColMap.put(symbol,currentColMap.get(symbol)+1);
        }
        else {
            currentColMap.put(symbol, 1);
        }


        return (currentColMap.get(symbol) == board.getDimension());
    }
}
