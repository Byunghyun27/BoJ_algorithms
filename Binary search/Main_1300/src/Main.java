import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int n, k;
    static long start, end;
    static long ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine()); //배열의 크기
        k = Integer.parseInt(br.readLine());

        //k의 범위 : k <= 10^9
        start = 1;
        end = k;

        long result = Search(start, end);

        System.out.println(result);

    }

    private static long Search(long start, long end) {
        while (end >= start) {
            long mid = (start + end) / 2;
            long cnt = 0;

            //i : 행을 의미
            /*
             * ex) n=3일 경우 3*3 배열로 예를 들어 i=1 (1행)
             * 중앙값 : 4 = (1+7)/2, 즉 4보다 작은 값은 i행에서는 3개 이후 행마다 확인
             * cnt값이 k보다 작다면 시작 값을 중앙값 +1, 크다면 end값을 중앙값 -1
             */
            for (int i = 1; i <= n; i++) {
                cnt += Math.min(mid / i, n);
            }

            if (cnt < k) {
                start = mid + 1;
            } else {
                ans = mid; // 정답 변수에 값 저장
                end = mid - 1;
            }
        }

        return ans;

    }
}