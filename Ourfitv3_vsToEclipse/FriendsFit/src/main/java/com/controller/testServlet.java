import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "testServlet", value = "/review/*")
public class testServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();  // "/41", "/42", "/43" 등을 가져옵니다.

        String reviewId = pathInfo.substring(1);  // 첫 번째 '/' 문자를 제거합니다. 

        // 리뷰를 데이터베이스에서 조회하고, 결과를 request attribute에 추가하는 로직을 구현할 수 있습니다.
        // 여기서는 단순히 예시를 보여주기 위해 실제 조회 과정은 생략하였습니다.

        // 뷰로 forward합니다.
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/review.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}