/**
 * 
 */
package edu.ncsu.csc216.movie_trivia.question;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Test;

import edu.ncsu.csc216.movie_trivia.util.EmptyQuestionListException;
import edu.ncsu.csc216.question_library.AdvancedQuestion;
import edu.ncsu.csc216.question_library.ElementaryQuestion;
import edu.ncsu.csc216.question_library.StandardQuestion;

/**
 * Tests the MovieQuestion class.
 * 
 * @author Benjamin Zich
 *
 */
public class MovieQuestionsTest {
	
	/** A standard question */
	private static final String STD_QUESTION1 = "How many licks to reach the center of a Tootsie Pop?";
	/** A standard question choice a */
	private static final String STD_CHOICE_A1 = "1";
	/** A standard question choice b */
	private static final String STD_CHOICE_B1 = "2";
	/** A standard question choice c */
	private static final String STD_CHOICE_C1 = "3";
	/** A standard question choice d */
	private static final String STD_CHOICE_D1 = "the world may never know";
	/** A standard question answer */
	private static final String STD_ANSWER1 = "d";
	
	
	/** Second standard question */
	private static final String STD_QUESTION2 = "How many angels can dance on the head of a pin?";
	/** Second standard question choice a */
	private static final String STD_CHOICE_A2 = "What?";
	/** Second standard question choice b */
	private static final String STD_CHOICE_B2 = "Are you high?";
	/** Second standard question choice c */
	private static final String STD_CHOICE_C2 = "0";
	/** Second standard question choice d */
	private static final String STD_CHOICE_D2 = "Never talk to me or my wife's son ever again.";
	/** Second standard question answer */
	private static final String STD_ANSWER2 = "d";
	
	/** Third standard question */
	private static final String STD_QUESTION3 = "What's 1x1";
	/** Third standard question choice a */
	private static final String STD_CHOICE_A3 = "1";
	/** Third standard question choice b */
	private static final String STD_CHOICE_B3 = "2";
	/** Third standard question choice c */
	private static final String STD_CHOICE_C3 = "3";
	/** Third standard question choice d */
	private static final String STD_CHOICE_D3 = "4";
	/** Third standard question answer */
	private static final String STD_ANSWER3 = "a";
	
	/** An elementary question */
	private static final String ELEM_QUESTION1 = "How much wood can a woodchuck chuck?";
	/** An elementary question choice a */
	private static final String ELEM_CHOICE_A1 = "1 bushel";
	/** An elementary question choice b */
	private static final String ELEM_CHOICE_B1 = "2 bushels";
	/** An elementary question choice c */
	private static final String ELEM_CHOICE_C1 = "3 bushels";
	/** An elementary question choice d */
	private static final String ELEM_CHOICE_D1 = "4 bushels";
	/** An elementary question answer */
	private static final String ELEM_ANSWER1 = "b";
	/** An elementary question hint */
	private static final String ELEM_HINT1 = "Greater than 1 bushel and less than 3 bushels.";
	
	/** Second elementary question */
	private static final String ELEM_QUESTION2 = "What have I got in my pocket?";
	/** Second elementary question choice a */
	private static final String ELEM_CHOICE_A2 = "Not a fair riddle, it asks.";
	/** Second elementary question choice b */
	private static final String ELEM_CHOICE_B2 = "It wins, nasty hobit.";
	/** Second elementary question choice c */
	private static final String ELEM_CHOICE_C2 = "But maybe we shows it something pretty.";
	/** Second elementary question choice d */
	private static final String ELEM_CHOICE_D2 = "My birthday present.";
	/** Second elementary question answer */
	private static final String ELEM_ANSWER2 = "b";
	/** Second elementary question hint */
	private static final String ELEM_HINT2 = "What's got hairy feet?";
	
	/** Third elementary question */
	private static final String ELEM_QUESTION3 = "What is your favorite color?";
	/** Third elementary question choice a */
	private static final String ELEM_CHOICE_A3 = "Red";
	/** Third elementary question choice b */
	private static final String ELEM_CHOICE_B3 = "Blue";
	/** Third elementary question choice c */
	private static final String ELEM_CHOICE_C3 = "Black";
	/** Third elementary question choice d */
	private static final String ELEM_CHOICE_D3 = "Pink";
	/** Third elementary question answer */
	private static final String ELEM_ANSWER3 = "b";
	/** Third elementary question hint */
	private static final String ELEM_HINT3 = "Duke _____";
	
	/** Fourth elementary question */
	private static final String ELEM_QUESTION4 = "I really want to get a ___?";
	/** Fourth elementary question choice a */
	private static final String ELEM_CHOICE_A4 = "Tesla";
	/** Fourth elementary question choice b */
	private static final String ELEM_CHOICE_B4 = "Drone";
	/** Fourth elementary question choice c */
	private static final String ELEM_CHOICE_C4 = "NVIDIA 1080";
	/** Fourth elementary question choice d */
	private static final String ELEM_CHOICE_D4 = "Dumbell set";
	/** Fourth elementary question answer */
	private static final String ELEM_ANSWER4 = "c";
	/** Fourth elementary question hint */
	private static final String ELEM_HINT4 = "New graphics card";
	
	/** An advanced question */
	private static final String ADV_QUESTION1 = "What is the answer to life, the universe, and everything?";
	/** An advanced question choice a */
	private static final String ADV_CHOICE_A1 = "42";
	/** An advanced question choice b */
	private static final String ADV_CHOICE_B1 = "nothing";
	/** An advanced question choice c */
	private static final String ADV_CHOICE_C1 = "infinity";
	/** An advanced question choice d */
	private static final String ADV_CHOICE_D1 = "7";
	/** An advanced question answer */
	private static final String ADV_ANSWER1 = "a";
	/** An advanced question comment */
	private static final String ADV_COMMENT1 = "Now, what is the question?";
	
	/** Second advanced question */
	private static final String ADV_QUESTION2 = "Who killed Laura Palmer?";
	/** Second advanced question choice a */
	private static final String ADV_CHOICE_A2 = "Bob";
	/** Second advanced question choice b */
	private static final String ADV_CHOICE_B2 = "Cooper";
	/** Second advanced question choice c */
	private static final String ADV_CHOICE_C2 = "One Eyed Jack";
	/** Second advanced question choice d */
	private static final String ADV_CHOICE_D2 = "David Lynch";
	/** Second advanced question answer */
	private static final String ADV_ANSWER2 = "a";
	/** Second advanced question comment */
	private static final String ADV_COMMENT2 = "Are you ready for a new season?";
	

	/**
	 * Test method for {@link edu.ncsu.csc216.movie_trivia.question.MovieQuestions#MovieQuestions(java.util.List, java.util.List, java.util.List)}.
	 */
	@Test
	public void testMovieQuestions() {
		//Advanced questions
		AdvancedQuestion adv1 = new AdvancedQuestion();
		adv1.setQuestion(ADV_QUESTION1);
		adv1.setChoiceA(ADV_CHOICE_A1);
		adv1.setChoiceB(ADV_CHOICE_B1);
		adv1.setChoiceC(ADV_CHOICE_C1);
		adv1.setChoiceD(ADV_CHOICE_D1);
		adv1.setAnswer(ADV_ANSWER1);
		adv1.setComment(ADV_COMMENT1);
		
		AdvancedQuestion adv2 = new AdvancedQuestion();
		adv2.setQuestion(ADV_QUESTION2);
		adv2.setChoiceA(ADV_CHOICE_A2);
		adv2.setChoiceB(ADV_CHOICE_B2);
		adv2.setChoiceC(ADV_CHOICE_C2);
		adv2.setChoiceD(ADV_CHOICE_D2);
		adv2.setAnswer(ADV_ANSWER2);
		adv2.setComment(ADV_COMMENT2);
		
		//Standard questions
		StandardQuestion std1 = new StandardQuestion();
		std1.setQuestion(STD_QUESTION1);
		std1.setChoiceA(STD_CHOICE_A1);
		std1.setChoiceB(STD_CHOICE_B1);
		std1.setChoiceC(STD_CHOICE_C1);
		std1.setChoiceD(STD_CHOICE_D1);
		std1.setAnswer(STD_ANSWER1);
		
		StandardQuestion std2 = new StandardQuestion();
		std2.setQuestion(STD_QUESTION2);
		std2.setChoiceA(STD_CHOICE_A2);
		std2.setChoiceB(STD_CHOICE_B2);
		std2.setChoiceC(STD_CHOICE_C2);
		std2.setChoiceD(STD_CHOICE_D2);
		std2.setAnswer(STD_ANSWER2);
		
		StandardQuestion std3 = new StandardQuestion();
		std3.setQuestion(STD_QUESTION3);
		std3.setChoiceA(STD_CHOICE_A3);
		std3.setChoiceB(STD_CHOICE_B3);
		std3.setChoiceC(STD_CHOICE_C3);
		std3.setChoiceD(STD_CHOICE_D3);
		std3.setAnswer(STD_ANSWER3);
		
		//Elementary Questions
		ElementaryQuestion elem1 = new ElementaryQuestion();
		elem1.setQuestion(ELEM_QUESTION1);
		elem1.setChoiceA(ELEM_CHOICE_A1);
		elem1.setChoiceB(ELEM_CHOICE_B1);
		elem1.setChoiceC(ELEM_CHOICE_C1);
		elem1.setChoiceD(ELEM_CHOICE_D1);
		elem1.setAnswer(ELEM_ANSWER1);
		elem1.setHint(ELEM_HINT1);
		
		ElementaryQuestion elem2 = new ElementaryQuestion();
		elem2.setQuestion(ELEM_QUESTION2);
		elem2.setChoiceA(ELEM_CHOICE_A2);
		elem2.setChoiceB(ELEM_CHOICE_B2);
		elem2.setChoiceC(ELEM_CHOICE_C2);
		elem2.setChoiceD(ELEM_CHOICE_D2);
		elem2.setAnswer(ELEM_ANSWER2);
		elem2.setHint(ELEM_HINT2);
		
		ElementaryQuestion elem3 = new ElementaryQuestion();
		elem3.setQuestion(ELEM_QUESTION3);
		elem3.setChoiceA(ELEM_CHOICE_A3);
		elem3.setChoiceB(ELEM_CHOICE_B3);
		elem3.setChoiceC(ELEM_CHOICE_C3);
		elem3.setChoiceD(ELEM_CHOICE_D3);
		elem3.setAnswer(ELEM_ANSWER3);
		elem3.setHint(ELEM_HINT3);
		
		ElementaryQuestion elem4 = new ElementaryQuestion();
		elem4.setQuestion(ELEM_QUESTION4);
		elem4.setChoiceA(ELEM_CHOICE_A4);
		elem4.setChoiceB(ELEM_CHOICE_B4);
		elem4.setChoiceC(ELEM_CHOICE_C4);
		elem4.setChoiceD(ELEM_CHOICE_D4);
		elem4.setAnswer(ELEM_ANSWER4);
		elem4.setHint(ELEM_HINT4);
		
		//The ArrayLists of questions
		ArrayList<StandardQuestion> standardQuestions = new ArrayList<StandardQuestion>();
		standardQuestions.add(std1);
		standardQuestions.add(std2);
		standardQuestions.add(std3);
		
		ArrayList<ElementaryQuestion> elementaryQuestions = new ArrayList<ElementaryQuestion>();
		elementaryQuestions.add(elem1);
		elementaryQuestions.add(elem2);
		elementaryQuestions.add(elem3);
		elementaryQuestions.add(elem4);
		
		ArrayList<AdvancedQuestion> advancedQuestions = new ArrayList<AdvancedQuestion>();
		advancedQuestions.add(adv1);
		advancedQuestions.add(adv2);
		
		MovieQuestions questions = new MovieQuestions(standardQuestions, elementaryQuestions, 
				advancedQuestions);
		
		assertTrue(questions.getElementaryQuestions().equals(elementaryQuestions));
		assertTrue(questions.getStandardQuestions().equals(standardQuestions));
		assertTrue(questions.getAdvancedQuestions().equals(advancedQuestions));
		
	}
	
	/**
	 * Tests the functionality of the processAnswer() method in the MovieQuestions class
	 * and its nested classes.
	 */
	@Test
	public void testProcessQuestion() {
		//Advanced questions
				AdvancedQuestion adv1 = new AdvancedQuestion();
				adv1.setQuestion(ADV_QUESTION1);
				adv1.setChoiceA(ADV_CHOICE_A1);
				adv1.setChoiceB(ADV_CHOICE_B1);
				adv1.setChoiceC(ADV_CHOICE_C1);
				adv1.setChoiceD(ADV_CHOICE_D1);
				adv1.setAnswer(ADV_ANSWER1);
				adv1.setComment(ADV_COMMENT1);
				
				AdvancedQuestion adv2 = new AdvancedQuestion();
				adv2.setQuestion(ADV_QUESTION2);
				adv2.setChoiceA(ADV_CHOICE_A2);
				adv2.setChoiceB(ADV_CHOICE_B2);
				adv2.setChoiceC(ADV_CHOICE_C2);
				adv2.setChoiceD(ADV_CHOICE_D2);
				adv2.setAnswer(ADV_ANSWER2);
				adv2.setComment(ADV_COMMENT2);
				
				//Standard questions
				StandardQuestion std1 = new StandardQuestion();
				std1.setQuestion(STD_QUESTION1);
				std1.setChoiceA(STD_CHOICE_A1);
				std1.setChoiceB(STD_CHOICE_B1);
				std1.setChoiceC(STD_CHOICE_C1);
				std1.setChoiceD(STD_CHOICE_D1);
				std1.setAnswer(STD_ANSWER1);
				
				StandardQuestion std2 = new StandardQuestion();
				std2.setQuestion(STD_QUESTION2);
				std2.setChoiceA(STD_CHOICE_A2);
				std2.setChoiceB(STD_CHOICE_B2);
				std2.setChoiceC(STD_CHOICE_C2);
				std2.setChoiceD(STD_CHOICE_D2);
				std2.setAnswer(STD_ANSWER2);
				
				StandardQuestion std3 = new StandardQuestion();
				std3.setQuestion(STD_QUESTION3);
				std3.setChoiceA(STD_CHOICE_A3);
				std3.setChoiceB(STD_CHOICE_B3);
				std3.setChoiceC(STD_CHOICE_C3);
				std3.setChoiceD(STD_CHOICE_D3);
				std3.setAnswer(STD_ANSWER3);
				
				//Elementary Questions
				ElementaryQuestion elem1 = new ElementaryQuestion();
				elem1.setQuestion(ELEM_QUESTION1);
				elem1.setChoiceA(ELEM_CHOICE_A1);
				elem1.setChoiceB(ELEM_CHOICE_B1);
				elem1.setChoiceC(ELEM_CHOICE_C1);
				elem1.setChoiceD(ELEM_CHOICE_D1);
				elem1.setAnswer(ELEM_ANSWER1);
				elem1.setHint(ELEM_HINT1);
				
				ElementaryQuestion elem2 = new ElementaryQuestion();
				elem2.setQuestion(ELEM_QUESTION2);
				elem2.setChoiceA(ELEM_CHOICE_A2);
				elem2.setChoiceB(ELEM_CHOICE_B2);
				elem2.setChoiceC(ELEM_CHOICE_C2);
				elem2.setChoiceD(ELEM_CHOICE_D2);
				elem2.setAnswer(ELEM_ANSWER2);
				elem2.setHint(ELEM_HINT2);
				
				ElementaryQuestion elem3 = new ElementaryQuestion();
				elem3.setQuestion(ELEM_QUESTION3);
				elem3.setChoiceA(ELEM_CHOICE_A3);
				elem3.setChoiceB(ELEM_CHOICE_B3);
				elem3.setChoiceC(ELEM_CHOICE_C3);
				elem3.setChoiceD(ELEM_CHOICE_D3);
				elem3.setAnswer(ELEM_ANSWER3);
				elem3.setHint(ELEM_HINT3);
				
				ElementaryQuestion elem4 = new ElementaryQuestion();
				elem4.setQuestion(ELEM_QUESTION4);
				elem4.setChoiceA(ELEM_CHOICE_A4);
				elem4.setChoiceB(ELEM_CHOICE_B4);
				elem4.setChoiceC(ELEM_CHOICE_C4);
				elem4.setChoiceD(ELEM_CHOICE_D4);
				elem4.setAnswer(ELEM_ANSWER4);
				elem4.setHint(ELEM_HINT4);
				
				//The ArrayLists of questions
				ArrayList<StandardQuestion> standardQuestions = new ArrayList<StandardQuestion>();
				standardQuestions.add(std1);
				standardQuestions.add(std2);
				standardQuestions.add(std3);
				
				ArrayList<ElementaryQuestion> elementaryQuestions = new ArrayList<ElementaryQuestion>();
				elementaryQuestions.add(elem1);
				elementaryQuestions.add(elem2);
				elementaryQuestions.add(elem3);
				elementaryQuestions.add(elem4);
				
				ArrayList<AdvancedQuestion> advancedQuestions = new ArrayList<AdvancedQuestion>();
				advancedQuestions.add(adv1);
				advancedQuestions.add(adv2);
				
				MovieQuestions questions = new MovieQuestions(standardQuestions, elementaryQuestions, 
						advancedQuestions);
				
				//Move through the processAnswer statements of each concrete nested class
				try {
					//Preliminary state
					assertEquals(0, questions.getNumAttemptedQuestions());
					assertEquals(0, questions.getNumCorrectQuestions());
					assertEquals(STD_QUESTION1, questions.getCurrentQuestionText());
					assertEquals(STD_CHOICE_A1, questions.getCurrentQuestionChoices()[0]);
					assertEquals(STD_CHOICE_B1, questions.getCurrentQuestionChoices()[1]);
					assertEquals(STD_CHOICE_C1, questions.getCurrentQuestionChoices()[2]);
					assertEquals(STD_CHOICE_D1, questions.getCurrentQuestionChoices()[3]);
					
					//Process an incorrect answer
					questions.processAnswer("c");
					assertEquals(ELEM_QUESTION1, questions.getCurrentQuestionText());
					assertEquals(ELEM_CHOICE_A1, questions.getCurrentQuestionChoices()[0]);
					assertEquals(ELEM_CHOICE_B1, questions.getCurrentQuestionChoices()[1]);
					assertEquals(ELEM_CHOICE_C1, questions.getCurrentQuestionChoices()[2]);
					assertEquals(ELEM_CHOICE_D1, questions.getCurrentQuestionChoices()[3]);
					assertEquals(1, questions.getNumAttemptedQuestions());
					assertEquals(0, questions.getNumCorrectQuestions());
					
					questions.processAnswer("c");
					assertEquals(ELEM_QUESTION1, questions.getCurrentQuestionText());
					assertEquals(ELEM_CHOICE_A1, questions.getCurrentQuestionChoices()[0]);
					assertEquals(ELEM_CHOICE_B1, questions.getCurrentQuestionChoices()[1]);
					assertEquals(ELEM_CHOICE_C1, questions.getCurrentQuestionChoices()[2]);
					assertEquals(ELEM_CHOICE_D1, questions.getCurrentQuestionChoices()[3]);
					assertEquals(ELEM_CHOICE_A1, questions.getCurrentQuestionChoices()[0]);
					assertEquals(2, questions.getNumAttemptedQuestions());
					assertEquals(0, questions.getNumCorrectQuestions());
					
					questions.processAnswer("c");
					assertEquals(ELEM_QUESTION2, questions.getCurrentQuestionText());
					assertEquals(ELEM_CHOICE_A2, questions.getCurrentQuestionChoices()[0]);
					assertEquals(ELEM_CHOICE_B2, questions.getCurrentQuestionChoices()[1]);
					assertEquals(ELEM_CHOICE_C2, questions.getCurrentQuestionChoices()[2]);
					assertEquals(ELEM_CHOICE_D2, questions.getCurrentQuestionChoices()[3]);
					assertEquals(2, questions.getNumAttemptedQuestions());
					assertEquals(0, questions.getNumCorrectQuestions());
					
					questions.processAnswer("c");
					assertEquals(ELEM_QUESTION2, questions.getCurrentQuestionText());
					assertEquals(ELEM_CHOICE_A2, questions.getCurrentQuestionChoices()[0]);
					assertEquals(ELEM_CHOICE_B2, questions.getCurrentQuestionChoices()[1]);
					assertEquals(ELEM_CHOICE_C2, questions.getCurrentQuestionChoices()[2]);
					assertEquals(ELEM_CHOICE_D2, questions.getCurrentQuestionChoices()[3]);
					assertEquals(3, questions.getNumAttemptedQuestions());
					assertEquals(0, questions.getNumCorrectQuestions());
					
					questions.processAnswer(ELEM_ANSWER2);
					assertEquals(ELEM_QUESTION3, questions.getCurrentQuestionText());
					assertEquals(ELEM_CHOICE_A3, questions.getCurrentQuestionChoices()[0]);
					assertEquals(ELEM_CHOICE_B3, questions.getCurrentQuestionChoices()[1]);
					assertEquals(ELEM_CHOICE_C3, questions.getCurrentQuestionChoices()[2]);
					assertEquals(ELEM_CHOICE_D3, questions.getCurrentQuestionChoices()[3]);
					assertEquals(3, questions.getNumAttemptedQuestions());
					assertEquals(1, questions.getNumCorrectQuestions());
					
					questions.processAnswer(ELEM_ANSWER3);
					assertEquals(ELEM_QUESTION4, questions.getCurrentQuestionText());
					assertEquals(ELEM_CHOICE_A4, questions.getCurrentQuestionChoices()[0]);
					assertEquals(ELEM_CHOICE_B4, questions.getCurrentQuestionChoices()[1]);
					assertEquals(ELEM_CHOICE_C4, questions.getCurrentQuestionChoices()[2]);
					assertEquals(ELEM_CHOICE_D4, questions.getCurrentQuestionChoices()[3]);
					assertEquals(4, questions.getNumAttemptedQuestions());
					assertEquals(2, questions.getNumCorrectQuestions());
					
					questions.processAnswer(ELEM_ANSWER4);
					assertEquals(STD_QUESTION2, questions.getCurrentQuestionText());
					assertEquals(STD_CHOICE_A2, questions.getCurrentQuestionChoices()[0]);
					assertEquals(STD_CHOICE_B2, questions.getCurrentQuestionChoices()[1]);
					assertEquals(STD_CHOICE_C2, questions.getCurrentQuestionChoices()[2]);
					assertEquals(STD_CHOICE_D2, questions.getCurrentQuestionChoices()[3]);
					assertEquals(5, questions.getNumAttemptedQuestions());
					assertEquals(3, questions.getNumCorrectQuestions());
					
					questions.processAnswer(STD_ANSWER2);
					assertEquals(STD_QUESTION3, questions.getCurrentQuestionText());
					assertEquals(STD_CHOICE_A3, questions.getCurrentQuestionChoices()[0]);
					assertEquals(STD_CHOICE_B3, questions.getCurrentQuestionChoices()[1]);
					assertEquals(STD_CHOICE_C3, questions.getCurrentQuestionChoices()[2]);
					assertEquals(STD_CHOICE_D3, questions.getCurrentQuestionChoices()[3]);
					assertEquals(6, questions.getNumAttemptedQuestions());
					assertEquals(4, questions.getNumCorrectQuestions());
					
					questions.processAnswer(STD_ANSWER3);
					assertEquals(ADV_QUESTION1, questions.getCurrentQuestionText());
					assertEquals(ADV_CHOICE_A1, questions.getCurrentQuestionChoices()[0]);
					assertEquals(ADV_CHOICE_B1, questions.getCurrentQuestionChoices()[1]);
					assertEquals(ADV_CHOICE_C1, questions.getCurrentQuestionChoices()[2]);
					assertEquals(ADV_CHOICE_D1, questions.getCurrentQuestionChoices()[3]);
					assertEquals(7, questions.getNumAttemptedQuestions());
					assertEquals(5, questions.getNumCorrectQuestions());
					
					questions.processAnswer(ADV_ANSWER1);
					assertEquals(ADV_QUESTION2, questions.getCurrentQuestionText());
					assertEquals(ADV_CHOICE_A2, questions.getCurrentQuestionChoices()[0]);
					assertEquals(ADV_CHOICE_B2, questions.getCurrentQuestionChoices()[1]);
					assertEquals(ADV_CHOICE_C2, questions.getCurrentQuestionChoices()[2]);
					assertEquals(ADV_CHOICE_D2, questions.getCurrentQuestionChoices()[3]);
					assertEquals(8, questions.getNumAttemptedQuestions());
					assertEquals(6, questions.getNumCorrectQuestions());
					
					questions.processAnswer("d");
					assertEquals(9, questions.getNumAttemptedQuestions());
					assertFalse(questions.hasMoreQuestions());
					
					
				} catch (EmptyQuestionListException e) {
					fail();
				}
				
				
				
		
	}


}
