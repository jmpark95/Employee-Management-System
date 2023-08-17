package com.fdmgroup.DTO;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PublicUserDTO {
	private UUID id;
	private String email;
	private String firstName;
	private String lastName;
}
