import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int[][] map;
    static int to = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //세로줄의 개수
        M = Integer.parseInt(st.nextToken());// 가로줄의 개수
        K = Integer.parseInt(st.nextToken()); //동아리원의 수

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                char ch = str.charAt(j);
                map[i][j] = ch - '0';
            }
        }

        Search();
    }

    private static void Search() {
        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    cnt++;
                    if (cnt >= K) {
                        to++; //자리가 연속되어 동아리 인원수 만큼 되면 경우의 수 증가
                    }
                } else {
                    cnt = 0; //연속되지 못한경우 cnt 0으로 초기화
                }
            }
        }
        System.out.println(to);
    }//Search();


}