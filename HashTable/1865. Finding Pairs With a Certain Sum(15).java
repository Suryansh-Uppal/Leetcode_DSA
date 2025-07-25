class FindSumPairs {

    int nums1[];
    int nums2[];
    HashMap<Integer,Integer> map = new HashMap<>();

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        for(int i=0; i < this.nums2.length; i++)
        {
            map.put(this.nums2[i], map.getOrDefault(this.nums2[i], 0)+1);
        }
    }
    
    public void add(int index, int val) {
        map.put(this.nums2[index], map.get(this.nums2[index])-1);
        this.nums2[index] += val;
        map.put(this.nums2[index], map.getOrDefault(this.nums2[index], 0)+1);
    }
    
    public int count(int tot) {
        int count = 0;
        for(int i=0; i < this.nums1.length; i++)
        {
            int val = tot - this.nums1[i];
            count += map.getOrDefault(val, 0);
        }
        return count;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */