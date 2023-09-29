import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] score;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //학생의 수
        K = Integer.parseInt(st.nextToken()); //과목의 수

        score = new int[K];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }

        grade(score);

    }

    private static void grade(int[] score) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < K; i++) {
            int p = (score[i] * 100) / N;

            if (p <= 4) {
                sb.append("1" + " ");
            } else if (p <= 11) {
                sb.append("2" + " ");
            } else if (p <= 23) {
                sb.append("3" + " ");
            } else if (p <= 40) {
                sb.append("4" + " ");
            } else if (p <= 60) {
                sb.append("5" + " ");
            } else if (p <= 77) {
                sb.append("6" + " ");
            }else if (p <= 89) {
                sb.append("7" + " ");
            }else if (p <= 96) {
                sb.append("8" + " ");
            }else{
                sb.append("9" + " ");
            }

        }

        System.out.println(sb);
    }


}