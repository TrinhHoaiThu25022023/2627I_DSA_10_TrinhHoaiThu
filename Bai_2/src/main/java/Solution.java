import java.util.Stack;
public class Solution {
    // tao mot stack de luu ngoac mo
    public static String inBalanced(String s){
        Stack<Character> stack = new Stack<>();
        // duyet qua tung ky tu trong chuoi s
        for (int i = 0; i<s.length(); i++) {
            char c = s.charAt(i);
            //neu ngoac mo thi day vao stack
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            // neu la ngoac dong
            else {
                // neu gap ngoac dong ma stack dang rong -> Khong can bang
                if (stack.isEmpty()) {
                    return "NO";
                }
                // lay ngoac mo tren dinh stack ra de so sanh
                char c1 = stack.pop();
                //kiem tra ngoac dong co khop khong
                if ((c == ')' && c1 != '(') || (c == ']' && c1 != '[') || (c == '}' && c1 != '{')) {
                    return "NO";

                }
            }
        }
        if (stack.isEmpty()){
            return "YES";
        } else {
            return "NO";
        }
    }
}
