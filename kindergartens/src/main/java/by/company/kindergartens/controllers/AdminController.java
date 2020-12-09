package by.company.kindergartens.controllers;

import by.company.kindergartens.models.Admin;
import by.company.kindergartens.models.Information;
import by.company.kindergartens.models.Kindergarten;
import by.company.kindergartens.repos.AdminRepository;
import by.company.kindergartens.repos.KindergartenRepository;
import by.company.kindergartens.services.AdminService;
import by.company.kindergartens.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private AdminRepository adminRepository;

    @GetMapping("/admin/registration")
    public String registration(Model model) {
        return "registration";
    }

    @PostMapping("/admin/registration")
    public String addAdmin(Admin admin, Map<String, Object> model){

        if(adminRepository.findByEmail(admin.getEmail())!=null)
        {
            model.put("fail_email", "Введенная электронная почта уже используется!");
            return "registration";
        }

        if(!adminService.addAdmin(admin))
        {
            model.put("fail_kindergarten", "Детский сад или пользователь с таким логином есть в базе данных!");
            return "registration";
        }

        return "redirect:/admin";
    }

    @GetMapping("/activate/{code}")
    public String activate(Model model,  @PathVariable String code) {
        boolean isActivated = adminService.activateAdmin(code);

        if(isActivated){
            model.addAttribute("message", "Пользователь успешно зарегистрирован!");
        }
        return "admin";
    }


}
