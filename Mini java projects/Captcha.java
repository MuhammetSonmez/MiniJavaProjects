import java.util.Random;
import java.util.Scanner;

public class CaptchaWithThread {
    
    public boolean run() {
        int num1;
        int num2;
        int answer;
        long start_time = System.currentTimeMillis();
        long current_time;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Solve the CAPTCHA within 30 seconds.");
            for(int i = 0; i < 2; i ++){

                
                Random rng = new Random();
                num1 = rng.nextInt(100);
                num2 = rng.nextInt(100);
                
                System.out.println(num1 +"+"+num2);
                answer = scanner.nextInt();
                current_time = System.currentTimeMillis();
                System.out.println((((current_time - start_time)-30000) / 1000) * -1 + " seconds left.");
                if ((answer != num1 + num2) || ((current_time - start_time) >= 30000)){
                    
                    System.out.println("CAPTCHA is incorrect!");
                    return false;
                }
            }
        }
        System.out.println("CAPTCHA is correct!");

        return true;

    }
}
