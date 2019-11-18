import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class InputConverter {

    private byte[] jsonData;

    @SneakyThrows
    public List<MediaFile> getListFromJson(String path) {
        setJsonData(path);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonData, new TypeReference<List<MediaFile>>() {});
    }

    private void setJsonData(String path) {
        try {
            jsonData = Files.readAllBytes(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
