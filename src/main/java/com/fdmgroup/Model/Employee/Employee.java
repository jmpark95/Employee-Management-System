package com.fdmgroup.Model.Employee;

import java.sql.Date;
import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "FDM_ROLE")
@Data
@NoArgsConstructor
public abstract class Employee implements UserDetails  {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	
	@Column(unique = true)
	@Size(min = 9)
	@Email
	@NotNull
	protected String email;
	
	@Size(min = 5)
	@NotNull
    @JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	
	@NotNull
	private String firstName;
	
	@NotNull
	private String lastName;
	
	@NotNull
	private Date startDate;
	
	@NotNull
	private int salary;
	
	//@ColumnDefault("false")
	private boolean hasPersonallySetPassword = false;
	
	private float leaveTaken;
	
	
	
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Set.of();
	}

	@Override
	public String getUsername() {
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
