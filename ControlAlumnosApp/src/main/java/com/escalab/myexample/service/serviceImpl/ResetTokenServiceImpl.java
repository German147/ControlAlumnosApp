package com.escalab.myexample.service.serviceImpl;

import com.escalab.myexample.entity.ResetToken;
import com.escalab.myexample.repository.IResetTokenRepository;
import com.escalab.myexample.service.IResetTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResetTokenServiceImpl implements IResetTokenService {

    @Autowired
    private IResetTokenRepository resetTokenRepository;

    @Override
    public ResetToken findByToken(String token) {
        return resetTokenRepository.findByToken(token);
    }

    @Override
    public void saveToken(ResetToken token) {
        resetTokenRepository.save(token);
    }

    @Override
    public void deletetoken(ResetToken token) {
        resetTokenRepository.delete(token);
    }
}
