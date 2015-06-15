
import org.vertx.java.core.Handler;
import org.vertx.java.core.http.HttpServerRequest;
import org.vertx.java.platform.Verticle;
import org.vertx.java.core.logging.Logger;
import org.vertx.java.core.http.HttpServer;
import java.sql.*;
import java.io.*;


public class ProductSet extends Verticle
 {
  
     public void start()
     {
           
       final String login="ProductSet";


        vertx.createHttpServer().requestHandler(new Handler<HttpServerRequest>()
        {
           public void handle(HttpServerRequest req) 
          {
               String file = req.path();
	      // req.expectMultiPart(true);
		
             if(file.equals("/ProductSet"))
              {

	       try
               {
			 String productset=req.params().get("productset");
	   		 String inclusions = req.params().get("inc");
		         System.out.println(inclusions);
			 String field = req.params().get("exclusion");
			 
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection connection  =DriverManager.getConnection("jdbc:mysql://localhost:3306/DPA","root","root");
			 PreparedStatement ps = connection.prepareStatement("insert into product_set(product_set,inclusion,exclusions) values(?,?,?)");

		         ps.setString(1, productset);
		         ps.setString(2, inclusions);
		         ps.setString(3, field);
		         
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
