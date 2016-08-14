/**
 * 
 */
package edu.ncsu.csc216.movie_trivia.util;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the EmptyQuestionListException class.
 * @author Benjamin Zich
 *
 */
public class EmptyQuestionListExceptionTest {


	/**
	 * Test method for {@link edu.ncsu.csc216.movie_trivia.util.EmptyQuestionListException#EmptyQuestionListException()}.
	 */
	@Test
	public void testEmptyQuestionListException() {
		EmptyQuestionListException e = new EmptyQuestionListException();
		assertEquals("There was an empty question list", e.getMessage());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.movie_trivia.util.EmptyQuestionListException#EmptyQuestionListException(java.lang.String)}.
	 */
	@Test
	public void testEmptyQuestionListExceptionString() {
		EmptyQuestionListException e = new EmptyQuestionListException("Encountered Empty String");
		assertEquals("Encountered Empty String", e.getMessage());
	}

}
