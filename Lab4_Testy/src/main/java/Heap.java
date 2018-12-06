import java.util.ArrayList;

public class Heap {

    private int heapSize = 0;
    private ArrayList<Double> tab = new ArrayList<>();

    public void insert(double value) {
        int currentIndex = heapSize;
        int parentIndex = parentIndex(currentIndex);
        tab.add(value);
        while( isChildGreaterThanParent(currentIndex, parentIndex) ) {
            swapElements(currentIndex, parentIndex);
            currentIndex = parentIndex;
            parentIndex = parentIndex(currentIndex);
        }
        heapSize++;
    }

    public boolean isChildGreaterThanParent(int currentIndex, int parentIndex) {
        return tab.get(currentIndex) > tab.get(parentIndex);
    }

    public void swapElements(int currentIndex, int parentIndex) {
        Double parentValue = tab.get(parentIndex);
        Double currentValue = tab.get(currentIndex);
        tab.set(parentIndex, currentValue);
        tab.set(currentIndex, parentValue);
    }

    public Double parentValue(int currentIndex) {
        Double parentValue = tab.get(parentIndex(currentIndex));
        return parentValue;
    }

    public int parentIndex(int currentIndex) {
        return currentIndex/2;
    }

    public int leftIndex(int currentIndex) {
        if(2*currentIndex<heapSize)
            return currentIndex*2;
        return heapSize-1;
    }

    public int rightIndex(int currentIndex) {
        if((2*currentIndex)+1<heapSize)
            return (currentIndex*2)+1;
        return heapSize-1;
    }

    public int size() {
        return heapSize;
    }

    public double top() {
        return tab.get(0);
    }

    public void heapify(){
        if(heapSize>1){
            int currentIndex = 0;
            int right = rightIndex(currentIndex);
            int left = leftIndex(currentIndex);
            while(isChildGreaterThanParent(left, currentIndex) ||
                    isChildGreaterThanParent(right, currentIndex)) {
                int oldIndex = currentIndex;
                currentIndex = left;
                if (currentIndex < right)
                    currentIndex = right;
                swapElements(currentIndex, oldIndex);
                right = rightIndex(currentIndex);
                left = leftIndex(currentIndex);
            }
        }
    }

    public void heapify(double [] input){
        for(int i=0; i<input.length;i++){
            insert(input[i]);
        }
    }

    public double extractMax(){
        int lastIndex = heapSize-1;
        int currentIndex = 0;
        swapElements(currentIndex,lastIndex);
        double result = tab.get(lastIndex);
        tab.remove(lastIndex);
        heapSize --;
        heapify();
        return result;
    }

    public void deleteMax(){
        extractMax();
    }

    public void replace(double value){
        tab.set(0, value);
        heapify();
    }

    public void meld(Heap other){
        while(other.size()>0){
            insert(other.extractMax());
        }
    }

}
