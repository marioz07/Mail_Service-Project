
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Atharva
 */
public class LoginServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        String uname = req.getParameter("email");
        String password = req.getParameter("password");
        boolean status = VerifyLogin.checkLogin(uname,password);
        if(status==true){
            HttpSession session = req.getSession();
            session.setAttribute("username", uname);
            out.print("Welcome" + uname);
            RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
            rd.include(req, res);
        } else {
            String Error = "Please check your Email and Password";
            req.setAttribute(Error, Error);
            RequestDispatcher rd=req.getRequestDispatcher("index.jsp");
			rd.include(req, res);
            }
        out.close();
        }
    }


