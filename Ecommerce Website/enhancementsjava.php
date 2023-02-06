<!DOCTYPE html>
<html lang="en">
     <head>
	     <meta charset= "utf-8"/>
		 <title>Enhancements(JAVA)</title>
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
			    <h1 class="enhancehead">1.Automatic Image Slideshow</h1>
				<br/>
				<ul>
				    <li><p class= "enhancepara">A web slideshow is a sequence of images or text that consists of showing one element of the sequence in a certain time interval.</p></li>
			        <li><p class= "enhancepara">This Java Code is applied by creating a single function which selects the images from the html, and then display all the pics by coverting them from display-none/opacity-0 to display-block.opacity-1 one by one at an interval rate of 3secs.</p></li>
				    <li><a class= "enhancepara" href="https://youtu.be/o_hRhTZORNY" target="_blank">Click Here for Source</a></li>
				    <li><p class="enhancepara">Enhancement is applied in the Index page for a slideshow of product images.</p></li>
				</ul>
             </div>
			 <!--Enhancement no.1 end-->
             <br/>
			 <br/>
			 <!--Enhancement no.2 start-->
             <div class="ack">
			     <!--Enhancement no.2 heading-->
			    <h1 class="enhancehead">2.Scroll Back To Top Button</h1>
				<ul>
				    <li><p class= "enhancepara">A page element with relative positioning gives you the control to absolutely position children elements inside of it.</p></li>
			        <li><p class= "enhancepara">This Java code is implemented by creating two main function, one for the appearance of the button when user scrolls down and other for going back to top when user clicks the button, which is then applied thru window.onscroll</p></li>
				    <li><a class= "enhancepara" href="https://www.w3schools.com/howto/howto_js_scroll_to_top.asp">Click Here for Source</a></li>
				    <li><p class="enhancepara">Enhancement is applied on all the pages of the website</p></li>
				</ul>	
			</div>	
			<!--Enhancement no.2 end-->
            <br/>
		    <br/>
			<!--Enhancement no.3 start-->
            <div class="ack">
			    <!--Enhancement no.3 Heading-->
			    <h1 class="enhancehead">3.Pop-up a preview page prior feedback formsubmission</h1>
				<ul>
				    <li><p class= "enhancepara">This Enhancement alerts back the user his inputs on submition of the form thru a alert window</p></li>
			        <li><p class= "enhancepara">This Java Code is applied through alert function</p></li>
				    <li><a class= "enhancepara" href="https://swinburnesarawak.instructure.com/courses/780/pages/week-6-introduction?module_item_id=37972" target="_blank">Click Here for Source</a></li>
				    <li><p class="enhancepara">Enhancement is applied in the Enquiry page, User will get alerted on his inputs through a alert window upon submission.</p></li>
				</ul>	
			</div>
			<!--Enhancement no.3 end-->
            <br/>
		    <br/>
			<!--Enhancement no.4 start-->
            <div class="ack">
			    <!--Enhancement no.4 Heading-->
			    <h1 class="enhancehead">4.Infinite Typing and Deleting Effect </h1>
				<ul>
				    <li><p class= "enhancepara">In this Enhancement, a real-time Infinite typing and deleting effect will be added for text</p></li>
			        <li><p class= "enhancepara">This Java code is implemented through storing the words required in a string format through a const and then its called under a function which then types it out through looping function at a timing interval of of 550, at the same time the first written string is deleted at a timing interval of 500 under a different function through looping and then the process is repeated infinitely to create an infinite typing and deleting effect.</p></li>
				    <li><a class= "enhancepara" href="https://codepen.io/haaswill/pen/VKzXvZ" target="_blank">Click Here for Source</a></li>
				    <li><p class="enhancepara">Enhancement is applied at the heading of the automatic slideshow in the index page to describe which product category is currently displayed.</p></li>
				</ul>	
			</div>
			<!--Enhancement no.4 end-->
			<br/>
		    <br/>
			<!--Enhancement no.5 start-->
            <div class="ack">
			    <!--Enhancement no.5 Heading-->
			    <h1 class="enhancehead">5.JavaScript Clock</h1>
				<ul>
				    <li><p class= "enhancepara">In this Enhancement, a real-time 12hr Clock has been implemented which will inform the user his/her time</p></li>
			        <li><p class= "enhancepara">This Java code is implemented through extracting the hours, minutes, and seconds and then its stored in a desired format and then displayed.</p></li>
				    <li><a class= "enhancepara" href="https://codepen.io/afarrar/pen/JRaEjP" target="_blank">Click Here for Source</a></li>
				    <li><p class="enhancepara">Enhancement is applied at the footer of the Index Page</p></li>
				</ul>	
			</div>
			<!--Enhancement no.5 end-->
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