package org.hbmuma.springbootgit202031.controller;

import org.hbmuma.springbootgit202031.dao.EmploeeDao;
import org.hbmuma.springbootgit202031.domain.Emploee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

@Controller
public class EmploeeController {
    @Autowired
    EmploeeDao emploeeDao;

    @GetMapping("/emps")
    public String list(Model model){
        Collection<Emploee> emploees = emploeeDao.getAll();
        model.addAttribute("emps", emploees);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(){
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Emploee emploee){
        emploeeDao.save(emploee);
        return "redirect:/emps";
    }
}
