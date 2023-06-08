package chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pieces.Piece;

import static org.assertj.core.api.Assertions.assertThat;
import static pieces.Piece.Color;
import static pieces.Piece.Type;
import static utils.StringUtils.appendNewLine;

public class BoardTest {
    private Board board;

    @BeforeEach
    public void setup() {
        board = new Board();
    }

    @Test
    @DisplayName("체스판을 초기 기물 위치에 맞게 초기화한다.")
    public void create() {
        board.initialize();
        assertThat(board.pieceCount()).isEqualTo(32);

        String blankLine = appendNewLine("........");
        assertThat(board.showBoard()).isEqualTo(
                appendNewLine("RNBQKBNR") + appendNewLine("PPPPPPPP") +
                        blankLine + blankLine + blankLine + blankLine +
                        appendNewLine("pppppppp") + appendNewLine("rnbqkbnr")
        );
    }

    @Test
    @DisplayName("검은색 폰 8개와 흰색 폰 8개가 생성된다.")
    public void initialize() {
        Board board = new Board();
        board.initialize();

        System.out.println(board.showBoard());
    }

    @Test
    @DisplayName("특정 색깔과 종류 기물의 개수를 반환한다.")
    public void pieceCount() {
        board.initialize();

        assertThat(board.pieceCount(Color.BLACK, Type.PAWN)).isEqualTo(8);
        assertThat(board.pieceCount(Color.BLACK, Type.BISHOP)).isEqualTo(2);
        assertThat(board.pieceCount(Color.BLACK, Type.QUEEN)).isEqualTo(1);

        assertThat(board.pieceCount(Color.WHITE, Type.PAWN)).isEqualTo(8);
        assertThat(board.pieceCount(Color.WHITE, Type.ROOK)).isEqualTo(2);
        assertThat(board.pieceCount(Color.WHITE, Type.KING)).isEqualTo(1);
    }

    @Test
    @DisplayName("입력한 위치에 해당하는 기물을 반환한다.")
    public void findPiece() throws Exception {
        //given
        board.initialize();
        //when
        Piece a8 = board.findPiece("a8");
        Piece c7 = board.findPiece("c7");
        Piece a1 = board.findPiece("a1");
        Piece d2 = board.findPiece("d2");
        //then
        isEqualPiece(a8, Piece.createBlackRook());
        isEqualPiece(c7, Piece.createBlackPawn());
        isEqualPiece(a1, Piece.createWhiteRook());
        isEqualPiece(d2, Piece.createWhitePawn());
    }

    @Test
    @DisplayName("입력한 위치에 기물을 추가한다.")
    public void move() throws Exception {
        //given
        board.initializeEmpty();

        String position = "b5";
        Piece piece = Piece.createBlackRook();

        //when
        board.move(position, piece);

        //then
        isEqualPiece(piece, board.findPiece(position));
        System.out.println(board.showBoard());
    }

    private void isEqualPiece(Piece target, Piece other) {
        assertThat(target.getType()).isEqualTo(other.getType());
        assertThat(target.getColor()).isEqualTo(other.getColor());
    }
}
