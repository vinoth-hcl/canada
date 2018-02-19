package com.hcl.canada.ui;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.hcl.canada.robots.AboutListRobot;
import com.hcl.canada.api.APIClient;
import com.hcl.canada.utils.FileUtils;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

import static java.net.HttpURLConnection.HTTP_OK;
import static java.net.HttpURLConnection.HTTP_UNAVAILABLE;

@RunWith(AndroidJUnit4.class)
public class AboutCanadaListActivityTest {

    @Rule
    public ActivityTestRule<AboutCanadaListActivity> activityTestRule = new ActivityTestRule<>(AboutCanadaListActivity.class, false, false);

    private static final String URL_PATH = "/";
    private static final String ABOUT_FACTS_CONTENT_JSON = "/about/facts.json";
    private static final String ABOUT_FACTS_ERROR_JSON = "/about/facts_not_found.json";

    private AboutListRobot.Eyes eyes = new AboutListRobot.Eyes();
    private MockWebServer mockWebServer;

    @Before
    public void setUp() throws Exception {
        mockWebServer = new MockWebServer();
        mockWebServer.start();
        APIClient.BASE_URL = mockWebServer.url(URL_PATH).toString();
    }

    @Test
    public void onLaunch_apiSuccess_seesAboutContent() {
        mockWebServer.enqueue(new MockResponse()
                .setResponseCode(HTTP_OK)
                .setBody(FileUtils.getResponseFromFile(getClass(), ABOUT_FACTS_CONTENT_JSON)));

        activityTestRule.launchActivity(new Intent());

        eyes.seesSwipeRefreshLayout()
                .seesListRecyclerView()
                .doesNotSeeNoContentView();
    }

    @Test
    public void onLaunch_apiFailure_seesNoContentInfo() {
        mockWebServer.enqueue(new MockResponse()
                .setResponseCode(HTTP_UNAVAILABLE)
                .setBody(FileUtils.getResponseFromFile(getClass(), ABOUT_FACTS_ERROR_JSON)));

        activityTestRule.launchActivity(new Intent());

        eyes.seesSwipeRefreshLayout()
                .doesNotSeeListRecyclerView()
                .seesNoContentView();
    }

    @After
    public void tearDown() throws Exception {
        mockWebServer.shutdown();
    }
}