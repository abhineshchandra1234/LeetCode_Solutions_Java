/**
 * 950. Reveal Cards In Increasing Order
 * 
 * Intuition
 * 
 * This question is difficult to understand, it is very tricky
 * we want cards to be revelead in increasing order
 * we can do this by first sorting the nos
 * Then placing the no with a gap of 1 index between them
 * As according to the question first no will be popped and second will be sent
 * at the back
 * we can do above operation using index and queue
 * First we will add all indices to queue
 * Then we will pop first index and add curr card to that index in res
 * Then we will pop the second index and add it to back of queue
 * we do this till length of the deck to get the res
 * then third index will be popped and curr card will be added, this way there
 * is a gap of 1 index between all cards as required by the question.
 * fourth index will be added to the back of queue for further computation.
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(nlogn), sorting
 * 
 * Space complexity: O(n)
 * 
 */
class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {

        int n = deck.length;
        Arrays.sort(deck);
        Queue<Integer> q = new LinkedList();

        for (int i = 0; i < n; i++)
            q.add(i);

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[q.poll()] = deck[i];
            q.add(q.poll());
        }

        return res;
    }
}