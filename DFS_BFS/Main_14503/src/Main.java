import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//로봇 청소기
public class Main {
    static int n, m;
    static int r, c, d;
    static int[][] room;
    //북, 동, 남, 서
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int cnt = 1;// 시작지점은 항상 비어있는 칸으로 '1' 시작

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        room = new int[n][m];

        //(r,c) : 로봇 청소기가 있는 좌표, d : 바라보는 방향
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());


        //0 : 빈 칸, 1: 벽이 있는 칸, [청소기가 있는 칸은 항상 빈칸]
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Cleaning(r, c, d);
        System.out.println(cnt);

    }

    //dfs
    private static void Cleaning(int x, int y, int d) {
        room[x][y] = -1;

        //d가 0인 경우 북쪽, 1인 경우 동쪽, 2인 경우 남쪽, 3인 경우 서쪽을 바라보고있음
        for (int i = 0; i < 4; i++) {
            d = (d + 3) % 4; //왼쪽 방향(반시계) 방향으로 돌면서 탐색

            int nx = x + dx[d];
            int ny = y + dy[d];

            if (Check(nx, ny) && room[nx][ny] == 0) {
                cnt++;
                Cleaning(nx, ny, d);
                return; //후진할 때만 이전 길을 되돌가 가며 확인할 수 있으므로 return을 해서 다시 되돌아 와도 더 이상 움직이면 안됨
            }
        }//for

        //반복문 탈출시 주변에 청소할 공간 존재 X
        int back = (d + 2) % 4; //반대 방향으로 후진
        int back_x = x + dx[back]; //후진 _x
        int back_y = y + dy[back]; //후진 _y

        if (Check(back_x, back_y) && room[back_x][back_y] != 1) {
            Cleaning(back_x, back_y, d);//후진시 방향 유지
        }
    }

    private static boolean Check(int nx, int ny) {
        if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
            return true;
        } else {
            return false;
        }
    }

}