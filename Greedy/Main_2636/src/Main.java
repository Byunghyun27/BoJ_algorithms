import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int row, col;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visit;
    static int cheese = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        map = new int[row][col];

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] ==1) cheese++;
            }
        }

        Search();


    }

    private static void Search() {
        int cnt = 0;
        int time = 0;

        while(cheese != 0){
            cnt = cheese;
            time++;
            visit = new boolean[row][col];
            bfs();
        }

        System.out.println(time);
        System.out.println(cnt);

    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0}); //테두리는 항상 0

        visit[0][0] = true;

        while(!q.isEmpty()){
            int[] now = q.poll();

            for(int i =0; i<4; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(nx>=0 && ny>=0 && nx<row && ny< col && !visit[nx][ny]){
                    visit[nx][ny] = true;

                    if(map[nx][ny] ==0){
                        q.offer(new int[] {nx, ny});
                    } else{ //치즈가 있다면 치즈는 녹아 없어지므로 cheese --;처리
                        cheese--;
                        map[nx][ny] = 0;
                    }
                }
            }
        }
    }

}