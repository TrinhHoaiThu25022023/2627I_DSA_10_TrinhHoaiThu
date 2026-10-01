import java.util.Scanner;
import java.util.Stack;

public class Solution_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt(); // Nhập số lượng truy vấn

        Stack<Integer> stack1 = new Stack<>(); // Dùng để enqueue (thêm)
        Stack<Integer> stack2 = new Stack<>(); // Dùng để dequeue/print (lấy ra)

        for (int i = 0; i < q; i++) {
            int type = sc.nextInt(); // Loại thao tác (1, 2, hoặc 3)

            if (type == 1) {
                // Thao tác 1 x: Enqueue phần tử x vào cuối queue
                int x = sc.nextInt();
                stack1.push(x);
            } else {
                // Nếu stack2 rỗng, trút hết dữ liệu từ stack1 sang stack2 để đảo chiều
                if (stack2.isEmpty()) {
                    while (!stack1.isEmpty()) {
                        stack2.push(stack1.pop());
                    }
                }

                if (type == 2) {
                    // Thao tác 2: Dequeue (xóa phần tử ở đầu queue)
                    stack2.pop();
                } else if (type == 3) {
                    // Thao tác 3: In ra phần tử ở đầu queue (không xóa)
                    System.out.println(stack2.peek());
                }
            }
        }
        sc.close();
    }
}