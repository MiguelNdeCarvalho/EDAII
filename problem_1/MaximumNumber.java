package problem_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximumNumber{
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // Creates the buffer
        int higherNum = -2147483648;

        int numChildren =  Integer.parseInt(reader.readLine());
        if(numChildren < 1 || numChildren > 300000)
        {
            System.exit(1);
        }
        
        for (int i = 0; i < numChildren; i++) {
            String readLine = reader.readLine();

            String[] lineNums = readLine.split(" ");
            int currentNum;

            for (int j = 1; j < Integer.parseInt(lineNums[0]) + 1; j++) {
                currentNum=Integer.parseInt(lineNums[j]);
                if (currentNum > higherNum)
                    higherNum = currentNum;
            }
        }
        System.out.println(higherNum);
    }
}