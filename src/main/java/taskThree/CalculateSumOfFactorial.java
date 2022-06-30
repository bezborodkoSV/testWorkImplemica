package taskThree;

import java.math.BigInteger;



public class CalculateSumOfFactorial {

    public int sumOfFactorial(int number){
        System.out.println("numb: " + number);
       int sum=0;
//       big numbers we cant save in int or lont. Then we use BigInteger for save
        BigInteger fact= new BigInteger(String.valueOf(1));

//        В задании не сказано про отлавливание ошибок. Факториал отрицательного числа не существует, так что выкидываю результат 0
        if (number<0){
            return 0;
        }

        if (number!=0) {
            for (int i = 1; i <= number; i++) {
                fact = fact.multiply(BigInteger.valueOf(i));
                System.out.println(fact);
            }
        }


//       convert factorial to string for take all numbers from our result
       String stringResultFactorial = String.valueOf(fact);

//take all symbol from string one by one (convert string format to Integer) and sum they;
       for (int i=0;i<stringResultFactorial.length();i++){
// convert Integer to int happens automatically
           sum+=Integer.parseInt(String.valueOf(stringResultFactorial.charAt(i)));
       }
        return sum;
    }
}
