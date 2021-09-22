package com.RoleGame.DAO;

import com.RoleGame.entity.Service;

public interface ServiceDAO {
    Service create (Service service);

    Service readById (long id);

    Service update (Service service);

    Service delete (long id);
}
