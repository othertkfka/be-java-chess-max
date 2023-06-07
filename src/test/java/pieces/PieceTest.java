package pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static pieces.Piece.Color;
import static pieces.Piece.Type;

public class PieceTest {

    @Test
    @DisplayName("흰색 또는 검은색으로 기물이 생성된다.")
    public void create() {
        verifyPiece(Piece.createWhitePawn(), Piece.createBlackPawn(), Type.PAWN);
        verifyPiece(Piece.createWhiteKnight(), Piece.createBlackKnight(), Type.KNIGHT);
        verifyPiece(Piece.createWhiteRook(), Piece.createBlackRook(), Type.ROOK);
        verifyPiece(Piece.createWhiteBishop(), Piece.createBlackBishop(), Type.BISHOP);
        verifyPiece(Piece.createWhiteQueen(), Piece.createBlackQueen(), Type.QUEEN);
        verifyPiece(Piece.createWhiteKing(), Piece.createBlackKing(), Type.KING);

        Piece blank = Piece.createBlank();
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
        Piece whitePawn = Piece.createWhitePawn();
        Piece blackPawn = Piece.createBlackPawn();
        Piece whiteKnight = Piece.createWhiteKnight();
        Piece blackKnight = Piece.createBlackKnight();

        assertThat(whitePawn.isWhite()).isTrue();
        assertThat(blackPawn.isBlack()).isTrue();
        assertThat(whiteKnight.isWhite()).isTrue();
        assertThat(blackKnight.isBlack()).isTrue();
    }

}
