package com.example;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import io.ecsdemo.accounts_web_service.Account;
import io.ecsdemo.accounts_web_service.PhoneType;



@Component
public class AccountRepository {
	private static final List<Account> accounts = new ArrayList<Account>();

	@PostConstruct
	public void initData() {
		Account customer1 = new Account();
		customer1.setNumber("123ABC");
		customer1.setPhone("5551231233");
		customer1.setPhoneType(PhoneType.CELL);
		accounts.add(customer1);

		Account customer2 = new Account();
		customer2.setNumber("4444455555");
		customer2.setPhone("4441233456");
		customer2.setPhoneType(PhoneType.BUS);
		accounts.add(customer2);
		

		Account cust3 = new Account();
		cust3.setNumber("KJH223JHJkk");
		cust3.setPhone("00909887987");
		cust3.setPhoneType(PhoneType.BUS);
		accounts.add(cust3);

	}
	
	public Account findAccount(String phone) {
		Assert.notNull(phone);

		Account result = null;

		for (Account account : accounts) {
			if (phone.equals(account.getPhone())) {
				result = account;
			}
		}

		return result;
	}
}
