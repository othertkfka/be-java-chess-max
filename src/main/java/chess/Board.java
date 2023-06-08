package chess;

import java.util.ArrayList;

import static pieces.Piece.Color;
import static pieces.Piece.Type;
import static utils.StringUtils.appendNewLine;

public class Board {
    private ArrayList<Rank> board = new ArrayList<>(8);

    public void initialize() {
        board.add(Rank.createFirstRank(Color.BLACK));
        board.add(Rank.createPawnRank(Color.BLACK));
        for(int i=0; i<4; i++) {
            board.add(Rank.createBlankRank());
        }
        board.add(Rank.createPawnRank(Color.WHITE));
        board.add(Rank.createFirstRank(Color.WHITE));
    }

    public int pieceCount() {
        int count = 0;
        for(Rank rank : board) {
            count += rank.getPieceCount();
        }
        return count;
    }

    public int pieceCount(Color color, Type type) {
        int count = 0;
        for(Rank rank : board) {
            count += rank.getPieceCount(color, type);
        }
        return count;
    }

    public String showBoard() {
        StringBuilder sb = new StringBuilder();
        for(Rank rank : board) {
            sb.append(appendNewLine(rank.getRankString()));
        }
        return sb.toString();
    }
}
