package com.RoleGame.DAO;

import com.RoleGame.entity.Incident;

public interface IncidentDAO {
    Incident create (Incident incident);

    Incident readById (long id);

    Incident update (Incident incident);

    Incident delete (long id);
}
