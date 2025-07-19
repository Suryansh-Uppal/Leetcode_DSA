// T.C: O(nlogn)
// S.C: O(1)

class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        for(int i=1; i < intervals.length; i++)
        {
            if(intervals[i-1][1] > intervals[i][0]){
                return false;
            }
        }
        return true;
    }
}