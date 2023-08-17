import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine()); //수열의 크기
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Search();

        System.out.println(list.size());

    }

    private static void Search() {
        for (int i = 0; i < n; i++) {
            if (list.size() == 0 || list.get(list.size() - 1) < arr[i]) { //list값이 없거나, 리스트 마지막보다 큰 값일 경우 리스트에 추가
                list.add(arr[i]);
            } else { //작다면 이분탐색으로 치환 위치 찾음
                int start = 0;
                int end = list.size() - 1;

                while (start < end) {
                    int mid = (start + end) / 2;

                    if (list.get(mid) < arr[i]) {
                        start = mid + 1;
                    } else {
                        end = mid;
                    }

                } //while

                list.set(end, arr[i]); //end위치의 값을 arr[i]로 치환
            }
        }
    }


}