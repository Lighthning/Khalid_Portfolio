<!DOCTYPE html>
<html lang="en">

  <head>
    <meta charset="utf-8" />
    <title>View Enquiries</title>
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
    <h1 class="ourproducts">VIEW ENQUIRY</h1>
    <br/>
    <?php
    $servername = "localhost";
    $username = "root";
    $password = "";
    $dbname = "Millennial";

    $conn = mysqli_connect($servername, $username, $password, $dbname);

    $query = "SELECT ID, FIRSTNAME, LASTNAME, EMAIL, PHONE, STREET, CITY, STATE, POSTCODE, SUBJECT, PRODUCT, COMMENT
    FROM Enquiry";

    $response = @mysqli_query( $conn, $query);

    if($response){
    ?>
        <table class="viewenquirytable">
        <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Phone Number</th>
        <th>Street Address</th>
        <th>City</th>
        <th>State</th>
        <th>Postcode</th>
        <th>Subject</th>
        <th>Product</th>
        <th>Comment</th>
        <th>Edit/Delete</th>
        </tr>
    <?php
        while($row = mysqli_fetch_array($response)){
    ?>
            <tr>
            <td><?php echo $row["ID"]?></td>
            <td><?php echo $row["FIRSTNAME"]?></td>
            <td><?php echo $row["LASTNAME"]?></td>
            <td><?php echo $row["EMAIL"]?></td>
            <td><?php echo $row["PHONE"]?></td>
            <td><?php echo$row["STREET"]?></td>
            <td><?php echo$row["CITY"]?></td>
            <td><?php echo$row["STATE"]?></td>
            <td><?php echo$row["POSTCODE"]?></td>
            <td><?php echo$row["SUBJECT"]?></td>
            <td><?php echo$row["PRODUCT"]?></td>
            <td><?php echo$row["COMMENT"]?></td>
            <td><a href="edit.php?id=<?php echo $row["ID"];?>">Edit</a> 
            <a href="delete.php?id=<?php echo $row["ID"];?>">Delete</a></td>
            </tr>
    <?php     
        }
    ?>
      <tr><td><a href="createdata.php">Add</a></td></tr>
      </table>
    <?php
    } else {
        echo '<h1>No Data to be displayed</h1>' . mysqli_error($conn);
    };
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