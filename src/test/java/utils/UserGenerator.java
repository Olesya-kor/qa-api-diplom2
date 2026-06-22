package utils;

public class UserGenerator {

    public static User getRandomUser() {

        long time = System.currentTimeMillis();

        return new User(
                "lesya" + time + "@mail.com",
                "123456",
                "Lesya"
        );
    }
}