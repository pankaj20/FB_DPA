

//---------------------Input type File Setting------------------------------------------//

function setPath(f) {
	document.getElementById('mypath').value = f;
	//document.getElementById('mypath').value = "";
}


function browse() 
{  //alert("hello");
	document.getElementById('realFile').click();
}
//----------------------------validations-------------------------//
    


function productFeedValidate()
      {

        var flag = true;
	//var url = $("#fileUrl").val();
        var mypath= $("#mypath").val();
        var schedule= $("#schedule").val();
         var timePicker= $("#timePicker").val();
        

	/*if (url == "")
        {
	 $("#msgFileUrl").text("Enter File Url");

	 return false;
	}*/
       if (mypath == "")
        {
	 $("#msgmypath").text("Select File");

	 return false;
	}

      
       if(schedule=="")
      {
       $("#msgSchedule").text("Select Date");
       return false;
      }
      
      if(timePicker=="")
      {
       $("#msgtimePicker").text("Select Time");
       return false;
      }
	
      if(flag)
	{
	$("#productFeedForm").submit();
                
	}
	
	
}



 function checkFileExtension()
{
 var mypath= $("#mypath").val();
 var ext = mypath.substring(mypath.lastIndexOf('.') + 1);
 if(ext == "xml" || ext == "csv" || ext == "tsv")
	{
	return true;
	} 
         else
         {
           $("#msgmypath").text("Upload XML,CSV or TSV file only");
           return false;
        }
}

function productSet()
      {

        var flag = true;
	var productset = $("#productset").val();
        var inc= $("#inc").val();
        var exclusion= $("#exclusion").val();
        
	if (productset == "")
        {
	 $("#msgproductset").text("Enter Product set Field");

	 return false;
	}
       if (inc == "")
        {
	 $("#msginclusions").text("Select Inclusion");

	 return false;
	}
       
      if (exclusion == "")
        {
	 $("#msgexclusion").text("Enter Exclusion Field");

	 return false;
	}
     
	
      if(flag)
		{
		$("#productSetForm").submit();
               
		}
	
	
}





function checkValues()
{
 var realFile=$("#mypath").val().size;
 //alert(realFile);

}

function adSet()
      {

        var flag = true;
	var name = $("#name").val();
        var product_id= $("#product_id").val();
        var bid_price= $("#bid_price").val();
        var daily_budget= $("#daily_budget").val();
	var gender= $("#gender").val();
	var interests= $("#interests").val();

	if (name == "")
        {
	 $("#msgname").text("Please Enter Name");

	 return false;
	}
       if (product_id == "")
        {
	 $("#msgproductid").text("Please Enter Product id");

	 return false;
	}
       
      if (bid_price == "")
        {
	 $("#msgbidprice").text("Please Enter bid price");

	 return false;
	}
     if (daily_budget == "")
        {
	 $("#msgdailybudget").text("Please Enter daily budget");

	 return false;
	}
     if (gender == "")
        {
	 $("#msggender").text("Please Select gender");

	 return false;
	}
     if (interests == "")
        {
	 $("#msginterests").text("Please Select interest field");

	 return false;
	}
     
	
      if(flag)
		{
//alert('why in');
		$("#adSetForm").submit();
               
		}
	
	
}




function removeMessage(id) {
	$("#" + id).text("");
}
