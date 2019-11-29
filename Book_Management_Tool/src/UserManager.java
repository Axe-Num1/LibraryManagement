import java.util.Scanner;

public class UserManager extends BookManager{
	Scanner input = new Scanner(System.in);
	
	UserInfo[] users = new UserInfo[10];
	
	public UserManager() {	
		super();
//	  							   이름		   주소 			 번호      회원번호 
		users[0] = new UserInfo("tester1", "address1", "010-0000-0000", 1);
		users[1] = new UserInfo("tester2", "address2", "010-0000-0000", 2);
		users[2] = new UserInfo("tester3", "address3", "010-0000-0000", 3);
		users[3] = new UserInfo("tester4", "address4", "010-0000-0000", 4);
		users[4] = new UserInfo("tester5", "address5", "010-0000-0000", 5);
		users[5] = new UserInfo("tester6", "address6", "010-0000-0000", 6);
		users[6] = new UserInfo("tester7", "address7", "010-0000-0000", 7);
		users[7] = new UserInfo("tester8", "address8", "010-0000-0000", 8);
		users[8] = new UserInfo("tester9", "address9", "010-0000-0000", 9);
		users[9] = new UserInfo("tester10", "address10", "010-0000-0000", 10);
	}
	
	// 회원번호를 통해 회원을 찾음 - 오버로딩 2-원본 - enhanced for 사용 
	UserInfo findUser(int userNum) {
		for(UserInfo user : users) {
			if(user != null) {
				if(user.userNum == userNum) {
					return user;
				}
			}
		}
		return null;
	}
	
	// 회원번호를 통해 회원정보를 찾음 - 오버로딩 2-1
	void findUser() {
		int userNum;
		BookInfo[] foundBook;
		UserInfo foundUser;
		
		System.out.println("검색할 회원의 회원번호를 입력해주세요.");
		System.out.print("회원번호: ");
		userNum = input.nextInt();

		foundUser = findUser(userNum);

		if(foundUser != null) {
			foundBook = findBook(userNum);

			if(foundBook != null) {
				for(int i = 0; i < 3; i++) {
					if(foundBook[i] != null) {
						System.out.println("대출한 책: "+foundBook[i].name);
						System.out.println("반납 일자: "+foundBook[i].returnDate);
						foundBook[i] = null;
					}
				}

			} else {
				printIssues("BookNotFound"); // "대출한 책이 없습니다."
				return;
			}

		} else {
			printIssues("UserNotFound"); // "존재하지 않는 회원입니다."
			return;
		}
	}

	@Override
	void printIssues(String errorInfo) {
		if(errorInfo == "UserNotFound") {
			System.out.println("존재하지 않는 회원입니다!");
		} else if (errorInfo == "BookNotFound") {
			System.out.println("대출한 책이 없습니다.");
		}
	}
	
	UserManager(Boolean reset) {
		this();
	}
}
