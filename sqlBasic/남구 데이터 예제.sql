SELECT * FROM hotel.namgu;

#구분 세대수 면적 뽑기, Namgu 테이블에서 구분, 세대수, 면적 필드 검색
 SELECT 구분, 세대수, 면적
 FROM Namgu;
 
 #Namgu 테이블에서 구분, 세대수, 면적 필드 중 중복을 제거하여 검색
 SELECT DISTINCT 면적, 구분, 세대수
 FROM Namgu; 
 
 -- Namgu 테이블에서
 -- 구분이 '문현2동 '인
 -- 레코드 중 전체 필드 검색
 SELECT * FROM Namgu WHERE 구분 = '문현2동 ';
-- Namgu 테이블에서
 -- 구성비가 3인
 -- 레코드 중 전체 필드 검색
 SELECT * FROM Namgu WHERE 구성비 = 3;
 
 -- Namgu 테이블에서
 -- 구분이 '문현'을 포함하는
 -- 레코드 중 전체 필드 검색
 # 해당 특정한 단어를 포함한 데이터를 보고싶을때 (문자열) LIKE
 SELECT * FROM Namgu WHERE 구분 LIKE '문현%'; #문현으로 시작하는 단어 포함시 가져오기
 SELECT * FROM Namgu WHERE 구분 LIKE '%문현%'; #문현이라는 단어를 포함하면 가져오기
 
 -- Namgu 테이블에서
 -- 세대수가 10000이상인
 -- 레코드 중 전체 필드 검색
 SELECT * FROM Namgu WHERE 세대수 >= 10000;
-- Namgu 테이블에서
 -- 세대수가 5000이하
 -- 레코드 중 전체 필드 검색
 SELECT * FROM Namgu WHERE 세대수 <= 5000;
 
-- Namgu 테이블에서
 -- 세대수가 5000이상 10000이하인
 -- 레코드 중 전체 필드 검색
 SELECT * FROM Namgu WHERE 세대수 <= 10000 AND 세대수 >=5000;
 SELECT * FROM Namgu WHERE 세대수 BETWEEN 5000 AND 10000;
 
-- Namgu 테이블에서
 -- 통이 21 22 23 중 하나라도 해당하는
 -- 레코드 중 전체 필드 검색
 SELECT * FROM Namgu WHERE 통 IN(21, 22, 23); #해당 인수만 뽑아내기
-- Namgu 테이블에서
 -- 통이 21 22 23를 제외한
 -- 레코드 중 전체 필드 검색
 SELECT * FROM Namgu WHERE 통 NOT IN(21, 22, 23);
 
 -- Namgu 테이블에서
 -- 인구수가 10000명 이상이면서, 18세 이상 인구수가 12000명 이하인 
 -- 레코드 중 전체 필드 검색 # 분명하게 검색조건 적어주는게 좋다
 SELECT * FROM Namgu WHERE 인구수 >= 10000 AND 18세이상인구수 <=12000;
 
 -- Namgu 테이블에서
 -- 통이 20이상 이거나 반이 100이하인
 -- 레코드 중 구분, 세대수, 인구수, 통, 반 필드를 검색
 SELECT 구분, 세대수, 인구수, 통, 반
 FROM Namgu WHERE 통 >=20 OR 반 <= 100;
 
-- Namgu 테이블에서
 -- 인구수가 10000명 이상인 레코드 중, 18세 이상 인구수가 12000명 이하이거나 반이 100이상인
 -- 레코드의 전체 필드 검색 #조건의 구분을 잘해줘야한다. 이것에따라 결과가 다르게 나타난다. 명확하게 필요
 
 SELECT * FROM Namgu WHERE 인구수 >= 10000
 AND (18세이상인구수 <= 12000 OR 반 >= 100);
 
SELECT * FROM Namgu 
WHERE 인구수 >= 10000 
AND 18세이상인구수 <= 12000
OR 반 >= 100;
