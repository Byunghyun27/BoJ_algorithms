import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, X;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //생활관의 수
        X =  Integer.parseInt(st.nextToken()); //분배의기준

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long sum = 0;

        for(int i =0; i<N; i++){
            sum += arr[i];
        }

        if(sum%X == 0){
            System.out.println(1);
        } else{
            System.out.println(0);
        }

    }
}