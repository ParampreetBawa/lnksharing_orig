package com.ig.linksharing

class UserController {

    /*def home(){
        *//*User user = User.findByEmail(session.user)
        def resources = []
        UserResource.findAllByUser(user).each {
            resources.add(it.resource)
        }
        render view :'home' ,model: [resources:resources]*//*
        redirect(
                action: dashboard()
        )
    }*/
    def dashboard(){
        User user = User.findByEmail(session.user)
        def resources = []
        UserResource.findAllByUserAndIsRead(user,false).each {
            resources.add(it.resource)
        }

        def topics = []
        Subscription.findByUser(user).each {
            topics.add(it.topic)
        }
        render view :'home' ,model: [resources:resources,topics:topics]
    }
}
