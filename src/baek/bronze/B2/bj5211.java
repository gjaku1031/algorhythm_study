package baek.bronze.B2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj5211 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String[] chords = input.split("\\|");

        int cMajorCount = 0;
        int aMinorCount = 0;

        for (String chord : chords) {
            if (chord.isEmpty()) {
                continue;
            }

            char firstNote = chord.charAt(0);
            if (firstNote == 'C' || firstNote == 'F' || firstNote == 'G') {
                cMajorCount++;
            } else if (firstNote == 'A' || firstNote == 'D' || firstNote == 'E') {
                aMinorCount++;
            }
        }

        if (cMajorCount > aMinorCount) {
            System.out.println("C-major");
        } else if (aMinorCount > cMajorCount) {
            System.out.println("A-minor");
        } else {
            char lastCharOfInput = input.charAt(input.length() - 1);

            if (lastCharOfInput == 'A' || lastCharOfInput == 'D' || lastCharOfInput == 'E') {
                System.out.println("A-minor");
            } else {
                System.out.println("C-major");
            }
        }
    }
}