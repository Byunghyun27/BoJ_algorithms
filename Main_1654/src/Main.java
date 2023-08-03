import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n,k;
    static long ans =0;
    static long[] arr;
    static long max,min,mid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        //k>=1 && k<=10000 && k<=N
        k = Integer.parseInt(st.nextToken()); //가지고있는 랜선의 개수
        n = Integer.parseInt(st.nextToken()); //필요한 랜선의 개수
        arr = new long[k];

        max = 0;

        //가지고 있는 랜선의 길이 입력
        for(int i=0; i<k; i++){
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }



        ans = search(arr, n, max);
        System.out.println(ans);

    }
    public static long search(long[] arr, int n, long max){
        long mid = 0;
        long min = 1;

        while(max>=min){
            mid = (max+min)/2;
            long cnt =0;

            for(long num : arr){
                cnt += num/mid;
            }

            if(cnt < n){
                max = mid-1;
            } else {
                min = mid+1;
            }
        }
        return (max+min)/2;
    }

}