<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style.css">
    <title>Shazar</title>
</head>
<body>
  <div class="wrapper">
    <header class="header">
      <div class="header-bar">
        <div class="header-a">
          <img src="img/pngtree-vector-tyre-icon-png-image_1833985.png" alt="">
          <div class="header-bar-logo-name">Shazar</div>
        </div>
          <div class="header-bar-content">
              <a href="#">C</a>
              <span>Logged in</span>
          </div>
      </div>
      <div class="header-description">
          <div class="header-description-container">
            <p class="det__title">Detailed searchbar</p>
          <div class="header-description-what-is-get-help">
            <input 
            class="searchbar"
            type="search" 
            name="searchBar"
            placeholder="Type here..."
          >
          <a class="search__button" href="#">Search</a>
          </div>
          <div class="main-banner">
            <div class="detailed__searchbar">
      
              <div class="block__main">
                  <div class="year">
                    <div class="a">Color</div>
                    <select name="year">
                      <option value="first" selected>
                        white
                      </option>
            
                      <option value="second">
                        black
                      </option>
            
                      <option value="third">
                        blue
                      </option>
            
                      <option value="forth">
                        red
                      </option>
                    </select>
                  </div>
      
                  <div class="brand">
                    <div class="a">Type</div>
                    <select name="brand">
                      <option value="brandFirst" selected>
                        Crossover
                      </option>
            
                      <option value="brandSecond">
                        Sedan
                      </option>
            
                      <option value="brandThird">
                        Minivan
                      </option>
                    </select>
                  </div>

                  <div class="engine">
                    <div class="a">Category</div>
                    <select name="engine">
                      <option value="engineFirst" selected>
                        New
                      </option>
            
                      <option value="emgineSecond">
                        Used
                      </option>
                    </select>
                  </div>

                  <div class="time-frame">
                    <div class="a">Time frame</div>
                    <select name="engine">
                      <option value="engineFirst" selected>
                        1h - 12h
                      </option>
            
                      <option value="emgineSecond">
                        12h - 24h
                      </option>

                      <option value="emgineSecond">
                        24h - more
                      </option>
                    </select>
                  </div>
          
                  <div class="price">
                    <div class="a">Price</div>
                    <div class="price__number">
                      <input 
                        type="number" name="priceMin"
                        placeholder="Min"
                      >
                      <input 
                        type="number" 
                        name="priceMax"
                        placeholder="Max"
                      >
                    </div>
                  </div>
              </div>
            </div>
          </div>
          </div>
      </div>
    </header>
    <main class="main">

      <div class="main-title-name">Top Deals</div>
      <div class="main-row">
          <div class="main-row-item-block">
              <div class="main-row-item-block-image">
                  <img src="img/new_car_landing_S_2.jpg" alt="">
              </div>
              <div class="main-row-item-block-title">Car Make & Model</div>
              <div class="main-row-item-block-description">Lorem ipsum dolor sit amet consectetur adipisicing elit. Hic, molestiae!</div>
              <div class="main-row-item-block-description-price">Price per hour</div>
              <div class="main-row-item-block-button">
                  <a href="/ProductPage"><span>Rent me!</span></a>
              </div>
          </div>
          <div class="main-row-item-block">
            <div class="main-row-item-block-image">
                <img src="img/new_car_landing_S_2.jpg" alt="">
            </div>
            <div class="main-row-item-block-title">Car Make & Model</div>
            <div class="main-row-item-block-description">Lorem ipsum dolor sit amet consectetur adipisicing elit. Hic, molestiae!</div>
            <div class="main-row-item-block-description-price">Price per hour</div>
            <div class="main-row-item-block-button">
                <a href="/ProductPage"><span>Rent me!</span></a>
            </div>
          </div>
          <div class="main-row-item-block">
            <div class="main-row-item-block-image">
                <img src="img/new_car_landing_S_2.jpg" alt="">
            </div>
            <div class="main-row-item-block-title">Car Make & Model</div>
            <div class="main-row-item-block-description">Lorem ipsum dolor sit amet consectetur adipisicing elit. Hic, molestiae!</div>
            <div class="main-row-item-block-description-price">Price per hour</div>
            <div class="main-row-item-block-button">
                <a href="/ProductPage"><span>Rent me!</span></a>
            </div>
          </div>
          <div class="main-row-item-block">
            <div class="main-row-item-block-image">
                <img src="img/new_car_landing_S_2" alt="">
            </div>
            <div class="main-row-item-block-title">Car Make & Model</div>
            <div class="main-row-item-block-description">Lorem ipsum dolor sit amet consectetur adipisicing elit. Hic, molestiae!</div>
            <div class="main-row-item-block-description-price">Price per hour</div>
            <div class="main-row-item-block-button">
                <a href="/ProductPage"><span>Rent me!</span></a>
            </div>
          </div>
      </div>

      <div class="main-title-name">Useful information</div>
      <div class="main-row-blog">
        <div class="main-row-item-block-blog">

          <div class="main-row-a">
            <div class="main-row-b">
              <div 
                class="main-row-item-block-title-blog-b"
              >FAQ
              </div>
            </div>
          </div>

          <div class="main-row-item-block-description-blog">Lorem ipsum dolor sit amet consectetur adipisicing elit. Hic, molestiae!</div>
          <div class="main-row-item-block-button-blog">
              <a href="#"><span>Read more...</span></a>
          </div>

      </div>


          <div class="main-row-item-block-blog">

            <div class="main-row-a">
              <div class="main-row-b">
                <div 
                  class="main-row-item-block-title-blog-b"
                >Legal regulation
                </div>
              </div>
            </div>

            <div class="main-row-item-block-description-blog">Lorem ipsum dolor sit amet consectetur adipisicing elit. Hic, molestiae!</div>
            <div class="main-row-item-block-button-blog">
                <a href="/terms"><span>Read more...</span></a>
            </div>

        </div>
      </div>

    </main>
    <footer class="footer-contact-information">
        <div class="footer-contact-information-container">
          <div class="footer-contact-information-links-social-media">
              <a href="#">Home</a>
              <a href="#">Cart</a>
              <a href="/UserProfile">Personal</a>
              <a href="#">Information</a>
          </div>
        </div>
    </footer>
  </div>
</body>
</html>