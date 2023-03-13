package chapter6.A_CollectionClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
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
		integerSet.add(43);
		integerSet.add(51);
		integerSet.add(562);
		integerSet.add(56);
		integerSet.add(18);
		integerSet.add(69);
		integerSet.add(35); //정렬없이 들어가야함..?
		
//		//iterator : 컬렉션의 요소에 접근해서 반복적인 작업을 할 때 도움을 주는 객체
		Iterator<Integer> iterator = integerSet.iterator();
//		//이터레이터 사용해서 접근시 보통 while문 쓴다
//		
//		//549812135 이터레이터가 뭉쳐놓고
//		//처음 커서에서 다음에 값이 있는지 확인하는데 hasNext
//		//next는 처음 커서에서 다음 값을 반환해주고 다음 값으로 넘어감
//		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
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
		
		//LinkedList<E> : 순서가 존재하고 중복이 허용된 '배열' +
//						  각 요소가 이전 요소와 다음 요소의 주소를 같이 가지고 있음
//						  검색속도가 빠름
		
		List<Integer> arrayList = new ArrayList<Integer>();
		List<Integer> linkedList = new LinkedList<Integer>();
		
		long startTime = System.currentTimeMillis(); //작업시간 측정시 사용 
		for(int integer = 0 ; integer < 100_000 ; integer++) {
			arrayList.add(0, integer);
		}
		long endTime = System.currentTimeMillis();
		
		System.out.println("Array List 작업시간 : " + (endTime - startTime));
		
		startTime = System.currentTimeMillis(); //작업시간 측정시 사용 
		for(int integer = 0 ; integer < 100_000 ; integer++) {
			linkedList.add(0, integer);
		}
		endTime = System.currentTimeMillis();
		
		System.out.println("Linked List 작업시간 : " + (endTime - startTime));
		
		//특정한 하나의 값을 찾아가는건 ArrayList가 더 빠르다 
		
		System.out.println("********구분선2********");
		
		
		//Map //선생님지금 classObject에 저장중인디..
		// key와 value가 하나의 쌍으로 저장되는 구조
		// 순서가 존재하지 않음, 단 key를 이용해서 특정한 value를 가져올수 있음
		
		//Map도 인터페이스로 구성되어 있으므로 구현해주는 작업이 필요하다
		//HashMap<E/*키에대한 제너릭*/, E/*벨류에 대한 제너릭*/>
		Map<String, String> hashMap = new HashMap<String, String>();
		
		hashMap.put("key", "value");
		hashMap.put("apple", "사과"); 
		
		//값을 꺼내고 싶을땐
		System.out.println(hashMap.get("apple")); //키에 대한 값을 반환해준다
		
		//클래스처럼 쓰일 수 있어서 hashMap은 잘 안쓰는게 좋다
		//hash는 특정한 타입을 미리 지정해서 입력해줘야한다 여러가지를 넣으려고 object로 넣어야하는데
		//꺼내올때도 object로 꺼내야하기때문에 정확한 데이터 타입을 가져오기 어려워진다
		
		System.out.println("***오늘의 로또***");
		
		//Lotto 응용 (배열말고 다른거 사용)와우
		//중복제거 + 정렬! -> treeSet 사용
		Set<Integer> lotto = new TreeSet<>();
		
		//반복돌리기
		while(lotto.size()<6) {
			Random random = new Random();
			int randomNumber = random.nextInt(45)+1;
			lotto.add(randomNumber);
		}
		
		System.out.println(lotto.toString());
	}

}
