package chess;

import pieces.Pawn;

import java.util.ArrayList;

public class Board {
    private ArrayList<Pawn> board = new ArrayList<>();
    private ArrayList<Pawn> blackPawnList = new ArrayList<>();
    private ArrayList<Pawn> whitePawnList = new ArrayList<>();

    public void initialize() {
        for(int i=0; i<8; i++) {
            blackPawnList.add(new Pawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION));
            whitePawnList.add(new Pawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION));
        }
    }

    public void add(Pawn pawn) {
        board.add(pawn);
    }

    public int size() {
        return board.size();
    }

    public Pawn findPawn(int index) {
        return board.get(index);
    }

    public String getWhitePawnResult() {
        return getPawnListString(whitePawnList);
    }

    public String getBlackPawnResult() {
        return getPawnListString(blackPawnList);
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        sb.append("........\n");
        sb.append(getBlackPawnResult()).append("\n");
        sb.append("........\n");
        sb.append("........\n");
        sb.append("........\n");
        sb.append("........\n");
        sb.append(getWhitePawnResult()).append("\n");
        sb.append("........\n");
        return sb.toString();
    }

    private String getPawnListString(ArrayList<Pawn> pawnList) {
        StringBuilder sb = new StringBuilder();
        for(Pawn pawn : pawnList) {
            sb.append(pawn.getRepresentation());
        }
        return sb.toString();
    }
}
