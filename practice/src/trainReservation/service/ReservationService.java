package trainReservation.service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import trainReservation.dto.GetTrainListDto;
import trainReservation.dto.PostReservationDto;
import trainReservation.entity.Cost;
import trainReservation.entity.ReservationInfo;
import trainReservation.entity.Seat;
import trainReservation.entity.StopStation;
import trainReservation.entity.Train;

public class ReservationService {

	private List<Train> trains = new ArrayList<>();
	private static DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
	private static List<Cost> costs = new ArrayList<>();
	
	public List<Train> getPossibleTrainList(GetTrainListDto dto, LocalTime departureTime){
		
		List<Train> possibleTrains = new ArrayList<>();
		
		for(Train train : trains) {
			
			List<StopStation> stopStations = new ArrayList<>();
			
			int sameStationIndex = -1;
			
			for(int stopStationIndex = 0 ; stopStationIndex < stopStations.size() ; stopStationIndex++) {
				
				StopStation stopStation = stopStations.get(stopStationIndex);
				String stopStationName = stopStation.getStationName();
				
				if(!dto.isEqualDepartureStation(stopStationName)){
					continue;
				}
				//이게 뭘까
				if(stopStation.getDepartureTime().equals("")) continue;
				
				LocalTime stationDeparureTime = LocalTime.parse(stopStation.getDepartureTime(), timeFormatter);
				if(stationDeparureTime.isBefore(departureTime)) {
					break;
				}
				sameStationIndex = stopStationIndex;
				break;
			}
			
			if(sameStationIndex == -1) 
				continue;
			
			for(int stopStationIndex = 0; stopStationIndex < stopStations.size(); stopStationIndex++) {
				
				String stopStationName = stopStations.get(stopStationIndex).getStationName();
				
				if(!dto.isEqualArrivalStation(stopStationName)) {
					continue;
				}
				
				if(stopStationIndex <= sameStationIndex) {
					break;
				}
				
				possibleTrains.add(train);
			}
		}
		return possibleTrains;
		
	}
	
	public ReservationInfo postReservation(PostReservationDto postReservationDto,GetTrainListDto getTrainListDto) {
		
		Train train = null;
		
		for(Train trainItem : trains) {
			if(postReservationDto.isEqulaTrainNumber(trainItem.getTrainNumber())) {
				train = trainItem;
				break;
			}
		}
		
		if(train == null) {
			System.out.println("존재하지 않는 열차번호 입니다");
			return null;
		}
		
		boolean designationSeat = true;
		
		List<Seat> seats = train.getSeats();
		List<String> inputSeatNumbers = postReservationDto.getSeats();
		
		for(int index = 0 ; index < seats.size() ; index++) {
			Seat seat = seats.get(index);
			for(String seatNumber : inputSeatNumbers) {
				if(!seat.getSeatNumber().equals(seatNumber)) {
					continue;
				}
				
				if(seat.isSeatStatus()) {
					designationSeat = false;
					break;
				}
				seat.setSeatStatus(true);
					break;
			}
			
			if(!designationSeat)
				break;
		}
		if(!designationSeat) {
			System.out.println("좌석배정에 실패했습니다");
			return null;
		}
		
		int totalCost = 0;
		
		for(Cost cost : costs) {
			
			boolean isEqualDepartureStation =
					getTrainListDto.isEqualDepartureStation(cost.getDepartureStation());
			boolean isEqulaArrivalStaion=
					getTrainListDto.isEqualArrivalStation(cost.getArrivalStation());
			
			if(!isEqualDepartureStation || !isEqulaArrivalStaion) continue;
			
			totalCost= cost.getAmount() * getTrainListDto.getNumberOfPeople();
			}
		
	}
}
