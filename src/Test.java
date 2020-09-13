import java.util.PriorityQueue;

public class Test {


    private static Student student;

    private static Student student1;

    private static Student student2;


    static {
        student = new Student("tom", "");

        student1 = new Student("mac", "");

        student2 = new Student("xiaohong", "");

    }


    public static void main(String[] args) {


        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);


        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }

        for (int i = 0; i < 5; ++i) {
            System.out.println(i);
        }

    }
}
