import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int t;
    static int[] A;
    static int[] B;
    static int n,m;
    static int ans;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            A = new int[n];
            B = new int[m];

            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                A[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                B[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(B);
            
            Search();

            System.out.println(ans);
        }




    }

    private static void Search() {
        int result = 0;

        for(int i=0; i<n; i++){ //그룹 A의 index만큼 반복
            int start = 0; //시작값
            int end = m-1; //종료값
            int cnt =0; //그룹 개수 저장 변수

            while(start <= end){
                int mid = (start + end) /2;

                if(B[mid] < A[i]){
                    start = mid + 1;
                    cnt = start;
                } else{
                    end = mid -1;
                }
            }
            result += cnt;
        }

        ans = result;

    }


}