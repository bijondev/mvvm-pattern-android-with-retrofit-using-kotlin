package com.bkb.mvvm.model

class Model {
    var email: String? = null
    var password:String? = null

    constructor()

    constructor(email: String?, password: String?) {
        this.email = email
        this.password = password
    }

    override fun toString(): String {
        return "Model(email=$email, password=$password)"
    }


}