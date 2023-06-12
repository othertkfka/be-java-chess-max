package chess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameController {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ChessGame chessGame = new ChessGame();

        while (true) {
            System.out.println("명령을 입력하세요.");
            String command = br.readLine();
            if (command.equals("start")) {
                chessGame.initialize();
                ChessView.viewBoard(chessGame.getBoard());
            } else if (command.equals("end")) {
                System.out.println("게임을 종료합니다.");
                break;
            } else if (command.startsWith("move")) {
                String[] splitCommand = command.split(" ");
                chessGame.move(splitCommand[1], splitCommand[2]);
                ChessView.viewBoard(chessGame.getBoard());
            } else {
                System.out.println("올바른 명령어를 입력하세요.");
            }
        }
        br.close();
    }
}
