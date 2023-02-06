<?php
	$servername = "localhost";
    $username = "root";
    $password = "";
    $dbname = "Millennial";

    $conn = mysqli_connect($servername, $username, $password, $dbname);
    
	$id=$_GET['id'];
	$query="SELECT * from Enquiry WHERE ID ='$id'";
    $response = @mysqli_query( $conn, $query);
	$row = mysqli_fetch_array($response);
?>
<!DOCTYPE html>
<html lang="en">

  <head>
    <meta charset="utf-8" />
    <title>Edit Enquiry</title>
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

    <!--Enquiry Section Start-->
    <div class="secdiv">
      <!--Enquiry Section Heading-->
      <section>
        <h1 class="ourproducts">EDIT ENQUIRIES</h1>
        <br />
        <!--Enquiry Form Holder Starts-->
        <div class="formholder">
          <!--Enquiry Form Starts-->
          <form action="update.php?id=<?php echo $id;?>" method="post" name="EmailForm" id="enquiryform">
            <!--first name Input-->
            <label class="labels" for="fname">First Name:*</label>
            <input class="inputs" type="text" name="First_Name" id="fname" maxlength="25" value="<?php echo $row['FIRSTNAME']; ?>"/>
            <br />
            <!--last name Input-->
            <label class="labels" for="lname">Last Name:*</label>
            <input class="inputs" type="text" name="Last_Name" id="lname" maxlength="25" value="<?php echo $row['LASTNAME']; ?>"/>
            <br />
            <!--Email Input-->
            <label class="labels" for="email">Email:*</label>
            <input class="inputs" type="email" name="Email" id="email" placeholder="user@millenialaccessories.com" value="<?php echo $row['EMAIL']; ?>"/>
            <br />
            <!--Phone number Input-->
            <label class="labels" for="number">Phone Number:*</label>
            <input class="inputs" type="text" name="Phone_Number" id="number" maxlength="10" placeholder="012 345 6789" value="<?php echo $row['PHONE']; ?>"/>
            <br />
            <!--Address Fieldset start-->
            <fieldset>
              <legend class="address">Address</legend>
              <!--Street Address Input-->
              <label class="labels" for="street">Street Address:*</label>
              <input class="inputs" type="text" name="Street_Address" id="street" maxlength="40" value="<?php echo $row['STREET']; ?>" />
              <br />
              <!--City Input-->
              <label class="labels" for="city">City/Town:*</label>
              <input class="inputs" type="text" name="City" id="city" maxlength="20" value="<?php echo $row['CITY']; ?>"/>
              <br />
              <!--State Input-->
              <label class="labels" for="state">State:*</label>
              <select class="inputs" name="State" id="state" onchange="change()" value="<?php echo $row['STATE']; ?>">
                <optgroup label="List of States">
                  <script>
                    statelist()
                  </script>
                </optgroup>
              </select>
              <br />
              <!--Postcode Input-->
              <label class="labels" for="postcode">Postcode:*</label>
              <input class="inputs" type="text" name="Postcode" id="postcode" maxlength="5" minlength="5" value="<?php echo $row['POSTCODE']; ?>"/>
            </fieldset>
            <!--Address Fieldset Ends-->
            <br />
            <!--Subject Input-->
            <label class="labels" for="subject">Subject:*</label>
            <input class="inputs" type="text" id="subject" name="Subject"  value="<?php echo $row['SUBJECT']; ?>"/>
            <br />
            <!--Product Input-->
            <label class="labels" for="product">Product:*</label>
            <select class="inputs" name="Product" id="product" onchange="change()" value="<?php echo $row['PRODUCT']; ?>">
              <optgroup label="Our Products">
                <script>
                  productlist1()
                </script>
              </optgroup>
            </select>
            <br />
            <!--Comment textarea-->
            <label class="labels" for="comment">Comment:</label>
            <textarea class="inputs" name="Comment" id="comment" cols="30" rows="10" value="<?php echo $row['COMMENT']; ?>"></textarea>
            <br />
            <br />
            <!--Submit button-->
            <button class="buttons" type="submit" name="add">Submit</button>
            <br />
            <br />
            <!--Back button-->
            <a class="buttons" width="100%" href="view_enquiries.php">Back</a>
        </form>
          <!--Enquiry Form Holder Ends-->
        </div>
        <!--Enquiry Form Holder Ends-->
      </section>
    </div>
    <!--Enquiry Section End-->

    <!--Footer start-->
    <footer>
			<?php include("./include/footer.php"); ?>
		</footer>
    <!--Footer End-->
  </body>

</html>
