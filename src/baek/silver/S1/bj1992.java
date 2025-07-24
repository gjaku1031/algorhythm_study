import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj1992 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] arr;
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = (int) line.charAt(j) - 48;
            }
        }
        recur(0, 0, N);
        System.out.println(sb.toString());
    }

    static void recur(int r, int c, int n) {
        if (all_zero(r, c, n)) {
            sb.append(0);
            return;
        } 
        else if (all_one(r, c, n)) {
            sb.append(1);
            return;
        }

        sb.append("(");
        
        int half = n / 2;
        recur(r, c, half);        
        recur(r, c + half, half);       
        recur(r + half, c, half);    
        recur(r + half, c + half, half); 
        
        sb.append(")");
    }

    static boolean all_zero(int r, int c, int n) {
        for (int i = r; i < r + n; i++) {
            for (int j = c; j < c + n; j++) {
                if (arr[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean all_one(int r, int c, int n) {
        for (int i = r; i < r + n; i++) {
            for (int j = c; j < c + n; j++) {
                if (arr[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
