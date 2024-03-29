package trainReservation.entity;

// 정차역 Entity class
public class StopStation {
	//정차역 (class - 역 이름, 도착시간, 출발시간 )
	private String stationName;
	private String departureTime;
	private String arriavalTime;
	
	public StopStation() {}

	public StopStation(String stationName, String departureTime, String arriavalTime) {
		super();
		this.stationName = stationName;
		this.departureTime = departureTime;
		this.arriavalTime = arriavalTime;
	}

	public String getStationName() {
		return stationName; 
		//Cost class처럼 다른 지역변수가 없기 this 안 사용해도 인식하지만 직접 작성할때는 this찍는게 좋다
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public String getArriavalTime() {
		return arriavalTime;
	}

	@Override
	public String toString() {
		return "StopStation [stationName=" + stationName + ", departureTime=" + 
							departureTime + ", arriavalTime="
									+ arriavalTime + "]";
	}
	
}
