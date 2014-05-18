package deliver;

import org.apache.commons.lang3.StringUtils;

/**
 * コンテンツ配信の内容決定クラス
 */
public class Deliver {

    public DeliverResponse getResponseContent(DeliverRequest reqObj) {
        String content = getContent(reqObj);
        return createHtmlResponse(content);
    }

    String getContent(DeliverRequest reqObj) {
        String id = reqObj.getId();
        // TODO 本来は何らかのロジックを走らせるなどする．
        if (StringUtils.equals(id, "12345")) {
            return "HIT";
        } else {
            return "NOTHING";
        }
    }

    DeliverResponse createHtmlResponse(String content) {
        // TODO 本来はテンプレートからレスポンス置換などする．
        String html = new StringBuilder()
                .append("<html>")
                .append(content)
                .append("</html>")
                .toString();
        return new DeliverResponse(html);
    }
}
