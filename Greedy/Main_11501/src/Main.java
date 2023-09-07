import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

//주식
public class Main {
    static int T;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int TC = 0; TC < T; TC++) {
            int n = Integer.parseInt(br.readLine());
            arr = new int[n];


            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Stock(arr, n);


        }

    }

    /*
    1. 주식 하나를 산다.
    2  원하는 만큼 가지고 있는 주식을 판다.
    3. 아무것도 안한다.
     */

    private static void Stock(int[] arr, int day) {
        int sum = 0; //주식으로 얻는 이익의 합
        int max = 0;

        for (int i = day - 1; i >= 0; i--) {
            if (arr[i] > max) {
                max = arr[i]; //주가 갱신
            } else {
                sum += max - arr[i]; //현재 주가가 작거나 크다는 것은 오늘이 가장 비싸게 팔 수 있는 날
            }

        }
        System.out.println(sum);
    }
}