package utilities;
import com.jayway.jsonpath.DocumentContext;
import net.minidev.json.JSONArray;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonUtils {

    public static String readFileAsString(String file) throws IOException {
        return new String(Files.readAllBytes(Paths.get(file)));
    }


    public static String getValueFromDataMap(DocumentContext documentContext, String key, String testDataId) {
        JSONArray jsonArr = documentContext.read("$.[?(@.TC_ID =~  /.*" + testDataId + "/i)]." + key);
        return jsonArr.get(0).toString();
    }
}
