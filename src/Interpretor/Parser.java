package Interpretor;

import java.util.ArrayDeque;
import java.util.Map;

public class Parser {
    private static Expr parseToken(String token, ArrayDeque<Expr> stack) {
        Expr left, right;
        switch(token) {
            case "+":
                // It's necessary to remove first the right operand from the stack
                right = stack.pop();
                // ...and then the left one
                left = stack.pop();
                return Expr.plus(left, right);
            case "-":
                right = stack.pop();
                left = stack.pop();
                return Expr.minus(left, right);
            default:
                return Expr.variable(token);
        }
    }
    public static Expr parse(String expression) {
        ArrayDeque<Expr> stack = new ArrayDeque<Expr>();
        for (String token : expression.split(" ")) {
            stack.push(parseToken(token, stack));
        }
        return stack.pop();
    }

    public static void main(final String[] args) {
        Expr expr = parse("w x z - + +");
        Map<String, Integer> context = Map.of("w", 5, "x", 10, "z", 42);
        int result = expr.interpret(context);
        System.out.println(result);        // -27
    }
}
