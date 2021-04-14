package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;

public class CreditCard implements ICreditCard {

private IAccount card=null;
    @Override
    public boolean ChangePin(String oldPin, String newPin, String newPinConfirm) {

        IsPinValid(newPin);

        if(oldPin != newPin && newPin==newPinConfirm)
        {
            return true;
        }

        return false;
    }

    @Override
    public boolean IsPinValid(String pin) {

    int number_pin=pin.length();

        if(number_pin==4)
        {
            for(int a=0;a<4;a++)
            {
                if(pin.charAt(a) >='0' && pin.charAt(a)<= '9')
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }

        return false;
    }

    @Override
    public void AddAccount(IAccount account) {

        if(card==null && account!=null)
        {
            card =account;
        }

    }

    @Override
    public boolean DepositFunds(double amount) {

        if(card!=null)
        {
            card.DepositFunds(amount);
                    return true;
        }

        return false;
    }

    @Override
    public boolean WithdrawFunds(double amount) {

        if(card!=null)
        {
            card.WithdrawFunds(amount);
            return true;
        }

        return false;
    }
}
