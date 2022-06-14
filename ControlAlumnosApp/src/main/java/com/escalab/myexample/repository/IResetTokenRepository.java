package com.escalab.myexample.repository;


import com.escalab.myexample.entity.ResetToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IResetTokenRepository extends JpaRepository<ResetToken, Integer> {
	
	//from ResetToken where token = :?
	ResetToken findByToken(String token);

}

