import java.util.Stack;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public static void main(String args[]) {

        // 테스트 코드 
        int [] prices = {1, 2, 3, 2, 3};
        int [] expectedResult = {4, 3, 1, 1, 0};

        Solution solution = new Solution();
        
        int [] result = solution.solution(prices);

        System.out.println(Arrays.toString(result));

        String b = Arrays.equals(result, expectedResult)?"true":"false";
        System.out.println("result : " + b);


    }
    public int[] solution(int[] prices) {
        int[] answer = {};
        
        answer = calcRemainPositive(prices);
        
        return answer;
    }
    
    int [] calcRemainPositive( int [] prices) {
        int [] result = new int [prices.length];

        for(int i=0;i<prices.length;i++) {
            for(int j=i+1;j<prices.length;j++) {

                result[i]++;
                if(prices[i] > prices[j]) {
                    break;
                }
            }
        }
      
        return result;
    }
}