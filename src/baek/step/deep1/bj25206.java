package baek.step.deep1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj25206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double totalSub = 0;
        double sum = 0;
        for (int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            double grade = Double.parseDouble(st.nextToken());
            String score = st.nextToken();
            if (i == 20) {
                System.out.println(str);
            }

            if (score.equals("P")) {
                continue;
            }
            totalSub += grade;
            sum += strToDouble(score) * grade;
        }
        System.out.println(sum / totalSub);
    }

    enum Score {
        A_PLUS(4.5), A0(4), B_PLUS(3.5), B0(3), C_PLUS(2.5), C0(2), D_PLUS(1.5), D0(1), F(0);

        final double grd;

        Score(double grd) {
            this.grd = grd;
        }

        public double getScore() {
            return grd;
        }
    }

    static double strToDouble(String string) {
        String newStr = "";
        if (string.length() > 1) {
            newStr = string.replace("+", "_PLUS");
        } else {
            newStr = string;
        }
        Score grade = Score.valueOf(newStr);
        return grade.getScore();
    }
}
