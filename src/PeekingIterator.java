import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
class PeekingIterator implements Iterator<Integer> {
	int next;
	Iterator<Integer> iter;
	boolean noSuchElement;

	public PeekingIterator(Iterator<Integer> iterator) {
		// initialize any member here.
		iter = iterator;
		advanceIter();
	}

	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		// you should confirm with interviewer what to return/throw
		// if there are no more values
		return next;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		if (noSuchElement)
			throw new NoSuchElementException();
		int res = next;
		advanceIter();
		return res;
	}

	@Override 
	public boolean hasNext() {
		return !noSuchElement;
	}

	private void advanceIter() {
		if (iter.hasNext()) {
			next = iter.next();
		} else {
			noSuchElement = true;
		}
	}
	
	public static void main(String args[]) 
	{ 
		ArrayList<Integer> as = new ArrayList<>();
		as.add(1);
		as.add(2);
		as.add(3);
		Iterator<Integer> it = as.iterator();
		PeekingIterator p = new PeekingIterator(it);
		System.out.println(p.next());
		System.out.println(p.next());
		System.out.println(p.next());
		System.out.println(p.next());
	}

}
