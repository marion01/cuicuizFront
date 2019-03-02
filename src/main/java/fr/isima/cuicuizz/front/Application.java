package fr.isima.cuicuizz.front;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		System.setProperty("spring.devtools.restart.enabled", "false");
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner lookup(QuestionClient quoteClient) {
		return args -> {

			final GetQuestionResponse response = quoteClient.getQuestion(1, 3);
			for (final Question question : response.getQuestions()) {
				System.err.println(question.getValue());
				for (final Answer answer : question.getAnswers()) {
					System.err.println(answer.getAnswer());
				}
			}
		};
	}

}
