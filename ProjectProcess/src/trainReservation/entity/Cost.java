package trainReservation.entity;

//비용 Entity class
public class Cost {

	//비용 (class - 출발역, 도착역, 금액)(출발역과 도착역의 정보 있어야하고 그에 매칭되는 값 필요)
		private String departureStation;
		private String arrivalStation;
		private int amount;
		
		//기본 생성자
		public Cost() {}
		//생성자 //cost 클래스에서만 다 직접 작성하고 나머지는 source로 자동 완성함
		public Cost(String departureStation, String arrivalStation, int amount) {
			this.departureStation = departureStation;
			this.arrivalStation = arrivalStation;
			this.amount = amount;
		}
		
		//Getter //entity의 경우에는 setter을 쓰지 않는다
		public String getDepartureStation() {
			return this.departureStation;
		}
		public String getArrivalStation() {
			return this.arrivalStation;
		}
		public int getAmount() {
			return this.amount;
		}
		
		public String toString() { //오브젝트 클래스에 toString 메서드 오버라이드한것
			return "Cost[departureStation: ]" + this.departureStation + 
					", arrivalStation : " + this.arrivalStation + 
					", amount : " + this.amount + "]";
		}
		

}
