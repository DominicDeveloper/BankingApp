package com.itteacher.bankingapp.models

class CardOwners {
    var name:String? = null
    var cardNumber:String? = null
    var cardType:String? = null
    constructor()
    constructor(name: String?, cardNumber: String?, cardType: String?) {
        this.name = name
        this.cardNumber = cardNumber
        this.cardType = cardType
    }


}