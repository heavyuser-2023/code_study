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
        List<String> inputList = readLine();
        List<String> outList = new ArrayList<>();

        for(String line : inputList) {
            String [] splitedLine = line.split(" ");
            String outLine = "";
            for(int i=0;i<splitedLine.length;i++) {
                Stack<Character> stack = new Stack<>();
                String curWord = splitedLine[i];
                for(int j=0;j<curWord.length();j++) {
                    stack.push(splitedLine[i].charAt(j));
                }
                StringBuffer reverseWord = new StringBuffer();
                for(int j=0;j<curWord.length();j++) {
                    reverseWord.append(stack.pop());
                }
                outLine = outLine + reverseWord.toString() + " ";
            }
            outList.add(outLine);
        }

        writeLine(outList);
    }


    static public List<String> readLine() {
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

    static public void writeLine(List<String> lines) {
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
