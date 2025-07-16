
/*                     Approach1                       */
// T.C = O(n)
// S.C = O(n)

class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = -1;
        for(int i : arr)
        {
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        for(int i : arr)
        {
            if(i == map.get(i)){
                if(i > ans){
                    ans = i;
                }
            }
        }
        return ans;
    }
}

/*                     Approach1                    */
// T.C = O(n)
// S.C = O(1)

class Solution {
    public int findLucky(int[] arr) {

        int freq[] = new int[501];

        for(int i: arr)
        {
            freq[i] = freq[i]+1;
        }

        int ans = -1;
        for(int i=500; i >= 1; i--)
        {
            if(freq[i] > ans && freq[i] == i){
                ans = freq[i];
            }
        }
        return ans;
    }
}