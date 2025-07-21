class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int interval[] : intervals)
        {
            if(pq.isEmpty()){
                pq.add(interval[1]);
                continue;
            }

            if(pq.peek() <= interval[0]){
                pq.remove();
            }

            pq.add(interval[1]);
        }
        return pq.size();
    }
}