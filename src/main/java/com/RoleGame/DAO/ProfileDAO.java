package com.RoleGame.DAO;

import com.RoleGame.entity.Profile;

public interface ProfileDAO {
    Profile create (Profile profile);

    Profile readById (long id);

    Profile update (Profile profile);

    Profile delete (long id);
}
