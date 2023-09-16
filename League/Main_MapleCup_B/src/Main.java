import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] Nova, Origin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //에르다 노바 사용 횟수
        M = Integer.parseInt(st.nextToken()); //오리진 스킬 사용 횟수

        Nova = new int[N];
        Origin = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            Nova[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            Origin[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(Nova);
        Arrays.sort(Origin);

        Bind();

    }

    private static void Bind() {
        int nova = 0;
        int origin = 0;

        int novaCooldown = 0;
        int originCooldown = 0;

        for (int i = 0; i < N; i++) {
            if (Nova[i] >= novaCooldown) {
                novaCooldown = Nova[i] + 100;
                nova++;
            }
        }

        for (int i = 0; i < M; i++) {
            if (Origin[i] >= originCooldown) {
                originCooldown = Origin[i] + 360;
                origin++;
            }
        }


        System.out.println(nova + " " + origin);

    }

}