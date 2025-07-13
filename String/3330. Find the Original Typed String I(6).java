class Solution {
    public int possibleStringCount(String word) {
        
        int count = 0;
        for(int i=1; i < word.length(); i++)
        {
            if(word.charAt(i-1) == word.charAt(i)){
                count++;
            }
        }
        return count+1;
    }
}