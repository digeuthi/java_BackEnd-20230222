# 내용 주석처리
-- 내용 --의 경우 꼭 띄어쓰기해야 주석처리가 된다
/* 부분 주석 처리 */
/*

여러줄의 주석처리할때 
이렇게 하면 된다.

*/

#DDL (데이터 정의어)
# 데이터 베이스 혹은 테이블(뷰, 인덱스, 프로시저..)을 생성, 수정, 삭제 할 때
# 사용하는 SQL문 / 데이터 자체를 만지는건 아니다. 정의할때 쓰임

# CREAT 문
# 데이터베이스, 테이블 등을 생성할때 사용하는 SQL문 

# 데이터 베이스 생성
# CREAT DATABASE 데이터베이스명;

CREATE DATABASE Hotel; #데이터 베이스 생성
SHOW DATABASES;
-- 데이터 베이스를 생성했으면 사용할 데이터베이스를 선택해야한다.
-- USE 데이터베이스명;
USE Hotel; #데이터 베이스 선택, 프로그램 껐다 키면 다시 USE부분 실행하거나, 왼쪽 창에 호텔부분 더블클릭

-- 테이블 생성 
-- CREATE TABLE 테이블 명(
-- 필드명 데이터타입(데이터 길이) 제약조건,
-- ... 데이터 타입이 프로그래밍언어에서 쓰는 데이터 타입과는 조금 다르다
-- 데이터의 길이 지정 
-- );
CREATE TABLE Custom( #필드명 데이터타입(데이터길이) 제약조건
	id INT PRIMARY KEY,
    name VARCHAR(20) NOT NULL, #문자형태, 길이 지정하면 문자열로 들어간다
    email VARCHAR(30) UNIQUE, #TEXT로 하면 문자열 길이 지정하지 않고도 장문의 문자 넣을수있다. 
    # UNIQUE : 동일한 조건이 들어오지 못하게 막는 제약조건 
	age INT,
    address TEXT, #텍스트에는 디폴트값 못넣는다
    accept_marketing BOOLEAN DEFAULT FALSE # 값을 넣을 적에 넣지않더라도 FALSE로 값 들어가게
    #테이블의 필드명에 띄어쓰기가 포함된경우 일반적으로 로우스네이크케이스, 언더바로 표현
);

SHOW TABLES;

-- 데이터 베이스 수정
-- ALTER DATABASE 데이터베이스명 수정할 속성명 = 값;

-- 테이블 수정
-- ALTER TABLE 테이블명

-- 테이블 필드 추가
-- ALTER TABLE 테이블명 ADD 필드명 데이터타입(데이터길이) 제약조건;
-- 테이블 필드 삭제
-- ALTER TABLE 테이블명 DROP;
-- 데이터 필드 수정
-- ALTER TABLE 테이블명 MODIFT COLUM 필드명 데이터타입(데이터길이) 제약조건;
-- 만약 실수로 필드명에 오타를 내거나 한 경우에는 MODIFY로 수정하면 된다? 
-- 공구모양 아이콘으로 눌러서 들어가서 하는게 더 좋다

-- 데이터베이스 삭제
-- DROP DATABASE 데이터베이스명;

-- 테이블 삭제
-- DROP TABEL 테이블명;
-- TRUNCATE TABLE 테이블명;

-- DROP TABLE 테이블명 : 테이블의 정의자체를 제거한다
-- TRUNCATE TABLE 테이블명 : 테이블을 정의만 남기고 모두 제거 (생성 초기상태로 돌려놓음)

# DML (데이터 조작어)
-- 데이터 베이스 테이블에 레코드를 삽입, 수정, 삭제, 검색 작업을 수행시키고자 할때 (CRUD)
-- 사용하는 SQL문. 

-- 삽입문(INSERT INTO)
-- 해당 테이블에 레코드를 삽입할때 사용하는 SQL구문
-- INSERT INTO 테이블명(필드명1, 필드명2, ...)
-- VALUES(필드1의 데이터, 필드2의 데이터, ...);

INSERT INTO Custom(id, name) VALUES (1, 'John Doe');
-- 필수값 미입력
INSERT INTO Custom(id, email) VALUES(5, 'qwer@qwer'); #name이 daflult 값 가지지 않는다고 뜸, 순서가 잘못된건가
-- 기본키 중복
INSERT INTO Custom(id, name, email)  VALUES(1, 'Jhon Doe', 'qwer@qwer'); # 기본키의 값이 중복됐다는 오류 뜸

SELECT * FROM Custom; #검색하는 작업 모든 필드를 보겠다

-- 모든 필드에 값을 넣을때 : 
-- INSERT INTO 테이블명 # 필드명을 지정하지 않았기때문에 정의(선언)해줄때 했던 그 순서 그대로 넣어줘야한다! 
-- VALUSE(데이터1, 데이터2, ...);

INSERT INTO Custom VALUES (10, 'Michle', 'qwer@qwer.com', 33, 'This is Address', true);
-- 타입이 다른 경우의 순서바꾸고 넣었을때 
INSERT INTO Custom VALUES(11, 'jihoon', 'qwer@qsdff.com', 'Busan', 31, true);
-- 타입이 같은 경우 순서 바꾸고 넣었을때는 들어가게 된다. 값 잘 보고 입력해야한다
INSERT INTO Custom VALUES(11, 'qwer@qsdff.com', 'jihoon',31, 'Busan' , true);
-- 모든 값들을 집어넣지 않은 경우 오류가 뜬다. 어떤 제약조건이 걸려있든 모두 넣어줘야한다.
INSERT INTO Custom VALUES (12, 'Michle', 'qwer1@qwer.com', 33, 'This is Address');

-- 수정문 (UPDATE)
-- 해당 테이블에서 특정 필드의 값을 수정하고자 할때
-- 사용하는 SQL문

-- UPDATE 테이블명 SET 필드명1 = 데이터1, 필드명2= 데이터2 ...
UPDATE Custom SET accept_marketing = false;
UPDATE Custom SET accept_marketing = true, age = 10;
-- WHERE 로 특정 조건만 변경시
-- UPDATE 테이블명 SET  필드명1= 데이터1 ...
-- WHERE 조건;
UPDATE Custom SET email = 'dkfjsld@dafksdl.com' # 세미콜론을 기준으로 실행된다.
WHERE id = 1;

-- 삭제문(DELETE)
-- 해당 테이블에서 레코드를 삭제할때 사용하는 SQL문
 
 -- DELETE FROM 테이블명; # 전부 다 삭제
 DELETE FROM Custom;
 
 -- DELETE FROM 테이블명 WHERE 조건;
DELETE FROM Custom WHERE name = 'John Doe';

-- 검색문 (SELECT)
-- 해당 테이블에서 특정 필드를 검색하고자 할때 사용하는 SQL문

-- SELECT 필드명1, 필드명2, ... FROM 테이블명;

SELECT id,name FROM Custom;

-- SELECT * FROM 테이블명; 전체 다 가져오기
SELECT * FROM Custom;

-- 필드에 별칭 사용
SELECT name AS 'Full Name'
FROM Custom; 

-- 테이블에 별칭 사용
SELECT C.name
FROM Custom AS C;

-- 중복 제거(DISTINCT)
SELECT DISTINCT name FROM Custom;