package metier;

public class BiblioException extends Exception {
	
	
	public BiblioException() {
		System.err.println("Une BiblioException est survenue !");
	}
	
	public BiblioException(String message) {
		super(message);
	}

}
