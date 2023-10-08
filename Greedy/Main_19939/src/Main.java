import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] basket;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //공의 개수
        K = Integer.parseInt(st.nextToken()); //바구니의 개수

        if (N <= K) {
            System.out.println(-1);
            return;
        }

        basket = new int[K];

        for (int i = 0; i < K; i++) {
            basket[i] = i + 1;
            N -= basket[i];

            //담는 중 공이 다 떨어지면 종료
            if (N < 0) {
                System.out.println(-1);
                return;
            }
        }

        //남은 공의 개수가 바구니 보다 많은 경우 모든 바구니에 +1
        while (N >= K) {
            N -= K;
            for (int i = 0; i < K; i++) {
                basket[i]++;
            }
        }

        if (N != 0) {
            basket[K - N] += N;
        }

        Arrays.sort(basket);
        System.out.println(basket[K - 1] - basket[0]);


    }
}