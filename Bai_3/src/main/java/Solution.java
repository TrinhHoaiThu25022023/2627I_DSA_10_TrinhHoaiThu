import java.util.Scanner;

public class Solution {

    // Thủ tục chèn phần tử cuối vào đúng vị trí và in trạng thái mảng tại mỗi bước[cite: 2]
    public static void insertIntoSorted(int[] arr) {
        int target = arr[arr.length - 1]; // Phần tử cần chèn (nằm ở cuối mảng)
        int i = arr.length - 2;          // Bắt đầu từ vị trí áp cuối

        // Dịch chuyển các phần tử lớn hơn target sang phải một vị trí
        while (i >= 0 && arr[i] > target) {
            arr[i + 1] = arr[i];
            printArray(arr); // In trạng thái mảng sau mỗi bước dịch chuyển[cite: 2]
            i--;
        }

        // Đặt target vào đúng vị trí tìm được
        arr[i + 1] = target;
        printArray(arr); // In trạng thái mảng sau khi chèn thành công[cite: 2]
    }

    // Thủ tục in mảng ra màn hình[cite: 2]
    public static void printArray(int[] ar) {
        for (int n : ar) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    // Hàm main nhập dữ liệu đầu vào[cite: 2]
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if (in.hasNextInt()) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            insertIntoSorted(arr);
        }
        in.close();
    }
}