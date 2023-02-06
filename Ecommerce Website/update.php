<?php
	$servername = "localhost";
    $username = "root";
    $password = "";
    $dbname = "Millennial";

    $conn = mysqli_connect($servername, $username, $password, $dbname);
    
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

	$id=$_GET['id'];
	$query="UPDATE Enquiry SET FIRSTNAME = '$fname', LASTNAME = '$lname', EMAIL = '$email', PHONE = '$number', STREET = '$address', CITY = '$city', STATE = '$state', POSTCODE = '$pcode', SUBJECT = '$subject', PRODUCT = '$product', COMMENT = '$comment' WHERE ID ='$id'";
    mysqli_query( $conn, $query);
    header('location:view_enquiries.php');
    mysqli_close($conn);
?>