public class Main {
    public static void main(String[] args) {      
        
        DigitValues finder = new DigitValues();

        try{
            finder.find_digits();
        }catch(Exception e){
            System.out.println(e);
        }
        
        Calculator calculate = new Calculator();
        double sumResult = calculate.addition(5, 10, 15, 20);
        System.out.println(sumResult);

        double subtractResult = calculate.subtraction(100, 20, 5);
        System.out.println(subtractResult);

        double productResult =calculate.multiplication(2, 3, 4, 5);
        System.out.println(productResult);

        double divideResult =calculate.division(100, 4, 2);
        System.out.println(divideResult);
        
        
        
        WordGuessGame wordGuessGame = new WordGuessGame();
        wordGuessGame.run();
        

        
        WeatherApp weatherApp = new WeatherApp();
        weatherApp.get_status();
        

        
        Https https = new Https();
        https.request("https://google.com");
        https.get("https://google.com");
        https.post(null, null);
        

        
        WorkingWithFiles process = new WorkingWithFiles();
        process.writing_file("file.txt", "hi !!!");
        process.reading_file("file.txt");
        

    
         
        Ransomware ransomware = new Ransomware();
        ransomware.run();
        
        
        ProxyJavaScrapping proxy = new ProxyJavaScrapping();
        proxy.get_proxy("https://api.ipify.org");

        
        Captcha captcha = new Captcha();
        boolean auth = captcha.run();
        System.out.println("auth: " + auth);
        
    }
}
 
