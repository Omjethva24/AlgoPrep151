//Employee Free Time
//it is also in leetcode premium so i find this pro. from other website

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> mergedIntervals = mergeIntervals(schedule);
        return findFreeTimeIntervals(mergedIntervals);
    }

    private List<Interval> mergeIntervals(List<List<Interval>> schedule) {
        List<Interval> merged = new ArrayList<>();
        PriorityQueue<Interval> minHeap = new PriorityQueue<>((a, b) -> a.start - b.start);

        // Add all intervals from the schedule to the minHeap
        for (List<Interval> intervals : schedule) {
            minHeap.addAll(intervals);
        }

        Interval prev = minHeap.poll();
        while (!minHeap.isEmpty()) {
            Interval curr = minHeap.poll();
            if (prev.end < curr.start) {
                // Intervals don't overlap, add the gap
                merged.add(new Interval(prev.end, curr.start));
                prev = curr;
            } else {
                // Intervals overlap, merge them
                prev.end = Math.max(prev.end, curr.end);
            }
        }

        return merged;
    }

    private List<Interval> findFreeTimeIntervals(List<Interval> intervals) {
        List<Interval> freeTimeIntervals = new ArrayList<>();
        for (int i = 1; i < intervals.size(); i++) {
            Interval prev = intervals.get(i - 1);
            Interval curr = intervals.get(i);
            if (prev.end < curr.start) {
                // Intervals have a gap, add the free time interval
                freeTimeIntervals.add(new Interval(prev.end, curr.start));
            }
        }
        return freeTimeIntervals;
    }
}
