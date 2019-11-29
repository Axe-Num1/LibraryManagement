import java.util.Scanner;

public class BookManager {
	Scanner input = new Scanner(System.in);
	
	// 입고된 책이 저장될 BookInfo형 배열 
	static BookInfo[] bookList = new BookInfo[120];
	// 사용자가 빌릴 수 있는 최대 3권의 책을 찾아서 저장할 BookInfo형 배열 
	BookInfo[] foundBookList = new BookInfo[3];
	
	// 각 분류 번호에 따른 책 입고를 위한 배열 
	protected static int[] arr = {0, 30, 60, 90};
	// 분류 번호와 이름을 저장할 변수
	public int inputGroup;
	public String inputName;
	
	public BookManager() {
		this.inputGroup = 0;
		this.inputName = "";
	}
	
	//책 입고 메소드 
	void insertBook() {
		System.out.println("입고할 책의 이름과 분류 번호를 입력해주세요.");
		
		System.out.print("책이름: ");
		inputName = input.next();
		
		System.out.println("0: 예술 | 1: 문학 | 2: 과학 | 3: 역사");
		System.out.print("분류 번호: ");
		inputGroup = input.nextInt();
		
		switch(inputGroup) {
		case 0:
			if(arr[0] < 30) {
				bookList[arr[0]] = new BookInfo(inputName, inputGroup);
				arr[0]++;
			} else {
				System.out.println("입고할 자리가 없습니다.");
			}
			break;
		case 1:
			if(arr[1] < 60) {
				bookList[arr[1]] = new BookInfo(inputName, inputGroup);
				arr[1]++;
			} else {
				System.out.println("입고할 자리가 없습니다.");
			}
			break;
		case 2:
			if(arr[2] < 90) {
				bookList[arr[2]] = new BookInfo(inputName, inputGroup);
				arr[2]++;
			} else {
				System.out.println("입고할 자리가 없습니다.");
			}
			break;
		case 3:
			if(arr[3] < 120) {
				bookList[arr[3]] = new BookInfo(inputName, inputGroup);
				arr[3]++;
			} else {
				System.out.println("입고할 자리가 없습니다.");
			}
			break;
		}
		return;
	}
	
	// 현재 분류별 책 상황
	void current() {
		int borrowCnt;
		int remaining;
		
		borrowCnt = 0;
		remaining = 0;
		for(int i = 0; i < 30; i++) {
			if(bookList[i] != null && bookList[i].isBorrow == true) {
				borrowCnt += 1;
			} else if (bookList[i] != null && bookList[i].isBorrow == false) {
				remaining += 1;
			}
		}
		System.out.printf("현재 분류 번호 0(예술)은 %d권이 대여 중이며, %d권의 책이 남아있습니다.\n", borrowCnt, remaining);

		borrowCnt = 0;
		remaining = 0;
		for(int i = 30; i < 60; i++) {
			if(bookList[i] != null && bookList[i].isBorrow == true) {
				borrowCnt += 1;
			} else if(bookList[i] != null && bookList[i].isBorrow == false) {
				remaining += 1;
			}
		}
		System.out.printf("현재 분류 번호 1(문학)은 %d권이 대여 중이며, %d권의 책이 남아있습니다.\n", borrowCnt, remaining);

		borrowCnt = 0;
		remaining = 0;
		for(int i = 60; i < 90; i++) {
			if(bookList[i] != null && bookList[i].isBorrow == true) {
				borrowCnt += 1;
			} else if(bookList[i] != null && bookList[i].isBorrow == false) {
				remaining += 1;
			}
		}
		System.out.printf("현재 분류 번호 2(과학)은 %d권이 대여 중이며, %d권의 책이 남아있습니다.\n", borrowCnt, remaining);
		
		borrowCnt = 0;
		remaining = 0;
		for(int i = 90; i < 120; i++) {
			if(bookList[i] != null && bookList[i].isBorrow == true) {
				borrowCnt += 1;
			} else if(bookList[i] != null && bookList[i].isBorrow == false) {
				remaining += 1;
			}
		}
		System.out.printf("현재 분류 번호 3(역사)은 %d권이 대여 중이며, %d권의 책이 남아있습니다.\n", borrowCnt, remaining);
		
		return;
	}

	
	// 책 이름으로 책찾기 - 오버로딩 1-원본
	static public BookInfo findBook(String inputName) {
		for(int i = 0; i < 120; i++) {
			if (bookList[i] != null) {
				if (bookList[i].name.equals(inputName)) {
					return bookList[i]; 
				} 
			}
		}
		return null;
	}

	// 회원번호로 책찾기 - 오버로딩 1-1
	public BookInfo[] findBook(int userNum) {
		int num = 0;
		for(int i = 0; i < 120; i++) {
			if (bookList[i] != null) {
				if (bookList[i].userNum == userNum) {
					foundBookList[num++] = bookList[i]; 
				}
			}
		}
		
		if (foundBookList[0] != null) {
			return foundBookList;
		} else {
			return null;
		}
	}

	// 책이름으로 책 정보검색 - 오버로딩 1-2
	void findBook() {
		String bookName;
		BookInfo foundBook;
		
		System.out.println("검색하실 책 이름을 입력해주세요.");
		System.out.print("책 이름: ");
		bookName = input.next();
		
		foundBook = findBook(bookName);
		
		if(foundBook != null) {
			
			if(foundBook.isBorrow == true) {
				System.out.println("이 책은 현재 대출중입니다.");
				System.out.printf("이 책의 반납일: %s\n", foundBook.returnDate);
				foundBook = null;
			} else {
				System.out.println("이 책은 현재 대출 가능합니다.");
			}
			
		} else {
			System.out.println("존재하지 않는 책입니다.");
			return;
		}
	}
	
	// 경고메시지 출력 메소드 - 오버라이딩 원본 
	void printIssues(String errorInfo) {
		System.out.println("errorInfo");
	}
	
}
