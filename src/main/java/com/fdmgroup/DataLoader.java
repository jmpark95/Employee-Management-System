//package com.fdmgroup;
//
//import java.sql.Date;
//import java.util.Arrays;
//import java.util.List;
//
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import com.fdmgroup.Model.FDMRole;
//import com.fdmgroup.Model.Employee.AccountManager;
//import com.fdmgroup.Model.Employee.HR;
//import com.fdmgroup.Model.Employee.Trainee;
//import com.fdmgroup.Model.Employee.Trainer;
//import com.fdmgroup.Model.Stream.EClass;
//import com.fdmgroup.Model.Stream.Stream;
//import com.fdmgroup.Repository.EClassRepository;
//import com.fdmgroup.Repository.FDMRoleRepository;
//import com.fdmgroup.Repository.StreamRepository;
//import com.fdmgroup.Repository.Employee.AccountManagerRepository;
//import com.fdmgroup.Repository.Employee.HRRepository;
//import com.fdmgroup.Repository.Employee.TraineeRepository;
//import com.fdmgroup.Repository.Employee.TrainerRepository;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//
//
//@Component
//public class DataLoader implements ApplicationRunner {
//	private final FDMRoleRepository fdmRoleRepository;
//	private final StreamRepository streamRepository;
//	private final EClassRepository eClassRepository;
//	private final TrainerRepository trainerRepository;
//	private final TraineeRepository traineeRepository;
//	private final HRRepository hrRepository;
//	private final AccountManagerRepository amRepository;
//	private final PasswordEncoder passwordEncoder;	
//
//	public DataLoader(FDMRoleRepository fdmRoleRepository, StreamRepository streamRepository,
//			EClassRepository eClassRepository, TrainerRepository trainerRepository, TraineeRepository traineeRepository,
//			HRRepository hrRepository, AccountManagerRepository amRepository, PasswordEncoder passwordEncoder) {
//		super();
//		this.fdmRoleRepository = fdmRoleRepository;
//		this.streamRepository = streamRepository;
//		this.eClassRepository = eClassRepository;
//		this.trainerRepository = trainerRepository;
//		this.traineeRepository = traineeRepository;
//		this.hrRepository = hrRepository;
//		this.amRepository = amRepository;
//		this.passwordEncoder = passwordEncoder;
//	}
//
//	public void run(ApplicationArguments args) {
//		saveFDMRoles();
//		saveStreams();
//		saveEmployees();
//	}
//	
//
//	@Data
//	@AllArgsConstructor
//	public class TraineeData {
//		private String email;
//		private String firstName;
//		private String lastName;
//		private int salary;
//		private Date startDate;
//		private FDMRole role;
//		private Stream stream;
//		private float leaveTaken;
//	}
//	
//	@Data
//	@AllArgsConstructor
//	public class TrainerData {
//		private String email;
//		private String firstName;
//		private String lastName;
//		private int salary;
//		private Date startDate;
//		private FDMRole role;
//		private float leaveTaken;
//	}
//	
//	@Data
//	@AllArgsConstructor
//	public class HRData {
//		private String email;
//		private String firstName;
//		private String lastName;
//		private int salary;
//		private Date startDate;
//		private FDMRole role;
//		private float leaveTaken;
//	}
//	
//	@Data
//	@AllArgsConstructor
//	public class AMData {
//		private String email;
//		private String firstName;
//		private String lastName;
//		private int salary;
//		private Date startDate;
//		private FDMRole role;
//		private float leaveTaken;
//	}
//
//	public void saveFDMRoles() {
//		fdmRoleRepository.save(new FDMRole("HR"));
//		fdmRoleRepository.save(new FDMRole("Trainee"));
//		fdmRoleRepository.save(new FDMRole("Trainer"));
//		fdmRoleRepository.save(new FDMRole("Account Manager"));
//	}
//
//	public void saveStreams() {
//		streamRepository.save(new Stream("Software Development"));
//		streamRepository.save(new Stream("Business Intelligence"));
//		streamRepository.save(new Stream("Data Engineering"));
//		streamRepository.save(new Stream("Cybersecurity"));
//		streamRepository.save(new Stream("Cloud Computing"));
//		streamRepository.save(new Stream("Technical Analysis"));
//	}
//	
//
//	
//	public void saveEmployees() {
//		List<TraineeData> traineeDataList = Arrays.asList(
//				new TraineeData("min.park@fdm.com", "Min", "Park", 60000, Date.valueOf("2023-05-15"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(1).get(), 1f),
//				new TraineeData("stanley.chilton@fdm.com", "Stanley", "Chilton", 60000, Date.valueOf("2023-05-15"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(1).get(), 12f),
//				new TraineeData("matthew.theseira@fdm.com", "Matthew", "Theseira", 60000, Date.valueOf("2023-05-15"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(1).get(), 11f),
//				new TraineeData("zhanzhao.yang@fdm.com", "Zhanzhao", "Yang", 60000, Date.valueOf("2023-05-15"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(1).get(), 8f),
//				new TraineeData("samantha.jermyn@fdm.com", "Samantha", "Jermyn", 60000, Date.valueOf("2023-05-15"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(1).get(), 7f),
//				new TraineeData("caovinh.lam@fdm.com", "CaoVinh", "Lam", 60000, Date.valueOf("2023-05-15"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(1).get(), 4f),
//				new TraineeData("matthew.veldhuizen@fdm.com", "Matthew", "Veldhuizen", 60000, Date.valueOf("2023-05-15"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(1).get(), 2f),
//				new TraineeData("christian.lee@fdm.com", "Christian", "Lee", 60000, Date.valueOf("2023-05-15"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(1).get(), 1f),
//				new TraineeData("phil.vu@fdm.com", "Phil", "Vu", 60000, Date.valueOf("2023-05-15"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(1).get(), 1f),
//				new TraineeData("yifeng.chen@fdm.com", "Yifeng", "Chen", 60000, Date.valueOf("2023-02-10"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(1).get(), 1f),
//				new TraineeData("emma.johnson@fdm.com", "Emma", "Johnson", 55000, Date.valueOf("2023-03-15"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(1).get(), 5f),
//				new TraineeData("oliver.williams@fdm.com", "Oliver", "Williams", 59000, Date.valueOf("2023-04-20"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(2).get(), 1f),
//			    new TraineeData("sophia.miller@fdm.com", "Sophia", "Miller", 60000, Date.valueOf("2022-02-10"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(3).get(), 10f),
//				new TraineeData("olivia.smith@fdm.com", "Olivia", "Smith", 52000, Date.valueOf("2018-04-20"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(4).get(), 3f),
//				new TraineeData("noah.wilson@fdm.com", "Noah", "Wilson", 58000, Date.valueOf("2020-02-10"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(5).get(), 3f),
//				   new TraineeData("liam.jones@fdm.com", "Liam", "Jones", 56000, Date.valueOf("2019-05-05"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(6).get(), 10f),
//				   new TraineeData("ava.anderson@fdm.com", "Ava", "Anderson", 60000, Date.valueOf("2021-06-30"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(1).get(), 9f),
//				   new TraineeData("grace.white@fdm.com", "Grace", "White", 53000, Date.valueOf("2020-07-15"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(2).get(), 10f),
//				   new TraineeData("ethan.martin@fdm.com", "Ethan", "Martin", 57000, Date.valueOf("2023-08-10"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(3).get(), 7f),
//				   new TraineeData("mia.brown@fdm.com", "Mia", "Brown", 54000, Date.valueOf("2022-09-25"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(4).get(), 10f),
//				   new TraineeData("oliver.johnson@fdm.com", "Oliver", "Johnson", 59000, Date.valueOf("2021-11-02"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(5).get(), 12f),
//				   new TraineeData("wence.panong@fdm.com", "Wence", "Panong", 62000, Date.valueOf("2022-12-12"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(6).get(), 10f),
//				   new TraineeData("olivia.johnson@fdm.com", "Olivia", "Johnson", 59000, Date.valueOf("2023-04-20"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(2).get(), 1f),
//				   new TraineeData("william.davis@fdm.com", "William", "Davis", 60000, Date.valueOf("2022-02-10"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(3).get(), 10f),
//				   new TraineeData("ava.wilson@fdm.com", "Ava", "Wilson", 52000, Date.valueOf("2018-04-20"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(4).get(), 3f),
//				   new TraineeData("noah.jones@fdm.com", "Noah", "Jones", 58000, Date.valueOf("2020-02-10"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(5).get(), 3f),
//				   new TraineeData("oliver.anderson@fdm.com", "Oliver", "Anderson", 56000, Date.valueOf("2019-05-05"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(6).get(), 10f),
//				   new TraineeData("ethan.brown@fdm.com", "Ethan", "Brown", 53000, Date.valueOf("2020-07-15"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(2).get(), 10f),
//				   new TraineeData("jessica.smith@fdm.com", "Jessica", "Smith", 62000, Date.valueOf("2022-12-12"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(3).get(), 10f),
//				   new TraineeData("james.smith@fdm.com", "James", "Smith", 55000, Date.valueOf("2023-03-15"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(4).get(), 5f),
//				   new TraineeData("daniel.martinez@fdm.com", "Daniel", "Martinez", 59000, Date.valueOf("2023-04-20"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(5).get(), 1f),
//				   
//				   
//				   
//				   new TraineeData("emma.jones@fdm.com", "Emma", "Jones", 55000, Date.valueOf("2023-03-15"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(1).get(), 5f),
//				   new TraineeData("oliver.miller@fdm.com", "Oliver", "Miller", 59000, Date.valueOf("2023-04-20"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(2).get(), 1f),
//				   new TraineeData("sophia.wilson@fdm.com", "Sophia", "Wilson", 60000, Date.valueOf("2022-02-10"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(3).get(), 10f),
//				   new TraineeData("olivia.brown@fdm.com", "Olivia", "Brown", 52000, Date.valueOf("2018-04-20"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(4).get(), 3f),
//				   new TraineeData("noah.anderson@fdm.com", "Noah", "Anderson", 58000, Date.valueOf("2020-02-10"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(5).get(), 3f),
//				   new TraineeData("liam.johnson@fdm.com", "Liam", "Johnson", 56000, Date.valueOf("2019-05-05"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(6).get(), 10f),
//				   new TraineeData("ava.davis@fdm.com", "Ava", "Davis", 60000, Date.valueOf("2021-06-30"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(1).get(), 9f),
//				   new TraineeData("ethan.martinez@fdm.com", "Ethan", "Martinez", 57000, Date.valueOf("2023-08-10"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(3).get(), 7f),
//				   new TraineeData("mia.smith@fdm.com", "Mia", "Smith", 54000, Date.valueOf("2022-09-25"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(4).get(), 10f),
//				   new TraineeData("william.johnson@fdm.com", "William", "Johnson", 59000, Date.valueOf("2021-11-02"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(5).get(), 12f),
//				   new TraineeData("lucas.davis@fdm.com", "Lucas", "Davis", 57000, Date.valueOf("2023-08-10"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(1).get(), 7f),
//				   new TraineeData("ella.jones@fdm.com", "Ella", "Jones", 54000, Date.valueOf("2022-09-25"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(4).get(), 10f),
//				   new TraineeData("oliver.smith@fdm.com", "Oliver", "Smith", 59000, Date.valueOf("2021-11-02"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(5).get(), 12f),
//				   new TraineeData("sophia.martinez@fdm.com", "Sophia", "Martinez", 62000, Date.valueOf("2022-12-12"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(6).get(), 10f),
//				   new TraineeData("jacob.miller@fdm.com", "Jacob", "Miller", 57000, Date.valueOf("2023-08-10"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(1).get(), 7f),
//				   new TraineeData("mia.jones@fdm.com", "Mia", "Jones", 54000, Date.valueOf("2022-09-25"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(4).get(), 10f),
//				   new TraineeData("emma.martinez@fdm.com", "Emma", "Martinez", 62000, Date.valueOf("2022-12-12"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(6).get(), 10f),
//				   new TraineeData("james.brown@fdm.com", "James", "Brown", 57000, Date.valueOf("2023-08-10"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(1).get(), 7f),
//				   
//				   new TraineeData("emm.jones@fdm.com", "Emm", "Jones", 55000, Date.valueOf("2023-03-15"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(1).get(), 5f),
//				   new TraineeData("olive.miller@fdm.com", "Olie", "Miller", 59000, Date.valueOf("2023-04-20"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(2).get(), 1f),
//				   new TraineeData("sophi.wilson@fdm.com", "Sophi", "Wilson", 60000, Date.valueOf("2022-02-10"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(3).get(), 10f),
//				   new TraineeData("oliv.brown@fdm.com", "Olivi", "Brown", 52000, Date.valueOf("2018-04-20"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(4).get(), 3f),
//				   new TraineeData("noa.anderson@fdm.com", "Noa", "Anderson", 58000, Date.valueOf("2020-02-10"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(5).get(), 3f),
//				   new TraineeData("lia.johnson@fdm.com", "Li", "Johnson", 56000, Date.valueOf("2019-05-05"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(6).get(), 10f),
//				   new TraineeData("av.davis@fdm.com", "Av", "Davis", 60000, Date.valueOf("2021-06-30"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(1).get(), 9f),
//				   new TraineeData("grace.thomas@fdm.com", "Grac", "Thomas", 53000, Date.valueOf("2020-07-15"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(2).get(), 10f),
//				   new TraineeData("ethn.martinez@fdm.com", "Eth", "Martinez", 57000, Date.valueOf("2023-08-10"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(3).get(), 7f),
//				   new TraineeData("mi.smith@fdm.com", "Mi", "Smith", 54000, Date.valueOf("2022-09-25"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(4).get(), 10f),
//				   new TraineeData("wil.johnson@fdm.com", "Will", "Johnson", 59000, Date.valueOf("2021-11-02"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(5).get(), 12f),
//				   new TraineeData("luca.davis@fdm.com", "Luca", "Davis", 57000, Date.valueOf("2023-08-10"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(1).get(), 7f),
//				   new TraineeData("ell.jones@fdm.com", "Ell", "Jones", 54000, Date.valueOf("2022-09-25"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(4).get(), 10f),
//				   new TraineeData("ol.smith@fdm.com", "Oliv", "Smith", 59000, Date.valueOf("2021-11-02"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(5).get(), 12f),
//				   new TraineeData("sophi.martinez@fdm.com", "Sophi", "Martinez", 62000, Date.valueOf("2022-12-12"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(6).get(), 10f),
//				   new TraineeData("jac.miller@fdm.com", "Jacobs", "Miller", 57000, Date.valueOf("2023-08-10"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(1).get(), 7f),
//				   new TraineeData("mian.jones@fdm.com", "Miad", "Jones", 54000, Date.valueOf("2022-09-25"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(4).get(), 10f),
//				   new TraineeData("emmz.martinez@fdm.com", "Emmaz", "Martinez", 62000, Date.valueOf("2022-12-12"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(6).get(), 10f),
//				   new TraineeData("jameie.brown@fdm.com", "Jamuie", "Brown", 57000, Date.valueOf("2023-08-10"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(1).get(), 7f)
//				   
//			
//
//				   );
//		
//		List<TrainerData> trainerDataList = Arrays.asList(
//			    new TrainerData("donald.witcombe@fdm.com", "Donald", "Witcombe", 110000, Date.valueOf("2021-02-01"), fdmRoleRepository.findByRole("Trainer"), 25f),
//			    new TrainerData("manisha.singh@fdm.com", "Manisha", "Singh", 85000, Date.valueOf("2021-05-01"), fdmRoleRepository.findByRole("Trainer"), 51f),
//			    new TrainerData("iffty.ahmed@fdm.com", "Iffty", "Ahmed", 100000, Date.valueOf("2020-03-11"), fdmRoleRepository.findByRole("Trainer"), 46f),
//			    new TrainerData("carolina.portugal@fdm.com", "Carolina", "Portugal", 100000, Date.valueOf("2021-07-11"), fdmRoleRepository.findByRole("Trainer"), 35f),
//			    new TrainerData("dan.solomon@fdm.com", "Dan", "Solomon", 92000, Date.valueOf("2020-07-11"), fdmRoleRepository.findByRole("Trainer"), 15f),
//			    new TrainerData("natalie.hughes@fdm.com", "Natalie", "Hughes", 92000, Date.valueOf("2021-03-15"), fdmRoleRepository.findByRole("Trainer"), 20f),
//			    new TrainerData("robert.anderson@fdm.com", "Robert", "Anderson", 92000, Date.valueOf("2020-11-10"), fdmRoleRepository.findByRole("Trainer"), 18f),
//			    new TrainerData("linda.brown@fdm.com", "Linda", "Brown", 90000, Date.valueOf("2021-05-05"), fdmRoleRepository.findByRole("Trainer"), 22f),
//			    new TrainerData("michael.jones@fdm.com", "Michael", "Jones", 100000, Date.valueOf("2021-06-30"), fdmRoleRepository.findByRole("Trainer"), 21f),
//			    new TrainerData("emily.smith@fdm.com", "Emily", "Smith", 95000, Date.valueOf("2020-07-15"), fdmRoleRepository.findByRole("Trainer"), 15f),
//			    new TrainerData("daniel.martin@fdm.com", "Daniel", "Martin", 90000, Date.valueOf("2020-08-10"), fdmRoleRepository.findByRole("Trainer"), 28f),
//			    new TrainerData("olivia.wilson@fdm.com", "Olivia", "Wilson", 87000, Date.valueOf("2020-09-25"), fdmRoleRepository.findByRole("Trainer"), 23f),
//			    new TrainerData("william.anderson@fdm.com", "William", "Anderson", 100000, Date.valueOf("2020-11-02"), fdmRoleRepository.findByRole("Trainer"), 20f),
//			    new TrainerData("sophia.davis@fdm.com", "Sophia", "Davis", 90000, Date.valueOf("2020-12-12"), fdmRoleRepository.findByRole("Trainer"), 30f),
//			    new TrainerData("suellen.steward@fdm.com", "Suellen", "Steward", 100000, Date.valueOf("2022-12-12"), fdmRoleRepository.findByRole("Trainer"), 15f)
//
//				);
//		
//		List<HRData> hrDataList = Arrays.asList(
//			    new HRData("edwina.than-aye@fdm.com", "Edwina", "Than-Aye", 110000, Date.valueOf("2021-02-01"), fdmRoleRepository.findByRole("HR"), 25f),
//			    new HRData("aleksandra.zlatevska@fdm.com", "Aleksandra", "Zlatevska", 110000, Date.valueOf("2021-02-01"), fdmRoleRepository.findByRole("HR"), 25f),
//			    new HRData("john.doe@fdm.com", "John", "Doe", 110000, Date.valueOf("2020-02-01"), fdmRoleRepository.findByRole("HR"), 25f),
//			    new HRData("jane.doe@fdm.com", "Jane", "Doe", 110000, Date.valueOf("2023-02-01"), fdmRoleRepository.findByRole("HR"), 5f),
//			    new HRData("joan.doe@fdm.com", "Joan", "Doe", 110000, Date.valueOf("2023-01-01"), fdmRoleRepository.findByRole("HR"), 5f)
//				);
//		
//		List<AMData> amDataList = Arrays.asList(
//			    new AMData("james.mccarthy@fdm.com", "James", "McCarthy", 110000, Date.valueOf("2022-01-15"), fdmRoleRepository.findByRole("Account Manager"), 15f),
//			    new AMData("will.rayner@fdm.com", "Will", "Rayner", 110000, Date.valueOf("2017-09-15"), fdmRoleRepository.findByRole("Account Manager"), 65f),
//			    new AMData("yasmin.bellairs-taylor@fdm.com", "Yasmin", "Bellairs-Taylor", 110000, Date.valueOf("2022-10-15"), fdmRoleRepository.findByRole("Account Manager"), 13f),
//			    new AMData("nina.evangelinides@fdm.com", "Nina", "Evangelinides", 110000, Date.valueOf("2022-01-25"), fdmRoleRepository.findByRole("Account Manager"), 6f),
//			    new AMData("joe.mclaren@fdm.com", "Joe", "Mclaren", 110000, Date.valueOf("2012-06-15"), fdmRoleRepository.findByRole("Account Manager"), 80f),
//			    new AMData("nicholas.lloyd@fdm.com", "Nicholas", "Lloyd", 110000, Date.valueOf("2020-01-28"), fdmRoleRepository.findByRole("Account Manager"), 12f),		
//			    new AMData("edward.bristow@fdm.com", "Edward", "Bristow", 110000, Date.valueOf("2018-09-15"), fdmRoleRepository.findByRole("Account Manager"), 35f),
//			    new AMData("rozalija.kizenevic@fdm.com", "Rozalija", "Kizenevic", 110000, Date.valueOf("2023-01-15"), fdmRoleRepository.findByRole("Account Manager"), 12f)
//				);
//		
//		
//		
//		
//		for (TraineeData traineeData : traineeDataList) {
//		    Trainee trainee = new Trainee();
//		    
//		    trainee.setEmail(traineeData.getEmail());
//		    trainee.setPassword(passwordEncoder.encode(traineeData.getEmail()));
//		    trainee.setFirstName(traineeData.getFirstName());
//		    trainee.setLastName(traineeData.getLastName());
//		    trainee.setSalary(traineeData.getSalary());
//		    trainee.setStartDate(traineeData.getStartDate());
//		    trainee.setHasPersonallySetPassword(false);
//		    trainee.setStream(traineeData.getStream());
//		    trainee.setRole(traineeData.getRole());
//		    trainee.setLeaveTaken(traineeData.getLeaveTaken());;
//
//
//		    traineeRepository.save(trainee);
//		}
//		
//		for (TrainerData trainerData : trainerDataList) {
//		    Trainer trainer = new Trainer();
//		    
//		    trainer.setEmail(trainerData.getEmail());
//		    trainer.setPassword(passwordEncoder.encode(trainerData.getEmail()));
//		    trainer.setFirstName(trainerData.getFirstName());
//		    trainer.setLastName(trainerData.getLastName());
//		    trainer.setSalary(trainerData.getSalary());
//		    trainer.setStartDate(trainerData.getStartDate());
//		    trainer.setHasPersonallySetPassword(false);
//		    trainer.setRole(trainerData.getRole());
//		    trainer.setLeaveTaken(trainerData.getLeaveTaken());;
//
//		    trainerRepository.save(trainer);
//		}	
//		
//		for (HRData hrData : hrDataList) {
//		    HR hr = new HR();
//		    
//		    hr.setEmail(hrData.getEmail());
//		    hr.setPassword(passwordEncoder.encode(hrData.getEmail()));
//		    hr.setFirstName(hrData.getFirstName());
//		    hr.setLastName(hrData.getLastName());
//		    hr.setSalary(hrData.getSalary());
//		    hr.setStartDate(hrData.getStartDate());
//		    hr.setHasPersonallySetPassword(false);
//		    hr.setRole(hrData.getRole());
//		    hr.setLeaveTaken(hrData.getLeaveTaken());;
//
//		    hrRepository.save(hr);
//		}	
//		
//		
//		for (AMData amData : amDataList) {
//		    AccountManager am = new AccountManager();
//		    
//		    am.setEmail(amData.getEmail());
//		    am.setPassword(passwordEncoder.encode(amData.getEmail()));
//		    am.setFirstName(amData.getFirstName());
//		    am.setLastName(amData.getLastName());
//		    am.setSalary(amData.getSalary());
//		    am.setStartDate(amData.getStartDate());
//		    am.setHasPersonallySetPassword(false);
//		    am.setRole(amData.getRole());
//		    am.setLeaveTaken(amData.getLeaveTaken());;
//
//		    amRepository.save(am);
//		}	
//	}
//	
//	
////	public void saveClasses() {
////		EClass class1 = new EClass();
////		class1.setStream(streamRepository.findByName("Software Development"));
////		class1.setStartDate(Date.valueOf("2023-05-01"));
////		class1.setEndDate(Date.valueOf("2023-08-01"));
////		class1.setTrainers(trainerRepository.findAll());
////		
////		EClass class2 = new EClass();
////		class2.setStream(streamRepository.findByName("Cybersecurity"));
////		class2.setStartDate(Date.valueOf("2023-06-01"));
////		class2.setEndDate(Date.valueOf("2023-09-01"));
////		class2.setTrainers(trainerRepository.findAll());
////
////		eClassRepository.save(class1);
////	    eClassRepository.save(class2);
////	}
//
//
//
//
////	public void saveLeaveRequests() {
////		User userForLeaveRequest = userRepository.findAll().get(0);
////		LeaveRequest leaveRequest = new LeaveRequest();
////		leaveRequest.setSender(userForLeaveRequest);
////
////		leaveRequestRepository.save(leaveRequest);
////	}
//}