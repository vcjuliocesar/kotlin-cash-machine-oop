package com.vcjuliocesar.kotlin_cash_machine_oop.models

import com.vcjuliocesar.kotlin_cash_machine_oop.constants.Constants
import com.vcjuliocesar.kotlin_cash_machine_oop.interfaces.ICredit

class Credit(private var initBalance:Number = Constants.INITIALIZE_CREDIT_BALANCE_AMOUNT):ICredit {

    override fun fee(amount: Number): Number {
        return amount.toInt() * Constants.FEE
    }

    override fun pay(amount: Number) {
        if (amount.toDouble() > Constants.LIMIT_CREDIT) {
            println("La cantidad ${amount} supera el limite de credito")
        }

        if (Constants.LIMIT_CREDIT == 0) {
            println("Excedite el limite de credito de tu cuenta")
        }

        update_balance(balance().toDouble() - amount.toDouble())
    }

    override fun balance(): Number {
        return initBalance
    }

    override fun with_drawal(amount: Number): Number {
        if (initBalance == 0){
            println("La cuenta esta vacia")
        }

        if(amount.toDouble() <= 0) {
            println("Indica una cantidad mayor a ${amount}")
        }

        if(amount.toDouble() > initBalance.toDouble()) {
            println("La cantidad ${amount} es mayor al saldo disponible")
        }

        update_balance(initBalance.toDouble() - (amount.toDouble() + fee(amount).toDouble()))

        return balance()
    }

    override fun update_balance(balance: Number) {
        initBalance = balance
    }
}

