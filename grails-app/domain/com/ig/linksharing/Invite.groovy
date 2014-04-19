package com.ig.linksharing

class Invite {

    boolean isAccepted
    static belongsTo = [sentBy:User,sentTo:User]
    static constraints = {
    }
}
