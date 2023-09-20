import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//통나무 건너뛰기
public class Main {
    static int T;
    static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int Tc = 0; Tc < T; Tc++) {
            int N = Integer.parseInt(br.readLine());

            tree = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                tree[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(tree);

            Search(tree, N);
        }


    }

    private static void Search(int[] tree, int N) {
        int[] ans = new int[N];

        int start = 0;
        int end = N - 1;

        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {  //2 5 9 7 4
                ans[start++] = tree[i];
            } else {
                ans[end--] = tree[i];
            }
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N - 1; i++) {
            max = Math.max(max, Math.abs(ans[i] - ans[i + 1]));
        }

        System.out.println(max);

    }
}