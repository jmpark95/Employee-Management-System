package com.fdmgroup.Model.User;

import com.fdmgroup.Model.Stream;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@DiscriminatorValue("Trainee")
@Data
@NoArgsConstructor
public class Trainee extends User {
	@ManyToOne
	@JoinColumn(name="FK_STREAM_TRAINEE")
	private Stream stream;
}