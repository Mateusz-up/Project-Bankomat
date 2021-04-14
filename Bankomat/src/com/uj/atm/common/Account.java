package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;

public class Account implements IAccount {

private double balance_account=0;

    @Override
    public double AccountStatus() {

        return balance_account;

    }

    @Override
    public double DepositFunds(double amount) {

       balance_account +=amount;

        return balance_account;

    }

    @Override
    public double WithdrawFunds(double amount) {

        if(balance_account >= amount)
        {
            balance_account -=amount;
        }
        else

        {
            System.out.println("Not enough money");
        }

        return 0;

    }
}
