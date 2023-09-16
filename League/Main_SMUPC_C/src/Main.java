import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<String> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            String str = st.nextToken();
            Moss(str);
        }
        System.out.println(sb);

    }

    private static void Moss(String str) {

        String[] output = new String[]{
                "A", "B", "C", "D", "E", "F", "G",
                "H", "I", "J", "K", "L", "M", "N",
                "O", "P", "Q", "R", "S", "T", "U",
                "V", "W", "X", "Y", "Z", "1", "2",
                "3", "4", "5", "6", "7", "8", "9",
                "0", ",", ".", "?", ":", "-", "@"};

        String[] Input = new String[]{
                ".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
                "....", "..", ".---", "-.-", ".-..", "--", "-.",
                "---", ".--.", "--.-", ".-.", "...", "-", "..-",
                "...-", ".--", "-..-", "-.--", "--..", ".----", "..---",
                "...--", "....-", ".....", "-....", "--...", "---..", "----.",
                "-----", "--..--", ".-.-.-", "..--..", "---...", "-....-", ".--.-."};

        for(int i=0; i<Input.length; i++){
            if(str.equals(Input[i])) {
                sb.append(output[i]);
            }
        }


    }
}