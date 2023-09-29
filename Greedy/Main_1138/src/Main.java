import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] line;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); //사람의 수

        LinkedList<Integer> q = new LinkedList<>();
        line = new int[N];

        //LinkedList 초기화 0~N까지
        for(int i =0; i<N; i++){
            q.add(i);
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            int people = Integer.parseInt(st.nextToken());
            int index = q.remove(people);
            line[index] = i;
        }

        for(int i : line){
            System.out.print(i + " ");
        }




    }
}