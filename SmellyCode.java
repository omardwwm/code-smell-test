import java.util.*;

public class ApplicationManager {
    private List<User> users;
    private List<Application> applications;

    public ApplicationManager() {
        users = new ArrayList<>();
        applications = new ArrayList<>();
    }

    // Long Method + God Class + Feature Envy + Switch Statement
    public void handleApplication(String username, String appType, String action) {
        User user = findUser(username);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        Application app = new Application(appType);
        applications.add(app);

        // Feature Envy: accessing user data directly
        if (user.getRole().equals("Admin")) {
            app.setPriority(1);
        } else {
            app.setPriority(5);
        }

        // Switch Statement
        switch (action) {
            case "submit":
                System.out.println("Submitting application for " + user.getName());
                break;
            case "approve":
                System.out.println("Approving application for " + user.getName());
                break;
            case "reject":
                System.out.println("Rejecting application for " + user.getName());
                break;
            default:
                System.out.println("Unknown action.");
        }

        // Duplicate Code
        System.out.println("Application handled for user: " + user.getName());
        System.out.println("Application type: " + app.getType());
        System.out.println("Priority: " + app.getPriority());
    }

    private User findUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    // Speculative Generality: unused method
    public void futureFeature() {
        // Placeholder for future logic
    }
}

// Data Class
class User {
    private String username;
    private String name;
    private String role;

    public User(String username, String name, String role) {
        this.username = username;
        this.name = name;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }
}

// Another Data Class
class Application {
    private String type;
    private int priority;

    public Application(String type) {
        this.type = type;
        this.priority = 0;
    }

    public String getType() {
        return type;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
