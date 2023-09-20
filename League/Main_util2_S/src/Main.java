import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K, len;
    static char[] Str;
    static HashSet<Character> hs = new HashSet<Character>();
    ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        hs.add(' '); //띄어쓰기 구분자

        N = Integer.parseInt(br.readLine()); //문자 구분자의 개수
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            hs.add(st.nextToken().charAt(0));
        }


        M = Integer.parseInt(br.readLine()); //숫자 구분자의 개수
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            hs.add(st.nextToken().charAt(0));
        }

        K = Integer.parseInt(br.readLine()); //병합자의 개수
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            char temp = st.nextToken().charAt(0);
            if (hs.contains(temp)) hs.remove(temp);
        }

        len = Integer.parseInt(br.readLine()); //기준 문자열 길이
        Str = new char[len];
        String str = br.readLine();

        for (int i = 0; i < len; i++) {
            Str[i] = str.charAt(i);
        }

        Slice();

    }

    private static void Slice() {
        StringBuilder sb = new StringBuilder();
        boolean flag = true;

        for (int i = 0; i < len; i++) {
            if (hs.contains(Str[i]) && flag) { //flag미사용시 출력형식 오류
                continue;
            } else if (hs.contains(Str[i])) { //hs에 구분자가 있다면 줄바꿈
                sb.append("\n");
                flag = true;
            } else {
                sb.append(Str[i]);
                flag = false;
            }
        }

        System.out.println(sb);

    }

}