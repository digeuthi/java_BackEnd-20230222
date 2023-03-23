package customer;

import java.text.SimpleDateFormat;
import java.util.Date; //생성당시의 날짜를 알기 위해 Date import
import java.util.UUID; //사용자 아이디 랜덤 생성을 위해 난수 생성가능하게 하는 UUID import

//A 사는 고객 관리를 위해 새로운 시스템을 구축하려 한다.
//고객 정보는 (UUID 형식의 고객번호), (이름), (성별), (yyyy. MM. dd. 형식의 생성 당시 날짜), 
//(주소), (전화번호), (마케팅 수신 여부), (개인정보 수집 동의 여부) 로 구성되어있다고 한다.
//이때 Java 언어로 고객 정보 관련 class를 생성하고 각 필드는 외부에서 직접 접근할 수 없으며 메서드를 통해서 
//접근 및 수정 할 수 있도록 작성할 예정이며 해당 클래스로 객체를 생성할 때 모든 값이 입력되어야 하지만 
//사용자로부터 (이름), (성별), (주소), (전화번호), (마케팅 수신 여부), (개인정보 수집 동의 여부)만 받는다고 할때
//해당 class를 클래스 명명 규칙, 변수 명명 규칙, 함수 명명 규칙을 준수하여 작성하시오. (pacakge 및 import 포함 제출)
//- 특정 class 혹은 library를 import하였다면 해당 import를 한 이유를 작성하시오.
public class CustomerReview {

	private String costomerId;
	private String name;
	private String gender;
	private String todayDate;
	private String address;
	private String telNumber;
	private boolean markettingConsent;
	private boolean privateConsent;
	
	public CustomerReview(String name, String gender, String address,
			String telNumber, boolean markettingConsent, boolean privateConsent) {
		Date now = new Date();
		SimpleDateFormat simpleDateForamt = new SimpleDateFormat("yyyy.MM.dd");
		this.costomerId = UUID.randomUUID().toString();
		this.name = name;
		this.gender = gender;
		this.todayDate = simpleDateForamt.format(now);
		this.address = address;
		this.telNumber = telNumber;
		this.markettingConsent = markettingConsent;
		this.privateConsent = privateConsent;
	}
	public String getCostomerId() {
		return costomerId;
	}
	public String getName() {
		return name;
	}
	public String getGender() {
		return gender;
	}
	public String getTodayDate() {
		return todayDate;
	}
	public String getAddress() {
		return address;
	}
	public String getTelNumber() {
		return telNumber;
	}
	public boolean isMarkettingConsent() {
		return markettingConsent;
	}
	public boolean isPrivateConsent() {
		return privateConsent;
	}
	public void setCostomerId(String costomerId) {
		this.costomerId = costomerId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setTodayDate(String todayDate) {
		this.todayDate = todayDate;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}
	public void setMarkettingConsent(boolean markettingConsent) {
		this.markettingConsent = markettingConsent;
	}
	public void setPrivateConsent(boolean privateConsent) {
		this.privateConsent = privateConsent;
	}
	@Override
	public String toString() {
		return "CustomerReview [costomerId=" + costomerId + ", name=" + name + ", gender=" + gender + ", todayDate="
				+ todayDate + ", address=" + address + ", telNumber=" + telNumber + ", markettingConsent="
				+ markettingConsent + ", privateConsent=" + privateConsent + "]";
	}

}
