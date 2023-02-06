<?php
    echo
    ' <nav>
    <a class="watchnav" href="./index.php">Home</a>
    <!--Dropdown menu start-->
    <div class="dropdown">
      <button class="drpbtnshoes">Shop
        <i class="shpbtn"></i>
      </button>
      <div class="drpcontshoes">
        <div class="drpcontshoes" name="shoplist" id="shop" onchange="change()">
          <optgroup>
            <script>
              shop()
            </script>
          </optgroup>
        </div>
      </div>
    </div>
    <!--Dropdown menu end-->
    <a class="watchnav" href="./enquiry.php">Enquiry</a>
    <a class="watchnav" href="./profile.php">Profile</a>
    <a class="watchnav" href="./disclaimer.php">Disclaimer</a>
    <a class="watchnav" href="./acknowledgements.php">Acknowledgement</a>
    <div class="dropdown">
      <button class="drpbtnshoes">Enhancements
        <i class="shpbtn"></i>
      </button>
      <div class="drpcontshoes" name="Enhancements" id="enhance" onchange="change()">
        <optgroup>
          <script>
            enhance()
          </script>
        </optgroup>
      </div>
    </div>
  </nav>'
?>