package chapter3.B_VariableMethod;

class Triangle {
	double underside;
	double height;
	double digonal;
	
	double area;
	double circumference;
	public double diagonal;
}

class TriangleMath {
	
	// 파라미터로 참조변수를 받는다면 메모리 주소가 복사되서 넘어오기 때문에
	// 실제 작업도 해당 메모리 주소에서 작업을 진행함
	// 실제 데이터가 변경된다.
	
	//메서드
	static void setArea(/*매개변수 참조형으로 받기*/Triangle triangle) {
		//파라미터로 받아오는 경우에는 메모리 주소 복사를 해서 가져오는것 이므로
		//바라보는 방향을 적어주는것이므로 호출부에서 값을 바꾸면 같이 바뀌게 된다.
		double area = 0.5 * triangle.underside * triangle.height;
		//변수가 할당된 데이터가 함수가 끝나면 사라져? 일반 변수는 스텍영역에 저장 
		triangle.area = area;		
	}
	
	//함수 깔끔하게 만들어두기 클린코드의 중요성
	static void setDiagonal(Triangle triangle) {
		double squareDiagonal = Math.pow(triangle.underside, 2) + Math.pow(triangle.height, 2);
		double diagonal = Math.sqrt(squareDiagonal);
		triangle.diagonal = diagonal;
	}
	//함수 깔끔하게 만들어두기2 클린코드의 중요성
	static void setCircumference(Triangle triangle) {
		triangle.circumference = triangle.height + triangle.underside + triangle.digonal;
	}
	
	//참조변수를 반환해준 경우
	static Triangle creatTriangle(double underside, double height) {
		Triangle triangle = new Triangle(); //인스턴스 힙영역에서 생성 (다른 공간) 
		//함수가 종료되도 메모리 바뀌지 않는다
		
		triangle.underside = underside;
		triangle.height = height;
		///*함수*/triangle.digonal = Math.sqrt((Math.pow(underside, 2) + Math.pow(height, 2)));
		setDiagonal(triangle);
		setArea(triangle);
		///*함수*/triangle.circumference = triangle.underside + triangle.height + triangle.digonal;
		setCircumference(triangle);
		
		return triangle;
	}
}

public class Method2 {

	public static void main(String[] args) {
		Triangle triangle1 = new Triangle();
		triangle1.underside = 3;
		triangle1.height = 4;
		triangle1.digonal = 5;
		
		TriangleMath.setArea(triangle1);
		System.out.println(triangle1.area);
		
		Triangle triangle2/*주소가 저장되어 있다*/ = new Triangle();
		triangle2 = TriangleMath.creatTriangle(5, 5);
		System.out.println(triangle2.area);
		
	}

}
