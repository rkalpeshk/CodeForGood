import java.util.Stack;

public class GetInfixFromPostFix {
    public static void main(String[] args) {
        System.out.println(getInfix("123*4/5/+6-"));
    }
    static String getInfix(String exp) {
        Stack<String> s = new Stack<String>();

        for (int i = 0; i < exp.length(); i++) {
            if (isOperand(exp.charAt(i)))
                s.push(exp.charAt(i) + "");
            else
            {
                String op1 = s.peek();
                s.pop();
                String op2 = s.peek();
                s.pop();
                s.push( op2 + exp.charAt(i) + op1 );
            }
        }
        return s.peek();
    }

    static boolean isOperand(char x) {
        return (x >= 'a' && x <= 'z') ||
                (x >= 'A' && x <= 'Z')||
                Character.isDigit(x);
    }
}