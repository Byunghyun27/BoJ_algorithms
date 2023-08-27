import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int center = 15;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine()); // 용사의 수

        List<hero> hero_list = new ArrayList<>(); //용사 좌표 저장 리스트
        StringBuilder[] sb = new StringBuilder[n+1]; //용사 이동 경로 저장

        //초기화
        for(int i=0; i<n; i++){
            sb[i] = new StringBuilder();
        }

        //용사 좌표 저장
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) + 15;
            int y = Integer.parseInt(st.nextToken()) + 15;
            hero_list.add(new hero(x, y));
        }

        //용사 이동
        for(int i=0; i<hero_list.size(); i++){
            hero hr = hero_list.get(i);
            int x = hr.x;
            int y = hr.y;

            while(true){
                //(15,16) 도착시 골인
                if(x==center+1 && y ==center){
                    sb[i].append('A'); //(x-1.y)
                    break;
                }

                //상단 이동
                if(x<center && y >= x+1 && y<= 2* center -x){
                    y-=1;
                    sb[i].append('X');
                    continue;
                }

                //하단
                if(x>center && y>=2*center - x && y<=x-2){
                    y+=1;
                    sb[i].append('W');
                    continue;
                }

                //좌측
                if(y>=center && x>= 2*center - y +1 && x<=y+1){
                    x-=1;
                    sb[i].append('A');
                    continue;
                }
                //우측
                if(y<center && x>=y && x<= 2* center - y -1){
                    x+=1;
                    sb[i].append('D');
                }

            }//while

        System.out.println(sb[i].toString());

        }//for



    }
    static class hero{
        int x;
        int y;

        public hero(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}