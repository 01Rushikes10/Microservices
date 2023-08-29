package com.contact.controller;


import com.contact.entity.Contact;
import com.contact.service.ContactService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;



    
    @RequestMapping("/user/{userId}")
    public List<Contact> getContacts(@PathVariable("userId") Long userId) {
        return this.contactService.getContactsOfUser(userId);
    }
    
    @GetMapping("/{cId}")
    public Contact getUser(@PathVariable("cId") Long cId) {

    	Contact user = this.contactService.getContact(cId);
        //http://localhost:9002/contact/user/1311
        return user;

    }

}
