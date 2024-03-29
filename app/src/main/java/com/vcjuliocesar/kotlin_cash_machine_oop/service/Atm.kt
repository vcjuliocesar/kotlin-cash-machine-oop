package com.vcjuliocesar.kotlin_cash_machine_oop.service
import com.vcjuliocesar.kotlin_cash_machine_oop.models.Credit
import com.vcjuliocesar.kotlin_cash_machine_oop.models.Debit
import java.lang.IllegalStateException

sealed class AccountType {
    abstract fun balance():Number

    class DebitAcount(private val debit:Debit) : AccountType(){
        override fun balance(): Number {
            return debit.balance()
        }

        fun saving(amount: Number) {
            debit.saving(amount)
        }

        fun withDrawal(amount: Number):Number{
            return debit.with_drawal(amount)
        }
    }
    class CreditAccount(private val credit:Credit) : AccountType(){
        override fun balance(): Number {
            return credit.balance()
        }

        fun fee(amount: Number): Number {
            return credit.fee(amount)
        }

        fun pay(amount: Number) {
            return credit.pay(amount)
        }

        fun withDrawal(amount: Number):Number{
            return credit.with_drawal(amount)
        }
    }
}

class Atm(private val account:AccountType) {

    fun balance():Number {
        return when(account) {
            is AccountType.DebitAcount -> (account as AccountType.DebitAcount).balance()
            is AccountType.CreditAccount -> (account as AccountType.CreditAccount).balance()
        }
    }

    fun withDrawal(amount: Number):Number {
        return when(account) {
            is AccountType.DebitAcount -> (account as AccountType.DebitAcount).withDrawal(amount)
            is AccountType.CreditAccount -> (account as AccountType.CreditAccount).withDrawal(amount)
        }
    }

    fun saving(amount: Number){
        return when(account) {
            is AccountType.DebitAcount -> (account as AccountType.DebitAcount).saving(amount)
            is AccountType.CreditAccount -> throw IllegalStateException("No se puede ahorrar en una cuenta de crédito")
        }
    }

    fun pay(amount: Number) {
        return when (account) {
            is AccountType.DebitAcount -> throw IllegalStateException("No se puede pagar con una cuenta de débito")
            is AccountType.CreditAccount -> (account as AccountType.CreditAccount).pay(amount)
        }
    }
}