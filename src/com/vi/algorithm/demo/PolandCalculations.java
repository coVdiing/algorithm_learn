package com.vi.algorithm.demo;

import com.vi.algorithm.stack.CalculateStack;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//  波兰表达式计算(后缀表达式)
public class PolandCalculations {
    public static void main(String[] args) { // 1+(2*3)+4
        String expression  = infixToSuffix("3.1+4.2*5.6-4.6");
        System.out.println(expression);
        System.out.println("计算的结果是:"+calculate(expression));
    }

    //  多位正浮点数计算
    public static float calculate(String expression) {
        // (30+4)*5-6 -> 30 4 + 5 * 6 -
        String[] target = expression.split(" ");
        List<String> strings = Arrays.asList(target);
        Stack<String> numberStack = new Stack<>();
        for (String str : strings) {
            if (str.matches("[\\+\\-\\*\\/]")) {
                //  如果是运算符，从数栈中弹出两个数进行计算
                BigDecimal num2 = new BigDecimal(numberStack.pop());
                BigDecimal num1 = new BigDecimal(numberStack.pop());
                float result = calculate(num1, num2, str);
                //  把计算出的结果压入数栈
                numberStack.push(result + "");
            } else {
                //  如果是运算符，压入数栈
                numberStack.push(str);
            }
        }
        return Float.parseFloat(numberStack.pop());
    }

    private static float calculate(BigDecimal num1, BigDecimal num2, String str) {
        if ("+".equals(str))
            return num1.add(num2).floatValue();
        if ("-".equals(str))
            return num1.subtract(num2).floatValue();
        if ("*".equals(str))
            return num1.multiply(num2).floatValue();
        if ("/".equals(str))
            return num1.divide(num2).floatValue();
        throw new RuntimeException("非法的操作符");
    }

    /**
     * 中缀表达式转后缀表达式，假设输入的中缀表达式都是符合规范的
     * 思路:
     * 1.准备两个栈，一个s1存操作符，另一个s2存处理以后的表达式
     * 2.遍历中序表达式，遇到数，压入s2栈,遇到操作符进行判断，如果s1为空，直接压入s1,如果不为空，判断是否"(","("直接压入
     * 3.判断是否")"，如果是，弹出s1中的元素，依次压入s1栈，直至遇到"(",将"("弹出
     * 4.如果不是以上情况，则判断当前运算符的优先级是否高于栈顶运算符的优先级，如果高于栈顶，把当前运算符压入s1，如果低于栈顶，把栈顶弹出压入s2,依次和新栈顶继续比较
     * 5.遍历结束，把s1元素弹出依次压入s2,倒序输出s2元素，即转换后的后缀表达式
     *
     * @param infixExpression
     * @return
     */
    private static String infixToSuffix(String infixExpression) {
        //  把字符串表达式转换成列表
        int index = 0;
        ArrayList<String> list = new ArrayList<>();
        //  把运算符存进列表
        while (index < infixExpression.length()) {
            if (infixExpression.substring(index, index + 1).matches("[()\\+\\-\\*\\/]")) {
                list.add(infixExpression.substring(index, index + 1));
            } else {
                //  把操作数存进列表
                String num = infixExpression.substring(index, index + 1);
                while (index != infixExpression.length() - 1 && !infixExpression.substring(index + 1, index + 2).matches("[()\\+\\-\\*\\/]")) {
                    index++;
                    num = num + infixExpression.substring(index, index + 1);
                }
                list.add(num);
            }
            index++;
        }
        //  准备一个栈存放运算符
        CalculateStack<String> stack = new CalculateStack<>();
        //  准备一个列表存放结果
        ArrayList<String> result = new ArrayList<>();
        //  顺序遍历集合
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).matches("[()\\+\\-\\*\\/]")) {
                //  如果不是运算符，直接存入result
                result.add(list.get(i));
            } else {
                //  如果是运算符
                if (stack.isEmpty()) {
                    //  栈为空，直接压入
                    stack.push(list.get(i));
                } else if ("(".equals(list.get(i))) {
                    //  如果是左括号，直接压入
                    stack.push(list.get(i));
                } else if (")".equals(list.get(i))) {
                    //  如果是右括号，弹出栈顶元素直到"("
                    while (!"(".equals(stack.peek())) {
                        result.add(stack.pop());
                    }
                    stack.pop();
                } else {
                    //  判断运算符优先级
                    if (CalculateStack.priority(list.get(i)) > CalculateStack.priority(stack.peek())) {
                        stack.push(list.get(i));
                    } else {
                        while (!stack.isEmpty() && CalculateStack.priority(stack.peek()) >= CalculateStack.priority(list.get(i))) {
                            result.add(stack.pop());
                        }
                        stack.push(list.get(i));
                    }
                }
            }
        }
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        //  把列表转成字符串
        final String[] str = {""};
        result.forEach(ele -> {
            str[0] = str[0] + ele +" ";
        });
        return str[0].substring(0,str[0].length()-1);
    }
}
