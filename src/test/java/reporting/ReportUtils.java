package reporting;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import io.restassured.response.Response;

public class ReportUtils {

    public static void logRequest(String json) {
        if (json == null || json.isEmpty()) return;
        ExtentTestManager.getTest().info("Request JSON:");
        ExtentTestManager.getTest().info(MarkupHelper.createCodeBlock(json, CodeLanguage.JSON));
    }

    public static void logResponse(Response response) {
        if (response == null) return;
        ExtentTestManager.getTest().info("Response status: " + response.getStatusCode());
        String body = response.getBody() != null ? response.getBody().asString() : "";
        if (!body.isEmpty()) {
            ExtentTestManager.getTest().info("Response body:");
            ExtentTestManager.getTest().info(MarkupHelper.createCodeBlock(body, CodeLanguage.JSON));
        }
    }

    public static void logInfo(String message) {
        ExtentTestManager.getTest().info(message);
    }

    public static void logPass(String message) {
        ExtentTestManager.getTest().pass(message);
    }

    public static void logFail(String message) {
        ExtentTestManager.getTest().fail(message);
    }
}
