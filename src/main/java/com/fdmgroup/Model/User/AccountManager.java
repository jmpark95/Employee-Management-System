package com.fdmgroup.Model.User;

import com.fdmgroup.Model.Stream;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@DiscriminatorValue("AccountManager")
@Data
@NoArgsConstructor
public class AccountManager extends User {

}
