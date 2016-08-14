package edu.ncsu.csc216.movie_trivia.quiz;

import edu.ncsu.csc216.movie_trivia.question.MovieQuestions;
import edu.ncsu.csc216.movie_trivia.util.EmptyQuestionListException;
import edu.ncsu.csc216.question_library.AdvancedQuestion;
import edu.ncsu.csc216.question_library.ElementaryQuestion;
import edu.ncsu.csc216.question_library.Question;
import edu.ncsu.csc216.question_library.QuestionException;
import edu.ncsu.csc216.question_library.QuestionReader;
import edu.ncsu.csc216.question_library.QuestionWriter;
import edu.ncsu.csc216.question_library.StandardQuestion;

/**
 * Defines the behavior for the MovieTrivia class.
 * 
 * @author Benjamin Zich
 *
 */
public class MovieTrivia implements TriviaMaster {
	/** The reader that gets questions from the xml file */
	private QuestionReader reader;
	/** The lists of movie questions */
	private MovieQuestions questions;
	
	/**
	 * Constructs the MovieTrivia object by reading questions from a given
	 * file with a question reader.
	 * 
	 * @param questionFile the file name to read questions from.
	 * @throws QuestionException when the question reader encounters a problem
	 */
	public MovieTrivia(String questionFile) throws QuestionException {
		reader = new QuestionReader(questionFile);
		questions = new MovieQuestions(reader.getStandardQuestions(), reader.getElementaryQuestions(),
				reader.getAdvancedQuestions());
	}

	@Override
	public boolean hasMoreQuestions() {
		return questions.hasMoreQuestions();
	}

	@Override
	public String getCurrentQuestionText() throws EmptyQuestionListException {
		return questions.getCurrentQuestionText();
	}

	@Override
	public String[] getCurrentQuestionChoices() throws EmptyQuestionListException {
		return questions.getCurrentQuestionChoices();
	}

	@Override
	public String processAnswer(String answer) throws EmptyQuestionListException {
		return questions.processAnswer(answer);
	}

	@Override
	public int getNumCorrectQuestions() {
		return questions.getNumCorrectQuestions();
	}

	@Override
	public int getNumAttemptedQuestions() {
		return questions.getNumAttemptedQuestions();
	}
	
	/**
	 * Ensures that a String passed to the question writer is not null.
	 * 
	 * @param theString the String passed to the question writer. This
	 * could be a question, a hint, or a comment in the question.
	 */
	private void validateString(String theString) {
		if (theString == null || theString.equals("")) {
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 * Ensures that a String of choices is not null before passing it
	 * to the question constructor.
	 * 
	 * @param stringArray is the array of question choices.
	 */
	private void validateStringArray(String[] stringArray) {
		if (stringArray == null || stringArray.length != 4) {
			throw new IllegalArgumentException();
		}
		for (String m: stringArray) {
			validateString(m);
		}
	}

	@Override
	public void addStandardQuestion(String questionText, String[] questionChoices, String correctAnswer) {
		validateString(questionText);
		validateString(correctAnswer);
		validateStringArray(questionChoices);
		StandardQuestion q = new StandardQuestion();
		q.setQuestion(questionText);
		q.setChoiceA(questionChoices[0]);
		q.setChoiceB(questionChoices[1]);
		q.setChoiceC(questionChoices[2]);
		q.setChoiceD(questionChoices[3]);
		q.setAnswer(correctAnswer);
		questions.addStandardQuestion(q);
		
	}

	@Override
	public void addElementaryQuestion(String questionText, String[] questionChoices, String correctAnswer,
			String hint) {
		validateString(questionText);
		validateString(correctAnswer);
		validateString(hint);
		validateStringArray(questionChoices);
		ElementaryQuestion q = new ElementaryQuestion();
		q.setQuestion(questionText);
		q.setChoiceA(questionChoices[0]);
		q.setChoiceB(questionChoices[1]);
		q.setChoiceC(questionChoices[2]);
		q.setChoiceD(questionChoices[3]);
		q.setAnswer(correctAnswer);
		q.setHint(hint);
		questions.addElementaryQuestion(q);
		
	}

	@Override
	public void addAdvancedQuestion(String questionText, String[] questionChoices, String correctAnswer,
			String comment) {
		validateString(questionText);
		validateString(correctAnswer);
		validateString(comment);
		validateStringArray(questionChoices);
		AdvancedQuestion q = new AdvancedQuestion();
		q.setQuestion(questionText);
		q.setChoiceA(questionChoices[0]);
		q.setChoiceB(questionChoices[1]);
		q.setChoiceC(questionChoices[2]);
		q.setChoiceD(questionChoices[3]);
		q.setAnswer(correctAnswer);
		q.setComment(comment);
		questions.addAdvancedQuestion(q);
		
	}

	@Override
	public void writeQuestions(String questionFile) throws QuestionException {
		QuestionWriter writer = new QuestionWriter(questionFile);
		
		for (Question e: questions.getStandardQuestions()) {
			writer.addStandardQuestion((StandardQuestion)e);
		}
		for (Question e: questions.getElementaryQuestions()) {
			writer.addElementaryQuestion((ElementaryQuestion)e);
		}
		for (Question e: questions.getAdvancedQuestions()) {
			writer.addAdvancedQuestion((AdvancedQuestion)e);
		}
		
		writer.marshal();
		
	}

}
