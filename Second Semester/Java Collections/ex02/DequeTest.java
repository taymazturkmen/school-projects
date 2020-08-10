package ex02;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

class DequeTest {

    @Test
    @Order(1)
    void testStack() {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        assertEquals(0, arrayDeque.size());
        
        // Testing push and pop
        arrayDeque.push(1);
        arrayDeque.push(2);
        arrayDeque.push(3);
        
        assertEquals(3, arrayDeque.size());
        
        assertEquals(3, arrayDeque.peekFirst());
        assertEquals(1, arrayDeque.peekLast());
        
        assertEquals(3, arrayDeque.pop());
        assertEquals(2, arrayDeque.pop());
        assertEquals(1, arrayDeque.pop());
        
        // Testing capacity being increased
        assertEquals(16, arrayDeque.capacity());
        
        for(int i=0; i < 15; i++) {
        	arrayDeque.push(i);
        }
        
        assertEquals(16, arrayDeque.capacity());
        
        arrayDeque.push(15);
        
        assertEquals(32, arrayDeque.capacity());
    }
    
    @Test
    @Order(2)
    void testQueue() {
    	ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
    	
    	// Testing offer and poll
    	arrayDeque.offer(1);
    	arrayDeque.offer(2);
    	arrayDeque.offer(3);
    	
    	assertEquals(1, arrayDeque.peekFirst());
    	assertEquals(3, arrayDeque.peekLast());
    	
    	assertEquals(1, arrayDeque.poll());
    	assertEquals(2, arrayDeque.poll());
    	assertEquals(3, arrayDeque.poll());
    	
    	// Testing capacity being increased
        assertEquals(16, arrayDeque.capacity());
        
        for(int i=0; i < 20; i++) {
        	arrayDeque.offer(i);
        }
        
        assertEquals(32, arrayDeque.capacity());
    }
    
    @Test
    @Order(3)
    void testMixed() {
    	ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
    	
    	// Testing mixed queue and stack operations
    	arrayDeque.push(1);
    	arrayDeque.push(2);
    	arrayDeque.push(3);
    	
    	assertEquals(3, arrayDeque.poll());
    	assertEquals(2, arrayDeque.poll());
    	assertEquals(1, arrayDeque.poll());
    	
    	arrayDeque.offer(1);
    	arrayDeque.offer(2);
    	arrayDeque.offer(3);
    	
    	assertEquals(1, arrayDeque.pop());
    	assertEquals(2, arrayDeque.pop());
    	assertEquals(3, arrayDeque.pop());
    	
    	arrayDeque.push(1);
    	arrayDeque.offer(2);
    	arrayDeque.push(3);
    	arrayDeque.offer(4);
    	
    	assertEquals(3, arrayDeque.pop());
    	assertEquals(1, arrayDeque.pop());
    	assertEquals(2, arrayDeque.pop());
    	assertEquals(4, arrayDeque.pop());
    }

}