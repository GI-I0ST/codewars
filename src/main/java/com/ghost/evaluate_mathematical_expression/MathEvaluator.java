package com.ghost.evaluate_mathematical_expression;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;

public class MathEvaluator {
    private static final Set<Character> OPERATORS = Set.of('-', '+', '*', '/');

    public static double calculate(String expression) {
        // Remove all whitespace for easier processing
        expression = expression.replaceAll("\\s+", "");
        return evaluateExpression(expression);
    }

    private static double evaluateExpression(String expression) {
        Deque<Double> values = new ArrayDeque<>();
        Deque<Character> operators = new ArrayDeque<>();

        int i = 0;
        while (i < expression.length()) {
            char ch = expression.charAt(i);

            // If current character is a number
            if (Character.isDigit(ch)) {
                String operand = parseOperand(expression, i);
                values.push(Double.parseDouble(operand));
                i += operand.length() - 1;
                computeHigherPrecedence(values, operators);
            }
            // Handle parentheses
            else if (ch == '(') {
                int j = findClosingParenthesis(expression, i);
                double nestedValue = evaluateExpression(expression.substring(i + 1, j));
                values.push(nestedValue);
                i = j;
                computeHigherPrecedence(values, operators);
            }

            // Handle operators
            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                if (isUnaryNegation(i, expression)) {
                    operators.push('~');
                } else {
                    operators.push(ch);
                }
            }
            i++;
        }

        // Evaluate the remaining operators in the stack
        while (!operators.isEmpty()) {
            double b = values.removeLast();
            double a = values.removeLast();
            values.addLast(applyOperator(operators.removeLast(), a, b));
        }

        // The final result is at the top of the values stack
        return values.pop();
    }

    private static void computeHigherPrecedence(Deque<Double> operands, Deque<Character> operators) {
        while (!operators.isEmpty() && hasHigherPrecedence(operators.peek())) {
            if (operators.peek() == '~') {
                operands.push(applyOperator(operators.pop(), operands.pop(), null));
            } else {
                operands.push(applyOperator(operators.pop(), operands.pop(), operands.pop()));
            }
        }
    }

    private static String parseOperand(String expression, int index) {
        StringBuilder number = new StringBuilder();
        while (index < expression.length() && (Character.isDigit(expression.charAt(index)) || expression.charAt(index) == '.')) {
            number.append(expression.charAt(index));
            index++;
        }
        return number.toString();
    }

    private static int findClosingParenthesis(String expression, int openIndex) {
        int counter = 0;
        for (int i = openIndex; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') counter++;
            if (expression.charAt(i) == ')') counter--;
            if (counter == 0) return i;
        }
        throw new IllegalArgumentException("No closing parenthesis found.");
    }

    private static boolean hasHigherPrecedence(char op) {
        return (op == '*' || op == '/' || op == '~');
    }

    private static double applyOperator(Character operator, Double b, Double a) {
        return switch (operator) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> a / b;
            case '~' -> -b;
            default -> throw new IllegalArgumentException("Unsupported operator: " + operator);
        };
    }

    private static boolean isUnaryNegation(int i, String expression) {
        if (expression.charAt(i) != '-') {
            return false;
        }

        return  (i == 0) || OPERATORS.contains(expression.charAt(i - 1));
    }
}
