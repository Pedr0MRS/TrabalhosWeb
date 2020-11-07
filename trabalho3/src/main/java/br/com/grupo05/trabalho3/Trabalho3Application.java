package br.com.grupo05.trabalho3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.com.grupo05.trabalho3.entity.AlunoEntity;
import br.com.grupo05.trabalho3.service.AlunoDAOImpl;

@SpringBootApplication
@ComponentScan({"br.com.grupo05.trabalho3.repository",
				"br.com.grupo05.trabalho3.dao",
				"br.com.grupo05.trabalho3.entity",
				"br.com.grupo05.trabalho3.service"})
@EnableJpaRepositories(basePackages = { "br.com.grupo05.trabalho3.repository" })
public class Trabalho3Application {

	public static void main(String[] args) {
		SpringApplication.run(Trabalho3Application.class, args);

		AlunoEntity aluno = new AlunoEntity(1L, "reds", "4535", "t6gdfgd");

		AlunoDAOImpl dao = new AlunoDAOImpl();
		dao.adicionarAluno(aluno);
	}
}
