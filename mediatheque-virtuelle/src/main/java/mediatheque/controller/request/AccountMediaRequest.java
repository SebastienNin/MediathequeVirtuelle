package mediatheque.controller.request;

public class AccountMediaRequest {
	private Integer mediaId;
	private Integer accountId;

	public AccountMediaRequest() {
		super();
	}

	public Integer getMediaId() {
		return mediaId;
	}

	public void setMediaId(Integer mediaId) {
		this.mediaId = mediaId;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

}
