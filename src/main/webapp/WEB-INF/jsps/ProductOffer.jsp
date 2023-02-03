<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style.css">
<title>Shazar</title>
</head>
<body>
  <div class="wrapper">
    <header class="header" id="header">
      <div class="header-bar">
        <div class="header-a">
          <img class="logo" src="pngtree-vector-tyre-icon-png-image_1833985.png" alt="">
          <div class="header-bar-logo-name">Shazar</div>
        </div>
          <div class="header-bar-content">
            <a href="/UserProfile">Back to your profile</a>
          </div>
      </div>
    </header>
    <main class="main">
      <div class="log-name-block">
        <div class="offer-block-main">
          <div class="offer-name">Create your offer here:</div>
          <form action="ProductOffer" method="POST" enctype="multipart/form-data">
            <label for="productName">Product Name:</label><br>
            <input 
              type="text" 
              id="productName" 
              name="productName"
              class="first"
              placeholder="type here..."
            ><br>
            <label for="description">Description:</label><br>
            <textarea 
              id="description" 
              name="description" 
              rows="7" 
              cols="35"
              class="textarea"
              class="first"
              placeholder="">
            </textarea><br>
            <label for="category">Category:</label><br><br>
            <select name="category" id="category">
            <option value="BMX">BMX</option>
			<option value="City Bike">City Bike</option>
			<option value="Electric Bike">Electric Bike</option>
			<option value="Gravel">Gravel</option>
			<option value="MTB">MTB</option>
			<option value="Road Bike">Road Bike</option>
			</select>
            <br><br>
            <label for="type">Type:</label><br><br>
            <select name="type" id="type">
            <option value="Ladies' bikes">Ladies' bikes</option>
			<option value="Men's bikes">Men's bikes</option>
			<option value="Children's bikes">Children's bikes</option>
			<option value="Unisex bikes">Unisex bikes</option>
			</select>
            <br><br>
            <label for="color">Color:</label><br><br>
            <select name="color" id="color">
            <option value="White">White</option>
			<option value="Black">Black</option>
			<option value="Blue">Blue</option>
			<option value="Red">Red</option>
			<option value="Pink">Pink</option>
			<option value="Green">Green</option>
			<option value="Yellow">Yellow</option>
			<option value="Other">Other</option>
			</select>
            <br><br> 
            <label for="price">Price:</label><br>
            <input 
              type="text" 
              id="price" 
              name="price"
              class="first"
              placeholder="type here..."
            ><br>
            <label for="pickUpLocation">Pick-up location:</label><br>
            <input 
              type="text" 
              id="pickUpLocation" 
              name="pickUpLocation"
              class="first"
              placeholder="type here..."
            ><br>
            <div class="register-button">
            <label>Photos: </label>
            <input type="file" name="image" accept="image/png, image/jpeg, image/jpg" multiple="multiple" />

           		<input type="submit" value="Submit">

          	</div>
          </form>
        </div>

      </div>
    </main>
    <footer class="footer-contact-information">
        <%@ include file ="footerBar.jsp" %>
    </footer>
  </div>
</body>
</html>