package problem_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TrocoX {
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
            // System.out.println(question + ": " + "[" + coins(question, coinArr) + "]");
            System.out.println(coins(question, coinArr));
        }
    }

    public static String coins(int value, int[] coinsArr)
    {
        int[] solutions = new int[value + 1];
        String[] solutionsCoin = new String[value +1];
        solutionsCoin[0] = "";
        solutions[0] = 0; // We need 0 coins for value 0
        Arrays.fill(solutions, 1, solutions.length,value+1);
        for (int i = 0; i < solutions.length; i++) {
            for (int j = 0; j < coinsArr.length; j++) {
                if (coinsArr[j] <= i){
                    int numberCoins = 1 + solutions[i- coinsArr[j]];
                    if (numberCoins <= solutions[i])
                    {
                        solutions[i] = numberCoins;
                        if (numberCoins == 1)
                            solutionsCoin[i] = String.valueOf(coinsArr[j]);
                        else
                            solutionsCoin[i] = solutionsCoin[i - coinsArr[j]] + " " + String.valueOf(coinsArr[j]);
                    }
                }
            }
        }
        
        // System.out.println(Arrays.toString(solutions));
        // System.out.println(Arrays.toString(solutionsCoin));

        return value + ": " + "[" + solutions[value] + "] " + solutionsCoin[value];
    }
}
