package com.unita.heistit.models

class get_items {
    var id:Int
    var name:String
    var item_name:String
    var price:Double
    var image:String

    constructor(id:Int, name:String , item_name:String , price:Double , image:String ,)
    {
        this.id=id
        this.name=name
        this.item_name=item_name
        this.price=price
        this.image=image

    }
}