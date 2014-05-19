package deliver;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ContentDao extends BaseDao {

    public List<Content> get(String id) {
        // TODO DBアクセスなど実装．
        List<Content> list = new ArrayList();

        if (StringUtils.equals(id, "12345")) {
            list.add(new Content("id1", "content1", new Date()));
            list.add(new Content("id2", "content2", new Date()));
            list.add(new Content("id3", "content3", new Date()));
        }

        return list;
    }
}
