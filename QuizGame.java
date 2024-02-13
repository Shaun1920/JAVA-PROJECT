import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class QuizQuestion {
    String question;
    ArrayList<String> options;
    int correctOption;

    QuizQuestion(String question, ArrayList<String> options, int correctOption) {
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
    }
}

public class QuizGame {
    private int score = 0;
    private int currentQuestionIndex = 0;

    private ArrayList<QuizQuestion> quizQuestions = new ArrayList<>();
    private ScheduledExecutorService timer; // Separate timer for each quiz session

    public static void main(String[] args) {
        QuizGame quizGame = new QuizGame();
        quizGame.initializeQuestions();
        quizGame.startQuiz();
    }

    private void initializeQuestions() {
        quizQuestions.add(new QuizQuestion("What is the capital of France?",
                new ArrayList<>(List.of("A. Berlin", "B. Madrid", "C. Paris", "D. Rome")), 2));

        quizQuestions.add(new QuizQuestion("What is the capital of Japan?",
                new ArrayList<>(List.of("A. Seoul", "B. Tokyo", "C. Beijing", "D. Bangkok")), 1));

        quizQuestions.add(new QuizQuestion("Which planet is known as the Red Planet?",
                new ArrayList<>(List.of("A. Venus", "B. Mars", "C. Jupiter", "D. Saturn")), 1));

        quizQuestions.add(new QuizQuestion("What is the largest mammal?",
                new ArrayList<>(List.of("A. Elephant", "B. Blue Whale", "C. Giraffe", "D. Tiger")), 1));

        // Add more questions as needed
        // ...

        // Example:
        quizQuestions.add(new QuizQuestion("What is the capital of Australia?",
                new ArrayList<>(List.of("A. Sydney", "B. Canberra", "C. Melbourne", "D. Brisbane")), 2));
    }

    private void startQuiz() {
        Scanner scanner = new Scanner(System.in);

        for (QuizQuestion question : quizQuestions) {
            displayQuestion(question);

            // Initialize a new timer for each question (e.g., 20 seconds)
            timer = Executors.newScheduledThreadPool(1);
            timer.schedule(() -> {
                System.out.println("\nTime's up! Moving to the next question.");
                evaluateAnswer(-1); // Automatically move to the next question
            }, 20, TimeUnit.SECONDS);

            // Allow the user to submit an answer
            System.out.print("Your answer (enter the option number): ");
            int userAnswer = scanner.nextInt();

            // Cancel the timer since the user submitted an answer
            timer.shutdownNow();

            evaluateAnswer(userAnswer);
        }

        displayResult();
        scanner.close();
    }

    private void displayQuestion(QuizQuestion question) {
        System.out.println("\n" + question.question);
        for (String option : question.options) {
            System.out.println(option);
        }
    }

    private void evaluateAnswer(int userAnswer) {
        QuizQuestion currentQuestion = quizQuestions.get(currentQuestionIndex);

        if (userAnswer == currentQuestion.correctOption) {
            System.out.println("Correct!\n");
            score++;
        } else if (userAnswer == -1) {
            System.out.println("Time's up! The correct answer was: " + currentQuestion.correctOption);
        } else {
            System.out.println("Incorrect! The correct answer was: " + currentQuestion.correctOption + "\n");
        }

        currentQuestionIndex++;
    }

    private void displayResult() {
        System.out.println("\nQuiz Completed!");
        System.out.println("Your Final Score: " + score + " out of " + quizQuestions.size());
    }
}
