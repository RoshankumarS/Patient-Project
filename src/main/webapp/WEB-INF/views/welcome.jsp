<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<h1>Patients Data</h1>
	<form action="submit" method="post" modelAttribute="patient">
		<div id="main">
			<div id="submit">
				<button id="submit" onclick="check()" type= "submit">Submit</button>	
			</div>
			<br>
			<div id="container:0" class = "container">
				<label for ="Name">Name: </label>
				<input type="text" id="patientName:0" name="Name" placeholder="Enter your Name">
				<br>
				<br>
				<label for="DOB">Date of Birth: </label>
				<input type="Date" id="DateOfBirth:0" name="DOB">
				<br>
				<br>
				<label for="phone">Phone No.: </label>
				<input type="text" id="phoneNo:0" name="phone" placeholder= "Enter Phone No.">	
				<br>	
			</div>
		</div>
	</form>	
	<br>
	<div id="addButton">
		<button id="Add" onclick="addRow()" type="submit">Add Row</button>	
	</div>
</body>
<script
  src="https://code.jquery.com/jquery-3.5.1.js"
  integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
  crossorigin="anonymous"></script>
<script >

	var count = 1;
	
	function check()
	{
		
		var i = 0;
		while(i<count)
		{
			var phone = document.getElementById("phoneNo:"+i).value;
			var regex = /^[7-9][0-9]{9}$/;
			
			if(!regex.test(phone))
			{
				alert("Please enter Valid Phone No."+phone)
			}	
			i++;
		}
	}
	
	function addRow()
	{
		
		$("#main").append('<div id="container:'+count+'" class = "container">\
				<label for ="Name">Name: </label>\
				<input type="text" id="patientName:'+count+'" name="Name" placeholder="Enter your Name">\
				<br>\
				<br>\
				<label for="DOB">Date of Birth: </label>\
				<input type="Date" id="DateOfBirth:'+count+'" name="DOB">\
				<br>\
				<br>\
				<label for="phone">Phone No.: </label>\
				<input type="text" id="phoneNo:'+count+'" name="phone" placeholder= "Enter Phone No.">	\
				<br>\
				<div id="deleteButton">\
					<button id="delete:'+count+'" onclick="removeElement(this.id)" type="submit">Delete Entry</button>\
				<div>\
			</div>');
		count++;
	}
		
	function removeElement(deleteId) {
		var splitId = deleteId.split(":");
		var deleteIndex = splitId[1];
		var contain = document.getElementById("container:"+deleteIndex);
		contain.remove();
		
	}
</script>
</html>