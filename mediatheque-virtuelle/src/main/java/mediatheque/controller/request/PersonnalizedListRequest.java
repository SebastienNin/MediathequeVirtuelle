package mediatheque.controller.request;

import mediatheque.model.Account;

public class PersonnalizedListRequest {
private String name;
private Account account;


public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Account getAccount() {
	return account;
}

public void setAccount(Account account) {
	this.account = account;
}

}
