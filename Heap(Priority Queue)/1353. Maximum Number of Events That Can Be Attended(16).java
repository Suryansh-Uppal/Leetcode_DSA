class Solution {
    public int maxEvents(int[][] events) {
        int n = events.length;

        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        
        int day = events[0][0];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int i = 0;
        int count = 0;

        while(!pq.isEmpty() || i < n){

            if(pq.isEmpty()){
                day = events[i][0];
            }

            while(i < n && events[i][0] == day){
                pq.offer(events[i][1]);
                i++;
            }

            if(!pq.isEmpty()){
                pq.poll(); // one event attended
                count++;
            }
            
            day++;

            while(!pq.isEmpty() && pq.peek() < day){
                pq.poll();
            }
        }
        return count;
    }
}