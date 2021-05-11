import java.util.Stack;

public class JZOffer30 {
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public JZOffer30() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int num) {
        s1.push(num);

        if(s2.empty())
            s2.push(num);
        else if(s2.pop() >= num)
            s2.push(num);
    }

    public int min() {
        return s2.peek();
    }

    public int pop() {
        int top = s1.pop();
        if (s2.peek()==top)
            s2.pop();
        return top;
    }

    public int top() {
        return s1.peek();
    }
}
