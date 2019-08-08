package dao;
import java.util.ArrayList;
import dto.Product;

public class ProductRepository {
	private ArrayList<Product> listOfProducts = new ArrayList<Product>();
	
	public ProductRepository() {
		Product phone = new Product("P1234", "iPhone 6s", 800000);
		phone.setDescription("4.7-inch, 1334x750 Renina HD display, 8-megapixel iSight Camera");
		phone.setCategory("Smart Phone");
		phone.setManufacturer("Apple");
		phone.setUnitPrice(1000);
		phone.setCondition("New");
		
		Product notebook = new Product("P1235", "LG PC그램", 1500000);
		notebook.setDescription("4.7-inch, 1334x750 Renina HD display, 8-megapixel iSight Camera");
		notebook.setCategory("Smart Phone");
		notebook.setManufacturer("Apple");
		notebook.setUnitPrice(1000);
		notebook.setCondition("New");
		
		Product tablet = new Product("P1236", "갤럭시 탭 S", 900000);
		tablet.setDescription("4.7-inch, 1334x750 Renina HD display, 8-megapixel iSight Camera");
		tablet.setCategory("Smart Phone");
		tablet.setManufacturer("Apple");
		tablet.setUnitPrice(1000);
		tablet.setCondition("New");
		
		listOfProducts.add(phone);
		listOfProducts.add(notebook);
		listOfProducts.add(tablet);
	}// 생성자
	
	public ArrayList<Product> getAllProducts(){
		return listOfProducts;
	}
}// end of class
