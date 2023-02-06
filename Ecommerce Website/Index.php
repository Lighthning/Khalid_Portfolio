<!DOCTYPE html>
<html lang="en">

  <head>
    <meta charset="utf-8" />
    <title>Home</title>
    <link rel="stylesheet" type="text/css" href="./style/style.css" />
	
    <script src="./script/script.js"></script>
  </head>

  <body>
    <!--Backdrop image-->
    <div class="backdrop" id="backdrop">
      <header>
		<button onclick="topFunction()" id="myBtn" title="Top"><img src="./images/angle-double-up-solid.svg" width="30px" height="40px" alt="back to top"/></button>
        <!--Navigation Bar Start-->
        <?php include("./include/navigation_black.php"); ?>
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
      <!--Article Section start-->
      <article class="intro">
        <h1 class="elegant" id="typewriter"> ELEGANT &amp; ASTHETIC ACCESSORIES FOR MILLENNIAL MEN</h1>
        <h2 class="style"> A Style For Every Story</h2>
        <br />
        <p class="ready">As our Tagline commands, We can make sure you are <b>ready</b> for all your stories,<br /> be it your first interview or your roadtrip thru Europe.</p>
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <!--Worldwide Delievry svg-->
        <div class="worldwide">
          <img src="./images/global-shipping.svg" alt="Worldwide Delivery" width="100" />
          <p><b>Worldwide<br /> Delivery</b></p>
        </div>
        <!--Freeshipping svg-->
        <div class="freeship">
          <img src="./images/free-shipping.svg" alt="Free shipping" width="100" />
          <p><b>Free Shipping on<br /> Orders above 100$</b></p>
        </div>
        <!--Warranty svg-->
        <div class="warranty">
          <img src="./images/term.svg" alt="1 Year Warranty" width="100" />
          <p><b>1 Year Warranty<br /> on all products</b></p>
        </div>
        <!--security svg-->
        <div class="secured">
          <img src="./images/cyber-security.svg" alt="Safe &amp; Secure payment" width="100" />
          <p><b>Safe &amp; Secured<br /> Payments</b></p>
        </div>
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
      </article>
      <!--Article Section start-->
      <!--Aside Section Start-->
      <aside class="reviews">
        <!--Review Heading-->
        <div class="reviewbox">
          <h2 class="reviewhead">OUR REVIEWS</h2>
        </div>
        <br />
        <br />
        <!--1st Review Start-->
        <div class="reviewbox">
          <p class="firstrev">I Loved everything about the product!<br />My purchase was carefully packaged &amp; <br />quickly shipped.I was extremely pleased <br />with the quality of the service &amp; the product.</p>
          <br />
          <h4 class="ahmed">Ahmed Saeed</h4>
          <span class="rating1">
            <img class="rating1" src="./images/rating.svg" alt="5 Star Rating" width="70" />
          </span>
        </div>
        <!--1st Review End-->
        <br />
        <br />
        <!--2nd Review Start-->
        <div class="reviewbox">
          <p class="secondrev">Hi, My Order arrived yesterday,<br /> I absolutely love everything<br />about it. I absolutely recommend<br /> it to anyone looking for accessories.<br /> Thanks a lot</p>
          <br />
          <h4 class="joel">Joel Johnson</h4>
          <span class="rating2">
            <img src="./images/rating.svg" alt="5 Star Rating" width="70" />
          </span>
        </div>
        <!--2nd Review End-->
        <br />
        <br />
        <!--3rd Review Start-->
        <div class="reviewbox">
          <p class="thirdrev">Despite ordering the wrong size,<br /> thanks to their swift return policy,<br /> I got the intended product just<br /> within two days. Many Thanks.</p>
          <br />
          <h4 class="noman">Noman Khan</h4>
          <span class="rating3">
            <img src="./images/rating.svg" alt="5 Star Rating" width="70" />
          </span>
        </div>
        <!--3rd Review End-->

      </aside>
      <!--Aside Section End-->
      <br />
      <br />
      <br />
      <br />
      <br />
      <!--Product Section Start-->
      <section class="productimgs">
        <br />
        <!--Watch Product Start-->
        <div class="watchdiv">
          <a href="./watches.php"><img class="watches" src="./images/watches.jpg" alt="Watches" width="455" /></a>
          <div class="watchtxt">
            <p class="textwat">Watches</p>
          </div>
        </div>
        <!--Watch Product End-->

        <!--Sunglasses Product Start-->
        <div class="sunglassesdiv">
          <a href="./sunglasses.php"><img class="sunglasses" src="./images/sunglasses04.jpg" alt="sunglasses" width="475" /></a>
          <div class="glstxt">
            <p class="textgls">Sunglasses</p>
          </div>
        </div>
        <!--Sunglasses Product End-->

        <!--Backpack Product Start-->
        <div class="backpackdiv">
          <a href="./backpack.php"><img class="backpacks" src="./images/bags01.jpg" alt="Backpacks" width="475" /></a>
          <div class="bagstxt">
            <p class="textbag">Backpacks</p>
          </div>
        </div>
        <!--Backpack Product End-->

        <!--Shoes Product Start-->
        <div class="shoesdiv">
          <a href="./shoes.php"><img class="shoes" src="./images/shoes08.jpg" alt="Shoes" width="475" /></a>
          <div class="shoetxt">
            <p class="textshoe">Shoes</p>
          </div>
        </div>
        <!--Shoes Product End-->

        <!--Other Product Start-->
        <div class="Othersdiv">
          <a href="./others.php"><img class="others" src="./images/belts.jpg" alt="others" width="475" /></a>
          <div class="othrtxt">
            <p class="textothr">Others</p>
          </div>
        </div>
        <!--Other Product End-->
      </section>
      <!--Product Section End-->
      <br />
      <br />
      <div class="slideshowhouse">
        <section>
          <div class="slideheaddiv">
            <div class="flex">
              <h1 class="slidehead">OUR&#160;</h1><p class="header-sub-title" id="word"></p><p class="header-sub-title blink">|</p><h1 class="slidehead">&#160;GALLERY</h1>
            </div>
          </div>
          <br/>
          <br/>
          <br/>
          <img src="" alt="" width="337"/>
          <img src="./images/tagheuer.png" alt="Tag Heuer Carrera Porsche Chronograph Special Edition" width="337"/>
          <img src="./images/diesel.png" alt="Diesel Mr. Daddy 2.0 chronograph black" width="325"/>
          <img src="./images/bulgari.png" alt="Bulgari Octo LOriginale Watch" width="300"/>
          <img src="./images/casio.png" alt="Casio G-Shock MRGB2000R-1A" width="315"/>
          <img src="./images/fossill.png" alt="Fossil 44mm Townsman Automatic" width="275"/>
          <img src="./images/rayban101.png" alt="Ray-Ban Aviator Classic" width="500"/>
          <img src="./images/tomahawk.png" alt="Tomahawk SeaPorts" width="500"/>
          <img src="./images/rayban102.png" alt="Ray-Ban Round Double Bridge" width="500"/>
          <img src="./images/tomford.png" alt="Tomford arnaud polarized" width="500"/>
          <img src="./images/randolph.png" alt="Randolph Aviator(Military)" width="500"/>
          <img src="./images/bags102.png" alt="Peakdesign everyday Backpack" width="437"/>
          <img src="./images/bags103.png" alt="Solgaard lifepack endeavor" width="447"/>
          <img src="./images/bags101.png" alt="Bellroy Transit Backpack" width="330"/>
          <img src="./images/bags104.png" alt="Matador SEG42 Travel Pack" width="345"/>
          <img src="./images/bags105.png" alt="Woody Backpack (French)" width="375"/>
          <img src="./images/shoes101.png" alt="Nike Air Jordan 1 Mid" width="500"/>
          <img src="./images/shoes102.png" alt="Adidas iconic superstar" width="440"/>
          <img src="./images/shoes103.png" alt="Koio capri castagna" width="500"/>
          <img src="./images/shoes104.png" alt="vans old skool" width="470"/>
          <img src="./images/shoes105.png" alt="Reiss leather bay" width="470"/>
          <img src="./images/belts00.png" alt=" Maximum Henry classic belt" width="500"/>
          <img src="./images/wallet.png" alt="Bellroy hide &amp; seek wallet" width="440"/>
          <img src="./images/hat.png" alt="Doice &amp; Gabbana Panama-style hat" width="500"/>
          <img src="./images/band.png" alt="Fossil Leather bracelet" width="470"/>
          <img src="./images/ring.png" alt="Unique Tungsten Ring" width="420"/>
          </section>
      </div>
      <br/>
    </div>

    <!--Main Holder End-->

    <!--Footer start-->
    <footer>
      <?php include("./include/footer.php"); ?>
    </footer>
    <!--Footer End-->
  </body>

</html>