import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class begin1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] hurt = new int[N][N];
        // 상처 입력
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                hurt[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(maxBandLen(hurt) * maxBandWid(hurt));
    }

    static int maxBandWid(int[][] hurt) {
        int max = 0;
        for (int i = 0; i < hurt.length; i++) {
            for (int j = 0; j < hurt.length; j++) {
                if (hurt[j][i] == 1) {
                    max = i + 1;
                }
            }
        }
        return max;
    }

    static int maxBandLen(int[][] hurt) {
        int max = 0;
        for (int i = 0; i < hurt.length; i++) {
            for (int j = 0; j < hurt.length; j++) {
                if (hurt[i][j] == 1) {
                    max = i + 1;
                }
            }
        }
        return max;
    }
}
