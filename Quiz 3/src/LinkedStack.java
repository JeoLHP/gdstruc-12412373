import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedStack {
    private LinkedList<Player> stack;

    public LinkedStack() {
        stack = new LinkedList<>();
    }

    public void push(Player player) {
        stack.push(player);
    }

    public Player pop() {
        return stack.pop();
    }



    public int size() {
        return stack.size();
    }

    public void printStack() {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.println("Printing stack:");
        ListIterator<Player> iterator = stack.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
