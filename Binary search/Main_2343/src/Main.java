import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr  = new int[n];

        int start = 0;
        int end = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            start = Math.max(start ,arr[i]); //레슨의 최댓값 저장
            end += arr[i]; //모든 강의 시간의 합
        }

        int result = search(arr, start, end);

        System.out.println(result);
    }

    private static int search(int[] arr, int start, int end) {

        while(start<=end){
            int mid = (start + end) / 2;
            int sum = 0;
            int cnt = 0;

            for(int i=0; i<n; i++) {
                //현재 블루레이 저장불가, 새로운 블루레이 교체
                if(sum + arr[i] > mid){
                    cnt++;
                    sum =0;
                }
                sum = sum + arr[i];
            }
            if(sum != 0) cnt ++;
            if(cnt > m) start = mid +1;
            else end = mid -1;
        }
        return start;
    }//search


}