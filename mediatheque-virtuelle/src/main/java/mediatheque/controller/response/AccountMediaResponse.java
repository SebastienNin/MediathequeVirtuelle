package mediatheque.controller.response;

import mediatheque.model.Account;
import mediatheque.model.TypeMedia;

public class AccountMediaResponse {
	private Account account;
	private MediaResponse media;
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public MediaResponse getMedia() {
		return media;
	}
	public void setMedia(MediaResponse media) {
		this.media = media;
	}
	
	
	
	

}
