import javax.swing.plaf.basic.BasicButtonUI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int T;
    static boolean[] arr;
    static int max = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        arr = new boolean[max+1];

        //false : 소수
        //0과 1은 소수가 아니므로 제외
        arr[0] = arr[1] = true;

        //에라토스테네스의 체 = "소수가 되는 수의 배수를 지우면 남은 건 소수가 된다"
        for (int i = 2; i <= Math.sqrt(max); i++) {
            if (arr[i]) continue; //ture는 소수가 아니므로 넘어감

            for (int j = i * i; j <= max; j += i) { //소수의 배수는 소수를 약수로 가지기 때문에 제외처리
                arr[j] = true;
            }
        }


        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < T; i++) {
            int cnt = 0;
            int num = Integer.parseInt(br.readLine());

            for (int j = 2; j <= num / 2; j++) {
                if (!arr[j] && !arr[num - j]) {
                    cnt++;
                }
            }
            sb.append(cnt + "\n");
        }

        System.out.println(sb);
    }
}