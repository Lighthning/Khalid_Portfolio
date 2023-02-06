<!DOCTYPE html>
<html lang="en">

  <head>
    <meta charset="utf-8" />
    <title>Enquiry Process</title>
    <link rel="stylesheet" type="text/css" href="./style/style.css" />
    <script src="./script/script.js"></script>
  </head>

  <body>
    <!--Backdrop image-->
    <div class="backdropenquiry">
      <header>
		<button onclick="topFunction()" id="myBtn" title="Top"><img src="./images/angle-double-up-solid.svg" width="30px" height="40px" alt="back to top"/></button>
        <!--Navigation Bar Start-->
        <?php include("./include/navigation_white.php"); ?>
        <!--Navigation Bar End-->
      </header>
      <!--Logo Start-->
      <section class="logo">
        <img src="./images/translogo.png" width="700" alt="Logo" />
      </section>
      <!--Logo End-->
    </div>
<!--Main Holder Start-->
    <div class="secdiv">
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
    ?>
    <h1 class = "EnquiryProcessConfirm">You have entered the following information: </h1>
    <br/>
    <br/>
    <table class="enquiryprocesstable">
      <th>Description</th>
      <th>Value</th>
      <tr>
        <th>First Name</th>
        <td><?php echo $fname ?></td>
      </tr>
      <tr>
        <th>Last Name</th>
        <td><?php echo $lname ?></td>
      </tr>
      <tr>
        <th>Email</th>
        <td><?php echo $email ?></td>
      </tr>
      <tr>
        <th>Phone Number</th>
        <td><?php echo $number ?></td>
      </tr>
      <tr>
        <th>Street Address</th>
        <td><?php echo $address ?></td>
      </tr>
      <tr>
        <th>City/Town</th>
        <td><?php echo $city ?></td>
      </tr>
      <tr>
        <th>State</th>
        <td><?php echo $state ?></td>
      </tr>
      <tr>
        <th>Postcode</th>
        <td><?php echo $pcode ?></td>
      </tr>
      <tr>
        <th>Subject</th>
        <td><?php echo $subject ?></td>
      </tr>
      <tr>
        <th>Product</th>
        <td><?php echo $product ?></td>
      </tr>
      <tr>
        <th>Comment</th>
        <td><?php echo $comment ?></td>
      </tr>
    </table>
    <br/>
    <br/>
    <br/>
    <?php
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
    mysqli_close($conn);
    ?>
    </div>
<!--Main Holder End-->

<!--Footer start-->
<footer>
  <?php include("./include/footer.php"); ?>
</footer>
<!--Footer End-->
</body>
</html>