import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int A, B;
    static int K, X;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken()); //브실이가 푼 문제의 개수
        X = Integer.parseInt(st.nextToken()); //문제수 차이가 X보다 작거나 같은 경우

        int cnt = 0;
        for (int i = A; i <= B; i++) {
            if (Math.abs(i - K) <= X) {
                cnt++;
            }
        }

        if(cnt == 0){
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(cnt);
        }

    }
}