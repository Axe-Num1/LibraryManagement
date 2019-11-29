import java.util.Scanner;

public class Management {
	Scanner input = new Scanner(System.in);
	
	// 클래스 인스턴스 생성 
	BookManager bookM = new BookManager();
	BorrowManager borrowM = new BorrowManager();
	UserManager userM = new UserManager();
	
	// Management클래스 생성자
	public Management() {
		int selected;
		
		do {
			System.out.println("기능을 선택해 주세요!");
			System.out.println("1. 대출 | 2. 반납 | 3. 책 현황 | 4. 책 입고 | 5. 책검색 | 6. 회원검색 | 0. 종료 || 회원번호 리스트 1 ~ 10");
			selected = input.nextInt();
			
			if(selected == 0) {
				System.out.println("도서 관리 프로그램을 종료합니다.");
				break;
			}
			
			switch(selected) {
			case 1:
				borrowM.borrowBook();
				break;
			case 2:
				borrowM.returnBook();
				break;
			case 3:
				bookM.current();
				break;
			case 4:
				bookM.insertBook();
				break;
			case 5:
				bookM.findBook();
				break;
			case 6:
				userM.findUser();
				break;
			default :
				System.out.println("다시 입력해주세요!");
				break;
			}
			
		} while(true);
		
	}
}
