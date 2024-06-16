package com.heavyuser.running_truck;
import java.util.*; 

class Solution {
    
    class Truck {
        private int weight;
        private int move = 1;
        
        public Truck(int weight) {
            this.weight = weight;
        }
        public int getWeight() {
            return this.weight;
        }
        
        public void moving() {
            move++;
        }
        public int getMove() {
            return move;
        }
    }
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Truck> waitQueue = new LinkedList<>();
        Queue<Truck> moveQueue = new LinkedList<>();
        
        int curWeight = 0;
        
        for(int w : truck_weights) {
            waitQueue.add(new Truck(w));
        }
        
        while(!waitQueue.isEmpty() || !moveQueue.isEmpty()) {
            answer++;
            if(moveQueue.isEmpty()) {
                Truck truck = waitQueue.poll();
                curWeight += truck.getWeight();
                moveQueue.offer(truck);
                continue;
            }
            
            for(Truck t : moveQueue) {
                t.moving();
            }
            
            if(moveQueue.peek().getMove() > bridge_length) {
                Truck t = moveQueue.poll();
                curWeight -= t.getWeight();
            }
            
            if(!waitQueue.isEmpty() && weight >= curWeight + waitQueue.peek().getWeight()) {
                Truck t = waitQueue.poll();
                curWeight += t.getWeight();
                moveQueue.offer(t);
            }
            
            
        }
        
        return answer;
    }
}