import java.util.StringTokenizer;

public class st {

	public static void main(String[] args) {
	     StringTokenizer st = new StringTokenizer("엄남경은-졸립다", "-");
	     while (st.hasMoreTokens()) {
	         System.out.println(st.nextToken());
	     }	
	}
}
