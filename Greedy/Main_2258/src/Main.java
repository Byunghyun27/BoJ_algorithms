import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static long M;
    static int[][] meat;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //소분한 고기의 개수
        M = Long.parseLong(st.nextToken()); //필요한 고기의 양

        meat = new int[N][2];

        //가격의 무게와 합은 2,147,483,647을 넘지 않음
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            meat[i][0] = Integer.parseInt(st.nextToken()); //무게
            meat[i][1] = Integer.parseInt(st.nextToken()); //가격
        }

        Arrays.sort(meat, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o2[0] - o1[0];
            } else {
                return o1[1] - o2[1];
            }
        });

        Search();

    }


    private static void Search() {
        int result = -1;
        int min = Integer.MAX_VALUE;
        int sum = 0; //고기 무게
        boolean flag = false;

        for (int i = 0; i < N; i++) {
            sum += meat[i][0];

            if (i > 0 && meat[i - 1][1] == meat[i][1]) { //이전 항목과 같은 가격이면 사야함
                result += meat[i][1];
            } else { //가격이 다르면 가격 이전의 항목들 공짜로 구입 가능
                result = meat[i][1];
            }

            if (sum >= M) {
                min = Math.min(result, min);
                flag = true;

                min = Math.min(result, min);
            }

        }//for

        if (flag) {
            System.out.println(min);
        } else {
            System.out.println(-1);
        }

    }
}