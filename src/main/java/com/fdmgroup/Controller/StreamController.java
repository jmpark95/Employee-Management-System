package com.fdmgroup.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fdmgroup.Model.Stream.Stream;
import com.fdmgroup.Repository.StreamRepository;

@RestController
@RequestMapping("/api/stream")
public class StreamController {
	private final StreamRepository streamRepository;

	public StreamController(StreamRepository streamRepository) {
		this.streamRepository = streamRepository;
	}
	
	@GetMapping("/streams")
	public ResponseEntity<List<Stream>> getAllStreams(){
		List<Stream> allStreams = streamRepository.findAll();
		
		return ResponseEntity.status(HttpStatus.OK).body(allStreams);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Stream> getStreamById(@PathVariable int id){
		Stream stream = streamRepository.findById(id).get();
		
		return ResponseEntity.status(HttpStatus.OK).body(stream);
	}

}
