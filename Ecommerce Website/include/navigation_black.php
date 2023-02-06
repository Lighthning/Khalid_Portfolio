<?php
    echo
    '<nav class="nav">
          <a href="./index.php">Home</a>
          <!--Dropdown Menu Start-->
          <div class="dropdown">
            <button class="drpbtn">Shop
              <i class="shpbtn"></i>
            </button>
            <div class="drpcont" name="shoplist" id="shop" onchange="change()">
              <optgroup>
                <script>
                  shop()
                </script>
              </optgroup>
            </div>
          </div>
          <!--Dropdown Menu End-->
          <a href="./enquiry.php">Enquiry</a>
          <a href="./profile.php">Profile</a>
          <a href="./disclaimer.php">Disclaimer</a>
          <a href="./acknowledgements.php">Acknowledgement</a>
          <div class="dropdown">
            <button class="drpbtn">Enhancements
              <i class="shpbtn"></i>
            </button>
            <div class="drpcont" name="Enhancements" id="enhance" onchange="change()">
              <optgroup>
                <script>
                  enhance()
                </script>
              </optgroup>
            </div>
          </div>
        </nav>';
?>