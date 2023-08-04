import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
  static int n, m;
  static int ans;
  static ArrayList<Integer>[] list;
  static boolean[] isCheck;
  static int[] memo; //각 정점에 대해 다른 정점까지 최단거리 저장 배열

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    memo = new int[n + 1];
    list = new ArrayList[n + 1];


    for (int i = 1; i <= n; i++) {
      list[i] = new ArrayList<Integer>();
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());

      list[A].add(B);
      list[B].add(A);

    }


    //memo[i]에 해당 정점에서 모든 다른 정점까지의 최단 거리 합을 누적
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        ans = Integer.MAX_VALUE;
        isCheck = new boolean[n + 1];

        if (i != j) {
          dfs(i, j, 0);
          memo[i] += ans;
        }
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


  private static void dfs(int start, int end, int cnt) {
    if (start == end) {
      ans = Math.min(ans, cnt);
      return;
    }

    isCheck[start] = true;

    for (int next : list[start]) {
      if (!isCheck[next]) {
        dfs(next, end, cnt + 1);
      }
    }
    isCheck[start] = false;
  }
}