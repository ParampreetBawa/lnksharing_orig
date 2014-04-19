package com.ig.linksharing

class Subscription implements Serializable{
    int seriousnessLevel = 10
    static belongsTo = [user:User,topic:Topic]
    static constraints = {
        seriousnessLevel range: 1..10, nullable: false
    }
    static mapping = {
        id composite: ['user','topic']
    }
    String toString(){
        return topic.toString()
    }
}
