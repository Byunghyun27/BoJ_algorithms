import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class info {
    int x;
    int y;

    public info(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

//맥주 마시면서 걸어가기
public class Main {
    static int tc, n;
    static List<info> po; //집, 편의점, 페스티벌에 위치 저장
    static List<ArrayList<Integer>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        tc = Integer.parseInt(br.readLine()); //TC개수

        for (int T = 0; T < tc; T++) {
            n = Integer.parseInt(br.readLine()); //편의 점의 개수

            po = new ArrayList<>();


            for (int i = 0; i < n + 2; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                po.add(new info(x, y));
            }

            list = new ArrayList<>();

            for (int i = 0; i < n + 2; i++) {
                list.add(new ArrayList<>());
            }

            //50m *20(개) =1000m 이하의 정점을 찾음
            //양방향 저장
            /*
                list[0] -> [1, 2]
                list[1] -> [0, 2]
                list[2] -> [0, 1, 3]
                list[3] -> [2]
             */

            for (int i = 0; i < n + 2; i++) {
                for (int j = i + 1; j < n + 2; j++) {
                    if (map(po.get(i), po.get(j)) <= 1000) {
                        list.get(i).add(j);
                        list.get(j).add(i);
                    }
                }
            }

            boolean result = bfs();


            if (result) {
                System.out.println("happy");
            } else {
                System.out.println("sad");
            }


        }//T

    }

    //맨헤튼 거리 구하기
    private static int map(info n1, info n2) {
        return Math.abs(n1.x - n2.x) + Math.abs(n1.y - n2.y);
    }


    private static boolean bfs() {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 2];

        q.add(0); //시작점
        visited[0] = true;

        while (!q.isEmpty()) {
            int now = q.poll();

            if (now == n + 1) {
                return true;
            }


            for (int next : list.get(now)) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }


        }

        return false;
    }

}