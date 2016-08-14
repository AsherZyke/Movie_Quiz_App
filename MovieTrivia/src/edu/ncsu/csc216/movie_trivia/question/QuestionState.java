package edu.ncsu.csc216.movie_trivia.question;

import java.util.ArrayList;
import java.util.List;

import edu.ncsu.csc216.movie_trivia.util.EmptyQuestionListException;
import edu.ncsu.csc216.question_library.Question;

/**
 * Defines the abstract class QuestionState behaviors governing
 * questions of various types.
 * 
 * @author Benjamin Zich
 *
 */
public abstract class QuestionState {
	/** The front of the current list of questions */
	private static final int FRONT = 0;
	/** 
	 * All questions that are unasked, new user-created questions are
	 *  added to the end of the list.
	 */
	private List<Question> waitingQuestions;
	/** 
	 * All the questions that have been asked.
	 * The last question in the list is currentQuestion. 
	 */
	private List<Question> askedQuestions = new ArrayList<Question>();
	/** The current question that would be asked of the user. */
	private Question currentQuestion;
	
	/**
	 * Constructs the QuestionState object and adds the question list to the 
	 * object's members. The list will be accessed to get questions to present
	 * to the user of the movie trivia program.
	 * 
	 * @param list is the question list to be added to the object.
	 */
	public QuestionState(List<Question> list) {
		waitingQuestions = list;
	}
	
	/**
	 * Evaluates an answer given by a user when posed by a question for whether the
	 * answer selected was correct or incorrect. Gives the user feedback on whether
	 * the answer selected was correct.
	 * 
	 * @param answer the answer selected by the user
	 * @return text telling the user whether the answer was correct or not
	 * @throws EmptyQuestionListException when the current question is null
	 */
	abstract String processAnswer(String answer) throws EmptyQuestionListException;
	
	/**
	 * Checks to see if the current question list has more questions to ask. If not,
	 * the quiz will end when this method returns false.
	 * 
	 * @return true if there are more questions to ask the user in the current question
	 * list.
	 */
	public boolean hasMoreQuestions() {
		return (currentQuestion != null || !waitingQuestions.isEmpty());
	}
	
	/**
	 * Gets the current question text to display to the user. 
	 * 
	 * @return the text of the current question
	 * @throws EmptyQuestionListException when the current question is null
	 */
	public String getCurrentQuestionText() throws EmptyQuestionListException {
		if (currentQuestion == null) {
			throw new EmptyQuestionListException();
		}
		return currentQuestion.getQuestion();
	}
	
	/**
	 * Gets the current question choices to display to the user
	 * to select from.
	 * 
	 * @return an array of the incorrect answers in text form
	 * @throws EmptyQuestionListException is thrown when the current question is null
	 */
	public String[] getCurrentQuestionChoices() throws EmptyQuestionListException {
		if (currentQuestion == null) {
			throw new EmptyQuestionListException();
		}
		String[] choices = { currentQuestion.getChoiceA(), currentQuestion.getChoiceB(), 
				currentQuestion.getChoiceC(), currentQuestion.getChoiceD() };
		return choices;
	}
	
	/**
	 * Gets the current question answer to display to the user
	 *  so that the user can select an incorrect answer or 
	 * a correct answer.
	 * 
	 * @return the correct answer in text form
	 * @throws EmptyQuestionListException when the current question is null
	 */
	public String getCurrentQuestionAnswer() throws EmptyQuestionListException {
		if (currentQuestion == null) {
			throw new EmptyQuestionListException();
		}
		return currentQuestion.getAnswer();
	}
	
	/**
	 * Gets the current question in the array of questions that the user is 
	 * working through. When there are no more questions this will return null
	 * to indicate that there are no more questions to ask.
	 * 
	 * @return the current question, null if there are no more questions
	 * @throws EmptyQuestionListException when the current question is null
	 */
	public Question getCurrentQuestion() throws EmptyQuestionListException {
		if (currentQuestion == null) {
			throw new EmptyQuestionListException();
		}
		return currentQuestion;
	}
	
	/**
	 * Adds the next question in waitingQuestions to currentQuestion or null
	 * if there are no more questions in the list. The currentQuestion is added
	 * to the end of the asked question list.
	 */
	public void nextQuestion() {
		if (waitingQuestions.isEmpty()) {
			currentQuestion = null;
		} else {
			currentQuestion = waitingQuestions.get(FRONT);
			askedQuestions.add(currentQuestion);
			waitingQuestions.remove(FRONT);
		}
		
	}
	
	/**
	 * Adds a question to waitingQuestion list to ask the user. The question
	 * is not added to the underlying xml file until the question array is 
	 * written to the xml file.
	 * 
	 * @param question the question to be added to the list of questions
	 */
	public void addQuestion(Question question) {
		if (currentQuestion == null && waitingQuestions.isEmpty()) {
			waitingQuestions.add(question);
			this.nextQuestion();
		} else {
			waitingQuestions.add(question);
		}
	}
	
	/**
	 * Gets a list of questions to ask the user. The list should contain
	 * questions only of a certain type - standard, elementary, or advanced.
	 * 
	 * @return a list of questions to ask the user
	 */
	public List<Question> getQuestions() {
		List<Question> jointCollection = askedQuestions;
		jointCollection.addAll(waitingQuestions);
		return jointCollection;
	}
	

}