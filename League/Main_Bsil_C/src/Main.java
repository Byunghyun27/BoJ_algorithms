import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;

public class Main {
    static String str;
    static int yy, mm, dd;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();
        N = Integer.parseInt(br.readLine());

        String[] day =str.split("-");

        int yy = Integer.parseInt(day[0]);
        int mm = Integer.parseInt(day[1]);
        int dd = Integer.parseInt(day[2]);

        dd+=N;

        while(dd>30){
            mm++;
            dd-=30;
            if(mm > 12){
                mm =1;
                yy++;
            }
        }
        String newDateString = String.format("%04d-%02d-%02d", yy, mm, dd);

        System.out.println(newDateString);

    }
}