package reservation.entity;

import java.util.List;

public class Train {

		private String trainNumber;//열차번호
		private String departureStation;//출발역
		private String departureTime; //출발시간
		private String arrivalStation;//도착역
		private String arrivalTime;//도착시간
		private int takeMinute;//걸리는 시간
		private String type;//열차 종류
		
		//Train은 Seat과 StopStation과의 관계성을 가진다
		private List<Seat> seats;
		private List<StopStation> stopStations;
		
		public Train() {}

		public Train(String trainNumber, String departureStation, String departureTime, String arrivalStation,
				String arrivalTime, int takeMinute, String type, List<Seat> seats, List<StopStation> stopStations) {
			super();
			this.trainNumber = trainNumber;
			this.departureStation = departureStation;
			this.departureTime = departureTime;
			this.arrivalStation = arrivalStation;
			this.arrivalTime = arrivalTime;
			this.takeMinute = takeMinute;
			this.type = type;
			this.seats = seats;
			this.stopStations = stopStations;
		}

		public String getTrainNumber() {
			return trainNumber;
		}

		public String getDepartureStation() {
			return departureStation;
		}

		public String getDepartureTime() {
			return departureTime;
		}

		public String getArrivalStation() {
			return arrivalStation;
		}

		public String getArrivalTime() {
			return arrivalTime;
		}

		public int getTakeMinute() {
			return takeMinute;
		}

		public String getType() {
			return type;
		}

		public List<Seat> getSeats() {
			return seats;
		}

		public List<StopStation> getStopStations() {
			return stopStations;
		}

		@Override
		public String toString() {
			return "Train [trainNumber=" + trainNumber + ", departureStation=" + departureStation + ", departureTime="
					+ departureTime + ", arrivalStation=" + arrivalStation + ", arrivalTime=" + arrivalTime
					+ ", takeMinute=" + takeMinute + ", type=" + type + ", seats=" + seats + ", stopStations="
					+ stopStations + "]";
		}
		
		
		

}
