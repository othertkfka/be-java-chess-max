package chess;

import pieces.Piece;

import java.util.ArrayList;

import static pieces.Piece.Color;
import static pieces.Piece.Type;
import static utils.StringUtils.appendNewLine;

public class Board {
    private static final int MAX_LENGTH = 8;

    private final ArrayList<Rank> board = new ArrayList<>(MAX_LENGTH);

    public void initialize() {
        board.add(Rank.createFirstRank(Color.WHITE));
        board.add(Rank.createPawnRank(Color.WHITE));
        for(int i=0; i<4; i++) {
            board.add(Rank.createBlankRank());
        }
        board.add(Rank.createPawnRank(Color.BLACK));
        board.add(Rank.createFirstRank(Color.BLACK));
    }

    public void initializeEmpty() {
        for(int i=0; i<MAX_LENGTH; i++) {
            board.add(Rank.createBlankRank());
        }
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
        for(int i=MAX_LENGTH-1; i>=0; i--) {
            sb.append(appendNewLine(board.get(i).getRankString()));
        }
        return sb.toString();
    }

    public Piece findPiece(String position) {
        int x = position.charAt(0) - 'a';
        int y = Character.getNumericValue(position.charAt(1)) - 1;
        return board.get(y).getPiece(x);
    }

    public void move(String position, Piece piece) {
        int x = position.charAt(0) - 'a';
        int y = Character.getNumericValue(position.charAt(1)) - 1;
        board.get(y).addPiece(x, piece);
    }
}
