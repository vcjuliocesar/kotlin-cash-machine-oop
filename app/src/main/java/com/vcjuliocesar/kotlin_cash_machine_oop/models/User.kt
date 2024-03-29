package com.vcjuliocesar.kotlin_cash_machine_oop.models
import com.vcjuliocesar.kotlin_cash_machine_oop.interfaces.IUser

class User(val name:String,val email:String,var _registered:Boolean = false):IUser {

    override fun register(){
        this._registered = true
    }
    override fun statusRegister():Boolean{
        return this._registered;
    }
}