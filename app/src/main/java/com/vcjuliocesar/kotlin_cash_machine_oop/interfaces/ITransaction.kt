package com.vcjuliocesar.kotlin_cash_machine_oop.interfaces

interface ITransaction {

    fun balance():Number

    fun with_drawal(amount:Number):Number

    fun update_balance(balance:Number)
}