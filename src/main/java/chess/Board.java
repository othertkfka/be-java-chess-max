package chess;

import pieces.Pawn;

import java.util.ArrayList;

public class Board {
    private ArrayList<Pawn> board = new ArrayList<>();

    public void add(Pawn pawn) {
        board.add(pawn);
    }

    public int size() {
        return board.size();
    }

    public Pawn findPawn(int index) {
        return board.get(index);
    }
}
