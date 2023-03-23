package customer;

import java.util.UUID;

public class Customer {
    private final UUID customerId;
    private String name;
    private String gender;
    private String address;
    private String phoneNumber;
    private boolean marketingConsent;
    private boolean dataCollectionConsent;
    private final String createdAt;

    public Customer(String name, String gender, String address, String phoneNumber, boolean marketingConsent, boolean dataCollectionConsent) {
        this.customerId = UUID.randomUUID();
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.marketingConsent = marketingConsent;
        this.dataCollectionConsent = dataCollectionConsent;
        this.createdAt = getCurrentDate();
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isMarketingConsent() {
        return marketingConsent;
    }

    public void setMarketingConsent(boolean marketingConsent) {
        this.marketingConsent = marketingConsent;
    }

    public boolean isDataCollectionConsent() {
        return dataCollectionConsent;
    }

    public void setDataCollectionConsent(boolean dataCollectionConsent) {
        this.dataCollectionConsent = dataCollectionConsent;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    private String getCurrentDate() {
        // Implement date formatting logic here
        return "yyyy. MM. dd.";
    }
}