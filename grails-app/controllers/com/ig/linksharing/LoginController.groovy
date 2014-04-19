package com.ig.linksharing

class LoginController {

    def index() {
        render view:'login'
    }
    def loginHandler(){
        String username = params.username
        String password = params.password
        User user = User.findByEmail(username)
        if(user && user.password.equals(password)){
            session.setAttribute("user",username)
            session.setAttribute("role",username.equals("admin@intelligrape.com")? "admin":"user")
            render view :'home'
        }else if(user){
            render view :'login',model :[errors:'Invalid Password']
        }else{
            render view :'login',model :[errors:'Invalid Username']
        }
    }
}
