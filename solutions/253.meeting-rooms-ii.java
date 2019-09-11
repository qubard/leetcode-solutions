class Solution {
    public int minMeetingRooms(int[][] intervals) {
        ArrayList<int[]> intervals_ = new ArrayList<>();
        
        for (int[] i: intervals) {
            intervals_.add(i);
        }
        
        if (intervals_.isEmpty()) return 0;
        
        Collections.sort(intervals_, (a, b) -> { 
            return a[0] - b[0];
        });
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for (int[] i : intervals_) {
            // start time > end time of min heap
            if (!pq.isEmpty() && i[0] >= pq.peek()[1]) {
                pq.poll();
            }
            pq.add(i);
        }
        
        return pq.size();   
    }
}

// We look at the smallest end time and we see if we can add our room
// on that layer and then expand it (by removing the smallest and replacing it)
// Otherwise, we just add it and make a new layer since it must overlap with the
// smallest

/*

My initial solution:

class Interval {
        public boolean arriving;
        public int time;
        public Interval(boolean arriving, int time) {
            this.arriving = arriving;
            this.time = time;
        }
    }
    public int minMeetingRooms(int[][] intervals) {
        ArrayList<Interval> intervals_ = new ArrayList<>();
        
        HashMap<Integer, Integer> dep = new HashMap<>();
        for (int[] i: intervals) {
            intervals_.add(new Interval(true, i[0]));
            intervals_.add(new Interval(false, i[1]));
            dep.put(i[1], dep.getOrDefault(i[1], 0) + 1);
        }
        
        Collections.sort(intervals_, (a, b) -> { 
            return a.time - b.time;
        });
        
        // Remove duplicate intervals..
        int in = 0;
        int sol = 0;
        int last = -1;
        for (Interval interval : intervals_) {
            // Process departures first
            if (last != interval.time && dep.containsKey(interval.time)) {
                in -= dep.get(interval.time);
            }
            last = interval.time;
            if (interval.arriving) {
                in++;
                sol = Math.max(in, sol);
            }
        }
        // You can also use a min heap to do this
        return sol;   
    }
    
*/