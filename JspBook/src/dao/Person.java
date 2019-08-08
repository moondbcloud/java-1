package dao;

public class Person {
	private int id = 20181004;
	private String name = "홍길순";
	
	public Person(){
		
	}// 빈 생성자

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}// end of class Person