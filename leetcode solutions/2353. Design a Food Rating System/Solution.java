/**
 * 2353. Design a Food Rating System
 * 
 * Intuition
 * 
 * the following are evident in the questions
 * we can solve it using single loop, and foods[i], cuisines[i] and rating[i]
 * create a food obj.
 * From highestRated we know we need to create a cuisines map with sorted food
 * obj according to rating
 * Things get confusing for changeRating where we need to fetch food obj and
 * change rating. For this we will create a food map with food obj just to fetch
 * food obj according to food.
 * Once we have fetched the food obj we will update its ratings which will
 * update its rating at all places (fMap, cMap), and we will re-sort food obj by
 * removing and again adding to pq.
 * Instead of creating complicated map with many values we are using food obj to
 * simplify things.
 * we can use ordered set to sort food, have used priority queue to keep things
 * simple
 * 
 * Approach
 * Complexity
 * 
 * Time complexity:
 * 
 * FoodRatings - O(nlogn), we neeed to add food to cuisine map
 * and sort them
 * 
 * changeRating - O(logn), although rating for food obj changes in
 * O(1), we need to rearrange it in pq in cuisine map
 * 
 * highestRated - O(1), fetching top element of pq of cuisine map
 * 
 * Space complexity: O(n), two maps food & cuisine
 * 
 */
class FoodRatings {

    HashMap<String, PriorityQueue<Food>> cMap = new HashMap<>();
    HashMap<String, Food> fMap = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++) {

            // food obj
            Food curr = new Food(foods[i], cuisines[i], ratings[i]);

            // update cuisine map with cuisine key and empty pq
            cMap.putIfAbsent(cuisines[i], new PriorityQueue<>(
                    (a, b) -> b.rating == a.rating ? a.name.compareTo(b.name) : b.rating - a.rating));

            // update cuisine map with food obj
            PriorityQueue<Food> pq = cMap.get(cuisines[i]);
            pq.add(curr);

            // update food map with food obj
            fMap.put(foods[i], curr);
        }
    }

    public void changeRating(String food, int newRating) {

        // fetch food obj from fMap
        Food curr = fMap.get(food);

        // remove food obj from cMap
        PriorityQueue<Food> pq = cMap.get(curr.cuisine);
        pq.remove(curr);

        // update rating of food obj
        // food obj is updated for fMap & cMap
        curr.rating = newRating;
        // add food obj in pq again, to re-sort it
        pq.add(curr);
    }

    public String highestRated(String cuisine) {
        // simply fetch food with highest rating from cMap
        return cMap.get(cuisine).peek().name;
    }

    class Food {
        int rating;
        String name, cuisine;

        Food(String name, String cuisine, int rating) {
            this.name = name;
            this.rating = rating;
            this.cuisine = cuisine;
        }
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */