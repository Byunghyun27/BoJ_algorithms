import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String str;
    static int result = 0;
    static final char[] DKSH = new char[]{'D', 'K', 'S', 'H'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();

        int index = 0;
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == DKSH[index]) {
                if (index == 3) {
                    result++;
                    index = 0;
                } else {
                    index++;
                }
            } else if (ch == 'D') {
                index = 1;
            } else {
                index = 0;
            }
        }

        System.out.println(result);

    }
}