

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
	var url = $("#fileUrl").val();
        var mypath= $("#mypath").val();
        var schedule= $("#schedule").val();
         var timePicker= $("#timePicker").val();
         var ext = mypath.substring(mypath.lastIndexOf('.') + 1);
	if (url == "")
        {
	 $("#msgFileUrl").text("Enter File Url");

	 return false;
	}
       if (mypath == "")
        {
	 $("#msgmypath").text("Select File");

	 return false;
	}

       if(ext == "xml" || ext == "csv" || ext == "tsv")
		{
		return true;
		} 
          else
             {
                $("#msgmypath").text("Upload XML,CSV or TSV file only");
                 return false;
             }
       
      if (schedule == "")
        {
	 $("#msgSchedule").text("Select Date");

	 return false;
	}
 if (timePicker == "")
        {
	 $("#msgtimePicker").text("Select Time");

	 return false;
	}
     
	
      if(flag)
		{
		$("#productFeedForm").submit();
		}
	
	
}



function removeMessage(id) {
	$("#" + id).text("");
}
