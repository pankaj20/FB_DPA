
import org.vertx.java.core.Handler;
import org.vertx.java.core.http.HttpServerRequest;
import org.vertx.java.platform.Verticle;
import org.vertx.java.core.logging.Logger;
import org.vertx.java.core.http.HttpServer;
import java.sql.*;
import java.io.*;


public class AdSet extends Verticle
 {
  
     public void start()
     {
           
       final String login="AdSet";


        vertx.createHttpServer().requestHandler(new Handler<HttpServerRequest>()
        {
           public void handle(HttpServerRequest req) 
          {
               String file = req.path();
	      // req.expectMultiPart(true);
		
             if(file.equals("/AdSet"))
              {

	       try
               {
			 String name=req.params().get("name");
	   		 String productid = req.params().get("product_id");
		     
			 String bidprice = req.params().get("bid_price");
			String dailybudget = req.params().get("daily_budget");
			String gender = req.params().get("gender");
			String interests = req.params().get("interests");
			  System.out.println(interests);

			 Class.forName("com.mysql.jdbc.Driver");
			 Connection connection  =DriverManager.getConnection("jdbc:mysql://localhost:3306/DPA","root","root");
			 PreparedStatement ps = connection.prepareStatement("insert into ad_set(name,product_id,bid_price,daily_budget,gender,interest) values(?,?,?,?,?,?)");

		         ps.setString(1, name);
		         ps.setString(2, productid);
		         ps.setString(3, bidprice);
		         ps.setString(4, dailybudget);
			 ps.setString(5, gender);
			 ps.setString(6, interests);
		         ps.executeUpdate(); 

		    
			}

	       //req.response.sendFile("demo.html");		 
		 catch (Exception e) {
			e.printStackTrace();
		}
      }

              }                 
          
        }).listen(8080);
    }

}
