import java.util.*;

class Student {
    int id;
    String fname;
    double cgpa;

    Student(int id, String fname, double cgpa) {
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public double getCgpa() {
        return cgpa;
    }
}

class StudentComparator implements Comparator<Student> {

    public int compare(Student a, Student b) {

   
        if (a.getCgpa() != b.getCgpa()) {
            return Double.compare(b.getCgpa(), a.getCgpa());
        }

        int nameCompare = a.getFname().compareTo(b.getFname());
        if (nameCompare != 0) {
            return nameCompare;
        }

        return Integer.compare(a.getId(), b.getId());
    }
}

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            students.add(new Student(id, fname, cgpa));
        }

        Collections.sort(students, new StudentComparator());

        for (Student s : students) {
            System.out.println(s.getFname());
        }

        in.close();
    }
}
