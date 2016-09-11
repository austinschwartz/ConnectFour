import java.util.*;

public class ConnectFour {
  public static void main(String[] args) {
    IBoard board = new SimpleBoard(6, 7);
    Colors playerOne = Colors.RED;
    Colors playerTwo = Colors.YELLOW;
    Scanner sc = new Scanner(System.in);
    while (true) {
      int playerOneMove = sc.nextInt();
      boolean p1Wins = board.playMove(playerOne, playerOneMove);
      board.drawBoard();
      if (p1Wins)
        System.exit(0);

      int playerTwoMove = sc.nextInt();
      boolean p2Wins = board.playMove(playerTwo, playerTwoMove);
      board.drawBoard();
      if (p2Wins)
        System.exit(0);
    }
  }
}
