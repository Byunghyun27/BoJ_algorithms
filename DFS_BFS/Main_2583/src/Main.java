import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class Main {
    static int n,m,k;
    static int[][] map;
    static int cnt;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int row = y1; row<y2; row++){
                for(int col = x1; col<x2; col++){
                    map[row][col] =1;
                }
            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == 0){
                    cnt = 0;
                    dfs(i,j);
                    list.add(cnt); //카운트값 리스트에 저장
                }
            }
        }

        Collections.sort(list);

        System.out.println(list.size());

        for(int i : list){
            System.out.print(i + " ");
        }

    }

    private static void dfs(int row, int col) {
        map[row][col] = 1; //boolean 대신 방문 처리
        cnt++;

        for(int i=0; i<4; i++){
            int nx = row + dx[i];
            int ny = col + dy[i];

            if(nx>=0 && ny>=0 && nx<n && ny<m){
                if(map[nx][ny] == 0){
                    dfs(nx,ny);
                }
            }
        }
    }
}