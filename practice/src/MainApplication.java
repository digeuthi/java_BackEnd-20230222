import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class User {

	private String email;
    private String password;
    private String passwordCheck;
    private String name;
    private String telNumber;
}

public class MainApplication {

	private static List<User> users = new ArrayList<>();
	
    public static void main(String[] args) {

    	Scanner scanner = new Scanner(System.in);

        while(true){
        	
        	System.out.println("이메일 : ");
        	users.email = scanner.nextLine();
        	System.out.println("비밀번호 : ");
        	users.email = scanner.nextLine();
        	System.out.println("비밀먼호 확인 : ");
        	users.email = scanner.nextLine();
        	System.out.println("이름 : ");
        	users.email = scanner.nextLine();
        	System.out.println("전화번호 : ");
        	users.email = scanner.nextLine();
        }

    }

}