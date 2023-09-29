import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int L, K, C;
    static int[] cuting;
    static long max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken()); //통나무의 길이
        K = Integer.parseInt(st.nextToken()); //자를 수 있는 위치
        C = Integer.parseInt(st.nextToken()); //자를 수 있는 횟수

        cuting = new int[K + 2];
        cuting[0] = 0; //아무것도 자르지 않은 경우
        cuting[1] = L; //마지막 자르는 위치

        st = new StringTokenizer(br.readLine());
        for (int i = 2; i < K + 2; i++) {
            cuting[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cuting);

        Slice();

    }

    private static void Slice() {
        int left = 0;
        int right = L; // 0 ~ L 까지의 범위
        int result_Wood = L; //자르는 가장 긴 조각의 위치
        int result_position = 0; //자르는 위치

        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = 0;
            int len = 0;
            int cut_position = 0;

            //자르는 구간별로 길이 더함
            for (int i = K; i >= 0; i--) {
                len += cuting[i + 1] - cuting[i];


                //나무 조각의 길이가 제한길이보다 더 길어지면 컷
                if (len > mid) {
                    len = cuting[i + 1] - cuting[i];
                    cnt++;


                    //컷한 길이가 제한 길이보다 길 경우 컷
                    if (len > mid) {
                        cnt = C + 1;
                        break;
                    }
                }
            }
            //자를 수 있는 횟수가 남아있다면 가장 작은 자르는 위치를 가져감
            if (cnt <= C) {
                cut_position = cuting[1];

                //자를 수 없으면 현재 위치 가져감
                if (cnt == C) cut_position = len;

                result_Wood = Math.min(mid, result_Wood);
                result_position = cut_position;


                right = mid - 1;
            } else {
                left = mid + 1;
            }
        } //while

        System.out.println(result_Wood + " " + result_position);
    }
}