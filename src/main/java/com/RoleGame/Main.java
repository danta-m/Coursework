package com.RoleGame;

import com.RoleGame.DAO.*;
import com.RoleGame.database.Init;

public class Main {
    public static Init initDB = new Init();

    public static IncidentDAO incidentDAO = new IncidentDAOImpl();
    public static ProfileDAO profileDAO = new ProfileDAOImpl();
    public static ServiceDAO serviceDAO = new ServiceDAOImpl();
    public static UserDAO userDAO = new UserDAOImpl();

    public static void main(String[] args) {

    }
}
