package deliver;

/**
 * レスポンス内容を保持する
 */
public class DeliverResponse {
    private final String responseHtml;

    public DeliverResponse(String responseHtml) {
        this.responseHtml = responseHtml;
    }

    public String getResponseHtml() {
        return responseHtml;
    }
}