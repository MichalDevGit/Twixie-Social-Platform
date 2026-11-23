package com.example.twixie.service;

import com.example.twixie.model.UserVerification;
import com.example.twixie.service.repository.UserVerificationRepository;
import org.springframework.stereotype.Service;

@Service
public class VerificationService {

    private UserVerificationRepository verificationRepository;

    public VerificationService(UserVerificationRepository verificationRepository) {
        this.verificationRepository = verificationRepository;
    }

    public boolean verifyCode(String email, String code) {
        UserVerification userVerification = verificationRepository.findByEmail(email);
        if (userVerification != null && userVerification.getVerificationCode().equals(code)) {
            // Verification successful
            return true;
        }
        // Verification failed
        return false;
    }



}
