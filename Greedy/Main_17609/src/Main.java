import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//회문
public class Main {
    static int T;
    static StringBuilder ans = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine()); //문자열의 개수

        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            Search(str);
        }
        System.out.println(ans);
    }

    private static void Search(String str) {
        //회문이면 0, 유사 회문이면 1, 모두 아니면 2
        StringBuilder sb = new StringBuilder(str);

        String result = "2"; //(default) 회문이 아닌 경우

        if (str.equals(sb.reverse().toString())) { // 비교했을때 뒤집어서 일치하면 회문
            result = "0";
        } else {
            int left = 0;
            int right = str.length() - 1;

            while (left < right) {
                if (str.charAt(left) != str.charAt(right)) {
                    //왼, 오 하나씩 삭제 시작
                    StringBuilder del_left = new StringBuilder(str).deleteCharAt(left); //StringBuilder().deleteCharAt() 특정 인덱스의 한 문자만 삭제
                    StringBuilder del_right = new StringBuilder(str).deleteCharAt(right);
                    
                    //삭제했을때 .reverse()시킨것과 같다면 유사회문
                    if (del_left.toString().equals(del_left.reverse().toString()) ||
                            del_right.toString().equals(del_right.reverse().toString())) {

                        result = "1";
                    }

                    break;
                }
                left++;
                right--;

            }
        }
        ans.append(result + "\n");
    }
}