
import org.vertx.java.core.Handler;
import org.vertx.java.core.http.HttpServerRequest;
import org.vertx.java.platform.Verticle;
import org.vertx.java.core.logging.Logger;
import org.vertx.java.core.http.HttpServer;
import java.sql.*;
import java.io.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;


public class ProductFeed extends Verticle
 {
  
     public void start()
     {
           
       final String login="ProductFeed";


        vertx.createHttpServer().requestHandler(new Handler<HttpServerRequest>()
        {
           public void handle(HttpServerRequest req) 
          {
               String file = req.path();
	       req.expectMultiPart(true);
		
             if(file.equals("/ProductFeed"))
              {

	       try
               {
			 String name=req.params().get("fileurl");
	   		 String docFile = req.params().get("docFile");
		         System.out.println(docFile);
			 String schedule = req.params().get("schedule");
			 String time = req.params().get("time");


		         byte b[]= docFile.getBytes();
			 System.out.println(b);
			 String realpath = "/home/pankaj/static/files/" + docFile ;
			 System.out.println(realpath);
			File file1 = new File(docFile);
			String filepath = file1.getAbsolutePath();
			String fileName = file1.getName();
			System.out.println(fileName);

  			int extensionIndex = fileName.lastIndexOf(".");
    			String fileExtension = fileName.substring(extensionIndex + 1);
			System.out.println(fileExtension);


        


//System.out.println(ext);



			System.out.println("----------------------------------"  + filepath);
			System.out.println(file1.length());

			OutputStream outputStream = null;
			File newFile = null;

			newFile = new File(realpath);
			System.out.print(" file exists : " + newFile.exists());

			if (newFile.exists() == false){
			newFile.createNewFile();
		        System.out.println();
			System.out.println(newFile.getAbsolutePath());
			outputStream = new FileOutputStream(newFile);
			outputStream.write(b);
			}

if (fileExtension.equals("xml"))
{
	File fXmlFile = new File(filepath);
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);
 
	
	doc.getDocumentElement().normalize();
 
	System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
 
	NodeList nList = doc.getElementsByTagName("item");
 
	//NodeList nList = doc.getDocumentElement().getChildNodes();
	System.out.println("----------------------------");
 
	for (int temp = 0; temp < nList.getLength(); temp++) {
 
		Node nNode = nList.item(temp);
 
		System.out.println("\nCurrent Element :" + nNode.getNodeName());
 
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
 
			Element eElement = (Element) nNode;
			System.out.println(eElement);
			System.out.println("Id : " + eElement.getAttribute("g:id"));
			String id = eElement.getElementsByTagName("g:id").item(0).getTextContent();			
			String title = eElement.getElementsByTagName("g:title").item(0).getTextContent();
			String desc = eElement.getElementsByTagName("g:description").item(0).getTextContent();
			String link = eElement.getElementsByTagName("g:link").item(0).getTextContent();
			String img_link = eElement.getElementsByTagName("g:image_link").item(0).getTextContent();
			String brand = eElement.getElementsByTagName("g:brand").item(0).getTextContent();
			String condition = eElement.getElementsByTagName("g:condition").item(0).getTextContent();
			String availability = eElement.getElementsByTagName("g:availability").item(0).getTextContent();
			String price = eElement.getElementsByTagName("g:price").item(0).getTextContent();
			String country = eElement.getElementsByTagName("g:country").item(0).getTextContent();
			String service = eElement.getElementsByTagName("g:service").item(0).getTextContent();
			String price1 = eElement.getElementsByTagName("g:price").item(0).getTextContent();
			String google_product_category = eElement.getElementsByTagName("g:service").item(0).getTextContent();

			}			
			
			
		}
}
if (fileExtension.equals("csv") || fileExtension.equals("tsv") )
{
System.out.println("Csv testing done-------------------------");
String csvFile = filepath; //"/home/pankaj/testcsv.csv";
	BufferedReader br = null;
	String line = "";
	String cvsSplitBy = ",";
 
	try {
 
		br = new BufferedReader(new FileReader(csvFile));
		while ((line = br.readLine()) != null) {
 
		        // use comma as separator
			String[] country = line.split(cvsSplitBy);
			
			
			System.out.println(line);
			//System.out.println("Country [code= " + country[4] 
                               //  + " , name=" + country[5] + "]");
 
		}
 
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


}

		 Class.forName("com.mysql.jdbc.Driver");
		 Connection connection  =DriverManager.getConnection("jdbc:mysql://localhost:3306/DPA","root","root");
		 PreparedStatement ps = connection.prepareStatement("insert into product_feed(name,file,schedule,time) values(?,?,?,?)");

	         ps.setString(1, name);
	         ps.setString(2, docFile);
	         ps.setString(3, schedule);
	         ps.setString(4, time);
	         ps.executeUpdate(); 

	       //req.response.sendFile("demo.html");		 
		} catch (Exception e) {
			e.printStackTrace();
		}
      

              }                 
            }
        }).listen(8080);
    }
}
