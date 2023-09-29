import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int A,B,C;
    static Integer[] kcal;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); //토핑의 종류의 수

        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken()); //도우의 가격
        B = Integer.parseInt(st.nextToken()); //토핑의 가격
        C = Integer.parseInt(br.readLine()); //도우의 열량

        kcal = new Integer[N];

        for (int i = 0; i < N; i++) {
            kcal[i] = Integer.parseInt(br.readLine()); //각 토핑의 열량
        }

        Arrays.sort(kcal, (o1, o2) -> o2 - o1);

        Price();

    }

    private static void Price() {
        //토핑 0개의 경우 칼로리당 가격
        int ans = C / A;

        int price = A;
        int Kcal = C;

        for(int i=0; i<N; i++){
            price += B; //토핑의 가격을 더함
            Kcal += kcal[i]; //토핑 칼로리 +

            int temp = Kcal / price;

            if(ans > temp) break;
            else ans = temp;
        }

        System.out.println(ans);

    }
}