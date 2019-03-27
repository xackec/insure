package com.dev.insure;

import com.dev.insure.model.Agreement;
import com.dev.insure.repository.AgreementRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.TransactionSystemException;
import java.sql.Date;
import java.util.Calendar;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ValidatorTests {

    @Autowired
    AgreementRepository agreementRepository;

    @Test(expected = TransactionSystemException.class)
    public void AgreementValidationTest() {
        Agreement agreement = new Agreement("1","22", new Date(Calendar.getInstance().getTimeInMillis()),
                new Date(Calendar.getInstance().getTimeInMillis()), "123.45");
        agreementRepository.save(agreement);

    }
}
