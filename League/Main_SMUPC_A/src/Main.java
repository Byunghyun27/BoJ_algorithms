import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static final char[] label = "WelcomeToSMUPC".toCharArray();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int temp = (N-1) % 14;

        System.out.println(label[temp]);

    }
}