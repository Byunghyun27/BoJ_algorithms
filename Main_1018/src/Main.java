import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//브루트포스
public class Main {
    static int n,m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        String[] board = new String[n];

        for(int i=0; i<n; i++){
            board[i] = br.readLine();
        }

        int sol = Integer.MAX_VALUE;

        for(int i=0; i<=n-8; i++){
            for(int j=0; j<=m-8; j++){
                int cursol = getSolution(i, j, board);

                if(sol > cursol){
                    sol = cursol;
                }
            }
        }

        
        System.out.println(sol);

    }

    private static int getSolution(int startrow, int startcol, String[] board) {
        String[] orgBorad = {"WBWBWBWB", "BWBWBWBW"};
        int whitesol = 0;

        for(int i=0; i<8; i++){
            int row = startrow + i;
            for(int j=0; j<8; j++){
                int col = startcol + j;

                if(board[row].charAt(col) != orgBorad[row%2].charAt(j)){
                    whitesol ++;
                }
            }
        }
        return Math.min(whitesol, 64 -whitesol);

    }
}