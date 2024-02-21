package com.example.water

class User {
    var userName: String = ""
    var userPassword: String = ""
    var email: String = ""
    var phoneNumber: String = ""
    constructor()
    constructor(userName: String, userPassword: String, email: String, phoneNumber: String) {
        this.userName = userName
        this.userPassword = userPassword
        this.email = email
        this.phoneNumber = phoneNumber
    }
}
