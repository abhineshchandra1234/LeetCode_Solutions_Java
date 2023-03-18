/**
 * 1472. Design Browser History
 * 
 * approach-
 * we will solve this using object of double linked list
 * It will have attributes like next,prev and url.
 * 
 * BrowserHistory-
 * We will create a dll object using homepage url
 * 
 * visit-
 * we will create a temp node using the given url
 * then we link curr.next to temp and temp.prev to curr and move curr to its next.
 * Time - O(1)
 * Space - O(1)
 * 
 * back-
 * we will check prev is not equal to null and steps not equal to zero.
 * We do this as we can have 3 prev nodes but steps are 10
 * and keep moving curr to its prev
 * Finally return curr url.
 * Time - O(n)
 * 
 * forward-
 * we will follow same process as back but this time we will check for curr next
 * and move curr to its next.
 * Time - O(n)
 */
class BrowserHistory {

    class Node {
        Node next, prev;
        String url;

        Node(String url) {
            next = null;
            prev = null;
            this.url = url;
        }
    }

    Node curr;

    public BrowserHistory(String homepage) {
        curr = new Node(homepage);
    }
    
    public void visit(String url) {
        Node temp = new Node(url);
        curr.next = temp;
        temp.prev = curr;
        curr = curr.next;
    }
    
    public String back(int steps) {
        while(curr.prev!=null && steps-->0)
            curr = curr.prev;
        return curr.url;
    }
    
    public String forward(int steps) {
        while(curr.next!=null && steps-->0)
            curr = curr.next;
        return curr.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */