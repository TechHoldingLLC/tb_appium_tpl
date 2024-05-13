package com.qa.testrailmanager;

import base.Setup;
import com.gurock.testrail.APIClient;
import com.gurock.testrail.APIException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestRailManager extends Setup {

    public static String TEST_RUN_ID = "172";
    public static String TEST_RAIL_USERNAME = "karishma.barot@techholding.co";
    public static String TEST_RAIL_PASSWORD = "Kari@123";
    public static String TEST_RAIL_ENGINE_URL = "https://techholding.testrail.io/";
    public static int TEST_RAIL_PASS_STATUS = 1;
    public static int TEST_RAIL_FAIL_STATUS = 5;

    public static void addResultForTestCase(String testCaseId, int status, String error){
        String testRunID = TEST_RUN_ID;
        APIClient client = new APIClient(TEST_RAIL_ENGINE_URL);
        client.setUser(TEST_RAIL_USERNAME);
        client.setPassword(TEST_RAIL_PASSWORD);

        Map<String, Object> data = new HashMap<String, Object>();
        data.put("status_id", status);
        data.put("comment","This test is executed via Automation code." + error);

        try {
            client.sendPost("add_result_for_case/"+testRunID+"/"+testCaseId, data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (APIException e) {
            throw new RuntimeException(e);
        }

    }
}
