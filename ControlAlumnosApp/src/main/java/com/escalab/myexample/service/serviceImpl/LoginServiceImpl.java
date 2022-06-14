package com.escalab.myexample.service.serviceImpl;

import com.escalab.myexample.entity.Usuario;
import com.escalab.myexample.repository.ILoginRepository;
import com.escalab.myexample.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements ILoginService {

    @Autowired
    private ILoginRepository loginRepository;


    @Override
    public Usuario verifyUserName(String user) throws Exception {
        Usuario us = null;
        try {
            us = loginRepository.verifyUserName(user);
            us = us != null ? us : new Usuario();
        } catch (Exception e) {
            us = new Usuario();
        }
        return us;
    }

    @Override
    public int changingKey(String key, String name) throws Exception {
        int rpta = 0;
        try {
            loginRepository.changingKey(key, name);
            rpta = 1;
        } catch (Exception e) {
            rpta = 0;
        }
        return rpta;
    }
}
