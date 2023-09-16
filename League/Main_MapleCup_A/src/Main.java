import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,U,L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //문제해결 개수
        U = Integer.parseInt(st.nextToken()); //유니온 레벨
        L = Integer.parseInt(st.nextToken()); //최고레벨

        Check();
    }

    private static void Check() {
        if(N>=1000 && (U >=8000 || L >=260)){
            System.out.println("Very Good");
        } else if(N<1000){
            System.out.println("Bad");
        } else{
            System.out.println("Good");
        }


    }

}