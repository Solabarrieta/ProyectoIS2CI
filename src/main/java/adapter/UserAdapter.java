package adapter;

import javax.swing.table.AbstractTableModel;

import domain.User;

public class UserAdapter extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	
	User user;
	public UserAdapter(User user) {
		this.user = user;
	}
	@Override
	public int getColumnCount() {
		
		return 0;
	}

	@Override
	public int getRowCount() {
		
		return 0;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {

		return null;
	}
	
}
