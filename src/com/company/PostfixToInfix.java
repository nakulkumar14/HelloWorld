package com.company;

import java.util.Set;
import java.util.Stack;

public class PostfixToInfix {
  void convert(String expr) {
    Stack<String> s = new Stack<>();
    Set<Character> operators = Set.of('+', '-', '/', '*');
    for (char c : expr.toCharArray()) {
      if (!Character.isLetter(c)) {
        String expr2 = s.pop();
        String expr1 = s.pop();

        if (expr1.length() > 1 && (c == '+' || c == '-' || c == '*' || c == '/')) {
          if (expr1.contains("*") || expr1.contains("/")) {
            expr1 = "(" + expr1 + ")";
          }
        }
        if (expr2.length() > 1 && (c == '+' || c == '-' || c == '*' || c == '/')) {
          if (expr2.contains("*") || expr2.contains("/")) {
            expr2 = "(" + expr2 + ")";
          }
        }

        s.push(expr1 + c + expr2);
      } else {
        s.push(String.valueOf(c));
      }
    }

    System.out.println(s.pop());
  }

  public static void main(String[] args) {
    PostfixToInfix postfixToInfix = new PostfixToInfix();
    String expr = "ab*c+";
    postfixToInfix.convert(expr);

    expr = "abc++";
    postfixToInfix.convert(expr);

    // 2 + 3 + 1 - 6
    expr = "ab+cd-+";
    postfixToInfix.convert(expr);

    expr = "ab*cd+-";
    postfixToInfix.convert(expr);

    expr = "ab*cd/-";
    postfixToInfix.convert(expr);

    // 10*5/5/5
    expr = "ab*cd//";
    postfixToInfix.convert(expr);

    expr = "ab*cd*e-/";
    postfixToInfix.convert(expr);
  }
}
