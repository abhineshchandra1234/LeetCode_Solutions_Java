/**
 * 1396. Design Underground System
 * 
 * Intuition
 * credits hiepit
 * question provides checkIn and checkOut details of the passenger.
 * We need to return the getAverageTime of a particular route which will be
 * equal to sum of all trips times by diff passengers/ total trips.
 * We need to have a route object with attributes total time and total trips.
 * Do identify route object we will use checkInStation+ "," + checkOutStation as
 * key bcs it is created at checkout.
 * We need to have a passenger check in object with attributes checkInStation,
 * checkInTime.
 * Do identify passenger check in object we will use passenger id as key.
 * We need to update route object with the help of passenger check in object
 * during check out time.
 * In getAverageTime we can simply return total time/ total trip.
 * 
 * Complexity
 * Time complexity:
 * O(1), add, remove, search in hashmap happens in O(1) time. king of data
 * structure :)
 * 
 * Space complexity:
 * 
 * O(n)
 */
class UndergroundSystem {
    // Passenger - {checkInStation, checkInTime}
    Map<Integer, Pair<String, Integer>> checkInMap;
    // RouteName - {totalTime, count}
    Map<String, Pair<Double, Integer>> routeMap;

    public UndergroundSystem() {
        checkInMap = new HashMap();
        routeMap = new HashMap();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new Pair(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> checkIn = checkInMap.get(id);
        checkInMap.remove(id);

        String routeName = checkIn.getKey() + "_" + stationName;
        int totalTime = t - checkIn.getValue();

        Pair<Double, Integer> route = routeMap.getOrDefault(routeName, new Pair(0.0, 0));
        routeMap.put(routeName, new Pair(route.getKey() + totalTime, route.getValue() + 1));
    }

    public double getAverageTime(String startStation, String endStation) {
        String routeName = startStation + "_" + endStation;
        Pair<Double, Integer> trip = routeMap.get(routeName);
        return trip.getKey() / trip.getValue();
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */