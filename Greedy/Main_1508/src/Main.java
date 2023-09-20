import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//그리디 + 이분탐색
public class Main {
    static int N, M, K;
    static int[] judge;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //레이스 트랙의 길이
        M = Integer.parseInt(st.nextToken()); //배치 할 수 있는 심판 수
        K = Integer.parseInt(st.nextToken()); //심판이 위치할 수 있는 장소

        judge = new int[K]; //배치될 심판의 위치 저장

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            judge[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(judge);

        Search();

    }

    //심판을 세울 곳에는 "1", 세우지 않으면 "0"
    private static void Search() {
        boolean[] Check = new boolean[K];
        Check[0] = true;

        int start = 0;
        int end = 1000001;

        while (start < end) {
            boolean[] tmp = new boolean[K];

            int mid = (start + end) / 2;

            int cnt = 1; //가용한 심판 수 기록(첫 심판은 항상 채용)
            int prev = 0; //이전 심판 위치 기록
            tmp[0] = true;
            boolean flag = false;

            for (int i = 1; i < K; i++) {
                if (judge[i] - judge[prev] >= mid) { //현 위치 - 이전 심판위치 >= 중앙 값
                    tmp[i] = true;
                    prev = i;
                    cnt++;

                    if (cnt == M) {
                        flag = true;
                        break;
                    }
                }
            }//for

            if (flag){
                start = mid + 1;
                Check = tmp;
            } else end = mid;


        }//while

        for (boolean i : Check) {
            if (i) System.out.print(1);
            else System.out.print(0);
        }

    }

}