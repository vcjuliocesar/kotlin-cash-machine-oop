package com.vcjuliocesar.kotlin_cash_machine_oop.models

class Account(
    val user:User,
    private val _debit:Debit = Debit(),
    private val _credit:Credit = Credit()
) {
    /**
     * init es un bloque de inicializacion que se utiliza para ejecutar codigo despues de crear una isntancia
     * */
    init {
        if(user.name.isEmpty()){
            println("El campo nombre no puede ser vacio")
        }

        if(user.email.isEmpty()){
            println("El campo email no puede ser vacio")
        }

        if(!user.statusRegister()){
            println("El usuario ${user.name} no está registrado")
        }
    }


    val debit:Debit
        get() = _debit

    val credit:Credit
        get() = _credit
}