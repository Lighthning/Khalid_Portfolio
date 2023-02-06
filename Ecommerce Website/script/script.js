//Khalid Yaseen Baig
//102763240

function validateForm() {
    var product = document.getElementById("product").value;
    sessionStorage.product = product;

    return result;
}

function storeProduct(productName) {
    var options = ["Tag Heuer Carrera Porsche Chronograph Special Edition", "Diesel Mr. Daddy 2.0 chronograph black", "Bulgari Octo LOriginale Watch", "Casio G-Shock MRGB2000R-1A", "Fossil 44mm Townsman Automatic", "Ray-Ban Aviator Classic", "Tomahawk SeaPorts", "Ray-Ban Round Double Bridge", "Tomford arnaud polarized", "Randolph Aviator(Military)", "Peakdesign everyday Backpack", "Solgaard lifepack endeavor", "Bellroy Transit Backpack", "Matador SEG42 Travel Pack", "Woody Backpack (French)", "Nike Air Jordan 1 Mid", "Adidas iconic superstar", "Koio capri castagna", "vans old skool", "Reiss leather bay", "Maximum Henry classic belt", "Bellroy hide & seek wallet", "Doice & Gabbana Panama-style hat", "Fossil Leather bracelet", "Unique Tungsten Ring"];

    options.forEach(array);

    function array(value) {
        if (value == productName) {
            sessionStorage.productIndex = options.indexOf(value);
        }
    }
}

function storeSub() {
    document.getElementById("product").selectedIndex = sessionStorage.productIndex;

    var product = document.getElementById("product").value;

    sessionStorage.subject = product;
    document.getElementById("subject").value = "RE: Enquiry on " + sessionStorage.subject;
}

function productlist1() {
    var select = document.getElementById("product");

    var options = ["Tag Heuer Carrera Porsche Chronograph Special Edition", "Diesel Mr. Daddy 2.0 chronograph black", "Bulgari Octo LOriginale Watch", "Casio G-Shock MRGB2000R-1A", "Fossil 44mm Townsman Automatic", "Ray-Ban Aviator Classic", "Tomahawk SeaPorts", "Ray-Ban Round Double Bridge", "Tomford arnaud polarized", "Randolph Aviator(Military)", "Peakdesign everyday Backpack", "Solgaard lifepack endeavor", "Bellroy Transit Backpack", "Matador SEG42 Travel Pack", "Woody Backpack (French)", "Nike Air Jordan 1 Mid", "Adidas iconic superstar", "Koio capri castagna", "vans old skool", "Reiss leather bay", "Maximum Henry classic belt", "Bellroy hide & seek wallet", "Doice & Gabbana Panama-style hat", "Fossil Leather bracelet", "Unique Tungsten Ring"];

    for (var i = 0; i < options.length; i++) {
        var opt = options[i];
        var el = document.createElement("option");
        el.textContent = opt;
        el.value = opt;
        select.appendChild(el);
    }
}

function storestate(productName) {
    var options = ["Sarawak", "Johor", "Kuala Lumpur", "Labuan", "Putrajaya", "Kedah", "Kelantan", "Malacca", "Negeri Sembilan", "Pahang", "Penang", "Perak", "Perlis", "Sabah", "Selangor", "Terengganu"];

    options.forEach(array);

    function array(value) {
        if (value == productName) {
            sessionStorage.productIndex = options.indexOf(value);
        }
    }
}

function statelist() {
    var select = document.getElementById("state");

    var options = ["Sarawak", "Johor", "Kuala Lumpur", "Labuan", "Putrajaya", "Kedah", "Kelantan", "Malacca", "Negeri Sembilan", "Pahang", "Penang", "Perak", "Perlis", "Sabah", "Selangor", "Terengganu"];

    for (var i = 0; i < options.length; i++) {
        var opt = options[i];
        var el = document.createElement("option");
        el.textContent = opt;
        el.value = opt;
        select.appendChild(el);
    }
}

function shopproduct(productName) {
    var options = ["Watches", "Sunglasses", "Backpacks", "Shoes", "Others"];

    options.forEach(array);

    function array(value) {
        if (value == productName) {
            sessionStorage.productIndex = options.indexOf(value);
        }
    }
}

function shop() {
    var select = document.getElementById("shop");

    var options = ["Watches", "Sunglasses", "Backpacks", "Shoes", "Others"];
    var link_list = ["watches.php","sunglasses.php","backpack.php","shoes.php","others.php"]

    for (var i = 0; i < options.length; i++) {
        var opt = options[i];
        let x = document.createElement('a');
        x.href = link_list[i]
        x.textContent = opt;
        select.appendChild(x);
    }
}

function enhancement(productName) {
    var options = ["Enhancement(CSS)", "Enhancement(JAVA)","Enhancement(PHP)"];

    options.forEach(array);

    function array(value) {
        if (value == productName) {
            sessionStorage.productIndex = options.indexOf(value);
        }
    }
}

function enhance() {
    var select = document.getElementById("enhance");

    var options = ["Enhancement(CSS)", "Enhancement(JAVA)","Enhancement(PHP)"];
    var link_list = ["enhancements.php","enhancementsjava.php","enhancementphp.php"]

    for (var i = 0; i < options.length; i++) {
        var opt = options[i];
        let x = document.createElement('a');
        x.href = link_list[i]
        x.textContent = opt;
        select.appendChild(x);
    }
}

function change(){
    var product = document.getElementById("product").value;
    sessionStorage.product = product;
    document.getElementById("subject").value = "RE: Enquiry on " + sessionStorage.product;
}

function storeitem(product_id){
    sessionStorage.setItem("product_id", product_id);
    window.location.href="enquiry.php";
}
function displayitem(){
    document.getElementById("subject").value = "RE: Enquiry on " + sessionStorage.getItem("product_id");
    document.getElementById("product").value =  sessionStorage.getItem("product_id");
}

function initalise(){
    var formElement = document.getElementById("form"); 
    displayitem();
    formElement.onsubmit = validate; 
}

window.onload = initalise;

var getErrorMsg = "";

function validate(){
    "use strict";
        var fname = document.getElementById("fname").value;
        var lname = document.getElementById("lname").value;
        var email = document.getElementById("email").value;
        var number = document.getElementById("number").value;
        var street = document.getElementById("street").value;
        var city = document.getElementById("city").value;
        var state = document.getElementById("state").value;
        var pcode = document.getElementById("postcode").value;
        var product = document.getElementById("product").value;
        var description = document.getElementById("comment").value;
        
        var everythingOkay = false;
        getErrorMsg = "";
        var fnameOkay = fnameCheck();
		var lnameOkay = lnameCheck();
        var emailOkay = emailCheck();
        var numOkay = numCheck();
		var streetOkay = streetCheck();
		var cityOkay = cityCheck();
        var stateOkay = stateSelect();
		var pcodeOkay = pcodeCheck();
        var productOkay = productSelect();
        var descriptionOkay = descriptionCheck();
        if (fnameOkay && lnameOkay && emailOkay && numOkay && streetOkay && cityOkay && stateOkay && pcodeOkay  && productOkay && descriptionOkay) {
        everythingOkay = true;
        alert ("Your First Name is " + document.getElementById("fname").value + '\n' +
        "Your Last Name is " + document.getElementById("lname").value + '\n' +
        "Your Email ID is " + document.getElementById("email").value + '\n' +
        "Your Phone Number is " + document.getElementById("number").value + '\n' +
        "Your Street Address is " + document.getElementById("street").value + '\n' +
        "Your City Address is " + document.getElementById("city").value + '\n' +
        "Your State Address is " + document.getElementById("state").value + '\n' +
        "Your PostCode is " + document.getElementById("postcode").value + '\n' +
        "Your selected Product is " + document.getElementById("product").value + '\n' +
        "Your Comment is " + document.getElementById("comment").value);

        storeEnquiry(fname, lname, email, number, street, city, state, pcode, product, description);
    }
    else{
    alert(getErrorMsg);
    getErrorMsg = "";
    everythingOkay = false;
    }
    return everythingOkay;
}

function fnameCheck(){
    var name = document.getElementById("fname").value;
    var pattern = /^[a-zA-Z ]+$/
    var fnameOkay = true;
    if ((name.length == 0)){
    getErrorMsg = getErrorMsg + "Your First Name cannot be blank\n"
    
    fnameOkay = false;
    }
    else{
        if (!pattern.test(name)){
        getErrorMsg = getErrorMsg + "Your First name should only contain characters\n"
        fnameOkay = false;
        }
    }
    return fnameOkay;
}

function lnameCheck(){
    var name = document.getElementById("lname").value;
    var pattern = /^[a-zA-Z ]+$/
    var lnameOkay = true;
    if ((name.length == 0)){
    getErrorMsg = getErrorMsg + "Your Last Name cannot be blank\n"
    lnameOkay = false;
    }
    else{
        if (!pattern.test(name)){
        getErrorMsg = getErrorMsg + "Your Last name should only contain characters\n"
        lnameOkay = false;
        }
    }
    return lnameOkay;
}

function emailCheck(){
    var email = document.getElementById("email").value;
    var result = true;
    var pattern = /[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-za-zA-Z0-9.-]{1,4}$/;
    if ((email.length == 0)){
        getErrorMsg = getErrorMsg + "Your Email cannot be blank\n"
        result = false;
    }
    else{
        if (!pattern.test(email)){
            getErrorMsg = getErrorMsg + "Enter a Valid Email Address\n"
            result = false;
        }
    }
    return result;
}

function numCheck() {
    var name = document.getElementById("number").value;
    var pattern = /^[#.0-9,-]+$/
    var numOkay = true;
    if ((name.length == 0)){
    getErrorMsg = getErrorMsg + "Phone Number cannot be blank\n"
    numOkay = false;
    }
    else{
        if (!pattern.test(name)){
        getErrorMsg = getErrorMsg + "Enter a valid Phone Number\n"
        numOkay = false;
        }
    }
    return numOkay;
}

function streetCheck(){
    var name = document.getElementById("street").value;
    var pattern = /^[#.0-9a-zA-Z\s,-]+$/
    var streetOkay = true;
    if ((name.length == 0)){
    getErrorMsg = getErrorMsg + "Street Address cannot be blank\n"
    streetOkay = false;
    }
    else{
        if (!pattern.test(name)){
        getErrorMsg = getErrorMsg + " Enter a vlid Street Address\n"
        streetOkay = false;
        }
    }
    return streetOkay;
}

function cityCheck(){
    var name = document.getElementById("city").value;
    var pattern = /^[#.0-9a-zA-Z\s,-]+$/
    var cityOkay = true;
    if ((name.length == 0)){
    getErrorMsg = getErrorMsg + "City cannot be blank\n"
    cityOkay = false;
    }
    else{
        if (!pattern.test(name)){
        getErrorMsg = getErrorMsg + "Enter a valid City name\n"
        cityOkay = false;
        }
    }
    return cityOkay;
}

function stateSelect(){
    var selected = false;
    var state = document.getElementById("state").value;
    if (state!="none"){
    selected = true;
    }
    else{
    selected = false;
    getErrorMsg = getErrorMsg + "You must select a State\n"
    }
    return selected;
}

function pcodeCheck() {
    var name = document.getElementById("postcode").value;
    var pattern = /^[#.0-9,-]+$/
    var pcodeOkay = true;
    if ((name.length == 0)){
    getErrorMsg = getErrorMsg + "Postcode cannot be blank\n"
    pcodeOkay = false;
    }
    else{
        if (!pattern.test(name)){
        getErrorMsg = getErrorMsg + "Enter a valid Postal Code\n"
        pcodeOkay = false;
        }
    }
    return pcodeOkay;
}

function productSelect(){
    var selected = false;
    var product = document.getElementById("product").value;
    if (product!="none"){
    selected = true;
    }
    else{
    selected = false;
    getErrorMsg = getErrorMsg + "You must select a Product\n"
    }
    return selected;
}

function descriptionCheck() {
    var description = document.getElementById("comment").value;
    var descriptionOk = true;
    if ((description.length == 0)){
    getErrorMsg = getErrorMsg + "Please enter your comments in the Comment box\n"
    descriptionOk = false;
    }
    return descriptionOk;
}

function storeEnquiry(fname, lname, email, number, street, city, state, pcode, product, description){
    sessionStorage.fname = fname;
    sessionStorage.lname = lname;
    sessionStorage.email = email;
    sessionStorage.number = number;
    sessionStorage.street = street;
    sessionStorage.city = city;
    sessionStorage.state = state;
    sessionStorage.pcode = pcode;
    sessionStorage.product = product;
    sessionStorage.description = description;
}

function slideshow(){
    const slideshowImages = document.querySelectorAll(".slideshowhouse img");
  
    const nextImageDelay = 3000;
    let currentImageCounter = 0;
    
    slideshowImages[currentImageCounter].style.opacity = 1;
  
    setInterval(nextImage, nextImageDelay);
  
    function nextImage() {
        slideshowImages[currentImageCounter].style.display = "none";
        slideshowImages[currentImageCounter].style.opacity = 0;
  
        currentImageCounter = (currentImageCounter+1) % slideshowImages.length;
  
         slideshowImages[currentImageCounter].style.display = "block";
         slideshowImages[currentImageCounter].style.opacity = 1;
    }
    nextImage();
}
  
function init(){
    slideshow();
    showTime();
    typingEffect();
}
  
window.onload = init;
  
  
function showTime(){
    var date = new Date();
    var hour = date.getHours();
    var minute = date.getMinutes();
    var second = date.getSeconds(); 
    var session = "AM";
    
    if(hour == 0){
        hour = 12;
    }
    
    if(hour > 12){
        hour = hour - 12;
        session = "PM";
    }
    
    hour = (hour < 10) ? "0" + hour : hour;
    minute = (minute < 10) ? "0" + minute : minute;
    second = (second < 10) ? "0" + second : second;
    
    var time = hour + ":" + minute + ":" + second + " " + session;
    document.getElementById("liveclock").innerText = time;
    document.getElementById("liveclock").textContent = time;
    
    setTimeout(showTime, 1000);
    
}

window.onscroll = function(){
    scrollFunction()
};

function scrollFunction() {
    mybutton = document.getElementById("myBtn");  
    if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
        mybutton.style.display = "block";
    } 
    else {
    mybutton.style.display = "none";
    }
}

function topFunction() {
  document.body.scrollTop = 0;
  document.documentElement.scrollTop = 0; 
}

const words = ["WATCHES       ", "SUNGLASSES    ", "BACKPACKS     ", "SHOES         ", "OTHER PRODUCTS   "];
let i = 0;
let timer;

function typingEffect() {
	let word = words[i].split("");
	var loopTyping = function() {
		if (word.length > 0) {
			document.getElementById('word').innerHTML += word.shift();
		} else {
			deletingEffect();
			return false;
		};
		timer = setTimeout(loopTyping, 550);
	};
	loopTyping();
};

function deletingEffect() {
	let word = words[i].split("");
	var loopDeleting = function() {
		if (word.length > 0) {
			word.pop();
			document.getElementById('word').innerHTML = word.join("");
		} else {
			if (words.length > (i + 1)) {
				i++;
			} else {
				i = 0;
			};
			typingEffect();
			return false;
		};
		timer = setTimeout(loopDeleting, 500);
	};
	loopDeleting();
};

