package servlet;

import deliver.Deliver;
import deliver.DeliverRequest;
import deliver.DeliverResponse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * コンテンツ配信サーブレット
 */
public class DeliverServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // parameter取得
        DeliverRequest reqObj = getRequestInfo(req);

        // レスポンス生成
        Deliver deliver = new Deliver();// TODO FactoryやDIでDaoなど依存関係を注入しつつインスタンス生成した方が良い。
        DeliverResponse respObj = deliver.getResponseContent(reqObj);

        // レスポンス書き込み
        writeResponse(resp, respObj);
    }

    DeliverRequest getRequestInfo(HttpServletRequest req) {
        return new DeliverRequest(req.getParameter("id"));
    }

    void writeResponse(HttpServletResponse resp, DeliverResponse deliverResp) throws IOException {
        resp.getWriter().print(deliverResp.getResponseHtml());
    }
}
