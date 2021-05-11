import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class JZOffer59 {

}

class MaxQueue {
    ArrayDeque<Integer> queue;
    ArrayDeque<Integer> maxQueue;
    public MaxQueue() {
        queue = new ArrayDeque<>();
        maxQueue = new ArrayDeque<>();
    }

    public int max_value() {
        if (queue.isEmpty())return -1;
        else return maxQueue.peek();
    }

    public void push_back(int value) {
        queue.add(value);
        if(value>maxQueue.peek()) {
            while(maxQueue.getLast()<value)
                maxQueue.removeLast();
        }
        maxQueue.add(value);
    }

    public int pop_front() {
        if(queue.isEmpty()) return -1;
        int result = queue.pop();
        if(result==maxQueue.peek())
            maxQueue.pop();
        return result;
    }
}

