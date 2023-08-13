import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr;
    static long m;
    static int max = Integer.MIN_VALUE;
    static long ans =0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());//지방의 수
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        m = Long.parseLong(br.readLine()); //총 예산

        Arrays.sort(arr);

        Search();

        System.out.println(ans);
    }

    private static void Search() {
        long start = 0; //초기값
        long end = arr[n-1];

        while(end >= start){
            long mid = (start + end) /2; //상한액
            long sum =0;

            for(int i =0; i<n; i++){
                if(arr[i] > mid){ //상한액 보다 크면 상한액을 더해줌
                    sum += mid;
                } else { //상한액 보다 작다면 값 그대로 더해줌
                    sum += arr[i];
                }
            }

            if(sum > m){
                end = mid -1;
            } else {
                start = mid + 1;
            }
        }

        ans = end;
    }


}