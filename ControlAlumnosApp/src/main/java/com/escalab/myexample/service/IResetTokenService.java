package com.escalab.myexample.service;


import com.escalab.myexample.entity.ResetToken;

public interface IResetTokenService {
	
	ResetToken findByToken(String token);
	
	void saveToken(ResetToken token);
	
	void deletetoken(ResetToken token);
}
