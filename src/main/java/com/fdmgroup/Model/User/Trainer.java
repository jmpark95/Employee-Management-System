package com.fdmgroup.Model.User;

import java.util.List;

import com.fdmgroup.Model.Stream;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@DiscriminatorValue("Trainer")
@Data
@NoArgsConstructor
public class Trainer extends User {
	@ManyToMany(mappedBy = "trainers")
	private List<Stream> streams;

}
