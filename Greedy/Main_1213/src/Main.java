import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static String name;
    static int[] alpa;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        alpa = new int[26];
        name = br.readLine();

        for(int i=0; i<name.length(); i++){
            alpa[name.charAt(i) - 'A']++;
        }

        palindrome();


    }

    private static void palindrome() {
        sb = new StringBuilder();
        int odd = 0; //홀수의 개수
        int num = 0; //홀수 문자 저장

        for(int i=0; i<alpa.length; i++){
            if(alpa[i] % 2 != 0){
                odd ++;
                num =i;
            }
            //홀수의 개수가 2개 이상이라면 펠린드롬을 만들 수 없으므로 오류 출력
            if(odd >=2){
                System.out.println("I'm Sorry Hansoo");
                return;
            }
        }

        for(int i=0; i<alpa.length; i++){
            for(int j=0; j<alpa[i] / 2; j++){
                sb.append((char)(i+'A'));
            }
        }

        String result = sb.toString();

        if (odd == 1) {
            result +=(char)(num + 'A');
        }
        result += sb.reverse().toString();
        System.out.println(result);

    }

}