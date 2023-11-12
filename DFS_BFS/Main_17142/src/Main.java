import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Point {
    int x, y, time;

    public Point(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}

//연구소3, youtube 해설 참조
public class Main {
    static int N, M;
    static int[][] map;
    final static int[] dx = {0, 1, 0, -1};
    final static int[] dy = {1, 0, -1, 0};
    static ArrayList<Point> list = new ArrayList<>();
    static Point[] active;

    static int result = Integer.MAX_VALUE;
    static int emptyCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        active = new Point[M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                //0 : 빈 공간, 1 : 벽, 2: 바이러스
                if (map[i][j] == 0) {
                    emptyCnt++;

                } else if (map[i][j] == 2) {
                    list.add(new Point(i, j, 0));
                }

            }
        }


        if (emptyCnt == 0) {
            System.out.println(0);
            return;
        }

        dfs(0, 0);

        System.out.println(result == Integer.MAX_VALUE ? -1 : result);

    }

    private static void dfs(int start, int cnt) {
        if (cnt == M) {
            bfs(emptyCnt);
            return;
        }

        for (int i = start; i < list.size(); i++) {
            active[cnt] = list.get(i);
            dfs(i + 1, cnt + 1);
        }

    }

    private static void bfs(int emptyCnt) {
        Queue<Point> q = new LinkedList<>();
        boolean[][] Check = new boolean[N][N];

        for (Point p : active) {
            q.add(p);
            Check[p.x][p.y] = true;
        }

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (map[nx][ny] == 1 || Check[nx][ny]) continue;

                if (map[nx][ny] == 0) emptyCnt--;

                if (emptyCnt == 0) {
                    result = Math.min(result, p.time + 1);
                    return;
                }

                Check[nx][ny] = true;
                q.add(new Point(nx, ny, p.time + 1));

            }
        }
    }
}