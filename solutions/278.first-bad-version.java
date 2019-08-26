/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    private int minVersion = 0;
    private int maxVersion = -1;
    public int firstBadVersion(int n) {
        if (maxVersion < 0) {
            maxVersion = n; // idk, no way to get max otherwise
        }
  
        if (maxVersion == minVersion) {
            return (int)maxVersion;  
        }
        
        // To prevent overflow you can do min + (max - min)/2
        int mid = (int) minVersion + (maxVersion - minVersion) / 2;
        boolean bad = isBadVersion(mid);
        
        if (bad) {
            // Recurse on left
            maxVersion = mid;
        } else {
            // Recurse on right
            minVersion = mid + 1;
        }

        return firstBadVersion(n);
    }
}