import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> firstLine = new Stack<>();
        Stack<Integer> waitingLine = new Stack<>();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 줄세우기
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            firstLine.push(value);
        }

        // result 조건
        if (Dokidoki(firstLine, waitingLine)) {
            System.out.println("Nice");
        } else {
            System.out.println("Sad");
        }
    }


    private static boolean Dokidoki(Stack<Integer> firstLine, Stack<Integer> waitingLine) {
        int size = firstLine.size();
        for (int i = 1; i <= size; i++) {
            if (!waitingLine.isEmpty()) {
                if (waitingLine.peek() == i) {
                    waitingLine.pop();
                    System.out.println("firstLine = " + firstLine);
                    System.out.println("waitingLine = " + waitingLine);
                } else {
                    DokiModule(i, firstLine, waitingLine);
                    System.out.println("firstLine = " + firstLine);
                    System.out.println("waitingLine = " + waitingLine);
                }
            } else {
                DokiModule(i, firstLine, waitingLine);
                System.out.println("firstLine = " + firstLine);
                System.out.println("waitingLine = " + waitingLine);
            }
        }

        return (waitingLine.isEmpty() && firstLine.isEmpty());
    }

    private static void DokiModule(int i, Stack<Integer> firstLine, Stack<Integer> waitingLine) {
        // firstLine 에서 번호 맞으면 나감
        if (firstLine.peek() == i) {
            firstLine.pop();
        // 아니면 기다리러 감
        } else {
            waitingLine.push(firstLine.pop());
        }
    }
}