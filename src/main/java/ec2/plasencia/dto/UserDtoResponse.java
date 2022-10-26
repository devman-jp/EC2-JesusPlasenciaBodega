package ec2.plasencia.dto;

public class UserDtoResponse {
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public UserDtoResponse(String token) {
		super();
		this.token = token;
	}

	public UserDtoResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
}
