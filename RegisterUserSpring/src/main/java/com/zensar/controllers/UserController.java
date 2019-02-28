package com.zensar.controllers;   
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;

import com.zensar.dao.UserDao;
import com.zensar.training.beans.User;  
@Controller  
public class UserController {  
    @Autowired  
    UserDao dao;
    
    @RequestMapping("/userform")  
    public String showform(Model m){  
    	m.addAttribute("command", new User());
    	return "userform"; 
    }  
   
    @RequestMapping(value="/save",method = RequestMethod.POST)  
    public String save(@ModelAttribute("usr") User emp){  
        dao.save(emp);  
        return "redirect:/viewemp";//will redirect to viewemp request mapping  
    }  
    
    @RequestMapping("/viewuser")  
    public String viewemp(Model m){  
        List<User> list=dao.getEmployees();  
        m.addAttribute("list",list);
        return "viewUser";  
    }  
   
    @RequestMapping(value="/edituser/{id}")  
    public String edit(@PathVariable int id, Model m){  
        User emp=dao.getEmpById(id);  
        m.addAttribute("command",emp);
        return "usereditform";  
    }  
   
    @RequestMapping(value="/editsave",method = RequestMethod.POST)  
    public String editsave(@ModelAttribute("usr") User usr){  
        dao.update(usr);  
        return "redirect:/viewUser";  
    }  
    /* It deletes record for the given id in URL and redirects to /viewemp */  
    @RequestMapping(value="/deleteuser/{id}",method = RequestMethod.GET)  
    public String delete(@PathVariable int id){  
        dao.delete(id);  
        return "redirect:/viewUser";  
    }   
}  