/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tcpdemoserver.business;

/**
 *
 * @author usuario
 */
public class NamesManager {
    public String generateMessage(String name, String lastName){
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(name).append("lastName: ").append(lastName);
        return sb.toString();
    }
}
