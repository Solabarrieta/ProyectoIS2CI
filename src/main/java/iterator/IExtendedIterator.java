package iterator;

import java.util.Iterator;

public interface IExtendedIterator extends Iterator<Object>{
	public Object previous();
	public boolean hasPrevious();
	public void goFirst();
	public void goLast();
}
