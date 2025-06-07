package baek.silver;

public class bj4673 {
    static int[] arr = new int[10001];
    public static void main(String[] args) {
        for (int i = 1; i <= 100000; i++) {
            selfNum(i);
        }

        for (int i = 1; i <= 10000; i++) {
            if (arr[i] == 0) {
                System.out.println(i);
            }
        }
    }

    static void selfNum(int n) {
        String num = Integer.toString(n);
        int sum = n;
        for (int i = 0; i < num.length(); i++) {
            sum += Integer.parseInt(Character.toString(num.charAt(i)));
        }
        if (sum <= 10000) {
            arr[sum] = 1;
        }
    }
}
