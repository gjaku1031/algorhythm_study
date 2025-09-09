package baek.platinum.P5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

class bj14003 {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int[] tail = new int[N];
        int[] parent = new int[N];
        int[] tailIdx = new int[N];
        int length = 0;

        for (int i = 0; i < N; i++) {
            int num = arr[i];
            int pos = binarySearch(tail, length, num);
            
            tail[pos] = num;
            tailIdx[pos] = i;
            
            if (pos > 0) {
                parent[i] = tailIdx[pos - 1];
            } else {
                parent[i] = -1;
            }
            
            if (pos == length) {
                length++;
            }
        }

        System.out.println(length);
        
        Stack<Integer> lis = new Stack<>();
        int idx = tailIdx[length - 1];
        while (idx != -1) {
            lis.push(arr[idx]);
            idx = parent[idx];
        }
        
        StringBuilder sb = new StringBuilder();
        while (!lis.isEmpty()) {
            sb.append(lis.pop()).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
    
    static int binarySearch(int[] tail, int length, int num) {
        int left = 0;
        int right = length;
        
        while (left < right) {
            int mid = (left + right) / 2;
            if (tail[mid] < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}