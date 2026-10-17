package com.foodshare.service;

import com.foodshare.dao.ActivityDAO;
import com.foodshare.dao.DonorDAO;
import com.foodshare.dao.NgoDAO;
import com.foodshare.model.DonorRegistrationPOJO;
import com.foodshare.model.NGORegistrationPOJO;
import com.foodshare.model.UserSession;

/**
 * Backend Authentication Service
 */
public class AuthService {

    private final DonorDAO donorDAO = new DonorDAO();
    private final NgoDAO ngoDAO = new NgoDAO();
    private final ActivityDAO activityDAO = new ActivityDAO();

    public boolean loginDonor(String email, String password) {
        DonorRegistrationPOJO donor = donorDAO.authenticateDonor(email, password);
        if (donor != null) {
            UserSession.getInstance().setUser(donor.getName(), donor.getEmail(), "Donor", donor.getAddress(), donor.getMobile());
            activityDAO.logActivity(donor.getEmail(), "LOGIN", "Donor logged into FoodShare portal");
            return true;
        }
        return false;
    }

    public boolean loginNgo(String email, String password) {
        NGORegistrationPOJO ngo = ngoDAO.authenticateNgo(email, password);
        if (ngo != null) {
            UserSession.getInstance().setUser(ngo.getOrganizationName(), ngo.getEmail(), "NGO", ngo.getAddress(), ngo.getMobile());
            activityDAO.logActivity(ngo.getEmail(), "LOGIN", "NGO logged into FoodShare dashboard");
            return true;
        }
        return false;
    }
}
