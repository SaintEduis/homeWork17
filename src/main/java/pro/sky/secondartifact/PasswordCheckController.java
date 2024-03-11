package pro.sky.secondartifact;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.secondartifact.exceptions.WrongLoginException;
import pro.sky.secondartifact.exceptions.WrongPasswordException;

@RestController
public class PasswordCheckController {
    @GetMapping(path = "/checkPassword")
    public String checkPassword(@RequestParam("login") String login, @RequestParam("password") String password, @RequestParam("confirmPassword") String confirmPassword) {
        try {
            return PasswordCheckService.checkPassword(login, password, confirmPassword);
        } catch (WrongLoginException e) {
            return "Неверный логин!";
        } catch (WrongPasswordException e) {
            return "Неверный пароль!";
        }
    }
}
