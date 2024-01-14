package com.phoneScamCatcher.scatcher.service;

import com.phoneScamCatcher.scatcher.entity.Phone;
import com.phoneScamCatcher.scatcher.repository.PhonesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhonesService {
    @Autowired
    private final PhonesRepository phonesRepository;

    public PhonesService(PhonesRepository phonesRepository) {
        this.phonesRepository = phonesRepository;
    }

    public void reportPhoneNumber(String phoneNumber) {
        Phone existingPhone = phonesRepository.findByPhoneNumber(phoneNumber);

        if (existingPhone == null) {
            Phone newPhone = new Phone();
            newPhone.setPhoneNumber(phoneNumber);
            newPhone.setReportCount(1);

            phonesRepository.save(newPhone);

        } else {
            existingPhone.setReportCount(existingPhone.getReportCount() + 1);

            phonesRepository.save(existingPhone);
        }

    }

    public int checkPhoneNumber(String phoneNumber) {
        Phone existingPhone = phonesRepository.findByPhoneNumber(phoneNumber);

        if (existingPhone != null) {
            return existingPhone.getReportCount();
        } else {
            return 0;
        }
    }

}
