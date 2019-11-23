/**
 *@author	Ritwik K Sinha
 *@version	3
 *@since	2/20/2019
 * */

public abstract class BaseResponse implements IResponse {

	private Integer responseCode;
	private String responseString;
	@SuppressWarnings("unchecked")

	@Override
	public Integer getResponseCode() {
		return responseCode;
	}

	@Override
	public void setResponseCode(Integer responseCode) {
		this.responseCode = responseCode;
	}

	@Override
	public String getResponseString() {
		return responseString;
	}

	@Override
	public void setResponseString(String responseString) {
		this.responseString = responseString;
	}
}
