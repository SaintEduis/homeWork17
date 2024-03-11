package pro.sky.secondartifact;

import org.springframework.stereotype.Service;
import pro.sky.secondartifact.exceptions.WrongLoginException;
import pro.sky.secondartifact.exceptions.WrongPasswordException;

import java.util.Arrays;

@Service
public class PasswordCheckService {
    static String checkPassword (String login, String password, String confirmPassword) {
        String[] exceptionSymbol = new String[] {"!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "'", "-", "=", "+", "/", "|", "\\", ",", ".", ";", ":", "'", "\""};

        for (int i = 0; i < exceptionSymbol.length; i++) {
            if (login.contains(exceptionSymbol[i])) {
                throw  new WrongLoginException();
            }
        }

        if ((login.length() > 20)) {
            throw new WrongLoginException();
        }

        for (int i = 0; i < exceptionSymbol.length; i++) {
            if (password.contains(exceptionSymbol[i])) {
                throw new WrongPasswordException();
            }
        }

        if ((password.length() > 20) || !(password.equals(confirmPassword))) {
            throw new WrongPasswordException();
        }

        return "Всё верно!";
    }
}
