import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int T;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine()); //TC개수
        arr = new int[T];

        for (int Tc = 0; Tc < T; Tc++) {
            arr[Tc] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < T; i++) {
            if (arr[i] <= 25) {
                System.out.println("Case #" + (i + 1) + ": World Finals");
            } else if (arr[i] <= 1000) {
                System.out.println("Case #" + (i + 1) + ": Round 3");
            } else if (arr[i] <= 4500) {
                System.out.println("Case #" + (i + 1) + ": Round 2");
            } else{
                System.out.println("Case #" + (i + 1) + ": Round 1");
            }
        }

    }
}