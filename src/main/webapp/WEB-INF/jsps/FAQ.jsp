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
      <%@ include file="headerBar.jsp" %>
    </header>
    <main class="main">
      <div class="faq-title">Frequently asked questions</div>
      <div class="faq-item-block-blog">
        <div 
          class="faq-item-block-title-blog-b"
        >What should I do if I entered wrong email / first name / surname during registration?
        </div>
    </div>
      <div class="faq-block">
        <div class="faq-block-main">
          <div class="faq-block-description">
            <div>You can easily change your name/nickname/email using the "Edit user details" option. </div>
            <div>1. Click on the <a href="#personal">Personal</a> link at the bottom of this page. </div>
            <div>2. You will be automatically redirected to the user profile page. </div>
            <div>3. The "Edit user details" option will be located there.</div>
          </div>
        </div>
      </div>

      <div class="faq-item-block-blog">
        <div 
          class="faq-item-block-title-blog-b"
        >How to add new products for the rent?
        </div>
    </div>
      <div class="faq-block">
        <div class="faq-block-main">
          <div class="faq-block-description">
            <div>You can add new product using the "Add new product" option. </div>
            <div>1. Click on the <a href="#personal">Personal</a> link at the bottom of this page. </div>
            <div>2. You will be automatically redirected to the user profile page. </div>
            <div>3. The "Add new product" option will be located there.</div>
          </div>
        </div>
      </div>

      <div class="faq-item-block-blog">
        <div 
          class="faq-item-block-title-blog-b"
        >Where can I find my products?
        </div>
    </div>
      <div class="faq-block">
        <div class="faq-block-main">
          <div class="faq-block-description">
            <div>You can add see the list of your products using the "Search" option on the main page. </div>
            <div>1. Go to the main page. </div>
            <div>2. In the "Detailed searchbar" section press the "Search" button - without adding the search request. </div>
            <div>3. You will be redirected to the page with the list of all of your products. </div>
          </div>
        </div>
      </div>

      <div class="faq-item-block-blog">
        <div 
          class="faq-item-block-title-blog-b"
        >How can I book a product for the rent?
        </div>
    </div>
      <div class="faq-block">
        <div class="faq-block-main">
          <div class="faq-block-description">
            <div>ADD INFO</div>
            <div>You can easily change your name/nickname/email using the "Edit user details" option. </div>
            <div>1. Click on the <a href="#personal">Personal</a> link at the bottom of this page. </div>
            <div>2. You will be automatically redirected to the user profile page. </div>
            <div>3. The "Edit user details" option will be located there.</div>
          </div>
        </div>
      </div>

      <div class="faq-item-block-blog">
        <div 
          class="faq-item-block-title-blog-b"
        >How can I contact the product owner?
        </div>
    </div>
      <div class="faq-block">
        <div class="faq-block-main">
          <div class="faq-block-description">
            <div>You can contact the product owner using the "Send a message" option on the product page. </div>
          </div>
        </div>
      </div>
      <div class="faq-item-block-blog">
        <div 
          class="faq-item-block-title-blog-b"
        >How can I contact "Shazar" team?
        </div>
    </div>
      <div class="faq-block">
        <div class="faq-block-main">
          <div class="faq-block-description">
            <div>You can contact us using one of our contact options. </div>
            <div>1. Reach the <a href="#faq-help">Help</a> section at the bottom of this page. </div>
            <div>2. Choose the option that is convenient for you: Email, Telegram, WhatsApp or Instagram. </div>
            <div>3. Our support team will redirect you to the department of your need. </div>
          </div>
        </div>
      </div>
      <div class="faq-help-block" id="faq-help">
        <div class="help-block-two-faq">
          <div class="help-sec-main-one">FAQ page didn't help you?</div>
          <div class="help-sec">Feel free to contact our support team!</div>
          <div class="help-sec"><span>Email:</span> shazar-support@gmail.com</div> 
          <div class="help-sec">OR</div>
          <div class="logos">
          <a href="https://telegram.me/tobosssss">
            <img class="logo-site" src="pngwing.com.png" alt="">
          </a>
          <a href="https://wa.me/48452750127">
            <img class="logo-site" src="pngwing.com-3.png" alt="">
          </a>
          <a href="https://www.instagram.com/ann.peretyatko/">
            <img class="logo-site" src="pngwing.com-2.png" alt="">
          </a>
          </div>
        </div>
      </div>
    </main>
    <footer class="footer-contact-information">
        <div class="footer-contact-information-container">
          <div class="footer-contact-information-links-social-media">
              <a href="#">Home</a>
              <a href="#">Cart</a>
              <a href="/UserProfile" id="personal">Personal</a>
              <a href="/Information">Information</a>
          </div>
        </div>
    </footer>
  </div>

</body>
</html>