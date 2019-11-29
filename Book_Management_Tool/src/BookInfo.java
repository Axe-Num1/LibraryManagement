public class BookInfo {

	public String name = ""; // 책 이름
	public String returnDate = ""; // 반납 일자
	public int group = 0; // 분류 번호
	public int bookNum = 0; // 책 번호
	public int userNum = 0; // 책을 빌린 회원의 회원번호
	public boolean isBorrow = false; // 대출 여부

	public BookInfo(String name, int group) {
		this.name = name;
		this.group = group;
		this.bookNum += 1;
		
		this.returnDate = "";
		this.userNum = 0;
		this.isBorrow = false;
	}

}
