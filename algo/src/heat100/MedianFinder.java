package heat100;

import java.util.PriorityQueue;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-19 9:58
 */
public class MedianFinder {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;


    public static void main(String[] args) {
        MedianFinder s = new MedianFinder();
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(-1);
        medianFinder.findMedian();
        medianFinder.addNum(-2);
        medianFinder.findMedian();
        medianFinder.addNum(-3);
        medianFinder.findMedian();
        medianFinder.addNum(-4);
        medianFinder.findMedian();
        medianFinder.addNum(-5);
        medianFinder.findMedian();
    }

    public MedianFinder() {
        left = new PriorityQueue<>((a, b) -> (b - a));
        right = new PriorityQueue<>((a, b) -> (a - b));
    }

    public void addNum(int num) {
        if(left.isEmpty() || num <= left.peek()){
            left.offer(num);
            if(left.size() > right.size() + 1){
                right.offer(left.poll());
            }
        }else{
            right.offer(num);
            if(right.size() > left.size()){
                left.offer(right.poll());
            }
        }
    }

    public double findMedian() {
        if(left.size() > right.size()){
            return left.peek();
        }else{
            return (left.peek() + right.peek()) / 2.0;
        }
    }
}
