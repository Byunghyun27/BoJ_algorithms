import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] line;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); //대기 명단
        m = Integer.parseInt(st.nextToken()); //친구가 선 대기 번호
        line = new int[n];


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            line[i] = Integer.parseInt(st.nextToken());
        }


        HashSet<Integer> hs = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            hs.add(Integer.parseInt(st.nextToken()));
        }


        int cnt = 0;

        //친구 대기 순위가 앞번이라면 바꿔줄 필요없음 
        for (int i = 0; i < m; i++) {
            if (hs.contains(line[i])) { //앞순번에 친구가 있다면 cnt 증가
                cnt++; 
            }
        }

        System.out.println(m - cnt); //총 친구 수에서 앞쪽에 서있는 사람 수 만큼 빼줌

    }
} 