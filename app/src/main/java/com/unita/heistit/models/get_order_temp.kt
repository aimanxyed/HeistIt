package com.unita.heistit.models

class get_order_temp {
    var id:Int
    var name:String
    var menus_name:String
    var price:Double
    var quantity:Int
    var mobile:String

    constructor(id:Int, name:String , menus_name:String , price:Double , quantity:Int, mobile:String)
    {
        this.id=id
        this.name=name
        this.menus_name=menus_name
        this.price=price
        this.quantity=quantity
        this.mobile=mobile

    }



}