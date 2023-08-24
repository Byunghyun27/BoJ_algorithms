import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//토마토
class pointer {
    int x; //row
    int y; //col
    int z; //면

    public pointer(int z, int x, int y) {
        this.z = z;
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int N, M, H;
    static int[][][] box;
    static Queue<pointer> Q = new LinkedList<>();

    static int[] dx = {-1, 0, 1, 0, 0, 0}; //상, 하, 좌, 우, 위, 아래
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); //col
        N = Integer.parseInt(st.nextToken()); //row
        H = Integer.parseInt(st.nextToken()); //상자의 수

        box = new int[H][N][M];

        //1 : 익은 토마토, 0 : 익지 않은 토마토, -1 : 토마토가 들어있지 않은 칸
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if (box[i][j][k] == 1) {
                        Q.add(new pointer(i, j, k));
                    }
                }
            }
        }//for_i

        System.out.println(bfs());

    }


    private static int bfs() {
        while (!Q.isEmpty()) {
            pointer pi = Q.poll();

            int z = pi.z;
            int x = pi.x;
            int y = pi.y;

            for (int i = 0; i <6; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];

                if(nx>=0 && ny>=0 && nz>=0 && nx<N && ny<M && nz<H){
                    if(box[nz][nx][ny] ==0){
                        Q.add(new pointer(nz, nx, ny)); //익은 토마토 추가

                        //익은 날짜를 얻기 위해 1증가
                        box[nz][nx][ny] = box[z][x][y] + 1; //박스안에 토마토 : 0 -> 1
                    }
                }
            }
        }//while

        int result = Integer.MIN_VALUE;

        for(int i=0; i<H; i++){
            for(int j=0; j<N; j++){
                for(int k=0; k<M; k++){
                    if(box[i][j][k] == 0) return -1; //익지 않은 토마토가 있으면 -1

                    //날짜 최댓값 구하기
                    result = Math.max(result, box[i][j][k]);
                }
            }
        }//for_i
        if(result ==1) return 0; //최대 값이 1이라면 시작부터 모두 익어있음
        else return (result -1); //(최대 값 -1) --> 걸린 일 수
    }//bfs

}