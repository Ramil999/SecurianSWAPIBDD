package utilities;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import databean.Services;

import java.io.File;
import java.util.List;
import java.util.Map;

public class CSVUtils {
    public static void convertCSVToJson(Services serviceName) {

        String ipFile = serviceName.getIpFile();
        String opFile = serviceName.getopFile();

        File input = new File("src/test/resources/testdata/" + ipFile + ".csv");
        File output = new File("src/test/resources/testdata/" + opFile + ".json");


        try {
            CsvSchema csv = CsvSchema.emptySchema().withHeader();
            CsvMapper csvMapper = new CsvMapper();
            csvMapper.configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true);
            MappingIterator<Map<?, ?>> mappingIterator = csvMapper.reader().forType(Map.class).with(csv).readValues(input);
            List<Map<?, ?>> list = mappingIterator.readAll();

            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(output, list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
