import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static int[] study;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); //계획하고 공부한 일수
        arr = new int[N];
        study = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            study[i] = Integer.parseInt(st.nextToken());
        }


        study_day();

    }

    private static void study_day() {
        int cnt = 0;

        for(int i=0; i<N; i++){
            if(study[i] >= arr[i]){
                cnt ++;
            }
        }

        System.out.println(cnt);
    }
}