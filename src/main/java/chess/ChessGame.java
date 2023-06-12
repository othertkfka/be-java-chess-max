package chess;

import pieces.Position;

public class ChessGame {
    Board board = new Board();

    public void initialize() {
        board.initialize();
    }

    public void move(String source, String target) {
        board.move(new Position(source), new Position(target));
    }

    public String getBoard() {
        return board.showBoard();
    }
}
