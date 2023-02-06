<?php
	$fname = $_POST["First_Name"];
    $lname = $_POST["Last_Name"];
	$email = $_POST["Email"];
	$number= $_POST["Phone_Number"];
	$address = $_POST["Street_Address"];
	$city = $_POST["City"];
	$state = $_POST["State"];
	$pcode = $_POST["Postcode"];
	$subject = $_POST["Subject"];
	$product = $_POST["Product"];
    $comment = $_POST["Comment"];

    $servername = "localhost";
    $username = "root";
    $password = "";
    $dbname = "Millennial";

    $conn = mysqli_connect($servername, $username, $password, $dbname);

    if (!$conn){
        die("Connection failed: ".mysqli_connect_error());
    }

    if(!empty($_POST['First_Name'])){
      $query = "INSERT INTO Enquiry ( ID, FIRSTNAME, LASTNAME, EMAIL, PHONE, STREET, CITY, STATE, POSTCODE, SUBJECT, PRODUCT, COMMENT)
      VALUES (NOT NULL,'$fname', '$lname', '$email', '$number', '$address', '$city', '$state', '$pcode', '$subject', '$product', '$comment')";
     } else {
      echo '<h1  class = "EnquiryProcessConfirm">Your information is not completed, please return back!</h1>';
    }

    if (mysqli_query($conn, $query)) {
        echo 
        '
        <h1 class = "EnquiryProcessConfirm" >Thank You!</h1>
        <h1 class = "EnquiryProcessConfirm" >Your Enquiry has been recorded successfully!</h1>
        ';
    } else {
        echo "Error Recording your enquiry: " . mysqli_error($conn);
    }
    header('location:../view_enquiries.php');
    mysqli_close($conn);
    ?>
