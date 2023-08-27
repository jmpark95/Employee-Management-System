package com.fdmgroup.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fdmgroup.DTO.Class.CreateClassDTO;
import com.fdmgroup.Model.Employee.Trainee;
import com.fdmgroup.Model.Employee.Trainer;
import com.fdmgroup.Model.Stream.EClass;
import com.fdmgroup.Model.Stream.Stream;
import com.fdmgroup.Repository.EClassRepository;
import com.fdmgroup.Repository.StreamRepository;
import com.fdmgroup.Repository.Employee.TraineeRepository;
import com.fdmgroup.Repository.Employee.TrainerRepository;
import com.fdmgroup.Service.EClassService;

@RestController
@RequestMapping("/api/class")
public class EClassController {
	private static final Logger logger = LoggerFactory.getLogger(EClassController.class);
	private final EClassService eClassService;
	private final EClassRepository eClassRepository;
	private final StreamRepository streamRepository;
	private final TrainerRepository trainerRepository;
	private final TraineeRepository traineeRepository;

	public EClassController(EClassService eClassService, EClassRepository eClassRepository,
			StreamRepository streamRepository, TrainerRepository trainerRepository,
			TraineeRepository traineeRepository) {
		super();
		this.eClassService = eClassService;
		this.eClassRepository = eClassRepository;
		this.streamRepository = streamRepository;
		this.trainerRepository = trainerRepository;
		this.traineeRepository = traineeRepository;
	}
	
	
	@GetMapping("/classes")
	public ResponseEntity<List<EClass>> getAllClasses() {
		List<EClass> allClasses = eClassRepository.findAll();
		
		return ResponseEntity.status(HttpStatus.OK).body(allClasses);
	}
	
	@PostMapping("/create")
	public void createClass(@RequestBody CreateClassDTO createClassDTO) {	
		Stream stream = streamRepository.findById(createClassDTO.getStreamId()).get();
		List<Trainer> trainers = trainerRepository.findAllById(createClassDTO.getTrainerIds());
		List<Trainee> trainees = traineeRepository.findAllById(createClassDTO.getTraineeIds());
		
		var eClass = EClass.builder()
				.stream(stream)
				.startDate(createClassDTO.getStartDate())
				.endDate(createClassDTO.getEndDate())
				.trainers(trainers)
				.trainees(trainees)
				.build();
		
//		for (Trainee trainee : trainees) {
//			trainee.setEclass(eClass);
//		}
		
		eClassRepository.save(eClass);
		//traineeRepository.saveAll(trainees);
	}
	
	@GetMapping("/classes-by-stream")
	public ResponseEntity<List<EClass>> getAllClassesByStream(@RequestParam("streamId") int streamId) {
		//  localhost:8080/api/class/classes-by-stream?streamId=1
		List<EClass> allClasses = eClassRepository.findAllByStreamId(streamId);
		
		return ResponseEntity.status(HttpStatus.OK).body(allClasses);
	}
	
	@GetMapping("/{classId}")
	public ResponseEntity<EClass> getClass(@PathVariable int classId){
		EClass eClass = eClassRepository.findById(classId).get();;
		
		return ResponseEntity.status(HttpStatus.OK).body(eClass);
	}
	
	@PutMapping("/{classId}")
	public ResponseEntity<EClass> updateClass(@PathVariable int classId, @RequestBody CreateClassDTO createClassDTO){
		EClass savedClass = eClassService.updateClass(classId, createClassDTO);
		
		return ResponseEntity.status(HttpStatus.OK).body(savedClass);
	}
	
	
	
	
	
//	@GetMapping("/streams/stream-name/{id}")
//	public ResponseEntity<List<Stream>> getAllStreamsByStreamNameId(@PathVariable UUID id) {
//		List<Stream> allStreams = streamService.getAllStreamsByStreamNameId(id);
//				
//		return ResponseEntity.status(HttpStatus.OK).body(allStreams);
//	}
//	
//	
//	@GetMapping("/stream-names")
//	public ResponseEntity<List<StreamName>> getAllStreamNames(){
//		List<StreamName> allStreamNames = streamNameRepository.findAll();
//		
//		return ResponseEntity.status(HttpStatus.OK).body(allStreamNames);
//	}
//	
//	@GetMapping("/stream-name/{id}")
//	public ResponseEntity<StreamName> getStreamNameById(@PathVariable UUID id) {
//		StreamName streamName = streamNameRepository.findById(id).get();
//		
//		return ResponseEntity.status(HttpStatus.OK).body(streamName);
//	}
//	
//	@PostMapping("/create")
//	public ResponseEntity createStream(@RequestBody @Valid CreateStreamDTO createStreamDTO) {
//		streamService.create(createStreamDTO);
//		
//		return ResponseEntity.status(HttpStatus.CREATED).build();
//	}

	
	
	
}
