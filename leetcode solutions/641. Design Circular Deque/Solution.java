/**
 * 641. Design Circular Deque
 * 
 * Intuition
 * we need to implement circular double-ended deque of fixed size k
 * we also need to implement its operations
 * we generally implement deque using linked list and its inbuilt methods
 * here we will also implement using linked list, but define our own methods
 * also we will have reference to front and rear of the linked list for
 * simplification or to reduce complexity
 * 
 * Approach
 * 
 * Complexity
 * Time complexity: O(1), as we already have reference to front and rear, rest
 * operations will take very less time
 * Space complexity: O(k), max k nodes will be present at a time
 */
class Node {

    int val;
    Node next;
    Node prev;

    public Node(int val, Node next, Node prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}

class MyCircularDeque {

    Node head;
    Node rear;
    int size;
    int capacity;

    public MyCircularDeque(int k) {
        size = 0;
        capacity = k;
    }

    boolean insertFront(int value) {
        if (isFull())
            return false;

        if (head == null) {
            // first element in the list
            head = new Node(value, null, null);
            rear = head;
        } else {
            // add new head in front
            Node newHead = new Node(value, head, null);
            head.prev = newHead;
            head = newHead;
        }
        size++;
        return true;
    }

    boolean insertLast(int value) {
        if (isFull())
            return false;

        if (head == null) {
            // first element in the list
            head = new Node(value, null, null);
            rear = head;
        } else {
            // add new head in last
            Node newHead = new Node(value, null, rear);
            rear.next = newHead;
            rear = rear.next;
        }
        size++;
        return true;
    }

    boolean deleteFront() {
        if (isEmpty())
            return false;
        if (size == 1) {
            head = null;
            rear = null;
        } else {
            head = head.next;
        }
        size--;
        return true;
    }

    boolean deleteLast() {
        if (isEmpty())
            return false;
        if (size == 1) {
            head = null;
            rear = null;
        } else {
            rear = rear.prev;
        }
        size--;
        return true;
    }

    int getFront() {
        if (isEmpty())
            return -1;
        return head.val;
    }

    int getRear() {
        if (isEmpty())
            return -1;
        return rear.val;
    }

    boolean isEmpty() {
        return size == 0;
    }

    boolean isFull() {
        return size == capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */