public class UserInfo {
	public String name = ""; // 회원 이름
	public int userNum = 0; // 회원번호
	private String address = ""; // 회원 주소
	private String phoneNum = ""; // 회원의 전화번호
	public int borrowCount = 0; // 회원이 책을 대출한 횟수
		
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public UserInfo(String name, String address, String phoneNum, int userNum) {
		this.name = name;
		this.userNum = userNum;
		this.borrowCount = 0;
		setAddress(address);
		setPhoneNum(phoneNum);
	}
}
