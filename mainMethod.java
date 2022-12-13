package atmApplication;

import java.util.Scanner;

interface AtmOperationalInterface {
	public void viewBalance();

	public void withdrawAmount(double withdrawAmount);

	public void depositAmount(double depositAmount);

}

class AtmOperationalImplementation implements AtmOperationalInterface {
	ATM atm = new ATM();

	@Override
	public void viewBalance() {
		System.out.println("available balance is:" + atm.getBalance());
	}

	@Override
	public void withdrawAmount(double withdrawAmount) {
		if (withdrawAmount <= atm.getBalance()) {
			System.out.println("amount withdrawal suceffuly done \ncollect the cash:" + withdrawAmount);
			atm.setBalance(atm.getBalance() - withdrawAmount);
			viewBalance();
		} else {
			System.out.println("insufficient balance \n plzz check your balance");

		}

	}

	@Override
	public void depositAmount(double depositAmount) {
		System.out.println(depositAmount + ":deposited sucessfully");
		atm.setBalance(atm.getBalance() + depositAmount);
		viewBalance();

	}

}

class ATM {
	private double balance;
	private double depositAmount;
	private double withdrawAmount;

//default constructor
	public ATM() {

	}

//getter setter
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(double depositAmount) {
		this.depositAmount = depositAmount;
	}

	public double getWithdrawAmount() {
		return withdrawAmount;
	}

	public void setWithdrawAmount(double withdrawAmount) {
		this.withdrawAmount = withdrawAmount;
	}

}

public class mainMethod {
	public static void main(String[] args) {
		AtmOperationalInterface operation = new AtmOperationalImplementation();
		int atmnumber = 12345;
		int atmpin = 123;
		Scanner sc = new Scanner(System.in);
		System.out.println("enter atm number:");
		int atmNum = sc.nextInt();
		System.out.println("enter pin:");
		int pin = sc.nextInt();
		if (atmNum == atmnumber && atmpin == pin) {
			System.out.println("welcome to ATM machine");
			while (true) {
				System.out.println("1.view available balance \n2.withdraw amount \n3.deposit amount  \n4.exit");
				System.out.println("enter your choice:");
				int ch = sc.nextInt();
				if (ch == 1) {
					operation.viewBalance();
				}

				else if (ch == 2) {
					System.out.println("enter withdraw amount:");
					double withdrawAmount = sc.nextDouble();
					operation.withdrawAmount(withdrawAmount);

				}

				else if (ch == 3) {
					System.out.println("enter deposit amount:");
					double depositAmount = sc.nextDouble();// 5000
					operation.depositAmount(depositAmount);
				}

				else if (ch == 4) {
					System.out.println("collect your card \nthanks for visiting ");

				} else {
					System.out.println("please enter correct choice");

				}
			}
		} else {
			System.out.println("incorrect pin");
		}

	}
}
