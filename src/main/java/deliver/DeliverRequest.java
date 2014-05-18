package deliver;

/**
 * リクエストパラメータなどを保持する
 */
public class DeliverRequest {
    private final String id;

    public DeliverRequest(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}