package mediatheque.controller.response;

import mediatheque.model.Account;

public class PersonnalizedListDetailResponse {
	
	private Integer id;
	private String name;
	private Account account;
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	

}
