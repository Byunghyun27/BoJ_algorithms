import java.io.*;
import java.util.*;

public class Main {

  static int n, m;
  static int start, end;
  static boolean[] ischeck;
  static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
  static int ans = -1; //끝점에 도달할 수 없는경우 -1을 출력하기 위한 초기값

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());

    for (int i = 0; i <= n; i++) {
      list.add(new ArrayList<>());
    }
    ischeck = new boolean[n + 1];

    StringTokenizer st = new StringTokenizer(br.readLine());
    start = Integer.parseInt(st.nextToken()); //시작 촌수
    end = Integer.parseInt(st.nextToken()); //찾을 촌수

    m = Integer.parseInt(br.readLine());

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());
      //양방향 인접리스트 
      list.get(A).add(B);
      list.get(B).add(A);
    }

    dfs(list, ischeck, start, end, 0);

    System.out.println(ans);

  }

  private static void dfs(ArrayList<ArrayList<Integer>> list, boolean[] ischeck, int start, int end, int cnt) {
    ischeck[start] = true;

    for (int i : list.get(start)) {
        if(!ischeck[i]){
          if(i == end){
            ans = cnt + 1 ;
            return;
          }

          dfs(list, ischeck, i, end, cnt+1);
        }
    }
  }

}