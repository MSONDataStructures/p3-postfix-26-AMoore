package stack;

/**
 * A {@link LinkedStack} is a stack that is implemented using
 * a Linked List structure to allow for unbounded size.
 * <p></p>
 * The {@code isEmpty} and {@code size} methods are provided,
 * on the house.
 * @param <T> the elements stored in the stack
 */
public class LinkedStack<T> implements StackInterface<T> {

    Node<T> first;
    int size;

    /**
     * {@inheritDoc}.
     */
    @Override
    public T pop() throws StackUnderflowException {
		if (isEmpty()) throw new StackUnderflowException();
		size--;
		T returneElem = first.getElement();
		first = first.getNext();
        return returneElem;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public T top() throws StackUnderflowException {
		if (isEmpty()) throw new StackUnderflowException();
		return first.element;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void push(T elem) throws NullPointerException {
		if (elem == null) throw new NullPointerException();
		size++;
		Node<T> toAdd = new Node<T>(elem);
		toAdd.setNext(first);
		first = toAdd;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public int size() {
        return size;
    }
}
