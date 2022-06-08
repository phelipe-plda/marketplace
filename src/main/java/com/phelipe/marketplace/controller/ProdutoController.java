/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.phelipe.marketplace.controller;

import com.phelipe.marketplace.model.entity.Produto;
import com.phelipe.marketplace.model.repository.ProdutoRepository;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author pheli
 */
@Transactional
@Controller
@RequestMapping("produtos")
public class ProdutoController {
    
    @Autowired
    ProdutoRepository repository;
    
    /**
     * @param produto necessário devido utilizar no form.html o th:object que faz referência ao objeto esperado no controller.
     * @return
     */
    @GetMapping("/form")
    public String form(Produto produto){
        return "/produtos/form";
    }
    
    @GetMapping("/list")
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("produtos", repository.produtos());
        return new ModelAndView("/produtos/list", model);
    }
    
    @PostMapping("/save")
    public ModelAndView save(@Valid Produto produto, BindingResult result){      
        if(result.hasErrors()){
            return new ModelAndView("/produtos/form");
        }
        else{
            repository.save(produto);
            return new ModelAndView("redirect:/produtos/list");   
        }  
    }
    
     @PostMapping("/update")
    public ModelAndView update(@Valid Produto produto, BindingResult result) {
        
        if(result.hasErrors()){
            return new ModelAndView("/produtos/form");
        }
        else{
            repository.update(produto);
            return new ModelAndView("redirect:/produtos/list"); 
        }  
            
        
    }
    
    /**
     * @param id
     * @return
     * @PathVariable é utilizado quando o valor da variável é passada diretamente na URL
     */
    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") Long id){
        repository.remove(id);
        return new ModelAndView("redirect:/produtos/list");
    }
    
    /**
     * @param id
     * @return
     * @PathVariable é utilizado quando o valor da variável é passada diretamente na URL
     */
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("produto", repository.produto(id));
        return new ModelAndView("/produtos/form", model);
    }
    
   

    
    
    
}

