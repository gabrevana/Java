package company;

public class BadInputException extends java.lang.RuntimeException{

	private static final long serialVersionUID = 1L;
	private static String s;
	
	public BadInputException() {
		this(s);
	}
	
	
	public BadInputException(String message) {
		super(message);
	}


}
