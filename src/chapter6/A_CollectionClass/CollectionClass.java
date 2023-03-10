package chapter6.A_CollectionClass;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

//Collection Framework  컬렉션 객체
//배열형태의 데이터를 보다 편하게 사용할 수 있도록 해주는 클래스의 집합

public class CollectionClass {

	public static void main(String[] args) {

		//Set 클래스
		// 집합의 개념, 중복을 허용하지 않고 순서가 없는 형태
		//순서가 없기 때문에 인덱스 사용 불가능
		
		//Set이 인터페이스로 구성되어 있으므로 구현해주는 작업이 필요하다
		// HashSet<E> : 중복을 허용하지 않고 순서가 없는 형태
		Set</*참조타입이 와야함*/Integer> integerSet = new HashSet<Integer>();
		integerSet.add(4);
		integerSet.add(1);
		integerSet.add(2);
		integerSet.add(5);
		integerSet.add(1);
		integerSet.add(6);
		integerSet.add(3); //정렬없이 들어가야함..?
		
//		//iterator : 컬렉션의 요소에 접근해서 반복적인 작업을 할 때 도움을 주는 객체
//		Iterator<Integer> iterator = integerSet.iterator();
//		//이터레이터 사용해서 접근시 보통 while문 쓴다
//		
//		//549812135 이터레이터가 뭉쳐놓고
//		//처음 커서에서 다음에 값이 있는지 확인하는데 hasNext
//		//next는 처음 커서에서 다음 값을 반환해주고 다음 값으로 넘어감
//		
//		while(iterator.hasNext()) {
//			System.out.println(iterator.next());
//		}
		
		for(Integer item : integerSet) {
			System.out.println(item);
		}
		
		// TreeSet<E> : 중복 허용하지않고 순서가 없는 형태 + 정렬
		Set<Integer> treeSet = new TreeSet<Integer>();
		treeSet.add(521);
		treeSet.add(542);
		treeSet.add(1);
		treeSet.add(852);
		treeSet.add(666);
		
		for(Integer item : treeSet) {
			System.out.println(item);
		}
		
		System.out.println("***************구분선****************");
		
		//List
		// 데이터를 일렬로 나열한 구조
		// 순서가 존재하고 중복이 허용(배열)
		
		//ArrayList<E> : 순석 존재하고 중복이 허용된 '배열'
		List/*인터페이스*/<String> list = new ArrayList<String>(); 
		//배열과 달리 길이 지정하지 않고쓴다
		list.add("apple"); //인덱스 0에 사과있었는데 밑에서 바나나를 0에 추가하면 밀려난다.
		list.add(0,"banana"); //특정인덱스에 값을 넣겠다(추가)
		
		list.set(0, "BaNaNa"); //값을 변경
		
		String removeItem = list.remove(1); //특정 인덱스 값 삭제, 삭제라기보단 보따리 안에서 꺼내주는것
		System.out.println(removeItem); //apple 꺼내옴
		
		System.out.println(list.toString()); //[BaNaNa, apple]형태 출력
		
		for(int index = 0 ; index < list.size() ; index++) { //배열의 경우 length 쓰는데 컬렉션들은 size
			System.out.println(list.get(index)/*get써서 접근한다*/);
		}
		
		
	}

}
