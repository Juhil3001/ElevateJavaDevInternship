import java.util.*;

class Question {
    String questionText;
    String[] options;
    char correctOption;

    public Question(String questionText, String[] options, char correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }

    public void displayQuestion() {
        System.out.println(questionText);
        char optionLabel = 'A';
        for (String option : options) {
            System.out.println(optionLabel + ". " + option);
            optionLabel++;
        }
    }

    public boolean isCorrect(char userAnswer) {
        return Character.toUpperCase(userAnswer) == Character.toUpperCase(correctOption);
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Question> questions = new ArrayList<>();
        questions.add(new Question("1. What is the capital of India?",
                new String[]{"Mumbai", "Delhi", "Chennai", "Kolkata"}, 'B'));
        questions.add(new Question("2. Who developed Java?",
                new String[]{"James Gosling", "Dennis Ritchie", "Bjarne Stroustrup", "Guido van Rossum"}, 'A'));
        questions.add(new Question("3. What is the size of int in Java?",
                new String[]{"2 bytes", "4 bytes", "8 bytes", "Depends on OS"}, 'B'));
        questions.add(new Question("4. Which keyword is used to inherit a class in Java?",
                new String[]{"implements", "inherits", "extends", "instanceof"}, 'C'));
        questions.add(new Question("5. What does JVM stand for?",
                new String[]{"Java Virtual Machine", "Java Verified Mode", "Joint Vector Machine", "Java Value Memory"}, 'A'));

        int score = 0;

        for (Question q : questions) {
            q.displayQuestion();
            System.out.print("Enter your answer (A/B/C/D): ");
            char answer = scanner.next().charAt(0);
            if (q.isCorrect(answer)) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Wrong! Correct Answer: " + q.correctOption + "\n");
            }
        }

        System.out.println("Quiz Completed!");
        System.out.println("Your Score: " + score + " out of " + questions.size());

        scanner.close();
    }
}
