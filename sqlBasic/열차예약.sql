-- 테이블 만들기
-- 기차예약 데이터베이스 생성
CREATE DATABASE train_reservation;
USE train_reservation; #선택

-- 가격테이블 생성
CREATE TABLE Cost( 
	departure_station VARCHAR(50) NOT NULL,
    arrival_station VARCHAR(50) NOT NULL,
    amount INT NOT NULL
);

# DROP TABLE Cost;

CREATE TABLE Train(
	train_number VARCHAR(10) PRIMARY KEY, #PRIMARY KEY속성 내에 NN과 UNIQUE 속성포함
    departure_station VARCHAR(50) NOT NULL,
    departure_time TIME NOT NULL,
    arrival_station VARCHAR(50) NOT NULL,
    arrival_time TIME NOT NULL,
    take_minute TIME NOT NULL,
    type VARCHAR(10) NOT NULL
    # stop_stations, #자바 클래스에서 리스트로 가져온값들 따로 정의해서 가져와야한다
    # seats
    # 기본키, defalut 기본값넣어주는것, null not_null(필수일때), unique(중복허용안할때)
);

CREATE TABLE Station(
	station_number INT AUTO_INCREMENT PRIMARY KEY,
    station_name VARCHAR(50) NOT NULL,
    address TEXT NOT NULL UNIQUE,
    tel_number VARCHAR(15) NOT NULL UNIQUE
);

CREATE TABLE Stop_station(
	station_number INT NOT NULL,
    train_number VARCHAR(10) NOT NULL,
    departure_time TIME NOT NULL,
    arrival_time TIME NOT NULL
);

CREATE TABLE Seat( #좌석의 경우 이 모든 필드를 합쳐야 seat를 정의할수 있다. 복합 기본키로 잡아서 쓰기도한다 
					#이 값들을 기본키로 잡아서 옮겨도 되는데 필드를 다 추가해야해서 하는 의미가 줄어듬
	seat_code VARCHAR(5) PRIMARY KEY,
	type VARCHAR(10) NOT NULL, #일반실 특실관련
    seat_number VARCHAR(2) NOT NULL,
    train_type VARCHAR(10) NOT NULL
);



