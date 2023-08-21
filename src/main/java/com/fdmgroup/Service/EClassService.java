package com.fdmgroup.Service;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fdmgroup.DTO.CreateStreamDTO;
import com.fdmgroup.Model.Stream.Stream;
import com.fdmgroup.Repository.StreamRepository;
import com.fdmgroup.Repository.TraineeRepository;
import com.fdmgroup.Repository.TrainerRepository;

@Service
public class EClassService {
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
