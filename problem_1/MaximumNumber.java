import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaximumNumber
{
    public static void main(String[] args) throws IOException
    {
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // Creates the buffer
        int i=0;
        List<Integer> highestNums = new ArrayList<>();

        int numChildren =  Integer.parseInt(reader.readLine());
        if(numChildren < 1 || numChildren > 300000)
        {
            System.exit(1);
        }

        while(i < numChildren) {
            String readLine = reader.readLine();
            if(readLine.length() < 0 &&  readLine.length()> 10)
                System.exit(1);

            String[] lineNums = readLine.split(" ");
            int[] childrenNums = new int[10];

            int j=0;
            for(String num: lineNums)
            {
                childrenNums[j]=Integer.parseInt(num);
                j++;
            }


            highestNums.add(Arrays.stream(childrenNums).max().getAsInt());
            i++;
        }
        System.out.println(Collections.max(highestNums));
    }
}