import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); //최장 스트릭 기간
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Strix();

    }

    private static void Strix() {
        int cnt = 0;
        int max = 0;
        for(int i=0; i<N; i++){
            if(arr[i] != 0){
                cnt ++;
                max = Math.max(cnt, max);
            } else if(arr[i] == 0) {
                max = Math.max(cnt, max);
                cnt = 0;
            }

        }//for

        System.out.println(max);

    }
}