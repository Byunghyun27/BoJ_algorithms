import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static long Sx = 0, Sy = 0, Sxy = 0, Sxx = 0;
    static double a2, b2;
    static boolean isCheck;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine()); //데이터의 개수


        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Integer.parseInt(st.nextToken());
            long y = Integer.parseInt(st.nextToken());

            Sx += x; //xi의 합
            Sy += y; //yi의 합
            Sxx += (x * x); //xi^2의 합
            Sxy += (x * y); //xi * yi의 합
        }

        isCheck = false;


        if ((Sx * Sx) == n * Sxx) {
            isCheck = true;
        } else if ((Sx * Sx) != n * Sxx) {
            a2 = (double) ((n * Sxy) - (Sx * Sy)) / ((n * Sxx) - (Sx * Sx));
            b2 = (Sy - (a2 * Sx)) / n;
        }


        if (isCheck) {
            System.out.println("EZPZ");
        } else {
            System.out.println(a2 + " " + b2);
        }


    }
}