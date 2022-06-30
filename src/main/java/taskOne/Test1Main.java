package taskOne;

public class Test1Main {
    public static void main(String[] args) {
        OnlyBrackets onlyBrackets = new OnlyBrackets();
        System.out.println(onlyBrackets.noNumbersAndCharactersOnlyBrackets("[   [10]+1-1]"));
        System.out.println(onlyBrackets.noNumbersAndCharactersOnlyBrackets("20+(2)"));
    }
}
