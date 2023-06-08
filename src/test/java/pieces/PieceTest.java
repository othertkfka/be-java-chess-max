package pieces;

import chess.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static pieces.Piece.Color;
import static pieces.Piece.Type;

public class PieceTest {

    @Test
    @DisplayName("흰색 또는 검은색으로 기물이 생성된다.")
    public void create() {
        verifyPiece(Piece.createWhitePawn(new Position("a1")), Piece.createBlackPawn(new Position("a8")), Type.PAWN);
        verifyPiece(Piece.createWhiteKnight(new Position("a1")), Piece.createBlackKnight(new Position("a8")), Type.KNIGHT);
        verifyPiece(Piece.createWhiteRook(new Position("a1")), Piece.createBlackRook(new Position("a8")), Type.ROOK);
        verifyPiece(Piece.createWhiteBishop(new Position("a1")), Piece.createBlackBishop(new Position("a8")), Type.BISHOP);
        verifyPiece(Piece.createWhiteQueen(new Position("a1")), Piece.createBlackQueen(new Position("a8")), Type.QUEEN);
        verifyPiece(Piece.createWhiteKing(new Position("a1")), Piece.createBlackKing(new Position("a8")), Type.KING);

        Piece blank = Piece.createBlank(new Position("a1"));
        assertThat(blank.getColor()).isEqualTo(Color.NOCOLOR);
        assertThat(blank.getType()).isEqualTo(Type.NO_PIECE);
    }

    public void verifyPiece(final Piece whitePiece, final Piece blackPiece, final Type type) {
        assertThat(whitePiece.isWhite()).isTrue();
        assertThat(whitePiece.getType()).isEqualTo(type);

        assertThat(blackPiece.isBlack()).isTrue();
        assertThat(blackPiece.getType()).isEqualTo(type);
    }

    @Test
    @DisplayName("생성한 기물이 흰색인지 검은색인지 확인한다.")
    public void isBlackOrWhite() {
        Piece whitePawn = Piece.createWhitePawn(new Position("a1"));
        Piece blackPawn = Piece.createBlackPawn(new Position("a8"));
        Piece whiteKnight = Piece.createWhiteKnight(new Position("a1"));
        Piece blackKnight = Piece.createBlackKnight(new Position("a8"));

        assertThat(whitePawn.isWhite()).isTrue();
        assertThat(blackPawn.isBlack()).isTrue();
        assertThat(whiteKnight.isWhite()).isTrue();
        assertThat(blackKnight.isBlack()).isTrue();
    }

}
