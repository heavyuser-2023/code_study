import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        
        List<String> result = new ArrayList<>();
        final String NO = "NO";
        final String YES = "YES";
        // 파일 입력
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            line = br.readLine();
            int count = Integer.valueOf(line);
            for(int i=0;i<count;i++) {
                line = br.readLine();
                if( checkVPS(line) == false) {
                    result.add(NO);
                }
                else {
                    result.add(YES);
                }
            }
        }
        catch (Exception e){
            
        }

        try (PrintWriter pw = new PrintWriter(new FileWriter("output.txt"))) {
            for(String line : result) {
                pw.println(line);
            }
        }
        catch (Exception e) {

        }


        // 파일 출력
    }

    private static boolean checkVPS(String line) throws Exception {
        Stack<Character> stack = new Stack<>();
        boolean result = true;
        for(char c : line.toCharArray()) {
            if(c == '{') {
                stack.add(c);
            }
            else if(c == '}') {
                if(stack.isEmpty()) {
                    result = false;
                    break;
                }
                else {
                    stack.pop();
                }
            }
            else {
                result = false;
                break;
            }
        }
        if(result == true && stack.size() == 0) {
            return true;
        }
        else {
            return false;
        }
    }
}
