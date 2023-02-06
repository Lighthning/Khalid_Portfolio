<!DOCTYPE html>
<html lang="en">
     <head>
	     <meta charset= "utf-8"/>
		 <title>Profile</title>
		 <link rel="stylesheet" type="text/css" href="./style/style.css"/>
		 <script src="./script/script.js"></script>
     </head>
     <body>
	      <!--Backdrop Image-->
	     <div class="backdropprofile">
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
		 
		 <!--Profile Section starts-->
		 <section>
		 <div class="secdiv">
		     <!--Profile Section Heading-->
		     <h1 class="ourproducts">About Me</h1>
		     <br/>
			 <!--Profile Holder Starts-->
		     <div class="profileholder">
			     <!--Profile Image-->
		         <img class="dp" src="./images/khalid.jpg" width="650" alt="Profile Pic"/>
		         <!--Name-->
				 <h1 class="yourname">Khalid Yaseen Baig</h1>
			     <!--studentid-->
				 <p class="stno">StudentID: 102763240</p>
			     <br/>
			     <br/>
			     <p class="ict">I am currently Studying <b class="baict">Bachelor of Information and Communication Technology</b> at Swinburne University of Technology Sarawak Campus, Kuching, Malaysia.</p>
			     <br/>
			     <br/>
				 <!--Profile table starts-->
			     <table class="profiletable">
			         <tbody>
				         <tr>
					         <th>Nationality</th>
						     <td>Indian</td>
					     </tr>
                         <tr>
					         <th>Hometown</th>
						     <td>The Sillicon Valley of India- Banglore, Capital of State of Karnataka in the Southern part of India. It has a population of around 11 Million, making it the third most populous city in India. It is widely regarded as IT Capital of India because it is the leading IT exporter. It is also widely known for its Gardens, Architecture, Shopping &amp; Food. If you are visiting Banglore,  you'll be delighted to taste its huge variety of South Indian food known for their unique mixture of spices. Its also known for its amazing Weather, it experiences mild weather(neither very hot nor very cold) throughout the year.</td>
					     </tr>
					     <tr>
					         <th>D.O.B</th>
						     <td>11th April 2002</td>
					     </tr>
                         <tr>
					         <th>Hobbies &amp; Interests</th>
						     <td>
						         <ol>
							         <li>Photography &amp; Editing</li>
								     <li>Travelling</li>
								     <li>Weightlifting</li>
							     </ol>	 
						 
						     </td>
					     </tr>
                     </tbody>
                 </table>	
				 <!--Profile table ends-->
                 <br/>
                 <br/>			 
			     <a class="mail" href="mailto:102763240@students.swinburne.edu.my">Mail to</a>
		     </div>	 
			 <!--Profile Holder Starts-->
		 </div>
		 </section>
		  <!--Profile Section ends-->
		 
		 <!--Footer start-->
		<footer>
			<?php include("./include/footer.php"); ?>
		</footer>
		 <!--Footer End-->
	 </body>
</html>	 