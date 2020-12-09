package by.company.kindergartens.controllers;

import by.company.kindergartens.models.Admin;
import by.company.kindergartens.models.Information;
import by.company.kindergartens.models.Kindergarten;
import by.company.kindergartens.repos.AdminRepository;
import by.company.kindergartens.repos.InformationRepository;
import by.company.kindergartens.repos.KindergartenRepository;
import by.company.kindergartens.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.criteria.CriteriaBuilder;
import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;

import static java.lang.Thread.sleep;

@Controller
public class MenuController {

    @Autowired
    private KindergartenRepository kindergartenRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private InformationRepository informationRepository;

    @Autowired
    private MenuService menuService;

    private Admin admin = new Admin();

    private Kindergarten kindergarten = new Kindergarten();

    @GetMapping("/menu")
    public String menu(Model model)
    {
        admin = adminRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        if(admin!=null)
            kindergarten = admin.getKindergartens();
        return "menu";
    }

    @GetMapping("/information/add")
    public String information(Model model)
    {
        if(kindergarten!=null)
        {
            model.addAttribute("fail_message", "Информация о детском саде присутствует в системе!");
            return "redirect:/menu";
        }
        return "information";
    }

    @PostMapping("/information/add")
    public String addInformation (Kindergarten kindergarten_new, Information info, Map<String, Object> model) {
        if(admin.getKindergarten().equals(kindergarten_new.getKinder())) {
            if (menuService.addKindergarten(kindergarten_new, info)) {
                admin.setKindergartens(kindergarten_new);
                adminRepository.save(admin);
                model.put("message", "Детский сад добавлен в систему!");
                return "redirect:/menu";
            }
        }
        model.put("fail_input", "Введенное название детского сада не соответствует зарегистрированному!");
        return "information";
    }

    @GetMapping("/delete")
    public String delete(Model model) {return "menu";}

    @PostMapping("/delete")
    public String deleteInformation(Model model)
    {
        Kindergarten kindergarten = kindergartenRepository.findByKinder(admin.getKindergarten());
        if(kindergarten!=null) {
            admin.setKindergartens(null);
            adminRepository.save(admin);
            kindergartenRepository.delete(kindergarten);
            model.addAttribute("message", "Детский сад удален!");
            return "menu";
        }
        model.addAttribute("fail_message", "Информации о детском саде нет в базе данных!");
        return "menu";
    }

    @GetMapping("/information/edit")
    public String editInformation(Model model)
    {
        if(kindergarten!=null)
        {
            Optional<Kindergarten> kinder = Optional.of(kindergarten);
            Optional<Information> information = Optional.ofNullable(kindergarten.getInfo());
            ArrayList<Kindergarten> res = new ArrayList<>();
            ArrayList<Information> res_info = new ArrayList<>();
            kinder.ifPresent(res::add);
            information.ifPresent(res_info::add);
            model.addAttribute("kindergarten", res);
            model.addAttribute("information", res_info);
            return "informationEdit";
        }
        return "redirect:/menu";
    }

    @PostMapping("/information/edit")
    public String editInformation(Kindergarten kindergarten_new, Information information, Model model)
    {
        if(admin.getKindergarten().equals(kindergarten_new.getKinder())) {
            if(menuService.editKindergarten(kindergarten_new, information, admin))
            {
                model.addAttribute("message", "Данные успешно отредактированы!");
                return "redirect:/menu";
            }
        }
        model.addAttribute("fail_input", "Введенное название детского сада не соответствует зарегистрированному!");
        return "information";
    }

    @GetMapping("/show")
    public String show(Model model)
    {
        Iterable<Kindergarten> kinders = kindergartenRepository.findAll();
        ArrayList<Kindergarten> kindergartens = new ArrayList<>();
        for(Kindergarten kinder : kinders)
        {
                kindergartens.add(kinder);
        }
        kindergartens.sort(Comparator.comparing(Kindergarten::getKinder));
        model.addAttribute("kindergartens", kindergartens);
        return "show";
    }

    @PostMapping("/show")
    public String postShow(String search, String s, Model model)
    {
        int max_length = search.length();
        String choice = search.substring(0, max_length-1);
        Iterable<Kindergarten> kinders = kindergartenRepository.findAll();
        switch (s) {
            case "region" -> {
                ArrayList<Kindergarten> kindergartens = new ArrayList<>();
                    for(Kindergarten kinder : kinders)
                    {
                        if(choice.equals(kinder.getRegion()))
                            kindergartens.add(kinder);
                    }
                    if(kindergartens.size()>0) {
                        kindergartens.sort(Comparator.comparing(Kindergarten::getKinder));
                        model.addAttribute("kindergartens", kindergartens);
                    }
                    else model.addAttribute("fail_search", "По Вашему запросу ничего не найдено!");
                break;
            }
            case "address" -> {
                ArrayList<Kindergarten> kindergartens = new ArrayList<>();
                for(Kindergarten kinder : kinders)
                {
                    if(choice.equals(kinder.getAddress()))
                        kindergartens.add(kinder);
                }
                if(kindergartens.size()>0)
                {
                    kindergartens.sort(Comparator.comparing(Kindergarten::getKinder));
                    model.addAttribute("kindergartens", kindergartens);
                }
                else model.addAttribute("fail_search", "По Вашему запросу ничего не найдено!");
                break;
            }
            case "name" -> {
                ArrayList<Kindergarten> kindergartens = new ArrayList<>();
                for(Kindergarten kinder : kinders)
                {
                    if(choice.equals(kinder.getKinder()))
                        kindergartens.add(kinder);
                }
                if(kindergartens.size()>0)
                {
                    kindergartens.sort(Comparator.comparing(Kindergarten::getKinder));
                    model.addAttribute("kindergartens", kindergartens);
                }
                else model.addAttribute("fail_search", "По Вашему запросу ничего не найдено!");
                break;
            }
        }
        return "show";
    }
}
