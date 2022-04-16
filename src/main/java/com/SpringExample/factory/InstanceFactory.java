package com.SpringExample.factory;

import com.SpringExample.dao.*;
import com.SpringExample.service.*;

public class InstanceFactory {

    public IAccountDao createAccountDao(){
        return new AccountDaoImpl_1();
    }

    public IAccountService createAccountService(){
        return new AccountServiceImpl_1();
    }
}
