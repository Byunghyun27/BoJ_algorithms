import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//벽 부수고 이동하기

class Point {
    int x, y;
    int cnt = 0;
    boolean visit;

    public Point(int x, int y, int cnt, boolean visit) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
        this.visit = visit;
    }

}


public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][][] Check;
    static ArrayList<int[]> list = new ArrayList<>();
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        /*
        1.3차원 배열 사용 이유 : 벽을 부순경우, 부수지 않은 경우
         1) Check [?][?][0] => 부신 벽이 없을 경우
         2) Check [?][?][1] => 부신 벽이 있을 경우
         */
        Check = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                char ch = str.charAt(j);
                map[i][j] = ch - '0';
            }
        }

        System.out.println(bfs());

    }

    private static int bfs() {
        Queue<Point> q = new LinkedList<>();

        q.add(new Point(0, 0, 1, false));
        Check[0][0][0] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();

            if (p.x == N - 1 && p.y == M - 1) return p.cnt;

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if (p.visit) {
                    //벽을 부심 && 벽이 아님 && 방문 x
                    if (map[nx][ny] == 0 && !Check[nx][ny][1]) {
                        Check[nx][ny][1] = true;

                        q.offer(new Point(nx, ny, p.cnt + 1, true));
                    }

                } else {
                    if (map[nx][ny] == 1) { //벽일 때
                        Check[nx][ny][1] = true;
                        q.add(new Point(nx, ny, p.cnt + 1, true));

                    } else if (!Check[nx][ny][0]) { //방문X, 벽부신적 없을경우
                        Check[nx][ny][0] = true;
                        q.add(new Point(nx, ny, p.cnt + 1, false));
                    }

                }

            }

        }
        return -1;

    }
}