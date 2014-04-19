package com.ig.linksharing

class Resource {
    String summary
    String title
    static belongsTo = [createdBy:User]
    static constraints = {
        summary (length: 1024)
    }
    static mapping = {
        tablePerHierarchy(false)
    }
}
