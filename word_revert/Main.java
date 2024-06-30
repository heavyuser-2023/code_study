import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Main {
    public static void main(String[] args){
        LineReadWrite lineReadWrite = new LineReadWrite();
        ReserseStack reserseStack = new ReserseStack();

        List<String> inputList = lineReadWrite.readLine();
        List<String> outList = new ArrayList<>();

        for(String line : inputList) {
            outList.add(reserseStack.reverseWordsInLines(line));
        }

        lineReadWrite.writeLine(outList);
    }

    static class ReserseStack {
        
        public String reverseWordsInLines(String line) {
            String [] splitedLine = line.split(" ");
            StringBuffer outLine = new StringBuffer();
            for(String word : splitedLine) {
                outLine.append(reverseString(word) + " ");
            }
            return outLine.toString();
                
        }
        // Stack 자료구조를 이용해서, 입력 스트링 source를 reverse 해서 리턴한다.
        public String reverseString(String source) {
            Stack<Character> stack = new Stack<>();
            String curWord = source;
            for(int j=0;j<curWord.length();j++) {
                stack.push(source.charAt(j));
            }
            StringBuffer reverseWord = new StringBuffer();
            for(int j=0;j<curWord.length();j++) {
                reverseWord.append(stack.pop());
            }
            return reverseWord.toString();
        }
    }

    static class LineReadWrite {
        public List<String> readLine() {
            List<String> result = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                    String line = br.readLine();
                    int loopCount = Integer.valueOf(line);
                    for(int i=0;i<loopCount;i++) {
                        result.add(br.readLine());
                    }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return result;
        }
    
        public void writeLine(List<String> lines) {
            try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
                for(String line : lines) {
                    bw.write(line);
                    bw.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
