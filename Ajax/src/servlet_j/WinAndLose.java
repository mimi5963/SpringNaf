package servlet_j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import user.UserDAO;


@WebServlet("/winAndLose")
public class WinAndLose extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dohandle(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dohandle(request,response);
	}
	
	protected void dohandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		String winner = request.getParameter("winner");
		String loser = request.getParameter("loser");
		System.out.println(winner + " " +loser);
		
		UserDAO dao = new UserDAO();
		
		
		
//		BufferedReader br = null;
//	    StringBuilder sb = new StringBuilder();
//	    String bodyJson="";
//	    String line ="";
	    //UserDAO dao =new UserDAO();
	    
	    //읽기
//	    try {
//	        
//	        InputStream is = request.getInputStream();
//	        if(is != null) {
//	            br = new BufferedReader(new InputStreamReader(is));
//	            while((line = br.readLine()) !=null) 
//	                sb.append(line);
//	        }else {
//	            System.out.println("data 없음");
//	        }
//	      
//	    }catch(IOException e) {
//	        e.printStackTrace();
//	    }
//	    
//	    bodyJson = sb.toString(); //변환
//	    System.out.println(bodyJson);
//	    JsonParser parser = new JsonParser();
//	    
//	    Object obj = parser.parse(bodyJson);
//	    JsonObject jobj = (JsonObject)parser.parse(bodyJson);
//	    String winner = jobj.get("winner").getAsString();
//	    String loser = jobj.get("loser").getAsString();
	    
	   // System.out.println(winner +" winner " + loser + "loser");
    }

}
