
import java.util.*;
import java.util.Scanner;

public class AllSolutions_Backtracking {
    static List<List<Integer>> result;
    static boolean[][] board;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Queen: ");
         n = sc.nextInt();
        result = new ArrayList<>();
        board = new boolean[n][n];
        solve(0);
      for(List<Integer> a:result){
          System.out.println(a.toString());
      }

    }

    public static void solve(int r) {
        if (r == board.length) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == true) {
                        list.add(j + 1);
                    }
                }
            }
          result.add(list);
        }
        for (int p = 0; p < board.length; p++) {
            if (isafe(r, p)) {
                board[r][p] = true;
                solve(r + 1);
                board[r][p] = false;
            }
        }
    }

    public static boolean isafe(int row, int col) {
        for (int i = 0; i <= row; i++) {
            if (board[i][col] == true)
                return false;
        }
        int x = row;
        int y = col;
        while (x >= 0 && y >= 0) {
            if (board[x][y] == true)
                return false;
            x--;
            y--;
        }
        x = row;
        y = col;
        while (x >= 0 && y < board.length) {
            if (board[x][y] == true)
                return false;
            x--;
            y++;
        }
        return true;
    }
}
