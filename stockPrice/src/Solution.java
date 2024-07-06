import java.util.Stack;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public static void main(String args[]) {

        int [] prices = {1, 2, 3, 2, 3};

        Solution solution = new Solution();
        
        System.out.println(Arrays.toString(solution.solution(prices)));


    }
    public int[] solution(int[] prices) {
        int[] answer = {};
        
        answer = calcRemainPositive(prices);
        
        return answer;
    }
    
    int [] calcRemainPositive( int [] prices) {
        List<Stack<Integer>>  stackArray = new ArrayList<>();
        for(int i=0;i<prices.length;i++) {
            stackArray.add(new Stack<Integer>());
        }
        int [] result = new int [prices.length];
        for(int price : prices) {
            for(Stack<Integer> stack : stackArray) {
                if(stack.isEmpty()) {
                    stack.push(price);
                }
                else if(stack.peek() != -1 && stack.peek() >= price) {
                    stack.push(price);
                }
                else {
                    stack.push(-1);
                }
            }
        }
        int index=0;
        for(Stack<Integer> stack : stackArray) {
            if(stack.peek() == -1) {
                stack.pop();
            }
            result[index++] = stack.size();
        }
        return result;
    }
}