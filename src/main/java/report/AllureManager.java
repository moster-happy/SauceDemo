package report;

import com.github.automatedowl.tools.AllureEnvironmentWriter;
import com.google.common.collect.ImmutableMap;

public class AllureManager {
    public static void setAllureEnvironmentInformation(String url, String browser, String env) {
        AllureEnvironmentWriter.allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("url", url)
                        .put("browser", browser)
                        .put("env", env)
                        .put("device", "PC")
                        .build(), System.getProperty("user.dir") + "/target/allure-results/");
    }
}
