package by.company.kindergartens.services;

import by.company.kindergartens.models.Admin;
import by.company.kindergartens.models.Kindergarten;
import by.company.kindergartens.models.Role;
import by.company.kindergartens.repos.AdminRepository;
import by.company.kindergartens.repos.KindergartenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.util.Collections;
import java.util.UUID;

@Service
public class AdminService implements UserDetailsService {
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private MailSender mailSender;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return (UserDetails) adminRepository.findByUsername(username);
    }


    public boolean addAdmin(Admin admin){
        Admin adminFromDb = adminRepository.findByKindergarten(admin.getKindergarten());
        Admin adminFromDb1 = adminRepository.findByUsername(admin.getUsername());

        if(adminFromDb!=null || adminFromDb1!=null)
        {
            return false;
        }

        admin.setActive(false);
        admin.setRoles(Collections.singleton(Role.USER));
        admin.setActivationCode(UUID.randomUUID().toString());
        adminRepository.save(admin);


        if(!StringUtils.isEmpty(admin.getEmail())){
            String message = String.format(
                    "Здравствуйте, %s!\n" +
                            "\nДобро пожаловать в систему хранения информации о детских садах!\nДля активации аккаунта перейдите по ссылке: http://localhost:8080/activate/%s",
                    admin.getFull_name(),
                    admin.getActivationCode()
            );

            mailSender.send(admin.getEmail(), "Код активации", message);

        }
        return true;
    }


    public boolean activateAdmin(String code)  {

        Admin admin = adminRepository.findByActivationCode(code);

         if(admin==null){
           return false;
         }

         admin.setActivationCode(null);
         admin.setActive(true);
         adminRepository.save(admin);

         return true;
    }
}
