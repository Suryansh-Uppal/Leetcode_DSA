
/*                Approach1 (Time Limt Exceeded)                        */

class Solution {
    public char kthCharacter(long k, int[] operations) {
        String word = "a";
        int i = 0;

        while(word.length() < k){
            String newWord = "";
            for(char ch : word.toCharArray())
            {
                if(operations[i] == 0){
                    newWord = newWord + ch;
                }else if(operations[i] == 1){
                    newWord = newWord + (char)(ch+1);
                }
            }
            word = word + newWord;
            i++;
        }
        return (char)(word.charAt((int)(k-1)));
    }
}



/*                Approach2 (Perfect Approach)        */

class Solution {
    public char kthCharacter(long k, int[] operations) {

        if(k == 1){
            return 'a';
        }
        
        long len = 1;
        int n = operations.length;
        long newK = -1;
        int operationType = -1;
        
        for(int i=0; i < n; i++)
        {
            len *= 2;

            if(len >= k){
                operationType = operations[i];
                newK = k - (len/2);
                break;
            }
        }

        char ch = kthCharacter(newK, operations);
        if(operationType == 0){
            return ch;
        }

        if(ch == 'z'){
            return 'a';
        }
        return (char)(ch+1);
    }
}