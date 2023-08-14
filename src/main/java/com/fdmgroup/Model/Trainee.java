package com.fdmgroup.Model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("Trainee")
@Data
@NoArgsConstructor
public class Trainee extends User {
	@ManyToOne
	@JoinColumn(name="FK_STREAM_TRAINEE")
	private Stream stream;
}