package chess;

import java.util.ArrayList;

import static pieces.Piece.Color;
import static utils.StringUtils.appendNewLine;

public class Board {
    private ArrayList<Rank> board = new ArrayList<>(8);

    public void initialize() {
        Rank blackFirstRank = new Rank();
        Rank whiteFirstRank = new Rank();
        blackFirstRank.createFirstRank(Color.BLACK);
        whiteFirstRank.createFirstRank(Color.WHITE);

        Rank blackPawnRank = new Rank();
        Rank whitePawnRank = new Rank();
        blackPawnRank.createPawnRank(Color.BLACK);
        whitePawnRank.createPawnRank(Color.WHITE);

        board.add(blackFirstRank);
        board.add(blackPawnRank);
        for(int i=0; i<4; i++) {
            Rank blankRank = new Rank();
            blankRank.createBlankRank();
            board.add(blankRank);
        }
        board.add(whitePawnRank);
        board.add(whiteFirstRank);
    }

    public int pieceCount() {
        int count = 0;
        for(Rank rank : board) {
            count += rank.getPieceCount();
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
