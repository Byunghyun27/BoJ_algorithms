import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        int ans = 0;

        //빙하가 2개 이상일 경우 반복문 종료
        //빙하가 다 녹았을 경우 0
        while ((cnt = Checking()) < 2) {
            if (cnt == 0) {
                ans = 0;
                break;
            }

            BFS();
            ans++;
        }

        System.out.println(ans);
    }


    //빙하 분리된 개수 카운트
    private static int Checking() {
        boolean[][] visited = new boolean[n][m];

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    DFS(i, j, visited);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private static void DFS(int x, int y, boolean[][] visited) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (factcheck(nx, ny) && !visited[nx][ny] && map[nx][ny] != 0) {
                DFS(nx, ny, visited);
            }
        }

    }

    //빙하 녹이기
    private static void BFS() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];

            int cnt = 0; //바다 개수 카운트

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (factcheck(nx, ny) && !visited[nx][ny] && map[nx][ny] == 0) {
                    cnt++;
                }
            }

            if (map[x][y] - cnt < 0) {
                map[x][y] = 0;
            } else {
                map[x][y] -= cnt;
            }

        }
    }


    private static boolean factcheck(int nx, int ny) {
        if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
            return true;
        }
        return false;
    }

}