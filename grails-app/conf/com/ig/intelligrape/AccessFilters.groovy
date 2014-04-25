package com.ig.intelligrape

import org.apache.log4j.Logger

class AccessFilters {

    Logger logger
    def filters = {
        all(controllerExclude:'login', action:'*') {
            before = {
                if(!session.user)
                    redirect controller: 'login',action: 'index'
            }
            after = { Map model ->

            }
            afterView = { Exception e ->

            }
        }
    }
}
