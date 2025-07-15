
/*            Approach 1                    */
// T.C = O(K)
// S.c = O(K)

class Solution {
    public char kthCharacter(int k) {
        String word = "a";

        while(word.length() < k){
            String newWord = "";
            for(char ch : word.toCharArray())
            {
                if(ch == 'z'){
                    newWord = newWord + "a";
                }
                newWord = newWord + (char)(ch+1);
            }

            word = word + newWord;
        }

        return (char)(word.charAt(k-1));
    }
}


/*            Approach 2                 */

class Solution {
    public char kthCharacter(int k) {
        int shift = Integer.bitCount(k-1);
        return (char)('a' + shift);
    }
}