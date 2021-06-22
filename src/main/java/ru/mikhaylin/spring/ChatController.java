package ru.mikhaylin.spring;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ChatController {

    @GetMapping("/registration")
    public String inputData() {
        return "registration";
    }

    @PostMapping("/regist")
    public String regist(@RequestParam("login") String login, @RequestParam("password") String password, HttpServletRequest request) {
        String cookie = request.getHeader("Cookie");
        Registered registered = Registered.getDataBaseRegistered();
        boolean answer = registered.addNewUser(login, password);
        System.out.println(login + password);
        if (answer) {
            return "successfullRegistration";
        }
        return "failedRegistration";
    }

//    @PostMapping("/backToRegistration")
//    public String backToRegistered() {
//        return "registration";
//    }

    @PostMapping("/goToAuthorization")
    public String goToAuthorized() {
        return "authorization";
    }

    @PostMapping("/authoriz")
    public String authoriz(@RequestParam("login") String login, @RequestParam("password") String password, @RequestParam("to") String to, Model model) {
        Authorized authorized = Authorized.getDataBaseAuthorized();
        if (authorized.addAuthorizedUser(login, password)) {
            MembersList membersList = MembersList.getMemberList();
            ChatsNew chatsNew = ChatsNew.getDataBaseChats();
            model.addAttribute("members", membersList.getList());
            if (to.equals("default")) {
                model.addAttribute("chat", chatsNew.getChatList(login, "dva"));
            } else {
                model.addAttribute("chat", chatsNew.getChatList(login, to));
            }
            model.addAttribute("login", login);
            model.addAttribute("password", password);
            model.addAttribute("to", to);
            return "chats";
        } else {
            return "failedAuthorization";
        }
    }

    @PostMapping("/goToSend")
    public String goToSend(@RequestParam("login") String login, @RequestParam("password") String password, Model model) {
        model.addAttribute("login", login);
        model.addAttribute("password", password);
        return "inputMessage";
    }

    @PostMapping("/registrationSend")
    public String registrationMessage(@RequestParam("login") String login, @RequestParam("password") String password, @RequestParam("to") String to,
                                      @RequestParam("message") String message, Model model) {
        ChatsNew chatsNew = ChatsNew.getDataBaseChats();
        chatsNew.addMessage(login, to, message);
        model.addAttribute("login", login);
        model.addAttribute("password", password);
        MembersList membersList = MembersList.getMemberList();
        model.addAttribute("members", membersList.getList());
        model.addAttribute("chat", chatsNew.getChatList(login, to));
        model.addAttribute("to", to);
        return "chats";
    }
}
