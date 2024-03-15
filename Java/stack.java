import java.util.*;

class Solution {

    public static void main(String[] argh) {
        Scanner sc = new Scanner(System.in);

        // Process each input line
        while (sc.hasNext()) {
            // Create a stack to keep track of opening brackets
            Stack<Character> stack = new Stack<>();
            // Read the input string
            String input = sc.next();

            // Iterate through each character in the input string
            for (int i = 0; i < input.length(); i++) {
                // Check if the stack is not empty
                if (!stack.empty()) {
                    // Switch statement to handle closing brackets
                    switch (input.charAt(i)) {
                        case ']':
                            // If the current character is ']' and the top of the stack is '[', pop the stack
                            if (stack.peek() == '[') {
                                stack.pop();
                            }
                            break;
                        case '}':
                            // If the current character is '}' and the top of the stack is '{', pop the stack
                            if (stack.peek() == '{') {
                                stack.pop();
                            }
                            break;
                        case ')':
                            // If the current character is ')' and the top of the stack is '(', pop the stack
                            if (stack.peek() == '(') {
                                stack.pop();
                            }
                            break;
                        default:
                            // If the current character is an opening bracket, push it onto the stack
                            stack.push(input.charAt(i));
                    }
                } else {
                    // If the stack is empty, push the current character onto the stack
                    stack.push(input.charAt(i));
                }
            }
            
            // Print whether the stack is empty (balanced brackets)
            System.out.println(stack.isEmpty());
        }

        sc.close();
    }
}
