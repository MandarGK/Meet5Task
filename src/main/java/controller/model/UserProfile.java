package controller.model;


public class UserProfile {
    // Attributes
    private Long userId;
    private String name;
    private int age;
    private String additionalField1;
    private String additionalField2;

    // Constructors, getters, and setters

    public UserProfile(Long userId, String name, int age, String additionalField1, String additionalField2) {
        this.userId = userId;
        this.name = name;
        this.setAge(age); // Validation for age
        this.setAdditionalField1(additionalField1); // Validation for additionalField1
        this.setAdditionalField2(additionalField2); // Validation for additionalField2
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        // Validation for name (example: not null or empty)
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        // Validation for age (example: age must be between 18 and 150)
        if (age < 18 || age > 150) {
            throw new IllegalArgumentException("Age must be between 18 and 150");
        }
        this.age = age;
    }

    public String getAdditionalField1() {
        return additionalField1;
    }

    public void setAdditionalField1(String additionalField1) {
        // Validation for additionalField1 (example: not null or empty)
        if (additionalField1 == null || additionalField1.trim().isEmpty()) {
            throw new IllegalArgumentException("AdditionalField1 cannot be null or empty");
        }
        this.additionalField1 = additionalField1;
    }

    public String getAdditionalField2() {
        return additionalField2;
    }

    public void setAdditionalField2(String additionalField2) {
        // Validation for additionalField2 (example: not null or empty)
        if (additionalField2 == null || additionalField2.trim().isEmpty()) {
            throw new IllegalArgumentException("AdditionalField2 cannot be null or empty");
        }
        this.additionalField2 = additionalField2;
    }
}
