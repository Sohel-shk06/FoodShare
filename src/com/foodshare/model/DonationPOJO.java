package com.foodshare.model;

/**
 * POJO for Surplus Food Donations
 */
public class DonationPOJO {
    private int id;
    private String title;
    private String category;
    private int portions;
    private String donorName;
    private String donorEmail;
    private String pickupAddress;
    private int expiryHours;
    private String dietary;
    private String status; // 'available', 'claimed'
    private String claimedBy;

    public DonationPOJO() {
        this.status = "available";
    }

    public DonationPOJO(String title, String category, int portions, String donorName, String donorEmail, String pickupAddress, int expiryHours, String dietary) {
        this.title = title;
        this.category = category;
        this.portions = portions;
        this.donorName = donorName;
        this.donorEmail = donorEmail;
        this.pickupAddress = pickupAddress;
        this.expiryHours = expiryHours;
        this.dietary = dietary;
        this.status = "available";
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public int getPortions() { return portions; }
    public void setPortions(int portions) { this.portions = portions; }

    public String getDonorName() { return donorName; }
    public void setDonorName(String donorName) { this.donorName = donorName; }

    public String getDonorEmail() { return donorEmail; }
    public void setDonorEmail(String donorEmail) { this.donorEmail = donorEmail; }

    public String getPickupAddress() { return pickupAddress; }
    public void setPickupAddress(String pickupAddress) { this.pickupAddress = pickupAddress; }

    public int getExpiryHours() { return expiryHours; }
    public void setExpiryHours(int expiryHours) { this.expiryHours = expiryHours; }

    public String getDietary() { return dietary; }
    public void setDietary(String dietary) { this.dietary = dietary; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getClaimedBy() { return claimedBy; }
    public void setClaimedBy(String claimedBy) { this.claimedBy = claimedBy; }
}
