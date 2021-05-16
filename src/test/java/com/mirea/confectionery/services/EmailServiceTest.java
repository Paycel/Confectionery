package com.mirea.confectionery.services;

import com.mirea.confectionery.models.Product;
import com.mirea.confectionery.models.Recipient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Captor;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.Collections;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class EmailServiceTest {
    @Autowired
    private EmailService service;
    @MockBean
    private JavaMailSender sender;
    @Captor
    ArgumentCaptor<SimpleMailMessage> captor;
    private CountDownLatch lock = new CountDownLatch(1);

    @Test
    void sendEmail() throws InterruptedException {
        Recipient recipient = new Recipient();
        recipient.setEmail("email@email.com");
        recipient.setFirstName("name");
        recipient.setProductList(Collections.singletonList(new Product("name", "pname", "bname", 1f, 10)));
        service.sendEmail(recipient);
        lock.await(2000, TimeUnit.MILLISECONDS);

        Mockito.verify(sender, times(1)).send(ArgumentMatchers.any(SimpleMailMessage.class));
        Mockito.verify(sender, times(1)).send(captor.capture());
        Assertions.assertTrue(captor.getValue().getText().contains(recipient.getFirstName()));

    }
}
