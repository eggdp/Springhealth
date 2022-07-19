package com.example.hello;

import com.example.hello.dto.TbMenu;
import com.example.hello.service.MenuService;
import com.example.hello.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class HelloController {
    @Autowired
    private MenuService menuService;

    @Autowired
    private MusicService musicService;
    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/insert")
    public String insert(){
        return "insert";
    }
    @GetMapping("/test")
    public String test(){
        return "test";
    }

    @PostMapping("/insert_proc")
    @ResponseBody
    public TbMenu insert_proc(@ModelAttribute TbMenu tbmenu){
        System.out.println(tbmenu.getMenu());
        System.out.println(tbmenu.getPrice());
        System.out.println(tbmenu.getImg());
        return tbmenu;
    }

    @GetMapping("/see")
    public String see(Model model) {
        model.addAttribute("list", menuService.findAll());
        return "see";
    }

    @GetMapping("/best")
    public String best() {
        return "best";
    }

    @GetMapping("/blog")
    public String blog() {
        return "blog";
    }

    @GetMapping("/melon")
    public String melon(Model model) {
        model.addAttribute("list", musicService.getMelonMusicList());
        return "melon";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/";
    }




}
