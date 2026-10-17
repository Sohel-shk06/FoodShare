package com.foodshare.service;

import java.util.List;
import com.foodshare.dao.ActivityDAO;
import com.foodshare.dao.DonationDAO;
import com.foodshare.model.DonationPOJO;
import com.foodshare.model.UserSession;

/**
 * Backend Donation Service
 */
public class DonationService {

    private final DonationDAO donationDAO = new DonationDAO();
    private final ActivityDAO activityDAO = new ActivityDAO();

    public boolean createDonation(String title, String category, int portions, String address, int expiryHours, String dietary) {
        UserSession session = UserSession.getInstance();
        if (!"Donor".equalsIgnoreCase(session.getRole())) return false;
        if (portions <= 0 || expiryHours <= 0) return false;
        DonationPOJO donation = new DonationPOJO(title, category, portions, session.getName(), session.getEmail(), address, expiryHours, dietary);

        boolean success = donationDAO.addDonation(donation);
        if (success) {
            activityDAO.logActivity(session.getEmail(), "DONATION", "Published " + portions + " portions: " + title);
        }
        return success;
    }

    public List<DonationPOJO> fetchAvailableFood() {
        return donationDAO.getAvailableDonations();
    }

    public boolean claimFoodItem(int id, String title) {
        UserSession session = UserSession.getInstance();
        if (!"NGO".equalsIgnoreCase(session.getRole())) return false;
        boolean ok = donationDAO.claimDonation(id, session.getEmail(), session.getName());
        if (ok) {
            activityDAO.logActivity(session.getEmail(), "CLAIM", "Reserved food pickup for: " + title);
        }
        return ok;
    }

    public int[] getSummaryStats() { return donationDAO.getImpactStats(); }

    public List<DonationPOJO> getMyClaims() {
        UserSession session = UserSession.getInstance();
        if (!"NGO".equalsIgnoreCase(session.getRole())) return java.util.Collections.emptyList();
        return donationDAO.getClaimsForNgo(session.getEmail());
    }
}
