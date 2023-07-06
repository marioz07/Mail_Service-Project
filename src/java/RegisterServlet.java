import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class RegisterServlet extends HttpServlet{
    
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        res.setContentType("text/Html");
        PrintWriter out =res.getWriter();
        String email= req.getParameter("email");
	String password= req.getParameter("password");
	String name= req.getParameter("name");
	String gender= req.getParameter("gender");
        
        String num=req.getParameter("mname");    
        double mname = Double.parseDouble(num);
        String country=req.getParameter("country");
        int status = RegisterUser.register(email, password, name, gender, mname,country);
        if(status>0){
            String register ="You are Successfully registered";
            req.setAttribute("register",register);
            RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
            rd.include(req, res);
        } else {
            String registererror="Sorry,Registration failed. please try later";
			req.setAttribute("registererror",registererror);
			RequestDispatcher rd=req.getRequestDispatcher("Register.jsp");
			rd.include(req, res);
        }
        
    }
}
