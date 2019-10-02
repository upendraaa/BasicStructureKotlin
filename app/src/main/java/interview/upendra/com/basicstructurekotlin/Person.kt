package interview.upendra.com.basicstructurekotlin

import java.sql.Date

class Person{

    var name:String? = null
    var id:String? = null;
    var dob:Date? = null;
    var image:Int?=null;

    constructor(name:String,id:String,dob:Date,image:Int) {

        this.name = name;
        this.id = id;
        this.dob = dob;
        this.image = image;


    }

}