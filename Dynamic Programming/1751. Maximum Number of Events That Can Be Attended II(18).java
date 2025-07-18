/*        Approach1: By recurssion memoization and Linear Search    */
// T.C: O(nk + nlogn)

class Solution {
    int n;

    public int solve(int events[][], int index, int k, int mem[][]){
        if(index >= n || k == 0){
            return 0;
        }

        int start = events[index][0];
        int end = events[index][1];
        int value = events[index][2];

        if(mem[index][k] != -1){
            return mem[index][k];
        }

        int skip = solve(events, index+1, k, mem);
        
        int j = index+1;
        for(; j < n; j++)
        {
            if(events[j][0] > events[index][1]){
                break;
            }
        }

        int take = value + solve(events, j, k-1, mem);

        return mem[index][k] = Math.max(skip, take);

    }

    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));

        n = events.length;

        int mem[][] = new int[n+1][k+1];
        for(int i=0; i <= n; i++)
        {
            for(int j=0; j <= k; j++)
            {
                mem[i][j] = -1;
            }
        }

        return solve(events, 0, k, mem);
    }
}


/*        Approach2: By recurssion memoization and Binary Search    */
// T.C: O(nlogk + nlogn)

class Solution {

    int n;

    public int binarySearch(int events[][], int target){
        int left = 0;
        int right = events.length;

        while(left < right){
            int mid = (left + right)/2;
            if(events[mid][0] <= target){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return left;
    }

    public int solve(int events[][], int index, int k, int mem[][]){
        if(index >= n || k == 0){
            return 0;
        }

        int start = events[index][0];
        int end = events[index][1];
        int value = events[index][2];

        if(mem[index][k] != -1){
            return mem[index][k];
        }

        int skip = solve(events, index+1, k, mem);

        int nextIndex = binarySearch(events, events[index][1]);

        int take = value + solve(events, nextIndex, k-1, mem);

        return mem[index][k] = Math.max(skip, take);

    }

    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));

        n = events.length;

        int mem[][] = new int[n+1][k+1];
        for(int i=0; i <= n; i++)
        {
            for(int j=0; j <= k; j++)
            {
                mem[i][j] = -1;
            }
        }

        return solve(events, 0, k, mem);
    }
}

/*        Approach3: Dynamic Programming and Binary Search    */
// T.C: O(nklogk + nlogn)

class Solution {

    public int binarySearch(int events[][], int target){
        int left = 0;
        int right = events.length;
        while(left  < right){
            int mid = (left + right)/2;
            if(events[mid][0] <= target){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return left;
    }

    public int maxValue(int[][] events, int k) {
        int n = events.length;
        int dp[][] = new int[n+1][k+1];

        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));

        for(int currIndex = n-1; currIndex >= 0; --currIndex)
        {
            for(int count = 1; count <= k; count++)
            {
                int nextIndex = binarySearch(events, events[currIndex][1]);
                dp[currIndex][count] = Math.max(dp[currIndex+1][count], events[currIndex][2] + dp[nextIndex][count-1]);
            }
        }
        return dp[0][k];
    }
}