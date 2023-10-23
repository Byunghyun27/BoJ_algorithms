import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//파이프 옮기기
public class Main {
    static int N;
    static int[][] room;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        room = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(1, 2, 0);

        System.out.println(ans);
    }

    //state = 0 가로, 1 = 세로, 2= 대각선
    private static void dfs(int r, int c, int state) {

        if (r == N && c == N) {
            ans++;
            return;
        }

        switch (state) {
            case 0: //가로방향 (오른쪽 1칸 or 대각선 이동)
                if (c + 1 <= N && room[r][c + 1] == 0) {
                    dfs(r, c + 1, 0); //오른쪽 이동
                }
                break;

            case 1: //세로 방향 (아래 한칸 or 대각선 이동)
                if (r + 1 <= N && room[r + 1][c] == 0) {
                    dfs(r + 1, c, 1); //아래쪽 이동
                }
                break;

            case 2: //대각선 이동 (오른쪽 or 아래쪽 or 대각선 이동 가능)
                if (c + 1 <= N && room[r][c + 1] == 0) {
                    dfs(r, c + 1, 0); //오른쪽 이동
                }

                if (r + 1 <= N && room[r + 1][c] == 0) {
                    dfs(r + 1, c, 1); //아래쪽 이동
                }
                break;
        }

        //대각선 이동
        if (c + 1 <= N && r + 1 <= N && room[r][c + 1] == 0 && room[r + 1][c] == 0 && room[r + 1][c + 1] == 0) {
            dfs(r + 1, c + 1, 2);
        }

    }
}