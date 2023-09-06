import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//걷기
public class Main {
    static long x, y, w, s;
    static int time = 0;
    static long cost1, cost2, cost3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        x = Long.parseLong(st.nextToken());
        y = Long.parseLong(st.nextToken());
        w = Long.parseLong(st.nextToken()); //걸어서 한 블록 가는데 걸리는 시간
        s = Long.parseLong(st.nextToken()); //대각선으로 한 블록을 가로지르는 시간

        Move();
    }

    private static void Move() {
        //1. 수평으로만 이동하는경우
        cost1 = (x + y) * w;

        /*
        2. 대각선 이동
        2 -1. 홀수일 경우 대각선 이동 후 수평 이동 1칸
        2 -2. 짝수일 경우 대각선으로만 이동 가능
         */
        if ((x + y) % 2 == 0) cost2 = Math.max(x, y) * s;
        else cost2 = (Math.max(x, y) - 1) * s + w;

        //3. 대각선 + 수평의 경우 대각선으로 최대한 이동 후 수평 이동
        cost3 = (Math.min(x, y) * s) + (Math.abs(x - y) * w);

        long result = Math.min(Math.min(cost1, cost2), cost3);
        System.out.println(result);
    }

}