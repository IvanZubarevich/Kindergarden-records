package by.company.kindergartens.services;

import by.company.kindergartens.models.Admin;
import by.company.kindergartens.models.Information;
import by.company.kindergartens.models.Kindergarten;
import by.company.kindergartens.repos.AdminRepository;
import by.company.kindergartens.repos.InformationRepository;
import by.company.kindergartens.repos.KindergartenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MenuService {
    @Autowired
    private KindergartenRepository kindergartenRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private InformationRepository informationRepository;

    public boolean addKindergarten(Kindergarten kindergarten, Information info)
    {
        Kindergarten kinder = kindergartenRepository.findByKinder(kindergarten.getKinder());

        if(kinder!=null)
        {
            return false;
        }

        kindergarten.setInfo(info);
        kindergartenRepository.save(kindergarten);
        return true;
    }

    public boolean editKindergarten(Kindergarten kindergarten_new, Information information, Admin admin)
    {
        Kindergarten kindergarten = kindergartenRepository.findByKinder(kindergarten_new.getKinder());

        if(kindergarten==null)
        {
            return false;
        }

        kindergarten.setInfo(information);
        kindergarten.setAddress(kindergarten_new.getAddress());
        kindergarten.setPhone(kindergarten_new.getPhone());
        kindergarten.setRegion(kindergarten_new.getRegion());
        admin.setKindergartens(kindergarten);
        kindergartenRepository.save(kindergarten);
        adminRepository.save(admin);

        return true;
    }
}
