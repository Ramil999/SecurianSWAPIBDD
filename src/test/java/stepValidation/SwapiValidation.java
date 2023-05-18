package stepValidation;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import databean.SwapiDatabean;
import org.testng.Assert;

import java.io.IOException;
import java.util.*;

public class SwapiValidation {
    public void SwapiValidation(String PEJson, SwapiDatabean swapiDatabean) {
        Map<String, String> dataFromDatabean = swapiDatabean.getExpectedResult();

        JsonNode PEJsonNode = convertJSONStringToJSONNode(PEJson);
        Map<String, String> jsonList = getMember(PEJsonNode);

        List<String> expectedResult = new ArrayList<>();
        for (Map.Entry<String, String> each : dataFromDatabean.entrySet()) {
            expectedResult.add(each.getValue());
        }
        Collections.sort(expectedResult);

        List<String> actualResult = new ArrayList<>();
        for (Map.Entry<String, String> each : jsonList.entrySet()) {
            actualResult.add(each.getValue());
        }
        Collections.sort(actualResult);

        for (int i = 0; i < actualResult.size(); i++) {
            Assert.assertEquals(actualResult.get(i), expectedResult.get(i));
        }
    }


    private JsonNode convertJSONStringToJSONNode(String JSONString) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readTree(JSONString);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Map<String, String> getMember(JsonNode PEJsonNode) {
        Map<String, String> results = new HashMap<String, String>();

        String name = getValueByJSONPath(PEJsonNode, "/results/0/name");
        String height = getValueByJSONPath(PEJsonNode, "/results/0/height");
        String hair_color = getValueByJSONPath(PEJsonNode, "/results/0/hair_color");
        String eye_color = getValueByJSONPath(PEJsonNode, "/results/0/eye_color");
        String gender = getValueByJSONPath(PEJsonNode, "/results/0/gender");
        results.put("name", name);
        results.put("height", height);
        results.put("hair_color", hair_color);
        results.put("eye_color", eye_color);
        results.put("gender", gender);
        return results;
    }

    public String getValueByJSONPath(JsonNode jsonObject, String sourcePath) {
        JsonNodeType dataType = jsonObject.at(sourcePath).getNodeType();
        if (dataType == JsonNodeType.NUMBER)
            return Integer.toString(jsonObject.at(sourcePath).intValue());
        else if (dataType == JsonNodeType.STRING)
            return jsonObject.at(sourcePath).textValue();
        else if (dataType == JsonNodeType.BOOLEAN)
            return Boolean.toString(jsonObject.at(sourcePath).booleanValue());
        else if (dataType == JsonNodeType.ARRAY) {
            return jsonObject.at(sourcePath).toString();
        } else if (dataType == JsonNodeType.OBJECT) {
            return jsonObject.at(sourcePath).toString();
        } else
            return "";
    }

}
