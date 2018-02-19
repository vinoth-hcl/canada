package utils;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.swipeDown;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.not;

public class RoboUtils {

    public static void seesViewWithId(int id) {
        onView(withId(id)).check(matches(isDisplayed()));
    }

    public static void doesNotSeesViewWithId(int id) {
        onView(withId(id)).check(matches(not(isDisplayed())));
    }

    public static void swipeDownRefreshLayout(int id) {
        onView(withId(id))
                .perform(swipeDown());
    }
}
