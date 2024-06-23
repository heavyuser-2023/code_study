import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

class App {
    public static void main(String[] args){
        try (BufferedReader bf = new BufferedReader(new FileReader("input.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))) {
                String line = bf.readLine();
                String [] splitedLine;
                int loopCount = Integer.valueOf(line);
                for(int i=0;i<loopCount;i++) {
                    Queue<Integer> queue = new LinkedBlockingDeque<>();
                    line = bf.readLine();
                    splitedLine = line.split(" "); 

                    int count = Integer.valueOf(splitedLine[0]);
                    int index = Integer.valueOf(splitedLine[1]);

                    line = bf.readLine();
                    splitedLine = line.split(" ");

                    for(int j=0;j<count;j++) {
                        int value = Integer.valueOf(splitedLine[j]); 
                        queue.add(value);
                    }

                    bw.write(String.valueOf(calQueueOut(queue, index)));
                    bw.newLine();
                }
        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
        }
        System.exit(0);

    }

    public static int calQueueOut(Queue<Integer> queue, int index) {
        int result = 0;
        while (queue.peek() != null && index > -1) {
            int max = getMaxInQueue(queue);
            Integer outQ = queue.poll();
            if(max > outQ) {
                queue.add(outQ);
                if(index > 0) index--;
                else index = queue.size()-1;
            }
            else {
                result++;
                index--;
            }
        }
        return result;
    }

    public static int getMaxInQueue(Queue<Integer> queue) {
        return queue.stream().max(Integer::compareTo).orElseThrow( () -> new RuntimeException("No exited queue"));
    }


}
