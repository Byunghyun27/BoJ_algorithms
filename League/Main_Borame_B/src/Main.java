import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static long P;
    static int[] room;
    static int item =0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //기지의 수
        M = Integer.parseInt(st.nextToken()); //각 기지의 층수
        P = Long.parseLong(st.nextToken()); //김병장의 전투력

        int flag = 1;

        for(int i =0; i<N; i++){
            room = new int[M];

            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                room[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(room);

            flag = Fight();

            if(flag == 0) break;
            else {
                while(item>0){
                    item --;
                    P*=2;
                }

            }
        }

        System.out.println(flag);


    }

    private static int Fight() {
        for(int i =0; i<M; i++){
            if(room[i] == -1) item++;
            else{
                if(P >= room[i]) P += room[i];
                else{
                    while(item > 0){
                        item --;
                        P*=2;
                        if(P>=room[i]) break;
                    }
                    if(P >= room[i]) P+=room[i];
                    else{
                        return 0;
                    }
                }
            }
        }

        return 1;
    }

}