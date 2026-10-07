import java.util.Comparator;

class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student x, Student y) {
        // 1. So sánh Điểm (CGPA) giảm dần (càng cao càng tốt)
        if (Double.compare(y.getCgpa(), x.getCgpa()) != 0) {
            return Double.compare(y.getCgpa(), x.getCgpa());
        }

        // 2. Nếu CGPA bằng nhau, so sánh Tên (fname) tăng dần (alphabet)
        int nameCompare = x.getFname().compareTo(y.getFname());
        if (nameCompare != 0) {
            return nameCompare;
        }

        // 3. Nếu Tên cũng bằng nhau, so sánh Mã (id) tăng dần (càng nhỏ càng tốt)
        return Integer.compare(x.getId(), y.getId());
    }
}