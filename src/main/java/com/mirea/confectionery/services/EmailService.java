package com.mirea.confectionery.services;

import com.mirea.confectionery.models.Product;
import com.mirea.confectionery.models.Recipient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
@Transactional
public class EmailService {
    @Autowired
    public JavaMailSender emailSender;

    @Async
    public void sendEmail(Recipient recipient) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipient.getEmail());
        message.setSubject("Thank you for your purchase!");
        String productList = recipient.getProductList().stream().map(Product::toString).collect(Collectors.joining("\n"));
        AtomicReference<Float> totalCost = new AtomicReference<>((float) 0);
        recipient.getProductList().forEach(product -> totalCost.updateAndGet(v -> v + product.getQuantity() * product.getPrice()));
        productList += String.format("\nTotal cost: $%.2f", totalCost.get());
        message.setText(String.format("Hello, %s %s!\nDelivery has been made to your address: %s, city: %s.\n" +
                        "Your contact number: %s, if that's incorrect, please contact us!\nInstructions for your delivery: %s\nProducts:\n%s",
                recipient.getFirstName(), recipient.getLastName(), recipient.getAddress(), recipient.getCity(), recipient.getPhoneNumber(),
                recipient.getInstructions() != null ? recipient.getInstructions() : "Absent", productList));
        this.emailSender.send(message);
    }
}
