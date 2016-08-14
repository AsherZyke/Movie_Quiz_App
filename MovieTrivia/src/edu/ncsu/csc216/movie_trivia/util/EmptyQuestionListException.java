package edu.ncsu.csc216.movie_trivia.util;

/**
 * Defines the behavior for the EmptyQuestionListException class
 * 
 * @author Benjamin Zich
 *
 */
public class EmptyQuestionListException extends Exception {
	/** The default message to send when this exception is thrown */
	private static final String MESSAGE = "There was an empty question list";
	/** The serial version UID for this exception */
	private static final long serialVersionUID = 1;
	
	/**
	 * Constructs the default EmptyQuestionListException with the default
	 * message.
	 */
	public EmptyQuestionListException() {
		super(MESSAGE);
	}
	
	/**
	 * Constructs an EmptyQuestionListException with a customized message.
	 * 
	 * @param message the custom message to be displayed to the developer
	 * when the error is encountered.
	 */
	public EmptyQuestionListException(String message) {
		super(message);
	}

}
