import java.util.ArrayList;
import java.util.Comparator;

public class Heap<T extends Comparable<T>> {

    private int heapSize = 0;
    private ArrayList<T> tab = new ArrayList<>();

    public void insert(T value) {
        int currentIndex = heapSize;
        int parentIndex = parentIndex(currentIndex);
        tab.add(value);
        while( isChildGreaterThanParent(currentIndex, parentIndex)==1 ) {
            swapElements(currentIndex, parentIndex);
            currentIndex = parentIndex;
            parentIndex = parentIndex(currentIndex);
        }
        heapSize++;
    }

    public int isChildGreaterThanParent(int currentIndex, int parentIndex) {
        return tab.get(currentIndex).compareTo(tab.get(parentIndex));
    }

    public void swapElements(int currentIndex, int parentIndex) {
        T parentValue = tab.get(parentIndex);
        T currentValue = tab.get(currentIndex);
        tab.set(parentIndex, currentValue);
        tab.set(currentIndex, parentValue);
    }

    public T parentValue(int currentIndex) {
        T parentValue = tab.get(parentIndex(currentIndex));
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

    public T top() {
        return tab.get(0);
    }

    public void heapify(){
        if(heapSize>1){
            int currentIndex = 0;
            int right = rightIndex(currentIndex);
            int left = leftIndex(currentIndex);
            while(isChildGreaterThanParent(left, currentIndex)==1 ||
                    isChildGreaterThanParent(right, currentIndex)==1) {
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

    public void heapify(ArrayList<T> input){
        for(int i=0; i<input.size();i++){
            insert(input.get(i));
        }
    }

    public T extractMax(){
        int lastIndex = heapSize-1;
        int currentIndex = 0;
        swapElements(currentIndex,lastIndex);
        T result = tab.get(lastIndex);
        tab.remove(lastIndex);
        heapSize --;
        heapify();
        return result;
    }

    public void deleteMax(){
        extractMax();
    }

    public void replace(T value){
        tab.set(0, value);
        heapify();
    }

    public void meld(Heap<T> other){
        while(other.size()>0){
            insert(other.extractMax());
        }
    }

}
