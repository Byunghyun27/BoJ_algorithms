import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        Search();

    }

    private static void Search() {
        int start = 0; //왼쪽 값
        int end = n - 1; //오른쪽 값
        int left = 0;
        int right = 0;
        int diff = Integer.MAX_VALUE;

        while (start < end) {
            int sum = arr[start] + arr[end]; //두 용액의 합
            int temp = Math.abs(sum);
            /*
             * 1. int sum = Math.abs(arr[start] + arr[end]);를 사용하면 sum은 양수만 저장
             * 2. int sum = arr[start] + arr[end];
             *    int temp = Math.abs(sum);을 사용하면 음수도 값을 저장 가능, 즉 '2'의 경우 부호 그대로 저장 가능
             */

            if (diff > temp) { //두 용액의 합을 비교했을때 값이 더 적은 경우 값을 저장
                diff = temp;
                left = arr[start];
                right = arr[end];

                if (diff == 0) break;
            }

            if (sum > 0) { //0보다 크면 오른쪽 요소를 왼쪽으로 이동
                end--;
            } else { //0보다 작으면 왼쪽 요소를 오른쪽으로 이동
                start++;
            }
        }
        System.out.println(left + " " + right);
    }//Search


}