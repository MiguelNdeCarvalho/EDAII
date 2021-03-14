// package problem_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Troco {
    public static void main(String[] args) throws IOException
    {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int numCoins = Integer.parseInt(buffer.readLine());

        if (numCoins < 1 || numCoins > 100)
            System.exit(1);

        String coinRead = buffer.readLine();
        String[] coinSplit = coinRead.split(" ");
        int[] coinArr = new int[numCoins];

        for (int i = 0; i < coinSplit.length; i++) {
            coinArr[i] = Integer.parseInt(coinSplit[i]);
        }

        int numQuestions = Integer.parseInt(buffer.readLine());

        if (numCoins < 1 || numQuestions > 100)
            System.exit(1);

        for (int i = 0; i < numQuestions; i++) {
            int question = Integer.parseInt(buffer.readLine());
            System.out.println(question + ": " + "[" + coins(question, coinArr) + "]");
        }
    }

    public static int coins(int value, int[] coinsArr)
    {
        int[] solutions = new int[value + 1];
        solutions[0] = 0; // We need 0 coins for value 0
        Arrays.fill(solutions, 1, solutions.length,value+1);
        for (int i = 0; i < solutions.length; i++) {
            for (int j = 0; j < coinsArr.length; j++) {
                if (coinsArr[j] <= i)
                    solutions[i] = Math.min(1 + solutions[i- coinsArr[j]], solutions[i]);
            }
        }
        
        // System.out.println(Arrays.toString(solutions));

        return solutions[value];
    }
}
