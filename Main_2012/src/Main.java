import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//등수 매기기
public class Main {
    static int n;
    static int[] score;
    static long sum =0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        score = new int[n];

        for (int i = 0; i < n; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(score);
        Num();
        System.out.println(sum);
    }

    private static void Num() {
        for(int i=0; i<score.length; i++){
            sum += Math.abs(score[i] - (i+1));
        }
    }

}