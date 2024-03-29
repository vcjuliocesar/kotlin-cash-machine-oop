package com.vcjuliocesar.kotlin_cash_machine_oop
import androidx.core.graphics.rotationMatrix
import com.vcjuliocesar.kotlin_cash_machine_oop.models.Account
import com.vcjuliocesar.kotlin_cash_machine_oop.models.Debit
import com.vcjuliocesar.kotlin_cash_machine_oop.models.User
import com.vcjuliocesar.kotlin_cash_machine_oop.service.AccountType
import com.vcjuliocesar.kotlin_cash_machine_oop.service.Atm


fun main(){
    val user:User = User("John Doe", "john@example.com")

    println("User name : ${user.name}")
    println("User email : ${user.email}")
    println("User status registered : ${user._registered}")

    user.register()

    println("User status registered : ${user._registered}")

    val account:Account = Account(user)

    var atm:Atm = Atm(AccountType.DebitAcount(account.debit))

    val balance = atm.balance()

    println("Debit balance $balance")

    atm.withDrawal(100)

    println("Debit balance ${atm.balance()}")

    atm.saving(200)

    println("Debit balance ${atm.balance()}")

    atm = Atm(AccountType.CreditAccount(account.credit))

    println("Credit balance ${atm.balance()}")

    atm.withDrawal(100)

    println("Credit balance ${atm.balance()}")

    atm.pay(200)

    println("Credit balance ${atm.balance()}")

}


