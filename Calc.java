import java.util.*;
import java.io.*;
import java.lang.IndexOutOfBoundsException;

//Custon class forlogging
class Print {
    static void error(String text) {
        System.out.println("ERROR: " + text);
    }

    static void info(String text) {
        System.out.println("INFO: " + text);
    }

    static void welcomeMessage() {
        System.out.println("_______________");
        System.out.println("|             |");
        System.out.println("|   O     O   |");
        System.out.println("|             |");
        System.out.println("|      |      |");
        System.out.println("|    _____/   |");
        System.out.println("|_____________|");
        System.out.println("Hi,");
        System.out.println("Welcome to anville calculator. Please use only lower case characters");
        System.out.println("If you need help, please type 'help' ");
    }
}

class Calc {

    private static String getInput() {
        Console console = System.console();

        if (console == null) {
            Print.error("CONSOLE UNAVAILABLE!");
            return null;
        }

        String input = console.readLine();
        return input;
    }

    private static String shortenRatiosAndLog(String input) {
        Print.info("Trig ratios and log unshortened: " + input);
        System.out.println();
        StringBuilder builder = new StringBuilder(input);
        // cos^-1
        while (builder.indexOf("cos^-1") >= 0) {
            builder.setCharAt(builder.indexOf("cos^-1"), 'x');
            builder.delete(builder.indexOf("xos^-1") + 1, builder.indexOf("xos^-1") + 6);
        }
        // sin^-1
        while (builder.indexOf("sin^-1") >= 0) {
            builder.setCharAt(builder.indexOf("sin^-1"), 'y');
            builder.delete(builder.indexOf("yin^-1") + 1, builder.indexOf("yin^-1") + 6);
        }
        // tan^-1
        while (builder.indexOf("tan^-1") >= 0) {
            builder.setCharAt(builder.indexOf("tan^-1"), 'z');
            builder.delete(builder.indexOf("tan^-1") + 1, builder.indexOf("tan^-1") + 6);
        }
        // cosine
        while (builder.indexOf("cos") >= 0) {
            builder.delete(builder.indexOf("cos") + 1, builder.indexOf("cos") + 3);
        }
        while (builder.indexOf("cosine") >= 0) {
            builder.delete(builder.indexOf("cosine") + 1, builder.indexOf("cosine") + 6);
        }
        Print.info("replaced cosine, text now: " + builder.toString());
        System.out.println();
        // sine
        while (builder.indexOf("sin") >= 0) {
            builder.delete(builder.indexOf("sin") + 1, builder.indexOf("sin") + 3);
        }
        // sine
        while (builder.indexOf("sine") >= 0) {
            builder.delete(builder.indexOf("sine") + 1, builder.indexOf("sine") + 4);
        }
        // sinh
        while (builder.indexOf("sh") >= 0) {
            builder.setCharAt(builder.indexOf("sh"), 'S');
            builder.delete(builder.indexOf("Sh") + 1, builder.indexOf("Sh") + 2);
        }
        // cosh
        while (builder.indexOf("ch") >= 0) {
            builder.setCharAt(builder.indexOf("ch"), 'C');
            builder.delete(builder.indexOf("Ch") + 1, builder.indexOf("Ch") + 2);
        }
        // tanh
        while (builder.indexOf("th") >= 0) {
            builder.setCharAt(builder.indexOf("th"), 'T');
            builder.delete(builder.indexOf("Th") + 1, builder.indexOf("Th") + 2);
        }
        Print.info("replaced sine, text now: " + builder.toString());
        System.out.println();
        // tan
        while (builder.indexOf("tan") >= 0) {
            builder.delete(builder.indexOf("tan") + 1, builder.indexOf("tan") + 3);
        }
        // tan equation shortens tangent to tgent...
        while (builder.indexOf("tgent") >= 0) {
            builder.delete(builder.indexOf("tgent") + 1, builder.indexOf("tgent") + 5);
        }
        Print.info("replaced tangents, text now: " + builder.toString());
        System.out.println();
        // log
        while (builder.indexOf("log") >= 0) {
            builder.delete(builder.indexOf("log") + 1, builder.indexOf("log") + 3);
        }
        // log shortens logarithm to larithm
        while (builder.indexOf("larithm") >= 0) {
            builder.delete(builder.indexOf("larithm") + 1, builder.indexOf("larithm") + 7);
        }
        // antilog
        while (builder.indexOf("al") >= 0) {
            builder.setCharAt(builder.indexOf("al"), 'w');
            builder.delete(builder.indexOf("wl") + 1, builder.indexOf("wl") + 2);
        }
        // Natural logarithm
        while (builder.indexOf("ln") >= 0) {
            builder.setCharAt(builder.indexOf("ln"), 'L');
            builder.delete(builder.indexOf("Ln") + 1, builder.indexOf("Ln") + 2);
        }
        Print.info("replaced logarithms, text now: " + builder.toString());
        System.out.println();
        Print.info("Text after shortening trigonometric ratios and logarithms: " + builder.toString());
        System.out.println();
        return builder.toString();
    }

    private static void help() {
        System.out.println("Hi");
        System.out.println("For trigonometric ratios: ");
        System.out.println("       cosine -> type 'cos' or 'c' e.g. cos x, cosx, cos(x), cos(  x ) etcetera");
        System.out.println("       sine -> type 'sine', 'sin' or 's' e.g. sinex sine x sin(x) e.t.c...");
        System.out.println("       tangents -> type 'tan' or 't'");
        System.out.println();
        System.out.println("       inverse of cosine -> type 'cos^-1' or 'x'");
        System.out.println("       inverse of sine -> type 'sin^-1' or 'y' ");
        System.out.println("       inverse of tangents -> type 'tan^-1' or 'z'");
        System.out.println();
        System.out.println("       cosh -> type 'cosh' or 'C'");
        System.out.println("       sinh -> type 'sinh' or 'S'");
        System.out.println("       tanh -> type 'tanh' or 'T'");
        System.out.println();
        System.out.println();
        System.out.println("For Logarithms: ");
        System.out.println("       natural logarithms -> type 'ln' or 'L'");
        System.out.println("       logarithms to base 10 -> type 'log' or 'logarithm' or 'l'");
        System.out.println();
        System.out.println();
        System.out.println("For factroials,");
        System.out.println("       ! -> append '!' e.g. x! returns the factorial of x");
        System.out.println("       ");
        System.out.println("       ");
        System.out.println("EVERY OTHER CONVETIONTIONAL SIMPLE MATH OPERATORS WORK. THANKS FOR DOWNLOADING, BYE!");
        main();
    }

    private static boolean isValid(String input) {

        char[] array = input.toCharArray();
        for (int index = 0; index < input.length(); index++) {
            // Chacking for letters...
            if ((int) array[index] >= 65) {
                if (array[index] != 'c' && array[index] != 't' && array[index] != 's' && array[index] != 'l'
                        && array[index] != 'L' && array[index] != 'T' && array[index] != 'C' && array[index] != 'S'
                        && array[index] != '!' && array[index] != 'w' && array[index] != 'x' && array[index] != 'y'
                        && array[index] != 'z') {
                    Print.error("Illegal values present in expression: " + array[index]);
                    return false;
                }
            }
        }
        // Checking unclosed brackets
        StringBuilder builder = new StringBuilder(input);
        while (builder.indexOf("(") >= 0) {
            if (builder.lastIndexOf(")") < 0) {
                Print.error("Unclosed bracket present!");
                return false;
            }
            builder.deleteCharAt(builder.indexOf("("));
            builder.deleteCharAt(builder.lastIndexOf(")"));
        }
        // Checking unopened brackets
        while (builder.lastIndexOf(")") >= 0) {
            if (builder.indexOf("(") < 0) {
                Print.error("Unopened bracket is closed!");
                return false;
            }
            builder.deleteCharAt(builder.indexOf("("));
            builder.deleteCharAt(builder.lastIndexOf(")"));
        }
        Print.info("Text is valid");
        return true;
    }

    private static List<String> refineInput(String input) {
        if (input.contains(" ")) {
            input = removeSpaces(input);
        }
        input = shortenRatiosAndLog(input);
        List<Integer> operatorPositions = getOperatorPositions(input);
        List<String> expressionList = getExpressionList(operatorPositions, input);
        expressionList = removeEmptyElements(expressionList);
        return expressionList;
    }

    private static String removeSpaces(String input) {
        Print.info("Text before removing spaces: " + input);
        StringBuilder builder = new StringBuilder(input);
        while (builder.indexOf(" ") >= 0) {
            builder.deleteCharAt(builder.indexOf(" "));
        }
        Print.info("Text after removing spaces: " + builder.toString());
        System.out.println();
        return builder.toString();
    }

    private static List<Integer> getOperatorPositions(String input) {
        Print.info("Input length is: " + input.length());
        char[] array = input.toCharArray();
        List<Integer> positions = new ArrayList<Integer>();
        for (int i = 0; i < input.length(); i++) {
            if (((int) array[i] <= 47 || (int) array[i] >= 59) && (int) array[i] != 46) {
                positions.add(i);
            }
        }
        positions.forEach(r -> Print.info("operator: '" + input.substring(r, r + 1) + "' at postion: " + r));
        System.out.println();
        return positions;
    }

    private static List<String> getExpressionList(List<Integer> positions, String input) {
        List<String> output = new ArrayList<String>();
        output.add(input.substring(0, positions.get(0)));
        output.add(input.substring(positions.get(0), positions.get(0) + 1));
        for (int i = 1; i < positions.size(); i++) {
            output.add(input.substring(positions.get(i - 1) + 1, positions.get(i)));
            output.add(input.substring(positions.get(i), positions.get(i) + 1));
        }
        output.add(input.substring(positions.get(positions.size() - 1) + 1, input.length()));
        output.forEach(r -> Print.info("Processed expressionListElement: " + r));
        System.out.println();
        return output;
    }

    private static List<String> removeEmptyElements(List<String> list) {
        list.forEach(r -> Print.info("List elements before removing empty elements: " + r));
        System.out.println();
        while (list.contains("")) {
            list.remove("");
        }
        list.forEach(r -> Print.info("List elements after removing empty elements " + r));
        System.out.println();
        return list;
    }

    private static Double evaluateList(List<String> expressionList) {
        Print.info("BEFORE REMOVING BRACKETS");
        expressionList.forEach(r -> System.out.println("      " + r));
        System.out.println();
        while (expressionList.contains("(")) {
            int start = expressionList.lastIndexOf("(");
            int size = expressionList.size();
            int stop = start
                    + expressionList.subList(expressionList.lastIndexOf("("), expressionList.size()).indexOf(")");
            Print.info("SUBLIST IS: ");
            expressionList.subList(start + 1, stop).forEach(r -> System.out.println("       " + r));
            expressionList.set(start, String.valueOf(evaluate(expressionList.subList(start + 1, stop))));
            for (int index = start; index <= stop - (size - expressionList.size()); index++) {
                expressionList.remove(start + 1);
            }
        }
        Print.info("AFTER REMOVING BRACKETS");
        expressionList.forEach(r -> System.out.println("      " + r));
        System.out.println();
        Double result = evaluate(expressionList);
        return result;
    }

    private static Double evaluate(List<String> expressionList) {

        // logarithms
        while (expressionList.contains("L")) {
            String numString = expressionList.get(expressionList.indexOf("L") + 1);
            Double number = Double.valueOf(numString);
            expressionList.set(expressionList.indexOf("L") + 1, String.valueOf(Math.log(number)));
            expressionList.remove("L");
        }
        while (expressionList.contains("l")) {
            String numString = expressionList.get(expressionList.indexOf("l") + 1);
            Double number = Double.valueOf(numString);
            expressionList.set(expressionList.indexOf("l") + 1, String.valueOf(Math.log(number) / 2.302585093));
            expressionList.remove("l");
        }
        Print.info("After solving all logarithms! \nList elements are: ");
        expressionList.forEach(r -> Print.info("         " + r));
        System.out.println();
        // cosines
        while (expressionList.contains("c")) {
            String numString = expressionList.get(expressionList.indexOf("c") + 1);
            Double number = Double.valueOf(numString);
            expressionList.set(expressionList.indexOf("c") + 1, String.valueOf(Math.cos(number)));
            expressionList.remove("c");
        }
        Print.info("After solving all Cosines! \nList elements are: ");
        expressionList.forEach(r -> Print.info("         " + r));
        System.out.println();
        // sines
        while (expressionList.contains("s")) {
            String numString = expressionList.get(expressionList.indexOf("s") + 1);
            Double number = Double.valueOf(numString);
            expressionList.set(expressionList.indexOf("s") + 1, String.valueOf(Math.sin(number)));
            expressionList.remove("s");
        }
        Print.info("After solving all Sines! \nList elements are: ");
        expressionList.forEach(r -> Print.info("         " + r));
        System.out.println();
        // tangents
        while (expressionList.contains("t")) {
            String numString = expressionList.get(expressionList.indexOf("t") + 1);
            Double number = Double.valueOf(numString);
            expressionList.set(expressionList.indexOf("t") + 1, String.valueOf(Math.tan(number)));
            expressionList.remove("t");
        }
        Print.info("After solving all tangents! \nList elements are: ");
        expressionList.forEach(r -> Print.info("         " + r));
        System.out.println();
        // cosh
        while (expressionList.contains("C")) {
            String numString = expressionList.get(expressionList.indexOf("C") + 1);
            Double number = Double.valueOf(numString);
            expressionList.set(expressionList.indexOf("C") + 1, String.valueOf(Math.cosh(number)));
            expressionList.remove("C");
        }
        Print.info("After solving all cosh! \nList elements are: ");
        expressionList.forEach(r -> Print.info("         " + r));
        System.out.println();
        // sinh
        while (expressionList.contains("S")) {
            String numString = expressionList.get(expressionList.indexOf("S") + 1);
            Double number = Double.valueOf(numString);
            expressionList.set(expressionList.indexOf("S") + 1, String.valueOf(Math.sinh(number)));
            expressionList.remove("S");
        }
        Print.info("After solving all sinh! \nList elements are: ");
        expressionList.forEach(r -> Print.info("         " + r));
        System.out.println();
        // tanh
        while (expressionList.contains("T")) {
            String numString = expressionList.get(expressionList.indexOf("T") + 1);
            Double number = Double.valueOf(numString);
            expressionList.set(expressionList.indexOf("T") + 1, String.valueOf(Math.tanh(number)));
            expressionList.remove("T");
        }
        Print.info("After solving all tanh! \nList elements are: ");
        expressionList.forEach(r -> Print.info("         " + r));
        System.out.println();
        // cos-inverse
        while (expressionList.contains("x")) {
            String numString = expressionList.get(expressionList.indexOf("x") + 1);
            Double number = Double.valueOf(numString);
            expressionList.set(expressionList.indexOf("x") + 1, String.valueOf(Math.acos(number)));
            expressionList.remove("x");
        }
        Print.info("After solving all cos^-1! \nList elements are: ");
        expressionList.forEach(r -> Print.info("         " + r));
        System.out.println();
        // sin-inverse
        while (expressionList.contains("y")) {
            String numString = expressionList.get(expressionList.indexOf("y") + 1);
            Double number = Double.valueOf(numString);
            expressionList.set(expressionList.indexOf("y") + 1, String.valueOf(Math.asin(number)));
            expressionList.remove("y");
        }
        Print.info("After solving all sin^-1! \nList elements are: ");
        expressionList.forEach(r -> Print.info("         " + r));
        System.out.println();
        // tan-inverse
        while (expressionList.contains("z")) {
            String numString = expressionList.get(expressionList.indexOf("z") + 1);
            Double number = Double.valueOf(numString);
            expressionList.set(expressionList.indexOf("z") + 1, String.valueOf(Math.atan(number)));
            expressionList.remove("z");
        }
        Print.info("After solving all tan^-1! \nList elements are: ");
        expressionList.forEach(r -> Print.info("         " + r));
        System.out.println();
        // factorial
        while (expressionList.contains("!")) {
            String numString = expressionList.get(expressionList.indexOf("!") - 1);
            Integer number = Integer.valueOf(numString);
            expressionList.set(expressionList.indexOf("!") + 1, String.valueOf(factorial(number)));
            expressionList.remove("!");
        }
        Print.info("After solving all factorials! \nList elements are: ");
        expressionList.forEach(r -> Print.info("         " + r));
        System.out.println();
        // division
        while (expressionList.contains("/")) {
            int index = expressionList.indexOf("/");
            Double firstOperand = Double.valueOf(expressionList.get(index - 1));
            Double secondOperand = Double.valueOf(expressionList.get(index + 1));
            firstOperand = firstOperand / secondOperand;
            expressionList.set(index - 1, String.valueOf(firstOperand));
            expressionList.remove(index + 1);
            expressionList.remove("/");
        }
        Print.info("After solving all Divisions! \nList elements are: ");
        expressionList.forEach(r -> Print.info("         " + r));
        System.out.println();
        // multiplication
        while (expressionList.contains("*")) {
            int index = expressionList.indexOf("*");
            Double firstOperand = Double.valueOf(expressionList.get(index - 1));
            Double secondOperand = Double.valueOf(expressionList.get(index + 1));
            firstOperand = firstOperand * secondOperand;
            expressionList.set(index - 1, String.valueOf(firstOperand));
            expressionList.remove(index + 1);
            expressionList.remove("*");
        }
        Print.info("After solving all Multiplications! \nList elements are: ");
        expressionList.forEach(r -> Print.info("         " + r));
        System.out.println();
        Double result = 1.0;
        // Check for implicit multiplications e.g (90)(2) = 180
        for (int index = 1; index < expressionList.size(); index++) {
            if (isNumber(expressionList.get(index)) && isNumber(expressionList.get(index - 1))) {
                expressionList.set(index - 1, String.valueOf(
                        Double.valueOf(expressionList.get(index)) * Double.valueOf(expressionList.get(index - 1))));
                expressionList.remove(index);
            }
        }
        // addition
        while (expressionList.contains("+")) {
            int index = expressionList.indexOf("+");
            Double firstOperand = Double.valueOf(expressionList.get(index - 1));
            Double secondOperand = Double.valueOf(expressionList.get(index + 1));
            firstOperand = firstOperand + secondOperand;
            expressionList.set(index - 1, String.valueOf(firstOperand));
            expressionList.remove(index + 1);
            expressionList.remove("+");
        }
        Print.info("After solving all Additions! \nList elements are: ");
        expressionList.forEach(r -> Print.info("         " + r));
        System.out.println();
        // subtraction
        while (expressionList.contains("-")) {
            int index = expressionList.indexOf("-");
            Double firstOperand = Double.valueOf(expressionList.get(index - 1));
            Double secondOperand = Double.valueOf(expressionList.get(index + 1));
            firstOperand = firstOperand - secondOperand;
            expressionList.set(index - 1, String.valueOf(firstOperand));
            expressionList.remove(index + 1);
            expressionList.remove("-");
        }
        Print.info("After solving all subtractions! \nList elements are: ");
        expressionList.forEach(r -> Print.info("         " + r));
        if (expressionList.size() == 1) {
            Print.info("All done\nResult: " + String.valueOf(expressionList.get(0)));
            System.out.println();
            return Double.valueOf(expressionList.get(0));
        }
        Print.info("FINALLY, LIST IS: ");
        expressionList.forEach(e -> System.out.println(e));
        Print.info("All done!\nResult: " + String.valueOf(result));
        System.out.println();
        return result;

    }

    public static Integer factorial(Integer number) {
        if (number == 0) {
            return 1;
        }
        return number * factorial(number - 1);
    }

    private static boolean isNumber(String input) {
        try {
            Double number = Double.valueOf(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String... args) {
        Print.welcomeMessage();
        System.out.print("Please type expression: ");
        String expression = getInput();
        if (expression.equals("help")) {
            help();
        }
        while (!expression.equals("exit")) {
            List<String> expressionList = refineInput(expression);
            expression = new String();
            for (int index = 0; index < expressionList.size(); index++) {
                expression += expressionList.get(index);
            }
            Print.info("expression: " + expression);
            boolean valid = isValid(expression);
            if (!valid) {
                return;
            }
            Double result = evaluateList(expressionList);
            System.out.println("Your result is: " + String.valueOf(result));
            System.out.println();
            System.out.print("Expression: ");
            expression = getInput();

        }
        if (expression.equals("help")) {
            help();
        }
        System.out.println("Bye!\n Come back again...");
        System.exit(0);
    }
}