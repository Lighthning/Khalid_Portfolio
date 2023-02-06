<!DOCTYPE html>
<html lang="en">

  <head>
    <meta charset="utf-8" />
    <title>Enquiry</title>
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
        <h1 class="ourproducts">Contact Us</h1>
        <br />
        <!--Enquiry Form Holder Starts-->
        <div class="formholder">
          <!--Enquiry Form Starts-->
          <form action="./enquiry_process.php" method="post" name="EmailForm" id="enquiryform">
            <!--first name Input-->
            <label class="labels" for="fname">First Name:*</label>
            <input class="inputs" type="text" name="First_Name" id="fname" maxlength="25" />
            <br />
            <!--last name Input-->
            <label class="labels" for="lname">Last Name:*</label>
            <input class="inputs" type="text" name="Last_Name" id="lname" maxlength="25" />
            <br />
            <!--Email Input-->
            <label class="labels" for="email">Email:*</label>
            <input class="inputs" type="email" name="Email" id="email" placeholder="user@millenialaccessories.com" />
            <br />
            <!--Phone number Input-->
            <label class="labels" for="number">Phone Number:*</label>
            <input class="inputs" type="text" name="Phone_Number" id="number" maxlength="10" placeholder="012 345 6789" />
            <br />
            <!--Address Fieldset start-->
            <fieldset>
              <legend class="address">Address</legend>
              <!--Street Address Input-->
              <label class="labels" for="street">Street Address:*</label>
              <input class="inputs" type="text" name="Street_Address" id="street" maxlength="40" />
              <br />
              <!--City Input-->
              <label class="labels" for="city">City/Town:*</label>
              <input class="inputs" type="text" name="City" id="city" maxlength="20" />
              <br />
              <!--State Input-->
              <label class="labels" for="state">State:*</label>
              <select class="inputs" name="State" id="state" onchange="change()">
                <optgroup label="List of States">
                  <script>
                    statelist()
                  </script>
                </optgroup>
              </select>
              <br />
              <!--Postcode Input-->
              <label class="labels" for="postcode">Postcode:*</label>
              <input class="inputs" type="text" name="Postcode" id="postcode" maxlength="5" minlength="5" />
            </fieldset>
            <!--Address Fieldset Ends-->
            <br />
            <!--Subject Input-->
            <label class="labels" for="subject">Subject:*</label>
            <input class="inputs" type="text" id="subject" name="Subject" />
            <br />
            <!--Product Input-->
            <label class="labels" for="product">Product:*</label>
            <select class="inputs" name="Product" id="product" onchange="change()">
              <optgroup label="Our Products">
                <script>
                  productlist1()
                </script>
              </optgroup>
            </select>
            <br />
            <!--Comment textarea-->
            <label class="labels" for="comment">Comment:</label>
            <textarea class="inputs" name="Comment" id="comment" cols="30" rows="10"></textarea>
            <br />
            <br />
            <!--Reset button-->
            <button class="buttons" type="reset" value="Reset">Reset</button>
            <br />
            <br />
            <!--Submit button-->
            <button class="buttons" type="submit" value="Submit" onclick="return validate()">Submit</button>
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
