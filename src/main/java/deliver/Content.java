package deliver;

import java.io.Serializable;
import java.util.Date;

/**
 * コンテンツ情報を保持するクラス．
 */
public class Content implements Serializable {

    private final String contentId;
    private final String content;
    private final Date date;

    public Content(String contentId, String content, Date date) {
        this.contentId = contentId;
        this.content = content;
        this.date = date;
    }


    public String getContentId() {
        return contentId;
    }

    public String getContent() {
        return content;
    }

    public Date getDate() {
        return new Date(date.getTime());
    }
}
