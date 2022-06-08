/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.phelipe.marketplace.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author pheli
 */
public class GeradorSenha {
    
    public static void main(String[] args) {
        //solicitando o encode para senha 123
        System.out.println(new BCryptPasswordEncoder().encode("123"));
    }
    
}
