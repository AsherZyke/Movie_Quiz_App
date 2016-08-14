/**
 * 
 */
package edu.ncsu.csc216.movie_trivia.quiz;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;

import edu.ncsu.csc216.movie_trivia.util.EmptyQuestionListException;
import edu.ncsu.csc216.question_library.QuestionException;
import edu.ncsu.csc216.question_library.StandardQuestion;
import junit.framework.TestCase;

/**
 * Tests the MovieTrivia class.
 * 
 * @author Benjamin Zich
 *
 */
public class MovieTriviaTest extends TestCase {

	/** Contains all of the files that will be created by the tests */
	private String [] fileNames = {"standard1.xml", "standard2.xml", "elementary1.xml", "elementary2.xml", "advanced1.xml", "advanced2.xml", "all.xml"};
	/** Contains all of the files containing the expected result for testing */
	private String [] expectedFileNames = {"exp_standard1.xml", "exp_standard2.xml", "exp_elementary1.xml", "exp_elementary2.xml", "exp_advanced1.xml", "exp_advanced2.xml", "exp_all.xml"};
	/** Contains the standard set of questions */
	private String question1 = "questions1.xml";
	
	/** A standard question */
	private static final String STD_QUESTION = "How many licks to reach the center of a Tootsie Pop?";
	/** A standard question choice a */
	private static final String STD_CHOICE_A = "1";
	/** A standard question choice b */
	private static final String STD_CHOICE_B = "2";
	/** A standard question choice c */
	private static final String STD_CHOICE_C = "3";
	/** A standard question choice d */
	private static final String STD_CHOICE_D = "the world may never know";
	/** A standard question answer */
	private static final String STD_ANSWER = "d";
	
	/** An elementary question */
	private static final String ELEM_QUESTION = "How much wood can a woodchuck chuck?";
	/** An elementary question choice a */
	private static final String ELEM_CHOICE_A = "1 bushel";
	/** An elementary question choice b */
	private static final String ELEM_CHOICE_B = "2 bushels";
	/** An elementary question choice c */
	private static final String ELEM_CHOICE_C = "3 bushels";
	/** An elementary question choice d */
	private static final String ELEM_CHOICE_D = "4 bushels";
	/** An elementary question answer */
	private static final String ELEM_ANSWER = "b";
	/** An elementary question hint */
	private static final String ELEM_HINT = "Greater than 1 bushel and less than 3 bushels.";
	
	/** An advanced question */
	private static final String ADV_QUESTION = "What is the answer to life, the universe, and everything?";
	/** An advanced question choice a */
	private static final String ADV_CHOICE_A = "42";
	/** An advanced question choice b */
	private static final String ADV_CHOICE_B = "nothing";
	/** An advanced question choice c */
	private static final String ADV_CHOICE_C = "infinity";
	/** An advanced question choice d */
	private static final String ADV_CHOICE_D = "7";
	/** An advanced question answer */
	private static final String ADV_ANSWER = "a";
	/** An advanced question comment */
	private static final String ADV_COMMENT = "Now, what is the question?";
	
	/**
	 * Sets up the project for each test case by deleting any of the 
	 * test files that were generated from earlier runs of the testing
	 * program.  Not deleting these files will cause test failures.
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		
		//Delete all files created by the tests
		//The files may not exist depending on which test was run last
		
		for (int i = 0; i < fileNames.length; i++) {
			File f = new File(fileNames[i]);
			if (f.exists()) {
				f.delete();
			}
		}
	}
	
	/**
	 * Compares the contents of the two files.  Returns true if the contents
	 * are exactly the same.  Returns false if the contents are not the
	 * same or if there are any errors while processing.
	 * 
	 * @param expectedFile the file with the expected results
	 * @param actualFile the file with the actual results
	 * @return true if the files are exactly the same and false otherwise
	 */
	private boolean compareFiles(File expectedFile, File actualFile) {
		try {
			Scanner expectedIn = new Scanner(expectedFile);
			String expected = "";
			while (expectedIn.hasNextLine()) {
				expected += expectedIn.nextLine();
			}
			expectedIn.close();
			
			Scanner actualIn = new Scanner(actualFile);
			String actual = "";
			while (actualIn.hasNextLine()) {
				actual += actualIn.nextLine();
			}
			actualIn.close();
			return expected.equals(actual);
		} catch (FileNotFoundException e) {
			return false;
		}
	}
	
	/**
	 * Tests that a {@link StandardQuestion} created by the user
	 * and added to the collection via the addStandardQuestion() method
	 * is written successfully to the XML file.
	 */
	public void testMovieTriviaAddStandardElementaryQuestion() {

		String[] stdChoices = { STD_CHOICE_A, STD_CHOICE_B, STD_CHOICE_C, STD_CHOICE_D };
		String[] elemChoices = { ELEM_CHOICE_A, ELEM_CHOICE_B, ELEM_CHOICE_C, ELEM_CHOICE_D };
		
		String actualFileName = fileNames[6];
		String expectedFileName = expectedFileNames[6];
		String fileNameWithAdvanced = expectedFileNames[4];
		
		//Check that the file doesn't exist
		File actualFile = new File(actualFileName);
		File expectedFile = new File(expectedFileName);
		assertTrue("MovieTrivia.testQuestionWriterAddStandardQuestion() - expected file doesn't exist, can't continue test", expectedFile.exists());
		
		MovieTrivia adder = null;
		try {			
			adder = new MovieTrivia(fileNameWithAdvanced);
			adder.addStandardQuestion(STD_QUESTION, stdChoices, STD_ANSWER);
			adder.addElementaryQuestion(ELEM_QUESTION, elemChoices, ELEM_ANSWER, ELEM_HINT);
			adder.writeQuestions(actualFileName);
			
			assertTrue("MovieTrivia.testQuestionWriterAddStandardQuestion() - file doesn't exist, can't continue test", actualFile.exists());
			
			assertTrue("MovieTrivia.testQuestionWriterAddStandardQuestion() - file doesn't match expected.", compareFiles(expectedFile, actualFile));
			
		} catch (QuestionException e) {
			fail("MovieTrivia.testQuestionWriterAddStandardQuestion() - unexpected exception");
		}
	}
	
	/**
	 * Tests that a {@link StandardQuestion} created by the user
	 * and added to the collection via the addStandardQuestion() method
	 * is written successfully to the XML file.
	 */
	public void testMovieTriviaAddStandardAdvancedQuestion() {

		String[] stdChoices = { STD_CHOICE_A, STD_CHOICE_B, STD_CHOICE_C, STD_CHOICE_D };
		String[] advChoices = { ADV_CHOICE_A, ADV_CHOICE_B, ADV_CHOICE_C, ADV_CHOICE_D };
		
		String actualFileName = fileNames[6];
		String expectedFileName = expectedFileNames[6];
		String fileNameWithElem = expectedFileNames[2];
		
		//Check that the file doesn't exist
		File actualFile = new File(actualFileName);
		File expectedFile = new File(expectedFileName);
		assertTrue("MovieTrivia.testQuestionWriterAddStandardQuestion() - expected file doesn't exist, can't continue test", expectedFile.exists());
		
		MovieTrivia adder = null;
		try {			
			adder = new MovieTrivia(fileNameWithElem);
			adder.addStandardQuestion(STD_QUESTION, stdChoices, STD_ANSWER);
			adder.addAdvancedQuestion(ADV_QUESTION, advChoices, ADV_ANSWER, ADV_COMMENT);
			adder.writeQuestions(actualFileName);
			
			assertTrue("MovieTrivia.testQuestionWriterAddStandardQuestion() - file doesn't exist, can't continue test", actualFile.exists());
			
			assertTrue("MovieTrivia.testQuestionWriterAddStandardQuestion() - file doesn't match expected.", compareFiles(expectedFile, actualFile));
			
		} catch (QuestionException e) {
			fail("MovieTrivia.testQuestionWriterAddStandardQuestion() - unexpected exception");
		}
	}
	
	/**
	 * Tests that a {@link StandardQuestion} created by the user
	 * and added to the collection via the addStandardQuestion() method
	 * is written successfully to the XML file.
	 */
	public void testMovieTriviaAddNullStrings() {

		String[] stdChoices = { STD_CHOICE_A, null, STD_CHOICE_C, STD_CHOICE_D };
		String[] elemChoices = { ELEM_CHOICE_A, ELEM_CHOICE_B, ELEM_CHOICE_C, ELEM_CHOICE_D };
		String[] nullArray = null;

		
		MovieTrivia adder = null;
		try {			
			adder = new MovieTrivia(question1);
			adder.addStandardQuestion(STD_QUESTION, stdChoices, STD_ANSWER);
			fail();
		} catch (QuestionException e) {
			fail("MovieTrivia.testQuestionWriterAddStandardQuestion() - unexpected exception");
		} catch (IllegalArgumentException e) {
			assertTrue(adder.hasMoreQuestions());
		}
		
		try {
			adder.addElementaryQuestion(ELEM_QUESTION, elemChoices, null, ELEM_HINT);
		} catch (IllegalArgumentException e) {
			assertTrue(adder.hasMoreQuestions());
		}
		try {
			adder.addAdvancedQuestion(ADV_QUESTION, nullArray, ADV_ANSWER, ADV_COMMENT);
		} catch (IllegalArgumentException e) {
			assertTrue(adder.hasMoreQuestions());
		}
	}


	/**
	 * Test method for {@link edu.ncsu.csc216.movie_trivia.quiz.MovieTrivia#processAnswer(java.lang.String)}.
	 */
	@Test
	public void testProcessAnswer() {
		try {
			MovieTrivia triviaManager = new MovieTrivia(question1);
			//Preliminary state
			assertEquals(0, triviaManager.getNumAttemptedQuestions());
			assertEquals(0, triviaManager.getNumCorrectQuestions());
			triviaManager.processAnswer("d");
			assertEquals("Choice a", triviaManager.getCurrentQuestionChoices()[0]);
			assertEquals("Standard Question 2", triviaManager.getCurrentQuestionText());
			
			
		} catch (QuestionException e) {
			fail();
		} catch (EmptyQuestionListException e) {
			fail();
		}
		
	}


}
