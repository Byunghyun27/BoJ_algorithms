import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//알바생 강호
public class Main {
    static int N;
    static Integer[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 사람의 수
        arr = new Integer[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, (o1,o2) -> o2-o1);

        Price();

    }

    private static void Price() {
        long ans = 0;

        Queue<Long> list = new LinkedList<>();

        for (int i = 0; i <N; i++) {
            long sum = arr[i] - ((i+1) - 1);

            if(sum<=0){
                sum = 0;
            } else {
                list.add(sum);
            }
        }

        while(!list.isEmpty()){
            ans += list.poll();
        }

        System.out.println(ans);

    }
}