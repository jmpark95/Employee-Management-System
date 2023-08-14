package com.fdmgroup.Model;

import java.util.List;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("Trainer")
@Data
@NoArgsConstructor
public class Trainer extends User {
	@ManyToMany(mappedBy = "trainers")
	private List<Stream> streams;

}
