import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Town implements Comparable<Town>{
    int city;
    int people;

    Town(int city, int people) {
        this.city = city;
        this.people = people;
    }

    @Override
    public int compareTo(Town o) {
        return this.city - o.city;
    }
}

public class Main {
    static int N;
    static ArrayList<Town> list = new ArrayList<>();
    static long total = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int po = Integer.parseInt(st.nextToken()); //마을 위치
            int cnt = Integer.parseInt(st.nextToken()); //사람 수

            total += cnt;
            list.add(new Town(po, cnt));
        }

        Collections.sort(list);

        Search(list);

    }
    //이진탐색
    private static void Search(ArrayList<Town> list) {
        long sum = 0;

        for(Town t : list){
            sum += t.people;

            if(sum >= (total+1) /2 ){ //총 인구수의 가장 가까운 마을에 우체국 설치
                System.out.println(t.city);
                break;
            }
        }


    }
}