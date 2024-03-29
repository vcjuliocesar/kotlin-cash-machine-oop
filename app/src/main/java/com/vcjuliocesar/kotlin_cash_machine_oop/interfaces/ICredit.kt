package com.vcjuliocesar.kotlin_cash_machine_oop.interfaces

interface ICredit:ITransaction {
    fun fee(amount: Number):Number
    fun pay(amount:Number)
}