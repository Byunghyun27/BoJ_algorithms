import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//미세먼지 안녕
class dust{
    int x,y,num;

    public dust(int x, int y, int num) {
        this.x = x;
        this.y = y;
        this.num = num;
    }
}
public class Main {
    static int R, C, T;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[] cleaner = new int[2];
    static int air_cnt=0;
    static Queue<dust> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken()); //행
        C = Integer.parseInt(st.nextToken()); //열
        T = Integer.parseInt(st.nextToken()); //시간(초)
        map = new int[R][C];


        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == -1){
                    cleaner[air_cnt] = i;
                    air_cnt ++;
                }

            }
        }


        for (int i = 0; i < T; i++) {
            spread();
            bfs();
        }

        System.out.println(solve());
    }


    //확산
    private static void spread() {
        Check_Dust();

        while(!q.isEmpty()){
            dust now = q.poll();
            //if(now.num < 5) continue; //A(rc)/5

            int S_num = now.num / 5; //확산시킬 먼지 량
            int cnt =0;

            for(int i=0; i<4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx>=0 && ny>=0 && nx<R && ny<C && map[nx][ny] != -1){
                    map[nx][ny] += S_num;
                    cnt++;
                }
            }

            map[now.x][now.y] -= S_num * cnt; //확산시키고 남은 먼지

        }

    }

    private static void Check_Dust() {
        q = new LinkedList<>();

        for(int i =0; i<R; i++){
            for(int j =0; j<C; j++){
                if(map[i][j] == -1 || map[i][j] == 0) continue;

                q.add(new dust(i, j, map[i][j]));
            }
        }
    }

    //공기청정기 순환
    private static void bfs() {
        int top = cleaner[0]; //공기청정기 윗부분 좌표(반시계 순환)
        int bot = cleaner[1]; //공기청저기 아래 좌표(시계 방향)

        //반시계 진행
        for (int i = top - 1; i > 0; i--) { //위에있는값 가져오기
            map[i][0] = map[i - 1][0];
        }

        for (int i = 0; i < C - 1; i++) { //오른쪽있는 값 가져오기
            map[0][i] = map[0][i + 1];
        }

        for (int i = 0; i < top; i++) { //아래있는 값 가져오기
            map[i][C - 1] = map[i + 1][C - 1];
        }

        for (int i = C - 1; i > 1; i--) { //왼쪽에 있는 값 가져오기
            map[top][i] = map[top][i - 1];
        }

        map[top][1] = 0; //공기청정기에서 나오면 정화처리

        for (int i = bot + 1; i < R - 1; i++) {
            map[i][0] = map[i + 1][0];
        }

        for (int i = 0; i < C - 1; i++) {
            map[R - 1][i] = map[R - 1][i + 1];
        }

        for (int i = R - 1; i > bot; i--) {
            map[i][C - 1] = map[i - 1][C - 1];
        }

        for (int i = C - 1; i > 1; i--) {
            map[bot][i] = map[bot][i - 1];
        }

        map[bot][1] = 0; 
    }

    private static int solve() {
        int result = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j] ==-1) continue;

                result += map[i][j];
            }
        }
        return result;
    }

}