package baek.silver.S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj17413 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        StringBuilder result = new StringBuilder();
        StringBuilder word = new StringBuilder();

        boolean isTag = false;

        for (int i = 0; i < line.length(); i++) {
            char currentChar = line.charAt(i);

            if (currentChar == '<') {
                result.append(word.reverse());
                word.setLength(0);

                isTag = true;
                result.append(currentChar);
            } else if (currentChar == '>') {
                isTag = false;
                result.append(currentChar);
            } else if (isTag) {
                result.append(currentChar);
            } else {
                if (currentChar == ' ') {
                    result.append(word.reverse());
                    word.setLength(0);
                    result.append(' ');
                } else {
                    word.append(currentChar);
                }
            }
        }

        if (word.length() > 0) {
            result.append(word.reverse());
        }

        System.out.println(result.toString());
    }
}