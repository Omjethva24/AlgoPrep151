//Find Median from Data Stream


class MedianFinder {
PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
PriorityQueue<Integer> min = new PriorityQueue<>();
    
    public void addNum(int num) {
        if(max.isEmpty() || max.peek()>=num){
            max.add(num);
        }else{
            min.add(num);
        }

        if(max.size() > min.size()+1){
            min.add(max.poll());
        }else if(max.size() < min.size()){
            max.add(min.poll());
        }
    }
    
    public double findMedian() {
      if(max.size() == min.size()){
          return (max.peek()+min.peek())/2.0;
      }

      return max.peek();
    }
}