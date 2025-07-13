class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        
        List<Integer> freeArray = new ArrayList<>();

        freeArray.add(startTime[0]);

        for(int i=1; i < startTime.length; i++)
        {
            freeArray.add(startTime[i] - endTime[i-1]);
        }

        freeArray.add(eventTime - endTime[endTime.length - 1]);

        int maxLeftFree[] = new int[freeArray.size()];
        maxLeftFree[0] = 0;
        for(int i=1; i < maxLeftFree.length; i++)
        {
            maxLeftFree[i] = Math.max(maxLeftFree[i-1], freeArray.get(i-1));
        }

        int maxRightFree[] = new int[freeArray.size()];
        maxRightFree[freeArray.size()-1] = 0;
        for(int i=maxRightFree.length-2; i >= 0; i--)
        {
            maxRightFree[i] = Math.max(maxRightFree[i+1], freeArray.get(i+1));
        }

        int result = 0;

        for(int i=1; i < freeArray.size(); i++)
        {
            int currentEvent = endTime[i-1] - startTime[i-1];

            // Case1: Moved the event
            if(currentEvent <= Math.max(maxLeftFree[i-1], maxRightFree[i])){
                result = Math.max(result, freeArray.get(i-1) + currentEvent + freeArray.get(i));
            }

            // Case2: shift to the Adjacent
            result = Math.max(result, freeArray.get(i-1) + freeArray.get(i));
        }

        return result;
    }
}