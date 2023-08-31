public class Calculator {

   
    public double addition(double... numbers) {
        double sum = 0;
        for (double number : numbers) {
            sum += number;
        }
        return sum;
    }

    
    public double subtraction(double... numbers) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("You must enter at least one number.");
        }
        double result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result -= numbers[i];
        }
        return result;
    }

    
    public double multiplication(double... numbers) {
        double product = 1;
        for (double number : numbers) {
            product *= number;
        }
        return product;
    }

   
    public double division(double... numbers) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("You must enter at least one number.");
        }
        double result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                throw new ArithmeticException("Cannot divide 0.");
            }
            result /= numbers[i];
        }
        return result;
    }

}
