package com.fdmgroup.Model;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import com.fdmgroup.Enum.StreamName;
import com.fdmgroup.Model.User.Trainee;
import com.fdmgroup.Model.User.Trainer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Stream {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
    @Enumerated(EnumType.STRING)
	private StreamName streamName;
	
	@Column(nullable = false)
	private Timestamp startDate;
	
	@Column(nullable = false)
	private Timestamp endDate;
	
	@Column(nullable = false)
	@ManyToMany
	@JoinTable(
            name = "STREAM_TRAINER",
            joinColumns = @JoinColumn(name = "stream_id"),
            inverseJoinColumns = @JoinColumn(name = "trainer_id"))
	private List<Trainer> trainers;
	
	@Column(nullable = false)
	@OneToMany(mappedBy = "stream")
	private List<Trainee> trainees;

}
