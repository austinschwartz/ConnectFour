import java.util.*;

public class SimpleBoard implements IBoard {
  Colors[][] board;
  int rows;
  int cols;

  public static int[][] coords = new int[][] {
    {-1, -1}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}
  };

  public SimpleBoard(int rows, int cols) {
    this.board = new Colors[rows][cols];
    this.rows = rows;
    this.cols = cols;

    for (int i = 0; i < rows; i++)
      Arrays.fill(board[i], Colors.NONE);
  }

  public boolean playMove(Colors color, int col) {
    int row = 0;
    while (row < rows) {
      if (board[row][col] != Colors.NONE)
        break;
      row++;
    }
    row--;

    board[row][col] = color;

    return checkMove(color, row, col);
  }

  public boolean checkMove(Colors color, int row, int col) {
    for (int[] coord : coords) {
      int count = 0;
      for (int i = -4; i < 4; i++) {
        int newerRow = row + (coord[0] * i);
        int newerCol = col + (coord[1] * i);
        if (isValid(newerRow, newerCol)
            && board[newerRow][newerCol] == color) {
          count++;
          if (count == 4)
            return true;
        } else {
          count = 0;
        }
      }
    }
    return false;
  }

  public boolean isValid(int row, int col) {
    if (row < 0 || row >= rows || col < 0 || col >= cols)
      return false;
    return true;
  }

  public void drawBoard() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < rows; i++) {
      StringBuilder row = new StringBuilder();
      for (int j = 0; j < cols; j++) {
        Colors color = board[i][j];
        switch (color) {
          case YELLOW:
            row.append('X');
            break;
          case RED:
            row.append('O');
            break;
          default:
            row.append('.');
            break;
        }
      }
      sb.append(row.toString() + "\n");
    }
    System.out.println(sb.toString());
  }
}
