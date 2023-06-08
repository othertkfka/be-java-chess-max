package chess;

import pieces.Piece;
import pieces.Piece.Color;
import pieces.Piece.Type;

import java.util.ArrayList;
import java.util.List;

public class Rank {
    private ArrayList<Piece> rank;

    private Rank() {
        rank = new ArrayList<>();
    }

    public static Rank createFirstRank(Color color) {
        Rank rank = new Rank();
        if(color.equals(Color.BLACK)) {
            rank.addPiece(Piece.createBlackRook());
            rank.addPiece(Piece.createBlackKnight());
            rank.addPiece(Piece.createBlackBishop());
            rank.addPiece(Piece.createBlackQueen());
            rank.addPiece(Piece.createBlackKing());
            rank.addPiece(Piece.createBlackBishop());
            rank.addPiece(Piece.createBlackKnight());
            rank.addPiece(Piece.createBlackRook());
        } else {
            rank.addPiece(Piece.createWhiteRook());
            rank.addPiece(Piece.createWhiteKnight());
            rank.addPiece(Piece.createWhiteBishop());
            rank.addPiece(Piece.createWhiteQueen());
            rank.addPiece(Piece.createWhiteKing());
            rank.addPiece(Piece.createWhiteBishop());
            rank.addPiece(Piece.createWhiteKnight());
            rank.addPiece(Piece.createWhiteRook());
        }
        return rank;
    }

    public static Rank createPawnRank(Color color) {
        Rank rank = new Rank();
        if(color.equals(Color.BLACK)) {
            for(int i=0; i<8; i++) {
                rank.addPiece(Piece.createBlackPawn());
            }
        } else {
            for(int i=0; i<8; i++) {
                rank.addPiece(Piece.createWhitePawn());
            }
        }
        return rank;
    }

    public static Rank createBlankRank() {
        Rank rank = new Rank();
        for(int i=0; i<8; i++) {
            rank.addPiece(Piece.createBlank());
        }
        return rank;
    }

    public Piece getPiece(int index) {
        return rank.get(index);
    }

    public void addPiece(Piece piece) {
        rank.add(piece);
    }

    public void addPiece(int index, Piece piece) {
        rank.set(index, piece);
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

    public int getPieceCount(Color color, Type type) {
        int pieceCount = 0;
        for(Piece piece : rank) {
            if(piece.getColor() == color && piece.getType() == type) {
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

    public List<Piece> findPiecesByColor(Color color) {
        List<Piece> pieces = new ArrayList<>();
        for(Piece piece : rank) {
            if(piece.getColor() == color) {
                pieces.add(piece);
            }
        }
        return pieces;
    }
}
