import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static Character[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static Queue<int[]> Q = new LinkedList<>(); //고슴도치 이동
    static Queue<int[]> WQ = new LinkedList<>(); //물 이동
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new Character[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'S') {
                    Q.add(new int[]{i, j, 0});
                } else if (map[i][j] == '*') {
                    WQ.add(new int[]{i, j});
                }
            }
        }

        bfs();

        System.out.println(ans == Integer.MAX_VALUE ? "KAKTUS" : ans);


    }
    //1초후 물이 빈공간에 차므로 물이동이 예정되어있으면 해당 부분 이동불가 >> 물을 먼저 채움
    private static void bfs() {

        while (!Q.isEmpty()) {
            //초기에 물 먼저 이동
            int w_len = WQ.size();

            for (int i = 0; i < w_len; i++) {
                int[] w_move = WQ.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = w_move[0] + dx[j];
                    int ny = w_move[1] + dy[j];

                    if (nx >= 0 && ny >= 0 && nx < R && ny < C && map[nx][ny] == '.') {
                        map[nx][ny] = '*';
                        WQ.add(new int[]{nx, ny});
                    }
                }
            }

            //고슴도치 이동
            int q_len = Q.size();

            for (int i = 0; i < q_len; i++) {
                int[] q_move = Q.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = q_move[0] + dx[j];
                    int ny = q_move[1] + dy[j];
                    int cnt = q_move[2];

                    if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
                        if (map[nx][ny] == 'D') { //도착지점이면 리턴
                            ans = Math.min(ans, cnt + 1);
                            return;

                        } else if (map[nx][ny] == '.') { //이동가능 지점일경우 위치 저장
                            map[nx][ny] = 'S';
                            Q.add(new int[]{nx, ny, cnt + 1});
                        }
                    }
                }
            }
        }//while
    }//bfs
}