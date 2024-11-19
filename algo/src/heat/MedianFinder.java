package heat;

import java.util.PriorityQueue;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-19 9:58
 */
public class MedianFinder {
    PriorityQueue<Integer> queMin;
    PriorityQueue<Integer> queMax;

    public MedianFinder() {
        queMin = new PriorityQueue<>((a, b) -> -(a - b));
        queMax = new PriorityQueue<>((a, b) -> (a - b));
    }

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

    public void addNum(int num) {
        if (queMin.isEmpty() || num <= queMin.peek()) {
            queMin.offer(num);
            if (queMin.size() > queMax.size() + 1 ) {
                queMax.offer(queMin.poll());
            }
        } else {
            queMax.offer(num);
            if (queMax.size() > queMin.size()) {
                queMin.offer(queMax.poll());
            }
        }
    }

    public double findMedian() {
        if (queMin.size() > queMax.size()){
            return queMin.peek();
        }else {
            return (queMin.peek() + queMax.peek()) / 2.0;
        }
    }
}
