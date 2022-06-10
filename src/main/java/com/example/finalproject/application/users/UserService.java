package com.example.finalproject.application.users;

import com.example.finalproject.core.invoice.Invoice;
import com.example.finalproject.core.invoice.InvoiceRepository;
import com.example.finalproject.core.invoiceDetail.InvoiceDetailRepository;
import com.example.finalproject.core.user.EncryptSerivce;
import com.example.finalproject.core.user.User;
import com.example.finalproject.core.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private EncryptSerivce encryptSerivce;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    InvoiceRepository invoiceRepository;

    @Autowired
    InvoiceDetailRepository invoiceDetailRepository;

    private static final String BRONZE = "bronze";

    private static final String SILVER = "silver";

    private static final String GOLD = "gold";

    private static final String DIAMOND = "diamond";

    public UserData createUser(@Valid UserRegisterParam userRegisterParam) {
        User user = new User(
                userRegisterParam.getEmail(),
                encryptSerivce.encryptPassword(userRegisterParam.getPassword()),
                userRegisterParam.getName(),
                userRegisterParam.getPhoneNumber(),
                userRegisterParam.getDob(),
                userRegisterParam.getAddress()
        );
        userRepository.save(user);
        return UserData.fromUser(user);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Optional<User> updateLevel(User user) {
        List<Invoice> invoiceList = invoiceRepository.getInvoiceByUser(user.getId());
        int sum = 0;
        String level = "";
        for (Invoice invoice : invoiceList) {
            sum += invoiceDetailRepository.getTotalMoneyByInvoiceId(invoice.getId());
        }
        if (sum <= 1000000) {
            level = BRONZE;
        }
        if (sum > 1000000 && sum <= 5000000) {
            level = SILVER;
        }
        if (sum > 5000000 && sum <= 10000000) {
            level = GOLD;
        }
        if (sum > 10000000) {
            level = DIAMOND;
        }

        userRepository.updateLevel(level, user.getId());

        return userRepository.findById(user.getId());
    }

}
