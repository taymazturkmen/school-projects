package ex02;

import java.util.Comparator;

// Hier die Definition erweitern, damit die Klasse von ArrayDeque erbt!
public class PriorityDeque<E> extends ArrayDeque<E> {
    Comparator<E> comparator;

    public PriorityDeque(Comparator<E> comp) {
        comparator = comp;
    }

    /**
     * Inserts the specified element in order.
     *
     * @param element the element to add
     * @return true
     */
    @Override
    public boolean offer(E element) {

        sizeCheck();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {

                if (comparator.compare(arr[i], element) < 0) {

                    for (int j = elementCount - 1; j >= i; j--) {
                        arr[j + 1] = arr[j];
                    }

                    arr[i] = element;
                    elementCount++;
                    break;
                }
            } else {
                arr[i] = element;
                elementCount++;
                break;

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
     * Inserts the specified element in order.
     *
     * @param element the element to push
     */
    @Override
    public boolean push(E element) {
        offer(element);
        return true;
    }
}
