import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int k;
    static String[] arr;
    static boolean[] isCheck = new boolean[10];
    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        k = Integer.parseInt(br.readLine());
        arr = new String[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            arr[i] = st.nextToken();
        }

        for (int i = 0; i <= 9; i++) {
            isCheck[i] = true;
            dfs(i, 0, i + "");
        }

        System.out.println(list.get(list.size()-1));
        System.out.println(list.get(0));

    }

    private static void dfs(int index, int cnt, String str) {
        if (cnt == k) {
            list.add(str);
        } else {
            for (int i = 0; i <= 9; i++) {
                if (isCheck[i]) continue;

                if (arr[cnt].equals("<")) {
                    if (index >= i) continue;
                } else {
                    if (index <= i) continue;
                }

                isCheck[i] = true;
                dfs(i, cnt + 1, str + i);
            }//for
        }
        isCheck[index] = false;
    }

}