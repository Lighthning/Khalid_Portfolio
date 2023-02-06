<?php
	$servername = "localhost";
    $username = "root";
    $password = "";
    $dbname = "Millennial";

    $conn = mysqli_connect($servername, $username, $password, $dbname);

    $id=$_GET['id'];
	mysqli_query($conn,"DELETE FROM Enquiry where ID='$id'");
	header('location:view_enquiries.php');
?>