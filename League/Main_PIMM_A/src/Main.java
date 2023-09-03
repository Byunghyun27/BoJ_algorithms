import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//학점 계산 프로그램
public class Main {
    static String s;
    static int cnt;
    static double score;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        s = br.readLine();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(ch == '+'){
                score+=0.5;
            } else {
                grade(ch);
                cnt++;
            }
        }

        System.out.println((double) score/ cnt);

    }

    private static void grade(char ch) {
        switch (ch) {
            case 'A':
                score += 4.0;
                break;
            case 'B':
                score += 3.0;
                break;
            case 'C':
                score += 2.0;
                break;
            case 'D':
                score += 1.0;
                break;
            case 'F':
                score += 0;
                break;
        }


    }


}