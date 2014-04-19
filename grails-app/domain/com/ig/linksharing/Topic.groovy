package com.ig.linksharing

class Topic {

    boolean isPrivate
    String name
    static hasMany = [resources: Resource]
    static belongsTo = [createdBy: User]
    static constraints = {
        name unique: true
    }
    String toString(){
        return name
    }
}
