package TestVagrant.constants;

public enum HttpStatusCodes {

	UNAUTHORIZED("401"),
	NOTFOUND("404"),
    SUCCESS("200");
	
	
	private final String value;
	
	private HttpStatusCodes(String value) {
		this.value=value;
	}
	public String getCode() {
		return value;
	}
	
}
