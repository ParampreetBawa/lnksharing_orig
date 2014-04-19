package com.ig.linksharing

class User {

    String email
    String password
    static constraints = {
        email(email: true,nullable: false,blank: false)
    }
}
