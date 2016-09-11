public interface IBoard {
  boolean playMove(Colors color, int col);
  boolean checkMove(Colors color, int row, int col);
  void drawBoard();
}
