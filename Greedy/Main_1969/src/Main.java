import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static String[] DNA;
    static int dis = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //DNA의 수
        M = Integer.parseInt(st.nextToken()); // 문자열의 길이

        DNA = new String[N];

        for (int i = 0; i < N; i++) {
            DNA[i] = br.readLine();
        }

        Hamming_Distance();

    }

    private static void Hamming_Distance() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int[] cnt = new int[4]; //A C G T

            for (int j = 0; j < N; j++) {
                char ch = DNA[j].charAt(i);

                if (ch == 'A') cnt[0]++;
                else if (ch == 'C') cnt[1]++;
                else if (ch == 'G') cnt[2]++;
                else cnt[3]++;
            }


            int index = 0;
            int max = 0;

            for (int k = 0; k < cnt.length; k++) {
                if(cnt[k] > max){
                    max = cnt[k];
                    index = k;
                }
            }

            if(index == 0) sb.append('A');
            else if(index ==1) sb.append('C');
            else if(index ==2) sb.append('G');
            else sb.append('T');

            dis += N - max; //N번째 문자열에서의 Distance는 N - alpa의 개수
        }//for_i

        System.out.println(sb);
        System.out.println(dis);

    }
}