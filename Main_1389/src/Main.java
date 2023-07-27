import java.io.*;
import java.util.*;

//플로이드 와샬 (2<=n<=100), 시간복잡도O(n^3)으로 n>=500일경우 사용 자제
public class Main {

  static int n, m; //유저의 수, 친구 수
  static int[] memo;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    memo = new int[n + 1];

    int[][] floyd = new int[n + 1][n + 1];

    //초기화
    for (int i = 1; i <=n; i++) {
      for (int j = 1; j <= n; j++) {
        if (i == j) floyd[i][j] = 0;
        else floyd[i][j] = 99999999; //경로를 알 수 없는경우 무한대 초기화(최단 경로 구하지 않은상태)
      }
    }


    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());

      floyd[A][B] = 1;
      floyd[B][A] = 1;
    }


    for (int i = 1; i <=n ; i++) {
      for (int j = 1; j <=n; j++) {
        memo[i] += floyd[i][j];
      }
    }

    int min = Integer.MAX_VALUE;
    int idx = 0;
    for (int i = 1; i <= n; i++) {
      if (min > memo[i]) {
        min = memo[i];
        idx = i;
      }
    }
    System.out.println(idx);
  }
}

