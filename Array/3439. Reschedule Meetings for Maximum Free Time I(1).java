class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        
        // Create a FreeTime ArrayList
        List<Integer> freeTime = new ArrayList<>();

        freeTime.add(startTime[0]);
        for(int i=1; i<startTime.length; i++)
        {
            freeTime.add(startTime[i] - endTime[i-1]);
        }
        freeTime.add(eventTime - endTime[endTime.length-1]);

        int i=0;
        int j=0;
        int sum = 0;
        int maxAns = 0;

        while(j < freeTime.size()){
            sum += freeTime.get(j);
            if(i < freeTime.size() && j-i+1 > k+1){
                sum -= freeTime.get(i);
                i++;
            }

            maxAns = Math.max(sum, maxAns);
            j++;
        }
        return maxAns;
    }
}