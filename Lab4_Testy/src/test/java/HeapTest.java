import static org.junit.Assert.*;

import org.junit.Test;

public class HeapTest {

    @Test
    public void insert0intoNewHeap_topIs0() {

        Heap heap = new Heap();
        heap.insert(0);

        assertEquals("size should be 1",1,heap.size());
        assertEquals(0,heap.top(),0.001);
        assertEquals(1,heap.size());
    }

    @Test
    public void insert0AndThen2intoNewHeap_topIs2() {

        Heap heap = new Heap();
        heap.insert(0);
        heap.insert(2);

        assertEquals("size should be 2",2,heap.size());
        assertEquals(2,heap.top(),0.001);
    }

    @Test
    public void insert0And2And3And5And6intoNewHeap_topIs6() {

        Heap heap = new Heap();
        heap.insert(0);
        heap.insert(2);
        heap.insert(3);
        heap.insert(5);
        heap.insert(6);

        assertEquals(6,heap.top(),0.001);
    }

    @Test
    public void extractMaxTest() {
        Heap heap = new Heap();
        heap.insert(0);
        heap.insert(5);
        heap.insert(6);
        heap.insert(10);
        heap.insert(3);

        assertEquals(10, heap.extractMax(), 0.001);
        assertEquals(6, heap.top(),0.001);
        assertEquals( 4, heap.size(), 0.001);
    }

    @Test
    public void deleteMaxTest() {
        Heap heap = new Heap();
        heap.insert(5);
        heap.insert(6);
        heap.insert(10);
        heap.insert(22);
        heap.insert(3);

        heap.deleteMax();

        assertEquals(10, heap.top(),0.001);
        assertEquals( 4, heap.size(), 0.001);

    }

    @Test
    public void replaceTest() {
        Heap heap = new Heap();
        heap.insert(7);
        heap.insert(23);
        heap.insert(10);
        heap.insert(22);
        heap.insert(11);

        heap.replace(33);

        assertEquals(33, heap.top(),0.001);
        assertEquals(5, heap.size(),0.001);
    }

    @Test
    public void heapifyTest(){
        Heap heap = new Heap();
        double [] list = new double[]{3, 22, 44, 1, 0};
        heap.heapify(list);

        assertEquals(44, heap.top(),0.001);
        assertEquals(5, heap.size(),0.001);
    }

    @Test
    public void meldTest() {
        Heap heap = new Heap();
        Heap other = new Heap();
        heap.insert(5);
        heap.insert(10);
        heap.insert(3);
        other.insert(2);
        other.insert(6);
        other.insert(33);

        heap.meld(other);

        assertEquals(33, heap.top(),0.001);
        assertEquals(0, other.size(),0.001);
        assertEquals(6,heap.size(),0.001);
    }
}