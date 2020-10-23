package seedu.address.model.login;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a UserLogin's username in the login.json.
 * Guarantees: immutable
 */
public class Username {
    public static final String MESSAGE_CONSTRAINTS =
            "Names should only contain alphanumeric characters, backslashes, and it should not be blank";

    public static final String VALIDATION_REGEX = "[\\p{Alnum}]\\[\\p{Alnum}]";

    public final String username;

    /**
     * Constructs a {@code Name}.
     *
     * @param username A valid name.
     */
    public Username(String username) {
        requireNonNull(username);
        checkArgument(isValidUsername(username), MESSAGE_CONSTRAINTS);
        this.username = username;
    }

    /**
     * Returns true if a given string is a valid username.
     */
    public static boolean isValidUsername(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    public boolean isEmpty() {
        return username.isEmpty();
    }

    @Override
    public String toString() {
        return username;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Username // instanceof handles nulls
                && username.equals(((Username) other).username)); // state check
    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }
}
