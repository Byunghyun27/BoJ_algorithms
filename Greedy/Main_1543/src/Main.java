import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//문서 검색
public class Main {
    static String name;
    static String keyword;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        name = br.readLine(); //문서
        keyword = br.readLine(); //검색하고 싶은 단어

        while(name.length() > 0){

            if(name.startsWith(keyword)){ //startsWith(), 특정 문자로 시작하는지 판별
                ans++;
                name = name.substring(keyword.length());
            } else{
                name = name.substring(1); //한개 자르기
            }

        }

        System.out.println(ans);

    }
}