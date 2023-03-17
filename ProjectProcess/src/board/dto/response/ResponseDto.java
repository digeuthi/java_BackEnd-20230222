package board.dto.response;

public class ResponseDto<D> {

	//사용자한테 반환해주는 포멧을 만든다
	//규칙적으로 동일한 포멧을 반환해주기 위해 정의함
	
	private boolean status;
	private String message;
	private D data; //이거 제네릭이였나
	//어떤 메서드든 이 포멧으로 반환을 해준거다. 그때마다 반환해주는 타입은 다를거다
	//그때마다 유연하게 변경되야 하니까 D로 정의해준다. (제너릭 맞음!)
	//D를 타입변수로 받아오려면 클래스에서 매개변수로 받아와야한다 <D>만들어주기
	
	public ResponseDto() {}
	
	public ResponseDto(boolean status, String message, D data) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
	}

	public boolean isStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public D getData() {
		return data;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setData(D data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResponseDto [status=" + status + ", message=" + message + ", data=" + data + "]";
	}
	
	
	
}
