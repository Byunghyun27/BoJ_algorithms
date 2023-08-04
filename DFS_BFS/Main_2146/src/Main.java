import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {
    static int n;
    static int[][] map;
    static boolean[][] isCheck;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        isCheck = new boolean[n][n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt =1;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j]==1 && !isCheck[i][j]){
                    cnt++;
                    makeland(i, j, cnt);
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] !=0){
                    isCheck = new boolean[n][n];
                    bfs(i,j);
                }
            }
        }

        System.out.println(ans);

    }

    private static void bfs(int x, int y) {
        int num = map[x][y]; //문제상으로 정의한 좌표의 섬의 번호 값

        Queue<int[]> Q = new LinkedList<>();
        isCheck[x][y] = true;
        Q.add(new int[] {x, y, 0}); //x, y 좌표값, 다음 섬까지의 cnt값

        while(!Q.isEmpty()){
            int[] now = Q.poll();

            for(int i=0; i<4; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(range(nx, ny) && !isCheck[nx][ny]){
                    isCheck[nx][ny] = true;

                    if(map[nx][ny] == 0){ //다음 방문 지역이 "물"인 경우 
                        Q.offer(new int[] {nx, ny, now[2]+1}); // 다음섬까지의 cnt++ 시켜줌
                    } else if(map[nx][ny] != num) { //다음 좌표가 다른 섬일경우 cnt의 값과 비교해서 최소값 반환
                        ans = Math.min(now[2], ans);
                        return;
                    }
                }
            }
        }
    }

    //섬에 번호 생성, cnt 초기값 2
    private static void makeland(int x, int y, int cnt) {
        Queue<int[]> q = new LinkedList<>();
        map[x][y] = cnt; //받은 좌표값의 섬의 값 추가
        isCheck[x][y] = true;
        q.add(new int[] {x,y});

        while(!q.isEmpty()){
            int[] now = q.poll();

            for(int i=0; i<4; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(range(nx, ny) && map[nx][ny] ==1 && !isCheck[nx][ny]){
                    map[nx][ny] = cnt;
                    isCheck[nx][ny] = true;
                    q.add(new int[] {nx, ny});
                }
            }
        }//while



    }//bfs 방문 조건
    public static boolean range(int x, int y){
        return x>=0 && y>=0 && x<n && y<n;
    }

}