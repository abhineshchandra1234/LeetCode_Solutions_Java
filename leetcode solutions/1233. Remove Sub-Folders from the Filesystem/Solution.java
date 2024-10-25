/**
 * 1233. Remove Sub-Folders from the Filesystem
 * 
 * Intuition
 * As evident in the question we will solve this problem using set
 * first add all folders to set
 * then traverse each folder, and remove slash and its content one by one
 * If the subfolder doesnt exist, add subfolder to res. Else move to next
 * folder.
 * Approach
 * 
 * Complexity
 * Time complexity: O(n*l^2), we are traversing n strings, removing slash cost
 * l, taking substring cost l
 * Space complexity: O(n*l), we are storing n strings of l length in set
 */
class Solution {
    public List<String> removeSubfolders(String[] folder) {

        Set<String> folderSet = new HashSet(Arrays.asList(folder));
        List<String> res = new ArrayList();

        for (String f : folder) {
            boolean isSubFolder = false;
            String prefix = f;

            while (!prefix.isEmpty()) {
                int pos = prefix.lastIndexOf('/');
                if (pos == -1)
                    break;
                prefix = prefix.substring(0, pos);

                if (folderSet.contains(prefix)) {
                    isSubFolder = true;
                    break;
                }
            }

            if (!isSubFolder) {
                res.add(f);
            }
        }
        return res;
    }
}