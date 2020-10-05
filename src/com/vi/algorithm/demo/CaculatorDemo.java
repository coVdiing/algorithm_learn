package com.vi.algorithm.demo;

import com.vi.algorithm.stack.CalculateStack;

import java.math.BigDecimal;

//  加减乘除简单计算Demo,用栈实现的，不带括号多位浮点数加减乘除计算。
public class CaculatorDemo {
    public static void main(String[] args) {//  +22.2+44.5678
//        System.out.println(caculate("11*22*33*44*55-66-71+8+11"));
        System.out.println(caculate("11+22-33*44+55*66+77/5+88"));
    }

    //  计算简单的加减乘除，不对输入的表达式进行校验，假设输入的都是正确的格式
    private static double caculate(String expression) {
        //  用于遍历表达式的指针
        int index = 0;
        //  定义两个计算栈，一个用于存储操作数，一个用于存储操作符
        CalculateStack<String> numStack = new CalculateStack<>();
        CalculateStack<String> commandStack = new CalculateStack<>();
        while (index < expression.length()) {
            String current = expression.charAt(index) + "";
            // TO DO:扩展部分,如果碰到括号，用递归处理
            if (!CalculateStack.isCommand(current)) {
                String num = current;
                //  如果当前字符是操作数,需要继续往下遍历，直到碰到操作符，将这段时间遍历过的操作数拼成一个数字
                while (true) {
                    if (index == expression.length() - 1) {
                        //  防止越界
                        numStack.push(num);
                        break;
                    } else {
                        if (CalculateStack.isCommand(expression.charAt(index + 1) + "")) {
                            numStack.push(num);
                            break;
                        }
                        index++;
                        num = num + expression.charAt(index);
                    }
                }
            } else {
                //  当前字符是运算符
                if (commandStack.isEmpty()) {
                    //  如果操作符栈为空，直接存入
                    commandStack.push(current);
                } else {
                    //  如果不为空，需要判断当前操作符和栈顶操作符的优先级大小
                    if (CalculateStack.priority(current) <= CalculateStack.priority(commandStack.peek())) {
                        //  如果栈中的操作符优先级大于等于当前操作符，需要弹出这个操作符和数栈中两个操作数，完成计算后重新存入数栈
                        BigDecimal num1 = new BigDecimal(numStack.pop());
                        BigDecimal num2 = new BigDecimal(numStack.pop());
                        //  注意操作数的顺序，后弹出的应该在前面
                        double result = caculate(num2, num1, commandStack.pop());
                        //  将当前操作符压入栈
                        commandStack.push(current);
                        //  将结果压入数栈
                        numStack.push(result + "");
                    } else {
                        //  当前操作符优先级大于栈顶元素的，比如说*遇到+,可以直接压入栈中
                        commandStack.push(current);
                    }
                }
            }
            index++;
        }
        //  当操作符栈不为空,循环取出两个栈中的元素进行计算，需要判断操作符优先级，只有栈顶操作符优先级高于前一项时可以直接计算
        while (commandStack.peek() != null) {
            String currentCommand = commandStack.pop();
            if (commandStack.peek() != null) {
                String preCommand = commandStack.pop();
                //  判断当前两个操作符的优先级
                if (CalculateStack.priority(currentCommand) > CalculateStack.priority(preCommand)) {
                    BigDecimal num1 = new BigDecimal(numStack.pop());
                    BigDecimal num2 = new BigDecimal(numStack.pop());
                    //  注意操作数的顺序，后弹出的应该在前面
                    double result = caculate(num2, num1, currentCommand);
                    //  将结果压入数栈
                    numStack.push(result + "");
                } else {
                    //  需要弹出三个操作数n1,n2,n3,先对n2,n3进行precommand计算
                    BigDecimal num1 = new BigDecimal(numStack.pop());
                    BigDecimal num2 = new BigDecimal(numStack.pop());
                    BigDecimal num3 = new BigDecimal(numStack.pop());
                    double result = caculate(num3, num2, preCommand);
                    result = caculate(new BigDecimal(result), num1, currentCommand);
                    numStack.push(result + "");
                }
            } else {
                BigDecimal num1 = new BigDecimal(numStack.pop());
                BigDecimal num2 = new BigDecimal(numStack.pop());
                //  注意操作数的顺序，后弹出的应该在前面
                double result = caculate(num2, num1,currentCommand);
                //  将结果压入数栈
                numStack.push(result + "");
            }

        }
        //  最终操作数栈中应该只剩下一个数，弹出得到结果
        return Double.parseDouble(numStack.pop());
    }

    private static double caculate(BigDecimal num1, BigDecimal num2, String command) {
        if ("+".equals(command)) {
            return num1.add(num2).doubleValue();
        }
        if ("-".equals(command)) {
            return num1.subtract(num2).doubleValue();
        }
        if ("*".equals(command)) {
            return num1.multiply(num2).doubleValue();
        }
        if ("/".equals(command)) {
            return num1.divide(num2).doubleValue();
        }
        throw new RuntimeException("非法操作符");
    }
}
