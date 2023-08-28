import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int F, S, G, U, D;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());//층 수
        S = Integer.parseInt(st.nextToken());//현 위치
        G = Integer.parseInt(st.nextToken());//도착지 위치
        U = Integer.parseInt(st.nextToken());//위 버튼
        D = Integer.parseInt(st.nextToken());// 아래 버튼


        int result = BFS();
        System.out.println((result == -1) ? "use the stairs" : result);
    }

    private static int BFS() {
        int cnt = -1; //버튼 누른 횟수 저장
        Queue<Integer> Q = new LinkedList<>();
        visited = new boolean[F + 1];//0층부터 F층까지

        Q.add(S);

        while (!Q.isEmpty()) {
            cnt++;

            int size = Q.size();

            for (int i = 0; i < size; i++) {
                int now = Q.poll();

                if (now == G) {
                    return cnt;
                }

                int next = now + U;
                if (next <= F &&!visited[next] ) {
                    visited[next] = true;
                    Q.add(next);
                }

                int back = now - D;
                if (back > 0 &&!visited[back]) {
                    visited[back] = true;
                    Q.add(back);
                }
            }
        }//while
        return -1;
    }
}