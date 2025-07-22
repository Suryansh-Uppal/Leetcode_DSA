class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> merge = new ArrayList<>();

        int currInterval[] = intervals[0];
        merge.add(currInterval);

        for(int interval[] : intervals)
        {
            int currEnd = currInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if(currEnd >= nextStart){

                currInterval[1] = Math.max(currEnd, nextEnd);
            }else{
                currInterval = interval;
                merge.add(currInterval);
            }
        }

        return merge.toArray(new int[merge.size()][]);
    }
}