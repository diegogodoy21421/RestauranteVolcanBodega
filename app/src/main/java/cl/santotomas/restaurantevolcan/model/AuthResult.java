package cl.santotomas.restaurantevolcan.model;

public class AuthResult {

    public enum Status {
        SUCCESS,
        INVALID_CREDENTIALS,
        INACTIVE_USER,
        ERROR
    }

    private final Status status;
    private final int userId;
    private final String username;
    private final String fullName;
    private final String roleName;

    private AuthResult(Status status, int userId, String username,
                       String fullName, String roleName) {
        this.status = status;
        this.userId = userId;
        this.username = username;
        this.fullName = fullName;
        this.roleName = roleName;
    }

    public static AuthResult success(int userId, String username,
                                     String fullName, String roleName) {
        return new AuthResult(Status.SUCCESS, userId, username, fullName, roleName);
    }

    public static AuthResult failure(Status status) {
        return new AuthResult(status, -1, null, null, null);
    }

    public Status getStatus() {
        return status;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getFullName() {
        return fullName;
    }

    public String getRoleName() {
        return roleName;
    }
}
