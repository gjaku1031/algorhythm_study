package 이승용.graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class bj14502 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] graph;
    static boolean[][] visited;
    static ArrayList<int[]> tmp = new ArrayList<>();; // 0인 위치 -> 안전지역 개수 세기
    static ArrayList<int[]> virus = new ArrayList<>();; // 바이러스 위치 -> Queue로 받으려다가 에잇 18!
    static Deque<int[]> queue;   // bfs에서 쓸 큐
    static Deque<Integer> btcQ;  // 백트래킹에서 쓸 큐
    static int[][] dir;  // 방향 배열

    static int N;  // 지도 세로
    static int M;  // 지도 가로
    static int min = 0;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        btcQ = new ArrayDeque<>();
        graph = new int[N][M];
        dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for(int i = 0 ; i < N ; i ++){
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; j ++){
                int n = Integer.parseInt(st1.nextToken());
                graph[i][j] = n;
                if(n == 0){
                    tmp.add(new int[]{i, j}); // 안전지역 일단 저장해두고, 몇 개나 막을지 생각해보려고 <-
                } else if (n == 2) {
                    virus.add(new int[]{i, j});  // 얘네는 고정되어 있어야 해서 그냥 가지고 있자...
                }
            }
        }
        btc(0);
        System.out.println(min);
    }
    public static void btc(int start){
        // 2인 애들만 따로 배열에 넣어두고 걔네 bfs 돌 때마다 Queue에다 넣어서 했어요
        // 개고수 ദ്ദി ( ᵔ ᗜ ᵔ ) 에바ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ
        if(btcQ.size() == 3){
            for(int i : btcQ){
                graph[tmp.get(i)[0]][tmp.get(i)[1]] = 1;
            }
            min = Math.max(bfs(graph, tmp.size() - 3), min);
            for(int i : btcQ){
                graph[tmp.get(i)[0]][tmp.get(i)[1]] = 0;
            }
            return;
        }
        for(int i = start; i < tmp.size() ; i ++){
            if(!btcQ.contains(i)){
                btcQ.push(i);
                btc(i + 1);
                btcQ.pop();
            }
        }
    }

    public static int bfs(int[][] grid, int safeZone){
        queue = new ArrayDeque<>();
        visited = new boolean[N][M];
        // virus들 Queue에 담아벌임
        for(int[] rc : virus){
            queue.add(rc);  // virus들을 Queue에 담기
            visited[rc[0]][rc[1]] = true;
        }

        while (!queue.isEmpty()){
            int[] cur = queue.remove();
            for(int[] dr : dir){
                int nr = cur[0] + dr[0];
                int nc = cur[1] + dr[1];
                if(isVal(nr, nc) && !visited[nr][nc] && grid[nr][nc] == 0){
                    visited[nr][nc] = true;
                    queue.add(new int[] {nr, nc});
                    safeZone -= 1;
                }
            }
        }
        return safeZone;
    }
    public static boolean isVal(int r, int c){
        return r >= 0 && c >= 0 && r < N && c < M;
    }
}
