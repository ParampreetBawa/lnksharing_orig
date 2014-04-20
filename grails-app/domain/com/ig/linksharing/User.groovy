package com.ig.linksharing

class User {

    String email
    String password
    String confirmPassword
    static transients = ['confirmPassword']
    static constraints = {
        email(email: true,nullable: false,blank: false)
        confirmPassword(validator: {val,obj->
            if(!val.equals(obj.password))
                return false
        })
    }
    String toString(){
        return email
    }
}
