package databean;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import static utilities.CSVUtils.convertCSVToJson;
import static utilities.JsonUtils.getValueFromDataMap;
import static utilities.JsonUtils.readFileAsString;

public class SwapiDatabean {
    private String name;
    private String height;
    private String hair_color;
    private String eye_color;
    private String gender;

    Map<String, String> expectedResult = new LinkedHashMap<>();

    public SwapiDatabean(Services serviceName, String TC_ID) {

        convertCSVToJson(serviceName);
        DocumentContext dc = null;
        try {

            dc = JsonPath.parse(readFileAsString("src/test/resources/testdata/" + serviceName.getopFile() + ".json"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        this.name = getValueFromDataMap(dc, "name", TC_ID);
        expectedResult.put("name", this.name = getValueFromDataMap(dc, "name", TC_ID));

        this.height = getValueFromDataMap(dc, "height", TC_ID);
        expectedResult.put("height", this.height = getValueFromDataMap(dc, "height", TC_ID));

        this.hair_color = getValueFromDataMap(dc, "hair_color", TC_ID);
        expectedResult.put("hair_color", this.hair_color = getValueFromDataMap(dc, "hair_color", TC_ID));

        this.eye_color = getValueFromDataMap(dc, "eye_color", TC_ID);
        expectedResult.put("eye_color", this.eye_color = getValueFromDataMap(dc, "eye_color", TC_ID));

        this.gender = getValueFromDataMap(dc, "gender", TC_ID);
        expectedResult.put("gender", this.gender = getValueFromDataMap(dc, "gender", TC_ID));

    }

    public Map<String, String> getExpectedResult() {
        return expectedResult;
    }

}
