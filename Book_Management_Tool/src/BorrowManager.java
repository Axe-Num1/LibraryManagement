import java.text.SimpleDateFormat; //날짜 계산
import java.util.Calendar; //날짜 불러오기

public class BorrowManager extends BookManager {
	UserManager userM = new UserManager();
	
	// 입력 받을 회원번호 
	int userNum;
	String bookName;
	UserInfo foundUser;
	
	public BorrowManager() {
		this.userNum = 0;
		this.bookName = "";
		foundUser = null;
	}
	
	// 책 대출 메소드 
	void borrowBook() {
		BookInfo foundBook;
		System.out.println("책을 빌리실려면 먼저 회원번호를 입력해주세요!");
		System.out.print("회원번호: ");
		userNum = input.nextInt();
		
		foundUser = userM.findUser(this.userNum);
		
		if(foundUser != null) {

			if(foundUser.borrowCount < 3) {
				System.out.print("책이름: ");
				bookName = input.next();
				foundBook = super.findBook(bookName); // 부모클래스 BookManager에서 가져온 findBook메소드를 실행 

				if(foundBook != null) {
					
					if(foundBook.isBorrow != true) {
						foundBook.userNum = this.userNum;
						foundBook.isBorrow = true;
						foundBook.returnDate = date();
						foundUser.borrowCount += 1;

						System.out.println("대출 완료!");
						System.out.printf("책을 %s까지 반납해주세요!\n", foundBook.returnDate);
						
					} else {
						printIssues("AlreadyBorrow"); // "이미 대출중인 책입니다."
						return;
					}
					
				} else {
					System.out.println("존재하지 않는 책입니다.");
					printIssues("BookNotFound");
					return;
				}
				
			} else {
				printIssues("OverBorrow"); // "대출횟수 초과입니다!"
				return;
			}
			
		} else {
			printIssues("UserNotFound"); // "존재하지 않는 회원입니다."
			return;
		}
	}

	// 책 반납 메소드 
	void returnBook() {
		BookInfo foundBook;
		System.out.println("책을 반납하실려면 먼저 회원번호를 입력해주세요!");
		System.out.print("회원번호: ");
		userNum = input.nextInt();
		
		foundUser = userM.findUser(this.userNum);
		
		if(foundUser != null) {
			
			if(foundUser.borrowCount > 0) {
				System.out.print("책이름: ");
				bookName = input.next();
				
				foundBook = super.findBook(bookName);
				
				if(foundBook != null) {
					foundBook.userNum = 0;
					foundBook.isBorrow = false;
					foundBook.returnDate = "";
					foundUser.borrowCount -= 1;
					
					System.out.println("반납완료!");
					
				} else {
					printIssues("BookNotFound"); // "존재하지 않는 책입니다."
					return;
				}
				
			} else {
				printIssues("EmptyReturnBook"); // "반납할 책이 없습니다!"
				return;
			}
			
		} else {
			printIssues("UserNotFound"); // "존재하지 않는 회원입니다."
			return;		
		}
	}

	
	public String date() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

        Calendar cal = Calendar.getInstance();
        cal.add(cal.DAY_OF_MONTH, 7);
        return sdf.format(cal.getTime());
    }
	
	@Override
	void printIssues(String errorInfo) {
		if(errorInfo == "UserNotFound") {
			System.out.println("존재하지 않는 회원입니다!");
		} else if (errorInfo == "BookNotFound") {
			System.out.println("존재하지 않는 책입니다.");
		} else if (errorInfo == "AlreadyBorrow") {
			System.out.println("이미 대출중인 책입니다.");
		} else if (errorInfo == "OverBorrow") {
			System.out.println("대출횟수 초과입니다!");
		} else if (errorInfo == "EmptyReturnBook") {
			System.out.println("반납할 책이 없습니다!");
		}
	}
}
