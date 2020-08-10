package ex02;


public class ArrayDeque<E> {
    int size;
    E[] arr;
    int head = 0;
    int tail = 0;
    int elementCount = 0;
    E poppedElement;

    // Attribute
    @SuppressWarnings("unchecked")
    public ArrayDeque() {
        // Hier muss etwas angepasst werden
        size = 16;
        arr = (E[]) new Object[size];
    }

    /**
     * Inserts the specified element at the end of this deque.
     *
     * @param element the element to add
     * @return true, if the insertion was successful
     */
    public boolean offer(E element) {
        sizeCheck();

        if (elementCount == 0) {
            arr[tail] = element;
            elementCount++;
        } else {
            tail++;
            arr[tail] = element;
            elementCount++;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(" ");
        sizeCheck();
        return true;
    }

    /**
     * Retrieves, but does not remove, the first element of this deque, or returns
     * null if this deque is empty.
     *
     * @return the head of this deque, or null if this deque is empty
     */
    public E peekFirst() {
        System.out.println(arr[head]);

        return arr[head];
    }

    /**
     * Retrieves, but does not remove, the last element of this deque, or returns
     * null if this deque is empty.
     *
     * @return the tail of this deque, or null if this deque is empty
     */
    public E peekLast() {
        System.out.println(arr[tail]);

        return arr[tail];
    }

    /**
     * Retrieves and removes the head of the queue represented by this deque (in
     * other words, the first element of this deque), or returns null if this deque
     * is empty.
     *
     * @return the head of the queue represented by this deque, or null if this
     *         deque is empty
     */
    public E poll() {
        pop();
        return poppedElement;
    }

    /**
     * Retrieves and removes the last element of this deque, or returns null if this
     * deque is empty.
     * 
     * @return the tail of this deque, or null if this deque is empty
     */
    public E pollLast() {
        return null;
    }

    /**
     * Pushes an element onto the stack represented by this deque. In other words,
     * inserts the element at the front of this deque.
     *
     * @param element the element to push
     * @return true, if the insertion was successful
     */
    public boolean push(E element) {
        sizeCheck();

        if (elementCount == 0) {
            arr[head] = element;
            elementCount++;
        } else {
            if (head == 0) {
                head = arr.length - 1;
                arr[head] = element;
                elementCount++;
            } else {
                head--;
                arr[head] = element;
                elementCount++;
            }

        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(" ");
        sizeCheck();

        return true;
    }

    /**
     * Pops an element from the stack represented by this deque. In other words,
     * removes and returns the first element of this deque.
     *
     * @return the element at the front of this deque (which is the top of the stack
     *         represented by this deque)
     */
    public E pop() {
        System.out.println("Head is " + head);

        poppedElement = arr[head];
        arr[head] = null;
        if (head == arr.length - 1) {
            head = 0;
        } else if (elementCount == 1) {
            head = 0;
            tail = 0;
        } else {
            head++;

        }
        elementCount--;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("Popped element is " + poppedElement);
        System.out.println("Head is now " + head);

        return poppedElement;
    }

    /**
     * Returns the number of elements in this deque.
     *
     * @return the number of elements in this deque
     */
    public int size() {
        System.out.println(elementCount);
        return elementCount;
    }

    /**
     * Returns the current capacity of the list.
     * 
     * @return the current capacity of the array in this list
     */

    public int capacity() {
        System.out.println("Capacity is "+size);
        return size;
    }

    @SuppressWarnings("unchecked")
    public void sizeCheck() {
        if (elementCount == arr.length) {
            int sizeTemp = size;
            size = size * 2;
            E[] temp = (E[]) new Object[size];
            if (head != 0) {
                System.arraycopy(arr, head, temp, 0, sizeTemp - head);
                System.arraycopy(arr, 0, temp, sizeTemp - head, head);
                arr = temp;
            } else {
                System.arraycopy(arr, 0, temp, 0, sizeTemp);

            }
            arr = temp;
        }
    }

}
