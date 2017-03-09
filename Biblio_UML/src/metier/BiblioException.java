package metier;


public class BiblioException extends Exception {
	
	
	private static final long serialVersionUID = 1L;

	
	public BiblioException() {
		System.err.println("Une BiblioException est survenue !");
	}
	
	 
	public BiblioException(String message) {
		super(message);
	}

} 
