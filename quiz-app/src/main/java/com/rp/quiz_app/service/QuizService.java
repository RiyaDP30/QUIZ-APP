package com.rp.quiz_app.service;

import com.rp.quiz_app.dao.QuestionDao;
import com.rp.quiz_app.dao.QuizDao;
import com.rp.quiz_app.model.Question;
import com.rp.quiz_app.model.QuestionWrapper;
import com.rp.quiz_app.model.Quiz;
import com.rp.quiz_app.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    private QuizDao quizDao;

    @Autowired
    private QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        try {
            List<Question> questions = questionDao.findRandomQuestionsByCategory(category, numQ);

            Quiz quiz = new Quiz();
            quiz.setTitle(title);
            quiz.setQuestions(questions);
            quizDao.save(quiz);

            return new ResponseEntity<>("Quiz created successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Failed to create quiz", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        try {
            Optional<Quiz> quizOptional = quizDao.findById(id);

            if (quizOptional.isPresent()) {
                Quiz quiz = quizOptional.get();
                List<Question> questionsFromDB = quiz.getQuestions();
                List<QuestionWrapper> questionsForUser = new ArrayList<>();

                for (Question q : questionsFromDB) {
                    QuestionWrapper qw = new QuestionWrapper(
                            q.getId(),
                            q.getQuestionTitle(),
                            q.getOption1(),
                            q.getOption2(),
                            q.getOption3(),
                            q.getOption4()
                    );
                    questionsForUser.add(qw);
                }

                return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        try {
            Optional<Quiz> quizOptional = quizDao.findById(id);

            if (quizOptional.isPresent()) {
                Quiz quiz = quizOptional.get();
                List<Question> questions = quiz.getQuestions();
                int right = 0;

                for (int i = 0; i < responses.size(); i++) {
                    Response response = responses.get(i);
                    Question question = questions.get(i);

                    if (response.getResponse() != null &&
                            response.getResponse().equals(question.getRightAnswer())) {
                        right++;
                    }
                }

                return new ResponseEntity<>(right, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(0, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(0, HttpStatus.BAD_REQUEST);
        }
    }
}
