import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//나무 자르기
public class Main {
    static int n;
    static long m;
    static long[] arr;
    static long max = Long.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); //가져갈려는 나무의 수
        m = Long.parseLong(st.nextToken()); //나무의 길이
        arr = new long[n];


        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        long result = search(arr, m, max);

        System.out.println(result);
        
    }

    private static long search(long[] arr, long m, long max) {
        long min =0;

        while(max > min) {
            long mid = (max + min)/2;
            long cnt =0;

            for(long i : arr){
                if(i - mid > 0){
                    cnt += i - mid;
                }
            }

            if(cnt < m){ //자른 나무 합이 m보다 작음 >> 높이가 높다는 의미로 높이를 낮춰야함 > 상한을 줄여야함
                max = mid; 
            } else{ //자른 나무 길이의 합이 m보다 큼 >> 자른 높이가 낮으므로 높이 상승
                min = mid + 1;
            }
        }


        return min -1;

    }//search


}