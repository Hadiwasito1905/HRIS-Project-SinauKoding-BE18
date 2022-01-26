package projecthrissinauKodingBE18.projecthrisbe18.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projecthrissinauKodingBE18.projecthrisbe18.common.RestResult;
import projecthrissinauKodingBE18.projecthrisbe18.entity.User;
import projecthrissinauKodingBE18.projecthrisbe18.service.UserService;

@RestController
@RequestMapping("auth")
@PreAuthorize("permitAll()")
public class AuthController extends BaseController {

    @Autowired
    private UserService service;

    @PostMapping(value = "do-login")
    public RestResult doLogin(@RequestBody User user){
        return service.login(user);
    }

    @PreAuthorize("permitAll()")
    @PostMapping(value = "do-register")
    public RestResult register(@RequestBody User param){
        return new RestResult(service.register(param, User.Role.ROLE_USER));
    }
}
