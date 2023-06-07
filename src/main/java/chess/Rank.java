package chess;

import pieces.Piece;
import pieces.Piece.Color;
import pieces.Piece.Type;

import java.util.ArrayList;

public class Rank {
    private ArrayList<Piece> rank;

    public Rank() {
        rank = new ArrayList<>();
    }

    public void createFirstRank(Color color) {
        if(color.equals(Color.BLACK)) {
            rank.add(Piece.createBlackRook());
            rank.add(Piece.createBlackKnight());
            rank.add(Piece.createBlackBishop());
            rank.add(Piece.createBlackQueen());
            rank.add(Piece.createBlackKing());
            rank.add(Piece.createBlackBishop());
            rank.add(Piece.createBlackKnight());
            rank.add(Piece.createBlackRook());
        } else {
            rank.add(Piece.createWhiteRook());
            rank.add(Piece.createWhiteKnight());
            rank.add(Piece.createWhiteBishop());
            rank.add(Piece.createWhiteQueen());
            rank.add(Piece.createWhiteKing());
            rank.add(Piece.createWhiteBishop());
            rank.add(Piece.createWhiteKnight());
            rank.add(Piece.createWhiteRook());
        }
    }

    public void createPawnRank(Color color) {
        if(color.equals(Color.BLACK)) {
            for(int i=0; i<8; i++) {
                rank.add(Piece.createBlackPawn());
            }
        } else {
            for(int i=0; i<8; i++) {
                rank.add(Piece.createWhitePawn());
            }
        }
    }

    public void createBlankRank() {
        for(int i=0; i<8; i++) {
            rank.add(Piece.createBlank());
        }
    }

    public int getPieceCount() {
        int pieceCount = 0;
        for(Piece piece : rank) {
            if(piece.getType() != Type.NO_PIECE) {
                pieceCount += 1;
            }
        }
        return pieceCount;
    }

    public String getRankString() {
        StringBuilder sb = new StringBuilder();
        for(Piece piece : rank) {
            sb.append(piece.getRepresentation());
        }
        return sb.toString();
    }
}
