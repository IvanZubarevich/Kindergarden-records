package by.company.kindergartens.controllers;

import by.company.kindergartens.models.Kindergarten;
import by.company.kindergartens.repos.KindergartenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Comparator;

@Controller
public class GuestController {

    @Autowired
    private KindergartenRepository kindergartenRepository;

    @GetMapping("/guest")
    public String guest(Model model)
    {
        Iterable<Kindergarten> kinders = kindergartenRepository.findAll();
        ArrayList<Kindergarten> kindergartens = new ArrayList<>();
        for(Kindergarten kinder : kinders)
        {
            kindergartens.add(kinder);
        }
        kindergartens.sort(Comparator.comparing(Kindergarten::getKinder));
        model.addAttribute("kindergartens", kindergartens);
        return "showGuest";
    }

    @PostMapping("/guest")
    public String postGuest(String search, String s, Model model)
    {
        if(search.equals(",") && s.equals("all"))
        {
            Iterable<Kindergarten> kinders = kindergartenRepository.findAll();
            ArrayList<Kindergarten> kindergartens = new ArrayList<>();
            for(Kindergarten kinder : kinders)
            {
                kindergartens.add(kinder);
            }
            kindergartens.sort(Comparator.comparing(Kindergarten::getKinder));
            model.addAttribute("kindergartens", kindergartens);
        }
        else {
            if(search.equals(",")) model.addAttribute("fail_param", "Строка поиска пуста!");
            else {
                int max_length = search.length();
                String choice = search.substring(0, max_length - 1);
                Iterable<Kindergarten> kinders = kindergartenRepository.findAll();
                switch (s) {
                    case "region" -> {
                        ArrayList<Kindergarten> kindergartens = new ArrayList<>();
                        for (Kindergarten kinder : kinders) {
                            if (choice.equals(kinder.getRegion()))
                                kindergartens.add(kinder);
                        }
                        if (kindergartens.size() > 0) {
                            kindergartens.sort(Comparator.comparing(Kindergarten::getKinder));
                            model.addAttribute("kindergartens", kindergartens);
                        } else model.addAttribute("fail_search", "По Вашему запросу ничего не найдено!");
                        break;
                    }
                    case "address" -> {
                        ArrayList<Kindergarten> kindergartens = new ArrayList<>();
                        for (Kindergarten kinder : kinders) {
                            if (choice.equals(kinder.getAddress()))
                                kindergartens.add(kinder);
                        }
                        if (kindergartens.size() > 0) {
                            kindergartens.sort(Comparator.comparing(Kindergarten::getKinder));
                            model.addAttribute("kindergartens", kindergartens);
                        } else model.addAttribute("fail_search", "По Вашему запросу ничего не найдено!");
                        break;
                    }
                    case "name" -> {
                        ArrayList<Kindergarten> kindergartens = new ArrayList<>();
                        for (Kindergarten kinder : kinders) {
                            if (choice.equals(kinder.getKinder()))
                                kindergartens.add(kinder);
                        }
                        if (kindergartens.size() > 0) {
                            kindergartens.sort(Comparator.comparing(Kindergarten::getKinder));
                            model.addAttribute("kindergartens", kindergartens);
                        } else model.addAttribute("fail_search", "По Вашему запросу ничего не найдено!");
                        break;
                    }
                }
            }
        }
        return "showGuest";
    }
}
