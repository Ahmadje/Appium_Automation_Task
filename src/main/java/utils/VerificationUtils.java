
package utils;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import static utils.FrameworkConstants.ASSERTION_FOR;


public class VerificationUtils {

    public static void validate(Object actual, Object expected, String message) {

        try {
            SoftAssert soft = new SoftAssert();
            soft.assertEquals(actual, expected, message);
            soft.assertAll();

        } catch (AssertionError assertionError) {
            Assert.fail(message);
        }
    }

    public static void validateTwoTexts(Object actual, Object expected1, Object expected2, String message) {

        try {
            SoftAssert soft = new SoftAssert();
            soft.assertTrue(actual.equals(expected1) || actual.equals(expected2), message);
            soft.assertAll();
        } catch (AssertionError assertionError) {
            Assert.fail(message);
        }
    }

    public static void validateResponse(boolean result, String message) {
        try {
            Assert.assertTrue(result);
        } catch (AssertionError assertionError) {
            Assert.fail(message);
        }
    }

}
