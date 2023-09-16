import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static long[] score;
    static long ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //교실의 개수
        K = Integer.parseInt(st.nextToken()); //학생들의 수

        score = new long[N];

        long sum =0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sum += Long.parseLong(st.nextToken());
            score[i] = sum;
        }

        Arrays.sort(score);

        for(int i=N-1; i>=N-K; i--){
            ans += score[i];
        }


        System.out.println(ans);

    }


}