package user;

import utils.PropertyReader;

public class UserFactory {
    public static User withAdminPermission() {
        return new User(PropertyReader.getProperty("saucedemo.user"),
        PropertyReader.getProperty("saucedemo.password"));
    }
    public static User withLockedUserPermission() {
        return new User(PropertyReader.getProperty("saucedemo.locked_user"),
        PropertyReader.getProperty("saucedemo.password"));
    }

    public static User withEmptyLogin() {
        return new User(PropertyReader.getProperty("saucedemo.empty_login"),
        PropertyReader.getProperty("saucedemo.password"));
    }

    public static User withEmptyPassword() {
        return new User(PropertyReader.getProperty("saucedemo.user"),
        PropertyReader.getProperty("saucedemo.empty_password"));
    }

    public static User withEmptyLoginAndPassword() {
        return new User(PropertyReader.getProperty("saucedemo.empty_login"),
        PropertyReader.getProperty("saucedemo.empty_password"));
    }

    public static User withInCorrectLogin() {
        return new User(PropertyReader.getProperty("saucedemo.incorrect_login"),
        PropertyReader.getProperty("saucedemo.password"));
    }

    public static User withInCorrectPassword() {
        return new User(PropertyReader.getProperty("saucedemo.user"),
        PropertyReader.getProperty("saucedemo.incorrect_password"));
    }


}
