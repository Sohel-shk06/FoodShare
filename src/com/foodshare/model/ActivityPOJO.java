package com.foodshare.model;

/**
 * POJO for Activity Logs
 */
public class ActivityPOJO {
    private int id;
    private String userEmail;
    private String actionType;
    private String description;
    private String timestamp;

    public ActivityPOJO() {}

    public ActivityPOJO(String userEmail, String actionType, String description) {
        this.userEmail = userEmail;
        this.actionType = actionType;
        this.description = description;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getUserEmail() { return userEmail; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }

    public String getActionType() { return actionType; }
    public void setActionType(String actionType) { this.actionType = actionType; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getTimestamp() { return timestamp; }
    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }
}
