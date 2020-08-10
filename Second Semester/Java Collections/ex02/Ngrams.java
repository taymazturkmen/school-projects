package ex02;

public class Ngrams {

    private Character[] chararray;
    public Ngrams(Character[] chararray) {
        this.chararray = chararray;
    }

    /**
     * Get maximum occurrence.
     * @param m Length of sliding window
     * @return maximum occurrence of a char in any sliding window
     */
    public int solve(int m) throws Exception{
        int max = 1;
        for(int i = 0 ; i<=chararray.length-m;i++){
            int temp = 1;
            for(int j = i; j<i+m;j++){
                if(chararray[i] == chararray[j] && i != j){
                    temp++;
                }
                if(temp>max){
                    max = temp;
                }
            }
        }
        return max;
    }

}
