/**
 * 2070. Most Beautiful Item for Each Query
 * 
 * - we can solve this problem by sorting
- we will sort items in ascending order, so that we can discard further items whose price is more
- we will sort queries in ascending order, alongwith its index, with same reason as above
- then we traverse queries, for each queries we will traverse all items
- and update maxBeauty with items beauty less than or equal to query
- then assign maxBeauty to its original index
- later return the ans

tc - O(nlogn), sorting items and queries
sc - O(logn), space for sorting
 */
class Solution {
    public:
        vector<int> maximumBeauty(vector<vector<int>>& items,
                                  vector<int>& queries) {
    
            vector<int> ans(queries.size());
            sort(items.begin(), items.end(),
                 [](vector<int>& a, vector<int>& b) { return a[0] < b[0]; });
    
            vector<vector<int>> qIdx(queries.size(), vector<int>(2));
    
            for (int i = 0; i < queries.size(); i++) {
                qIdx[i][0] = queries[i];
                qIdx[i][1] = i;
            }
    
            sort(qIdx.begin(), qIdx.end(),
                 [](vector<int>& a, vector<int>& b) { return a[0] < b[0]; });
    
            int itemIdx = 0;
            int maxBty = 0;
    
            for (int i = 0; i < queries.size(); i++) {
    
                int query = qIdx[i][0];
                int orgIdx = qIdx[i][1];
    
                while (itemIdx < items.size() && items[itemIdx][0] <= query) {
                    maxBty = max(maxBty, items[itemIdx][1]);
                    itemIdx++;
                }
    
                ans[orgIdx] = maxBty;
            }
            return ans;
        }
    };