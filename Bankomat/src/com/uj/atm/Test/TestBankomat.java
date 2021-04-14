package com.uj.atm.Test;

import com.uj.atm.common.Account;
import com.uj.atm.common.Atm;
import com.uj.atm.common.CreditCard;
import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.IAtm;
import com.uj.atm.interfaces.ICreditCard;
import org.junit.Assert;
import org.junit.Test;

public class TestBankomat {

    IAccount account1 = new Account();
    ICreditCard creditCard1 = new CreditCard();
    IAtm atm1 = new Atm();

    IAccount account2 = new Account();
    ICreditCard creditCard2 = new CreditCard();




    @Test
    public void card_pin()
    {
    creditCard1.AddAccount(account1);

    Assert.assertTrue(atm1.CheckPinAndLogIn(creditCard1,"0000")==true); // 1 Test sprawdzenie czy pin domyślny 0000

    Assert.assertTrue(atm1.ChangePinCard(creditCard1,"0000","4561","4561")==true);    // 2 Test  zmiana pinu na nowy

    Assert.assertTrue(atm1.CheckPinAndLogIn(creditCard1,"4561")==true); // 3 Test  sprawdzenie poprawnosci pinu po zmianie

    }

    @Test
    public void check_account()
    {

        creditCard1.AddAccount(account1);

        Assert.assertTrue(account1.AccountStatus()==0); //1 Test sprawdzenie konta

        Assert.assertTrue(atm1.DepositFunds(creditCard1,300)==true);// 2 Test wpłacenie 300 pieniedzy na konto

        Assert.assertTrue(atm1.AccountStatus(account1)==300); // 3 Test sprawdzenie konta czy zawartosc wynosi 300

        Assert.assertTrue(atm1.WithdrawFunds(creditCard1,100)==true); // 4 Test wyplacenie 100 pieniedzy z konta

        Assert.assertTrue(atm1.AccountStatus(account1)==200); // 5 Test sprawdzenie czy po wyplacie, pieniadze sie zgadzaja
    }


    @Test
    public void money_transfer()
    {
        creditCard1.AddAccount(account1);
        creditCard2.AddAccount(account2);

        Assert.assertTrue(atm1.DepositFunds(creditCard1,320)==true); // 1 Test  wpłacenie 320 pieniedzy na konto1

        Assert.assertTrue(atm1.DepositFunds(creditCard2,650)==true); // 2 Test wpłacenie 650 pieniedzy na konto2

        Assert.assertTrue(atm1.Transfer(creditCard2,account1,100)==true); // 3 Test przeslanie 100 pieniedzy z konta2 na konto1

        Assert.assertTrue(atm1.AccountStatus(account1)==420); // 4 Test sprawdzenie czy po przelewie stan konta1 wynosi 420

        Assert.assertTrue(atm1.AccountStatus(account2)==550); // 5 Test sprawdzenie czy po przelewie stan konta2 wynosi 550

    }



}
