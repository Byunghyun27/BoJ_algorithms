import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int W,H;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken()); //밑변 길이
        H = Integer.parseInt(st.nextToken()); //높이

        double ans =  (double)(W * H) / 2;

        System.out.printf("%.1f",ans);


    }
}