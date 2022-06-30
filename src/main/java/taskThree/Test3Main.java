package taskThree;

public class Test3Main {
    public static void main(String[] args) {
        CalculateSumOfFactorial calculateSumOfFactorial = new CalculateSumOfFactorial();
        int sum= calculateSumOfFactorial.sumOfFactorial(10);
        int sum1=calculateSumOfFactorial.sumOfFactorial(0);

        System.out.println("sum all numbers of factorial results: "+calculateSumOfFactorial.sumOfFactorial(100));
        System.out.println("sum all numbers of factorial results: "+calculateSumOfFactorial.sumOfFactorial(10));
    }
}
