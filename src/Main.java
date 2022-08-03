// Java program for checking
// balanced brackets
import java.util.*;

public class Main {

    static String inputString(String message){
        boolean isValidInput;
        String output = "";
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                isValidInput = true;
                System.out.println(message);
                output = scanner.nextLine();
            }catch (Exception e){
                isValidInput = false;
                System.out.println("Неправильно сука");
            }
        }while (isValidInput == false);

        return output;
    }

    // function to check if brackets are balanced
    static boolean areBracketsBalanced(String expr)
    {
        Deque<Character> stack
                = new ArrayDeque<Character>();

        for (int i = 0; i < expr.length(); i++){
            char x = expr.charAt(i);
            if (x == '(' || x == '[' || x == '{'){
                stack.push(x);
                continue;
            }

            if (stack.isEmpty())
                return false;
            char check;
            switch (x) {
                case ')':
                    check = stack.pop();
                    if (check == '{' || check == '[')
                        return false;
                    break;

                case '}':
                    check = stack.pop();
                    if (check == '(' || check == '[')
                        return false;
                    break;

                case ']':
                    check = stack.pop();
                    if (check == '(' || check == '{')
                        return false;
                    break;
            }
        }
        return (stack.isEmpty());
    }

    public static void main(String[] args){

        String expr = inputString("Введите своё выражение:");
        if (areBracketsBalanced(expr))
            System.out.println("true ");
        else
            System.out.println("false");
    }
}
