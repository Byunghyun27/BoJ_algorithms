import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//공유기 설치
public class Main {
    static int n,c;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); //집의 개수
        c = Integer.parseInt(st.nextToken()); //공유기의 개수

        arr = new int[n];


        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int result = Search(arr, c);

        System.out.println(result);


    }

    private static int Search(int[] arr, int c) {
        int min = 1;
        int max = arr[n-1];

        while(max >= min){
            int mid = (max + min)/2;

            int cnt =1; //공유기 한개는 먼저 설치하고 시작
            int position = 0; //공유기 설치 가능 위치

            for(int i=0; i<n; i++){
                if(arr[i] - arr[position] >= mid){
                    cnt++;
                    position = i;
                }
            } //for

            if(cnt < c){
                max = mid - 1; //최소 거리 줄임
            } else {
                min = mid + 1; //최소 거리 증가
            }

        }
        return min -1; //설치한 수 < 가지고 있는 수가 될때 종료 되기 때문에 최소 거리의 최대값을 위한 -1
    }

}