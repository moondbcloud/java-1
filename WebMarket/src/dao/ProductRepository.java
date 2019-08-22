package dao;
import java.util.ArrayList;
import dto.Product;

public class ProductRepository {
	private ArrayList<Product> listOfProducts = new ArrayList<Product>();
	private static ProductRepository instance = new ProductRepository();
	
	public static ProductRepository getInstance(){
		return instance;
	} 
	
	public ProductRepository() {
		Product phone = new Product("P1234", "iPhone 6s", 800000);
		phone.setDescription("4.7-inch, 1334x750 Renina HD display, 8-megapixel iSight Camera");
		phone.setCategory("Smart Phone");
		phone.setManufacturer("Apple");
		phone.setUnitPrice(800000);
		phone.setCondition("New");
		phone.setFilename("P1234.png");
		
		Product notebook = new Product("P1235", "LG PC그램", 1500000);
		notebook.setDescription("4.7-inch, 1334x750 Renina HD display, 8-megapixel iSight Camera");
		notebook.setCategory("Notebook");
		notebook.setManufacturer("LG");
		notebook.setUnitPrice(1500000);
		notebook.setCondition("New");
		notebook.setFilename("P1235.png");
		
		Product tablet = new Product("P1236", "갤럭시 탭 S", 900000);
		tablet.setDescription("4.7-inch, 1334x750 Renina HD display, 8-megapixel iSight Camera");
		tablet.setCategory("Table PC");
		tablet.setManufacturer("Samsung");
		tablet.setUnitPrice(900000);
		tablet.setCondition("New");
		tablet.setFilename("P1236.png");
		
		listOfProducts.add(phone);
		listOfProducts.add(notebook);
		listOfProducts.add(tablet);
	}// 생성자
	
	public ArrayList<Product> getAllProducts(){
		return listOfProducts;
	}
	
	public Product getProductById(String productId) {
		Product productById = null;
		for(int i=0;i<listOfProducts.size();i++) {
			Product product = listOfProducts.get(i);
			if(product != null && product.getProductId() != null &&
					product.getProductId().contentEquals(productId)) {
				productById = product;
				break;
			}// end of if
		}// end of for
		return productById;
	}// end of getProductById()
	
	public void addProduct(Product product) {
		listOfProducts.add(product);
	}// end of addProduct
}// end of class
