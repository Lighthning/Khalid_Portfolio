<!DOCTYPE html>
<html lang="en">
     <head>
	     <meta charset= "utf-8"/>
		 <title>Enhancements(PHP)</title>
		 <link rel="stylesheet" type="text/css" href="./style/style.css"/>
		 <script src="./script/script.js"></script>
     </head>
     <body>
	     <!--Backdrop image-->
	     <div class="backdropenhancement">
             <header>
				<button onclick="topFunction()" id="myBtn" title="Top"><img src="./images/angle-double-up-solid.svg" width="30px" height="40px" alt="back to top"/></button>
		    <!--Navigation Bar Start-->
			<?php include("./include/navigation_black.php"); ?>
			<!--Navigation Bar End-->
		     </header>
			 <!--Logo Start-->
		     <section class="logo">
		     <img src="./images/translogo.png" width="700" alt="Logo"/>
			 </section>
			 <!--Logo End-->
		 </div>
		 
		 <!--Section Start-->
		 <section>
		 <div class="secdiv">
		     <!--Enhancement Heading-->
		     <h1 class="ourproducts">Enhancements(JAVA)</h1>
			 <br/>
			 <!--Enhancement no.1 start-->
		     <div class="ack">
			    <!--Enhancement no.1 heading-->
			    <h1 class="enhancehead">User Management Module</h1>
				<br/>
				<ul>
				    <li><p class= "enhancepara">In this Enhancement, the owner is able to create, view, edit and delete data in the view_enquiries page, which is submitted by the users through enquiry form.  </p></li>
			        <li><p class= "enhancepara">This php code is implemented by creating multiple php files required for the program such as ‘edit.php’, ‘update.php’, ‘delete.php’, ‘createdata.php’ and ‘adddata.php’.</p></li>
				    <li><a class= "enhancepara" href="https://www.youtube.com/watch?v=mpQts3ezPVg&t=747s" target="_blank">Click Here for Source</a></li>
				    <li><p class="enhancepara">Enhancement is applied at the view_enquiries.php</p></li>
				</ul>
             </div>
			 <!--Enhancement no.1 end-->
            
		 </div>
		 </section>
		 <!--Section End-->
		     
		 <!--Footer start-->
		 <footer>
			<?php include("./include/footer.php"); ?>
		</footer>
		 <!--Footer End-->
	</body>
</html>	