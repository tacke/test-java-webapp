package deliver;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * コンテンツ配信の内容決定クラス
 */
public class Deliver {

    private final ContentDao dao = new ContentDao();// TODO DIなどでやりたい。

    public DeliverResponse getResponseContent(DeliverRequest reqObj) {
        String content = getContent(reqObj);
        return createHtmlResponse(content);
    }

    String getContent(DeliverRequest reqObj) {
        // DAOから候補のリストを取得
        List<Content> list = dao.get(reqObj.getId());

        // TODO 何らかのロジックでリストを加工したり絞り込んだりする．
        // list.stream()
        //         .parallel()
        //         .filter(f -> f.getContentId().endsWith(""))
        //         .collect();

        // 配信コンテンツを決定
        if (list.size() > 0) {
            return list.get(0).getContent();
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
