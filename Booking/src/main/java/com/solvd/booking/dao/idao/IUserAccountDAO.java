package com.solvd.booking.dao.idao;

import com.solvd.booking.travelcompany.UserAccount;

import java.util.List;

public interface IUserAccountDAO extends IBaseDAO<UserAccount> {
    List<UserAccount> getUserAccountsByTravelCompanyId(int travelCompanyId);
}
