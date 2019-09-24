package com.integration;

import org.junit.jupiter.api.Test;

class TestSuite {

    private ApiJsonRyanairTestCases apiJsonRyanairTestCases = new ApiJsonRyanairTestCases();
    private ApiJsonPlaceholderTestCases apiJsonPlaceholderTestCases = new ApiJsonPlaceholderTestCases();

    @Test
    void runTestSuite() {
        //-----------Ryanair--------------
        apiJsonRyanairTestCases.testGoogleFlightResponse_isCorrect();

        //----------ApiPlaceholder-------
        apiJsonPlaceholderTestCases.testSchemaJsonForUsersResponse_isCorrect();
        apiJsonPlaceholderTestCases.testSchemaJsonForPostsResponse_isCorrect();
        apiJsonPlaceholderTestCases.testSchemaJsonForCommentsResponse_isCorrect();
        apiJsonPlaceholderTestCases.testSchemaJsonForAlbumsResponse_isCorrect();
        apiJsonPlaceholderTestCases.testUserResponse_isIncorrect();
        apiJsonPlaceholderTestCases.testAlbumsResponse_isIncorrect();
        apiJsonPlaceholderTestCases.testCommentsResponse_isIncorrect();
        apiJsonPlaceholderTestCases.testPostsResponse_isIncorrect();
    }
}
