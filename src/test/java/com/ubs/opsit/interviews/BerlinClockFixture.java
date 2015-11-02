package com.ubs.opsit.interviews;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Test;

import static com.ubs.opsit.interviews.support.BehaviouralTestEmbedder.aBehaviouralTestRunner;
import static org.junit.Assert.assertEquals;

/**
 * Acceptance test class that uses the JBehave (Gerkin) syntax for writing stories.  You need to
 * edit this class to complete the exercise.
 */
public class BerlinClockFixture {

    private TimeConverter berlinClock;
    private String inputTime;

    @Test
    public void berlinClockAcceptanceTests() throws Exception {
        aBehaviouralTestRunner()
                .usingStepsFrom(this)
                .withStory("berlin-clock.story")
                .run();
    }

    @When("the time is $time")
    public void inputTimeIs(String time) {
        inputTime = time;
    }

    @Then("Berlin clock should look like$clock")
    public void berlinClockShouldLookLike(String clock) {
        berlinClock = new BerlinClock();
        assertEquals(clock, berlinClock.convertTime(inputTime));
    }
}
