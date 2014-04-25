package com.ig.linksharing

import grails.validation.Validateable
import org.grails.databinding.BindingFormat

import java.text.DateFormat
import java.text.SimpleDateFormat

/**
 * Created by intelligrape on 20/4/14.
 */
@Validateable
class UserCO {
    String email
    String password
    String confirmPassword
    @BindingFormat("mm/dd/yyyy")
    Date date
    String dateString
    static transients = ['dateString']
    static constraints = {
        dateString(bindable:true)
    }
    /*void setDateString(String dateString){
        def sdf = new SimpleDateFormat("mm/dd/yyyy")
        Date date = sdf.parse(dateString)
        this.date = date
        //1988
    }*/
}
