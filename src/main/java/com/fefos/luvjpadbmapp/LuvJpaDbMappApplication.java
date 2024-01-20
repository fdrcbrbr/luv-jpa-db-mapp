package com.fefos.luvjpadbmapp;

import com.fefos.luvjpadbmapp.dao.AppDAO;
import com.fefos.luvjpadbmapp.entity.Instructor;
import com.fefos.luvjpadbmapp.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LuvJpaDbMappApplication {

	public static void main(String[] args) {
		SpringApplication.run(LuvJpaDbMappApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner ->{
			createInstructor(appDAO);
			//findInstructor(appDAO);
			//deleteInstructorById(appDAO);
		};
	}

	private void deleteInstructorById(AppDAO appDAO) {
		int id = 2;
		appDAO.deleteInstuctorById(id);
	}

	private void findInstructor(AppDAO appDAO) {
		int id = 1;
		System.out.println("Found the instryctor with the id: "+id);

		System.out.println(appDAO.findInstructorById(id));
	}

	private void createInstructor(AppDAO appDAO) {
		Instructor newInstructor =
				new Instructor("Vidar", "Barberi","vidarx@gmail.com");

		InstructorDetail newInstructorDet =
				new InstructorDetail("I_amo_roblox", "roblox");

		newInstructor.setInstructorDetail(newInstructorDet);

		System.out.println("Saved the instructor: "+ newInstructor);
		appDAO.save(newInstructor);
	}
}
