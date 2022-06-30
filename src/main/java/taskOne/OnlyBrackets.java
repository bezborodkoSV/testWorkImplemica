package taskOne;

public class OnlyBrackets {

    //      checking for symbols of arithmetic operations
    private boolean chekArithmeticOperationSymbol(String arithmeticOperationSymbol) {
        final String[] str = {"/", "*", "+", "-"};
        for (int i = 0; i < str.length; i++) {
            if (arithmeticOperationSymbol.equals(str[i]) == true) {
                return true;
            }
        }
        return false;
    }

    //      checking parentheses in an equation
    private boolean chekParentheses(String parentheses) {
        final String[] strParentheses = {"(", ")", "[", "]", "{", "}"};
        for (int i = 0; i < strParentheses.length; i++) {
            if (parentheses.equals(strParentheses[i]) == true) {
                return true;
            }
        }
        return false;
    }


    public String noNumbersAndCharactersOnlyBrackets(String equation) {

//        boolean variable to check for end of equation
        boolean chekSim = false;
//        removing spaces in an equation
        equation = equation.replace(" ", "");
//        StringBuilder takes up less memory
        StringBuilder stringBuilder = new StringBuilder();
//        iterate over all symbols of the equation
        for (int i = 0; i < equation.length(); i++) {
            String s = String.valueOf(equation.charAt(i));

//            If they are parentheses, they are written to the string. If not, put the brackets in place of the numbers
            if (!chekParentheses(String.valueOf(equation.charAt(i)))) {

//                check for beginning or end of equation
                if (!chekArithmeticOperationSymbol(String.valueOf(equation.charAt(i))) && !chekSim) {
                    stringBuilder.insert(stringBuilder.length(), "(");
                    chekSim = true;
                }

                if (chekArithmeticOperationSymbol(String.valueOf(equation.charAt(i))) && chekSim) {
                    chekSim = false;
                    stringBuilder.insert(stringBuilder.length(), ")");
                }
            }
//            If they are parentheses, they are written to the string. If not, put the brackets in place of the numbers
            if (chekParentheses(String.valueOf(equation.charAt(i)))) {
                if (!chekSim) {
                    stringBuilder.insert(stringBuilder.length(), equation.charAt(i));
                }
                if (chekSim) {
                    stringBuilder.insert(stringBuilder.length(), ")");
                    stringBuilder.insert(stringBuilder.length(), equation.charAt(i));
                    chekSim = false;
                }
            }
        }
//        checking if an equation ends in parentheses
        if (!chekParentheses(String.valueOf(equation.charAt(equation.length() - 1)))) {
            stringBuilder.insert(stringBuilder.length(), ")");
        }

        equation = String.valueOf(stringBuilder);
        return equation;
    }
}
