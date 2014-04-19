package com.ig.linksharing

import org.springframework.web.multipart.MultipartFile

class DocResource extends Resource {
    MultipartFile file
    static constraints = {
        file(nullable: false)
    }
    static mapping = {
        file type:'blob'
    }
}
