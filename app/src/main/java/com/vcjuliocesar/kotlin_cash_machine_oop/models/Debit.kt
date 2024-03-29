package com.vcjuliocesar.kotlin_cash_machine_oop.models

import com.vcjuliocesar.kotlin_cash_machine_oop.constants.Constants
import com.vcjuliocesar.kotlin_cash_machine_oop.interfaces.IDebit

class Debit(private var initBalance:Number = Constants.INITIALIZE_BALANCE_AMOUNT):IDebit {
    override fun saving(amount: Number) {
        if (amount.toDouble() >= Constants.MAX_AMOUNT_AVAILABLE){
            println("No se permiten transacciones superiores o iguales a ${Constants.MAX_AMOUNT_AVAILABLE}")
        }

        if(amount.toDouble() < Constants.MIN_AMOUNT_AVAILABLE) {
            println("No se permiten transacciones menores a ${Constants.MIN_AMOUNT_AVAILABLE}")
        }

        update_balance(balance().toDouble() + amount.toDouble())
    }

    override fun balance():Number{
        return initBalance
    }

    override fun update_balance(balance:Number){
        initBalance = balance
    }

    override fun with_drawal(amount: Number):Number{
        if(initBalance == 0){
            println("La cuenta esta vacia")
        }

        if(amount.toDouble() <= 0) {
            println("Indica una cantidad mayor a $amount")
        }

        if(amount.toDouble() > initBalance.toDouble()) {
            println("La cantidad $amount es mayor al saldo disponible")
        }
        update_balance(initBalance.toDouble() - amount.toDouble())

        return balance()
    }
}