import lombok.SneakyThrows;

public class Application {

    @SneakyThrows
    public static void main(String[] args) {
        Downloader downloader = new Downloader();
        String rootPath = "src/main/resources/";
        for (MediaFile med : new InputConverter().getListFromJson(rootPath + "input.json")) {
            downloader.download(med.getUrl(), rootPath + "output/");
        }
    }
}
