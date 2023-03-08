package Example.Exchange;

//화폐 : 화폐 = 환율
// 환율 관리할 용도의 클래스
public class ExchangeRate {
	
	//넣을 화폐 (ex. 원화, 달러, 엔화, 위안화 ... )
	private/*캡슐화?*/ String exchangingCurrency ; //왜 굳이 캡슐화하는거지
	//바꿀 화폐 (ex. 원화, 달러, 엔화, 위안화 ... )
	private String exchangedCurrency ;
	// 환율 ( 1000 / 1,316.30(원화 대비 달러) )
	private double exchangeRate ;
	
	//이클립스에서 오른쪽버튼 source 구간에서 다 만든것... 다 타이핑할 필요없이 만들수 있다(15~50구간)
	public ExchangeRate(String exchangingCurrency, String exchangedCurrency, double exchangeRate) {
//		super();
		this.exchangingCurrency = exchangingCurrency;
		this.exchangedCurrency = exchangedCurrency;
		this.exchangeRate = exchangeRate;
	}

	public String getExchangingCurrency() {
		return exchangingCurrency;
	}

	public void setExchangingCurrency(String exchangingCurrency) {
		this.exchangingCurrency = exchangingCurrency;
	}

	public String getExchangedCurrency() {
		return exchangedCurrency;
	}

	public void setExchangedCurrency(String exchangedCurrency) {
		this.exchangedCurrency = exchangedCurrency;
	}

	public double getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	@Override //출력을 해보고 싶을때 사용? 인스턴스.toString 해서 쓰면 된다
	public String toString() {
		return "ExchangeRate [exchangingCurrency=" + exchangingCurrency + ", exchangedCurrency=" + exchangedCurrency
				+ ", exchangeRate=" + exchangeRate + "]";
	}
	
	//생성자
//	public ExchangeRate(
//			String exchangingCurrency, 
//			String exchangedCurrency, 
//			double exchangeRate) { //인스턴스와 매개변수 이름 같을때 this 써서 초기화
//		this.exchangingCurrency =exchangingCurrency;
//		this.exchangedCurrency = exchangedCurrency;
//		this.exchangeRate = exchangeRate;
//	}
	
	//get, set 메서드 : private로 설정해뒀기때문에 접근 가능하도록 함
	//Get :  해당 인스턴스에 특정 인스턴스 변수(이미 갖고 있는것)를 반환해주는 메서드
	//get은 인스턴스를 생성해야하고 set은 인스턴스를 생성하고 나서 쓰는것..?
	// 인스턴스가 가지고 있는 특정 인스턴스 변수의 값을 반환해주기 위한 메서드
	//반환타입 메서드명(get~특정인스턴스변수이름) (매개변수 -> 필요한것 없다. 있는걸 반환해주는것이라서)
//	public/*외부에서 접근할수 있어야 하므로*/ String getExchangingCurrency() { //get 메서드
//		return this.exchangingCurrency;
//	}
//	public String getExchangedCurrency() {
//		return this.exchangedCurrency;
//	}
//	public double getExchangeRate() {
//		return this.exchangeRate;
//	}
	
	
	//Set : 원래 갖고 있는 인스턴수 변수를 변경해주는 메서드, 반환은 하지 않는다. 변경만 함
	//반환하지 않으니 반환타입은 void 
	//void 메서드명(set~매개변수명)(바꾸고자하는 값,위에 선언한 인스턴스 타입과 변수 그대로 입력)
	//인스턴스가 가지고 있는 특정 인스턴스 변수를 변경할  때 사요하는 메서드
//	public/*외부에서 접근할수 있어야 하므로*/ void setExchangingCurrency(String exchangingCurrency) {
//		this.exchangingCurrency = exchangingCurrency;
//	}
//	public void setExchangedCurrency (String exchangedCurrency) {
//		this.exchangedCurrency = exchangedCurrency;
//	}
//	public void setExchangeRate (double exchangeRate) {
//		this.exchangeRate = exchangeRate;
//	}
}
