package com.ig.linksharing

class UserResource {
    boolean isRead
    static belongsTo = [user:User,resource:Resource]
    static constraints = {
    }
}
