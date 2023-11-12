import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//순회강연
class Schedule{
    int price;
    int day;


    public Schedule(int price, int day) {
        this.price = price;
        this.day = day;
    }

}

public class Main {
    static int N;

    static PriorityQueue<Schedule> pq = new PriorityQueue<>((o1, o2) -> {
        if (o1.price == o2.price) {
            return o2.day - o1.day;
        } else {
            return o2.price - o1.price;
        }
    });

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); //학자에게 대학에서 요청한 강연 수

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            pq.add(new Schedule(p, d));
        }

        Cycle();

    }

    private static void Cycle() {
        int sum = 0;

        boolean[] isCheck = new boolean[10001];

        while(!pq.isEmpty()){
            Schedule s = pq.poll();

            for(int i = s.day; i>0; i--){
                if(!isCheck[i]){
                    isCheck[i] = true;
                    sum += s.price;
                    break;
                }
            }
            System.out.println("[" + s.price +", " +s.day +"]");
        }

        System.out.println(sum);

    }

}