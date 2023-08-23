package com.fdmgroup.Service;

import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fdmgroup.DTO.Class.CreateClassDTO;
import com.fdmgroup.Model.Employee.Trainee;
import com.fdmgroup.Model.Employee.Trainer;
import com.fdmgroup.Model.Stream.EClass;
import com.fdmgroup.Repository.EClassRepository;
import com.fdmgroup.Repository.StreamRepository;
import com.fdmgroup.Repository.TraineeRepository;
import com.fdmgroup.Repository.TrainerRepository;

@Service
public class EClassService {
	private static final Logger logger = LoggerFactory.getLogger(EClassService.class);
	private final EClassRepository eClassRepository;
	private final StreamRepository streamRepository;
	private final TrainerRepository trainerRepository;
	private final TraineeRepository traineeRepository;

	public EClassService(EClassRepository eClassRepository, StreamRepository streamRepository,
			TrainerRepository trainerRepository, TraineeRepository traineeRepository) {
		super();
		this.eClassRepository = eClassRepository;
		this.streamRepository = streamRepository;
		this.trainerRepository = trainerRepository;
		this.traineeRepository = traineeRepository;
	}








	public EClass updateClass(int classId, CreateClassDTO createClassDTO) {
		EClass eClass = eClassRepository.findById(classId).get();
		List<Trainee> trainees = traineeRepository.findAllById(createClassDTO.getTraineeIds());
		List<Trainer> trainers = trainerRepository.findAllById(createClassDTO.getTrainerIds());
		
		//The list of trainees in this class before updating. There is a possibility that an existing trainee/trainees was removed from the frontend, so set all classes to null before updating
		//the class with a new list of trainees
//		List<Trainee> preUpdateList = eClass.getTrainees();;
//		for (Trainee trainee : preUpdateList) {
//			trainee.setEclass(null);;
//		}
//		traineeRepository.saveAll(preUpdateList);
		
		


		//Logic to update the class
		eClass.setStream(streamRepository.findById(createClassDTO.getStreamId()).get());
		eClass.setStartDate(createClassDTO.getStartDate());;
		eClass.setEndDate(createClassDTO.getEndDate());	
		eClass.setTrainers(trainers);
		eClass.setTrainees(trainees);
//		for (Trainee trainee : trainees) {
//			eClass.addTrainee(trainee);
//		}
		
		//traineeRepository.saveAll(trainees);		
		return eClassRepository.save(eClass);
	}
	
	
	
	
//	private static final Logger logger = LoggerFactory.getLogger(StreamService.class);
//	private final StreamRepository streamRepository;
//	private final StreamNameRepository streamNameRepository;
//	private final TrainerRepository trainerRepository;
//	private final TraineeRepository traineeRepository;
//	private final UserRepository userRepository;
//	
//
//
//	public StreamService(StreamRepository streamRepository, StreamNameRepository streamNameRepository,
//			TrainerRepository trainerRepository, TraineeRepository traineeRepository, UserRepository userRepository) {
//		super();
//		this.streamRepository = streamRepository;
//		this.streamNameRepository = streamNameRepository;
//		this.trainerRepository = trainerRepository;
//		this.traineeRepository = traineeRepository;
//		this.userRepository = userRepository;
//	}
//
//	public List<Stream> getAllStreamsByStreamNameId(UUID id) {
//		return streamRepository.findAllByStreamNameId(id);
//	}
//
//	public void create(CreateStreamDTO createStreamDTO) {
//		StreamName streamName = streamNameRepository.findById(createStreamDTO.getStreamNameId()).get();
//		
//		User user = userRepository.findById(createStreamDTO.getTrainees().get(0)).get();
//				
//		logger.debug(user.toString());;
//		
////				
////		var stream = Stream.builder()
////				.stream(streamName)
////				.startDate(createStreamDTO.getStartDate())
////				.endDate(createStreamDTO.getEndDate())
////				.trainers(createStreamDTO.getTrainers())
////				.trainees(createStreamDTO.getTrainees())
////				.build();
////				
////		logger.debug(stream.toString());
////
////		streamRepository.save(stream);
////	}
	

}
