import java.io.*;
import java.util.*;

public class Main {

  static int R,C;
  static int[][] map;
  static int ans = 0;
  static boolean[] isCheck;

  static int[] dx = {0,1,0,-1};
  static int[] dy = {1,0,-1,0};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    R = Integer.parseInt(st.nextToken()); //세로
    C = Integer.parseInt(st.nextToken()); //가로

    map = new int[R][C];
    isCheck = new boolean[26];

    for(int i=0; i<R; i++) {
      String str = br.readLine();
      for(int j=0; j<C; j++) {
        map[i][j] = str.charAt(j) -'A';
      }
    }

    dfs(0,0,0);

    System.out.println(ans);

  }

  private static void dfs(int x, int y, int cnt) {
    if(isCheck[map[x][y]]) {
      ans = Math.max(ans, cnt);
      return;

    } else {
      isCheck[map[x][y]] = true;

      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
          dfs(nx, ny, cnt + 1);
        }

      }

      isCheck[map[x][y]] = false;

    }

  }
}