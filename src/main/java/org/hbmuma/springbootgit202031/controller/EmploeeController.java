package org.hbmuma.springbootgit202031.controller;

import org.hbmuma.springbootgit202031.dao.EmploeeDao;
import org.hbmuma.springbootgit202031.domain.Emploee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Collection;

@Controller
public class EmploeeController {
    @Autowired
    EmploeeDao emploeeDao;

    // 员工列表
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Emploee> emploees = emploeeDao.getAll();
        model.addAttribute("emps", emploees);
        return "emp/list";
    }

    // 添加页面
    @GetMapping("/emp")
    public String toAddPage(){
        return "emp/add";
    }

    // 添加员工
    @PostMapping("/emp")
    public String addEmp(Emploee emploee){
        emploeeDao.save(emploee);
        return "redirect:/emps";
    }

    // 修改页面
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,
                             Model model){
        Emploee emploee = emploeeDao.get(id);
        model.addAttribute("emp",emploee);
        return "emp/add";
    }

    // 修改员工
    @PutMapping("/emp")
    public String updateEmp(Emploee emploee){
        emploeeDao.save(emploee);
        return "redirect:/emps";
    }
}
