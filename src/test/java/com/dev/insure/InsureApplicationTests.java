package com.dev.insure;

import com.dev.insure.model.Client;
import com.dev.insure.repository.ClientRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.Calendar;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InsureApplicationTests {

	@Autowired
	ClientRepository clientRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	@Transactional
	public void addClientTest() {
		assertNotNull(clientRepository.save(new Client("2200","123456",
				"Иванов Иван Иванович", new Date(Calendar.getInstance().getTimeInMillis()))));
	}


}
