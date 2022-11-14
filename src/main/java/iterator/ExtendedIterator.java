package iterator;

import java.util.Iterator;
import java.util.Vector;

import domain.Event;

public class ExtendedIterator<Object> implements IExtendedIterator{
	int pos = 0;
	Vector<Event> events;
	
	public ExtendedIterator(Vector<Event> vector) {
		this.events = vector;
	}
	@Override
	public Object previous() {
		Event ev = events.get(pos);
		pos--;
		return (Object) ev;
	}

	@Override
	public boolean hasPrevious() {
		try {
			int aux = pos-1;
			Event ev = events.get(aux);
			return ev!=null;
		}catch(Exception e) {
			return false;
		}
		
	}

	@Override
	public void goFirst() {
		pos = 0;
	}

	@Override
	public void goLast() {
		pos = events.size();
	}

	@Override
	public boolean hasNext() {
		return pos<events.size();
	}

	@Override
	public Object next() {
		// TODO Auto-generated method stub
		Event ev = events.get(pos);
		pos++;
		return (Object) ev;
	}

}
