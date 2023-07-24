import java.io.*;
import java.util.*;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int[] dx = {0,1,0,-1};
  static int[] dy = {1,0,-1,0};
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;


    for(int i =0; i<3; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<3; j++) {
        String s = st.nextToken();

        if(s.equals("0")) {
          sb.append("9");
        } else {
          sb.append(s);
        }
      }
    }


    System.out.println(bfs());


  }

  private static int bfs() {

    Queue<String> Q = new LinkedList<>();
    Map<String, Integer> map = new HashMap<>();

    Q.add(sb.toString());
    map.put(sb.toString(), 0);

    while(!Q.isEmpty()) {
      String now = Q.poll();

      //저장값이 123596478 일경우 9의 index는 5,
      int zeroindex = now.indexOf("9"); //문자열에서 9의 index값을 반환
      int x = zeroindex /3; //5/3 = 1, 1행을 의미
      int y = zeroindex %3; //5 %3 =2, 2열을 의미

      for(int i=0; i<4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];


        if(nx<3 && ny <3 && nx>=0 && ny>=0) {
          StringBuilder next = new StringBuilder(now);
          int move = nx*3 + ny;//이동하기 위한 상하좌우의 1차원 배열에서의 인덱스
          char temp = next.charAt(move);

          next.setCharAt(move,'9'); //이동할 인덱스에 9 저장
          next.setCharAt(zeroindex, temp); //원래 9 자리에 이동한 곳의 수 저장

          String nextstr = next.toString();

          if(!map.containsKey(nextstr)) {
            Q.offer(nextstr);
            map.put(nextstr, map.get(now)+1);
          }
        }
      }
    }

    if(map.containsKey("123456789")) {
      return map.get("123456789");
    } else {
      return -1;
    }

  }//bfs

}