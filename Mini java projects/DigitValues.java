import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DigitValues {
    public void find_digits() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("enter a number\n");
        String input = reader.readLine();
        reader.close();
        int number = Integer.parseInt(input);
        System.out.println("input :" + input);
        System.out.println("data type: " + input.getClass().getSimpleName());
        System.out.println("changed data type: int");
        System.out.println("\n");
        System.out.println("value is: " + number + "\n\n");

        int counter = 1;
        int tmp1 = -1;
        int tmp2 = -1;
        int digit = 0;
        while (true){
            if (counter >= 1){
                tmp2 = tmp1;
            }
            tmp1 =  number%((int) Math.pow(10, counter));
            counter = counter + 1;

            if (tmp1 == tmp2 && number - tmp2 == 0){
                break;
            }
            digit = digit + 1;
        }

        int value = 0;
        for (int i = 1; i <= digit; i++){
            value = number % ((int) Math.pow(10, i));
            tmp1 = number % ((int) Math.pow(10, i-1));
            if (i != 1){
                value = (value / ((int) Math.pow(10, i - 1)) ) % 10;
            }
            
            System.out.println("decimal place: " + i);
            System.out.println("value: " + value +"\n");
            
        }
    }

}
