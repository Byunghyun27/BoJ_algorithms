import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long x,y,z;
    static long ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        x = Long.parseLong(st.nextToken()); //게임 횟수
        y = Long.parseLong (st.nextToken()); //이긴 게임
        z = 100 * y/x;

        Search();
        System.out.println(ans);
    }

    private static void Search() {
        /*
         * 1. 승률이 100%를 넘을 수 없기때문에 100이 최대값
         * 2. 전적에 패배가 있다면 몇번을 이기든 99%가 최대값
         */
        if(99<=z){
            ans = -1;
            return;
        } else {
            long start = 1;
            long end = x;

            while(start <= end){
                long mid = (start + end) /2;
                long win_par = (y + mid) * 100 /(x+mid);

                if(win_par > z){
                    ans = mid;
                    end = mid -1;
                } else {
                    start = mid +1;
                }


            }



        }





    }

}