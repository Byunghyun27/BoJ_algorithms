import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//DP
//https://www.acmicpc.net/problem/12026 BOJ거리
public class Main {
    static int N;
    static String str;
    static int[] dp;
    final static int max = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        str = br.readLine();

        dp = new int[N];

        Arrays.fill(dp, max);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            char po = str.charAt(i);

            if (po == 'B') {
                Jump(i, 'O');
            } else if(po =='O'){
                Jump(i, 'J');
            } else {
                Jump(i, 'B');
            }

        }

        if(dp[N-1] == max){
            System.out.println(-1);
        } else{
            System.out.println(dp[N-1]);
        }

    }

    private static void Jump(int i, char next) {
        for (int j = i + 1; j < N; j++) {
            char k = str.charAt(j);

            if (k == next) {
                dp[j] = Math.min(dp[j], dp[i] + (j - i) * (j - i));
            }
        }

    }
}