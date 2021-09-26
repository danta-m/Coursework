package com.RoleGame.DAO;

import com.RoleGame.entity.User;

public interface UserDAO {
    User create (User user);

    User readById (long id);

    User update (User user);

    User delete (long id);
}
