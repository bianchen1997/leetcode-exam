import java.util.Stack;

public class StackTest {
    private Stack<Integer> tail;
    private Stack<Integer> head;

    public StackTest() {
        tail = new Stack<>();
        head = new Stack<>();
    }

    public void appendTail(int num) {
        tail.push(num);
    }

    public int deleteHead() {
        if (tail.empty() && head.empty()) return -1;

        while (!tail.empty())
            head.push(tail.pop());

        int result = head.pop();

        while(!head.empty())
            tail.push(head.pop());

        return result;
    }
}
