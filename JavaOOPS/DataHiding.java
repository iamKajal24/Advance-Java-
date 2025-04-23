package JavaOOPS;

class Bank {

	private long CurBalance = 0;

	long bank_id;
	String name;

	public long get_balance(long Id) {

		if (this.bank_id == Id) {

			return CurBalance;
		}

		return -1;
	}

	public void set_balance(long balance, long Id) {
		if (this.bank_id == Id) {

			CurBalance = CurBalance + balance;
		}
	}
}

public class DataHiding {
	public static void main(String[] args) {

		Bank _emp = new Bank();

		_emp.bank_id = 12345;
		_emp.name = "Kajal";

		_emp.set_balance(100000, 12345);

		long emp_balance = _emp.get_balance(12345);

		System.out.println("User Name" + "  " + _emp.name);
		System.out.println("Bank_ID" + "  " + _emp.bank_id);
		System.out.println("Current Balance" + "  " + emp_balance);
	}
}
