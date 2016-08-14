package edu.ncsu.csc216.movie_trivia.question;

import java.util.ArrayList;
import java.util.List;

import edu.ncsu.csc216.movie_trivia.util.EmptyQuestionListException;
import edu.ncsu.csc216.question_library.AdvancedQuestion;
import edu.ncsu.csc216.question_library.ElementaryQuestion;
import edu.ncsu.csc216.question_library.Question;
import edu.ncsu.csc216.question_library.StandardQuestion;

/**
 * Defines the behavior for the MovieQuestions class that implements a
 * Finite State Machine for question sequencing, additions, and transitions.
 * 
 * @author Benjamin Zich
 *
 */
public class MovieQuestions {
	/** The number of correct answers gotten by the user. */
	private int numCorrectAnswers = 0;
	/** The number of attempted answers by the user. */
	private int numAttemptQuests = 0;
	/** The text to be displayed when a correct answer is selected */
	public static final String CORRECT = "Correct!";
	/** The text to be displayed when an incorrect answer is selected . */
	public static final String INCORRECT = "Incorrect!";
	/** The separator for text in questions */
	public static final String SEPARATOR = " ";
	/** The current question state to deliver to the user */
	private QuestionState currentState;
	/** The elementary question state.*/
	private ElementaryQuestionState elementaryState;
	/** The standard question state.*/
	private StandardQuestionState standardState;
	/** The advanced question state.*/
	private AdvancedQuestionState advancedState;
	
	/**
	 * The constructor for MovieQuestions creates the object with lists of questions
	 * of three difficulty levels that will be used to ask the user questions.
	 * 
	 * @param standardQuestions list of questions of standard difficulty.
	 * @param elementaryQuestions list of questions of elementary difficulty.
	 * @param advancedQuestions list of questions of advanced difficulty.
	 */
	public MovieQuestions(List<StandardQuestion> standardQuestions, 
			List<ElementaryQuestion> elementaryQuestions, List<AdvancedQuestion> advancedQuestions) {
		elementaryState = new ElementaryQuestionState(elementaryQuestions);
		standardState = new StandardQuestionState(standardQuestions);
		advancedState = new AdvancedQuestionState(advancedQuestions);
		currentState = standardState;
		currentState.nextQuestion();
	}
	
	/**
	 * Checks to see if the current list of questions the user is working through has 
	 * more questions to pose to the user.
	 * 
	 * @return true when there are more questions to ask the user in the current question
	 * list.
	 */
	public boolean hasMoreQuestions() {
		return currentState.hasMoreQuestions();
	}
	
	/**
	 * Gets the current question text to pose to the user and displayed in the 
	 * GUI.
	 * 
	 * @return the question in text form
	 * @throws EmptyQuestionListException when the current question is null
	 */
	public String getCurrentQuestionText() throws EmptyQuestionListException {
		return currentState.getCurrentQuestionText();
	}
	
	/**
	 * Gets the current question choices that are incorrect in order to display
	 * them to the user through the GUI.
	 * 
	 * @return the incorrect answers to the current question in text form
	 * @throws EmptyQuestionListException when the current question is null
	 */
	public String[] getCurrentQuestionChoices() throws EmptyQuestionListException {
		return currentState.getCurrentQuestionChoices();
	}
	
	/**
	 * Accepts an answer from the user and evaluates it to see if it is the correct
	 * answer and then displays a message to the user to communicate whether the 
	 * answer was correct or incorrect.
	 * 
	 * @param answer the answer that the user has selected for the question
	 * @return a message to the user whether the answer was correct
	 * @throws EmptyQuestionListException when the current question is null
	 */
	public String processAnswer(String answer) throws EmptyQuestionListException {
		return currentState.processAnswer(answer);
	}
	
	/**
	 * Gets the number of correct answers that the user has selected so far in
	 * the running of the movie trivia program.
	 * 
	 * @return the number of correct answers the user has answered
	 */
	public int getNumCorrectQuestions() {
		return numCorrectAnswers;
	}
	
	/**
	 * Gets the number of attempts the user has made to answer the questions
	 * thus far in the movie trivia program regardless of whether the answer
	 * was correct.
	 * 
	 * @return the number of attempted answers
	 */
	public int getNumAttemptedQuestions() {
		return numAttemptQuests;
	}
	
	/**
	 * Adds a standard question to the list of questions to increase the number
	 * of questions in the question array. Adding a question will not
	 * remove any question currently in the list.
	 * 
	 * @param q the standard question to be added into the standard question list
	 */
	public void addStandardQuestion(StandardQuestion q) {
		standardState.addQuestion(q);
	}
	
	/**
	 * Adds an elementary question to the list of questions to increase the number
	 * of questions in the question array. Adding a question will not
	 * remove any question currently in the list.
	 * 
	 * @param question the elementary question to be added into the standard question list
	 */
	public void addElementaryQuestion(ElementaryQuestion question) {
		elementaryState.addQuestion(question);
	}
	
	/**
	 * Adds an advanced question to the list of questions to increase the number
	 * of questions in the question array. Adding a question will not
	 * remove any question currently in the list.
	 * 
	 * @param question the advanced question to be added into the advanced question list
	 */
	public void addAdvancedQuestion(AdvancedQuestion question) {
		advancedState.addQuestion(question);
	}
	
	/**
	 * Gets the list of standard questions that were given to the MovieQuestion object.
	 * 
	 * @return the list of standard questions
	 */
	public List<Question> getStandardQuestions() {
		return standardState.getQuestions();
	}
	
	/**
	 * Gets the list of elementary questions that were given to the MovieQuestion object.
	 * 
	 * @return the list of elementary questions
	 */
	public List<Question> getElementaryQuestions() {
		return elementaryState.getQuestions();
	}
	
	/**
	 * Gets the list of advanced questions that were given to the MovieQuestion object.
	 * 
	 * @return the list of advanced questions
	 */
	public List<Question> getAdvancedQuestions() {
		return advancedState.getQuestions();
	}
	
	/**
	 * Defines the behaviors of the question state when the question
	 * is an elementary question.
	 * 
	 * @author Benjamin Zich
	 *
	 */
	public class ElementaryQuestionState extends QuestionState {
		/** The number of attempts the user has made to answer the 
		 * current question.
		 */
		private int attempts = 0;
		/** The number of elementary questions the user has gotten correct
		 * in a row.
		 */
		private int numCorrectInRow = 0;
		
		/**
		 * Constructs the ElementaryQuestionState object for a given list of 
		 * elementary questions.
		 * 
		 * @param list the list of elementary questions to be posed in the 
		 * elementary question state.
		 */
		public ElementaryQuestionState(List<ElementaryQuestion> list) {
			super(new ArrayList<Question>(list));
		}
		
		/**
		 * Evaluates whether an answer given by the user is correct and displays
		 * whether the answer was correct.
		 * 
		 * @param answer is the answer selected by the user to evaluate
		 * @return text indicating whether the selected answer was correct.
		 * 
		 */
		public String processAnswer(String answer) throws EmptyQuestionListException {
			if (elementaryState.getCurrentQuestionAnswer().equalsIgnoreCase(answer)) {
				if (attempts == 0 && numCorrectInRow == 1) {
					currentState = standardState;
					numCorrectInRow = 0;
					numAttemptQuests++;
				} else if (attempts == 0 && numCorrectInRow == 0) {
					numCorrectInRow++;
					numAttemptQuests++;
				} else if (attempts == 1 && numCorrectInRow == 0) {
					attempts = 0;
				}
				currentState.nextQuestion();
				numCorrectAnswers++;
				return CORRECT;
			}
			if (attempts == 0) {
				ElementaryQuestion m = (ElementaryQuestion)elementaryState.getCurrentQuestion();
				attempts++;
				numCorrectInRow = 0;
				numAttemptQuests++;
				return INCORRECT + SEPARATOR + m.getHint();
			}
			attempts = 0;
			numCorrectInRow = 0;
			currentState.nextQuestion();
			return INCORRECT;
		}
	}
	
	/**
	 * Defines the behaviors of the question state when the question
	 * is a standard question.
	 * 
	 * @author Benjamin Zich
	 *
	 */
	public class StandardQuestionState extends QuestionState {
		/** Number of questions answered correctly consecutively. */
		private int numCorrectInRow = 0;
		
		/**
		 * Constructs the StandardQuestionState object for a given list of 
		 * standard questions.
		 * 
		 * @param list the list of standard questions to be posed in the 
		 * standard question state.
		 */
		public StandardQuestionState(List<StandardQuestion> list) {
			super(new ArrayList<Question>(list));
		}
		
		/**
		 * Evaluates whether an answer given by the user is correct and displays
		 * whether the answer was correct.
		 * 
		 * @param answer is the answer selected by the user to evaluate
		 * @return text indicating whether the selected answer was correct.
		 * @throws EmptyQuestionListException 
		 * 
		 */
		public String processAnswer(String answer) throws EmptyQuestionListException {
			if (standardState.getCurrentQuestionAnswer().equalsIgnoreCase(answer)) {
				if (numCorrectInRow == 1) {
					numCorrectInRow = 0;
					currentState = advancedState;
					currentState.nextQuestion();
					numCorrectAnswers++;
					numAttemptQuests++;
					return CORRECT;
				}
				numCorrectInRow++;
				currentState.nextQuestion();
				numCorrectAnswers++;
				numAttemptQuests++;
				return CORRECT;
			}
			numCorrectInRow = 0;
			currentState = elementaryState;
			currentState.nextQuestion();
			numAttemptQuests++;
			return INCORRECT;
		}
	}
	
	/**
	 * Defines the behaviors of the question state when the question
	 * is an advanced question.
	 * 
	 * @author Benjamin Zich
	 *
	 */
	public class AdvancedQuestionState extends QuestionState {
		
		/**
		 * Constructs the AdvancedQuestionState object for a given list of 
		 * advanced questions.
		 * 
		 * @param list the list of standard questions to be posed in the 
		 * standard question state.
		 */
		public AdvancedQuestionState(List<AdvancedQuestion> list) {
			super(new ArrayList<Question>(list));
		}
		
		/**
		 * Evaluates whether an answer given by the user is correct and displays
		 * whether the answer was correct.
		 * 
		 * @param answer is the answer selected by the user to evaluate
		 * @return text indicating whether the selected answer was correct.
		 * 
		 */
		public String processAnswer(String answer) throws EmptyQuestionListException {
			if (currentState.getCurrentQuestionAnswer().equalsIgnoreCase(answer)) {
				AdvancedQuestion m = (AdvancedQuestion)currentState.getCurrentQuestion();
				currentState.nextQuestion();
				numCorrectAnswers++;
				numAttemptQuests++;
				return CORRECT + SEPARATOR + m.getComment();
			}
			currentState = standardState;
			currentState.nextQuestion();
			numAttemptQuests++;
			return INCORRECT;
		}
	}

}
