package baek.gold.G3;

import java.io.*;
import java.util.*;


public class bj7579 {
    
    static int n,m;
    static int[][] dp;
    static int[] w;
    static int[] c;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        dp = new int[n+1][10001];
        w = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++) {
            w[i] = Integer.parseInt(st.nextToken());
        }
        
        c = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++) {
            c[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i=1;i<=n;i++) {
            for (int c=1;c<=10000;++c)
                dp[i][c] = dp[i-1][c];
            
            for (int cost=c[i];cost<=10000;cost++)
                dp[i][cost] = Math.max(dp[i][cost], dp[i-1][cost-c[i]] + w[i]);

        }
        
        for(int i=0;i<=10000;i++) {
            if(dp[n][i]>=m) {
                System.out.println(i);
                return;
            }
        }
    }
}