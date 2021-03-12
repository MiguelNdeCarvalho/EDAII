package problem_2;

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
        int aux = Integer.MAX_VALUE;
        int count = 0;
        if (value == 0)
        {
            return 1;
        }
        else if (value < 0)
        {
            return 0;
        }
        for (int i = 0; i < coinsArr.length; i++) {
            count += coins(value - coinsArr[i], coinsArr);
            if (count < aux)
                aux = count;
            count = 0;
        }
        return  aux + 1;
    }
}
