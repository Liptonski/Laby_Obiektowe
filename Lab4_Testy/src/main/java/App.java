public class App {
    public static void main(String [] args){
        Heap heap = new Heap();
        heap.insert(5);
        heap.insert(6);
        heap.insert(52);
        heap.insert(64);

        heap.extractMax();
        heap.deleteMax();
        heap.size();
    }
}
