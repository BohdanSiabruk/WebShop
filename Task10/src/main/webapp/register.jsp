<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="myprefix" uri="/WEB-INF/inputCapch.tld" %>
<%@ taglib uri="/WEB-INF/login.tld" prefix="log"%>

<head>
    <title>Free Home Shoppe Website Template | Contact :: w3layouts</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="js/move-top.js"></script>
    <script type="text/javascript" src="js/easing.js"></script>
    <!--<script src="js/register.js"></script>-->
    <!--<script src="js/jquery-register-validate.js"></script>-->

</head>

<body>
<div class="wrap">
    <div class="header">
        <div class="headertop_desc">
            <div class="call">
                <p><span>Need help?</span> call us <span class="number">1-22-3456789</span></p>
            </div>
            <div class="account_desc">

               <ul>
               					<li><a href="#">Delivery</a></li>
               					<li><a href="#">Checkout</a></li>
               					<li><a href="#">My Account</a></li>
               				</ul>
               				<div class="signin">
               					<div class="cart-sec">
               						<a href="cart.jsp"><img href="cart.jsp" src="images/cart.png" alt=""/></a></div>
               					<ul>
               						<li><c:if test = "${!empty sessionScope.email}">
               							<log:Login firstName="${sessionScope.firstName}" email="${sessionScope.email}"/>
               						</c:if></li>
               						<c:if test = "${empty sessionScope.email}">
               							<li><a href="login.jsp"> LOGIN</a></li>
               							<li><a href="register">REGISTRATION</a></li>
               						</c:if>
               					</ul>
               				</div>
               			</div>
        <div class="header_top">
            <div class="logo">
                <a href="index.jsp"><img src="images/logo.png" alt=""/></a>
            </div>
            <div class="cart">
            			  	   <p>Welcome to our Online Store! <span>Cart:</span><div id="dd" class="wrapper-dropdown-2"> 0 item(s) - $0.00
            			  	   	<ul class="dropdown">
            							<li>you have no items in your Shopping cart</li>
            					</ul></div></p>
            			  </div>

            <script type="text/javascript">
                function DropDown(el) {
                    this.dd = el;
                    this.initEvents();
                }

                DropDown.prototype = {
                    initEvents: function () {
                        var obj = this;

                        obj.dd.on('click', function (event) {
                            $(this).toggleClass('active');
                            event.stopPropagation();
                        });
                    }
                }

                $(function () {

                    var dd = new DropDown($('#dd'));

                    $(document).click(function () {
                        // all dropdowns
                        $('.wrapper-dropdown-2').removeClass('active');
                    });

                });

            </script>
            <div class="clear"></div>
        </div>
    </div>
    <div class="main">
        <div class="content">
            <div class="section group">
                <div class="col span_2_of_3">
                    <form method="post" action="/register" class="contact-form" id="register-form" enctype="multipart/form-data">

                        <h2>Register</h2>
                        <ul class="error-msm">
                            <c:forEach var="error" items="${mapError}">
                                <li>
                                        ${error.value}
                                </li>
                            </c:forEach>
                        </ul>
                        <div class="registration-form">
                            <div>

                                <span><input value="${firstName}" name="firstName" id="first-name-input" type="text"
                                             class="textbox" placeholder="First Name"></span>
                            </div>
                            <div>

                                <span><input value="${lastName}" name="lastName" id="last-name-input" type="text"
                                             class="textbox" placeholder="Last Name"></span>
                            </div>
                            <div>

                                <span><input value="${email}" name="email" id="email-name-input" type="text"
                                             class="textbox" placeholder="E-mail"></span>
                            </div>
                            <div>

                                <span><input name="password" id="password-name-input" type="password" class="textbox"
                                             placeholder="Password"></span>
                            </div>
                            <div>

                                <span><input name="confirmPassword" id="password-verify-name-input" type="password"
                                             class="textbox" placeholder="Verify password"></span>
                            </div>
                            <div class="captchaField">

                             <ul>
                                  <li style="padding:7px;"class="text-info">Avatar:<input type="file" name="file_name"></li>
                                  <li></li>
                             </ul>

                                <input type="capt" id="captcha-verify-input" name="captchaString">
                                <myprefix:MyCaptcha/>
                                <input type="hidden" name="captchaKey" id="captchaKey" value="${captchaKey}" >
                                <input type="hidden" name="mapError" id="map-error" value="${mapError}">
                                <span></span>
                            </div>
                            <div>
                                <span><input id="butt" type="submit" class="myButton" value="REGISTER"></span>
                            </div>
                        </div>
                        <div color="green">

                        </div>
                        <ul class="registerSuccessful">

                                <li>
                                       <p style="color:green; font-size:50px;">${requestScope.registerSuccessful}</p>
                                </li>

                        </ul>
                    </form>
                </div>
                <div class="col span_1_of_3">
                    <div class="contact_info">
                        <h3>Find Us Here</h3>
                        <div class="map">
                            <iframe width="100%" height="175" frameborder="0" scrolling="no" marginheight="0"
                                    marginwidth="0"
                                    src="https://maps.google.co.in/maps?f=q&amp;source=s_q&amp;hl=en&amp;geocode=&amp;q=Lighthouse+Point,+FL,+United+States&amp;aq=4&amp;oq=light&amp;sll=26.275636,-80.087265&amp;sspn=0.04941,0.104628&amp;ie=UTF8&amp;hq=&amp;hnear=Lighthouse+Point,+Broward,+Florida,+United+States&amp;t=m&amp;z=14&amp;ll=26.275636,-80.087265&amp;output=embed"></iframe>
                            <br>
                            <small><a
                                    href="https://maps.google.co.in/maps?f=q&amp;source=embed&amp;hl=en&amp;geocode=&amp;q=Lighthouse+Point,+FL,+United+States&amp;aq=4&amp;oq=light&amp;sll=26.275636,-80.087265&amp;sspn=0.04941,0.104628&amp;ie=UTF8&amp;hq=&amp;hnear=Lighthouse+Point,+Broward,+Florida,+United+States&amp;t=m&amp;z=14&amp;ll=26.275636,-80.087265"
                                    style="color:#666;text-align:left;font-size:12px">View Larger Map</a></small>
                        </div>
                    </div>
                    <div class="company_address">
                        <h3>Company Information :</h3>
                        <p>500 Lorem Ipsum Dolor Sit,</p>
                        <p>22-56-2-9 Sit Amet, Lorem,</p>
                        <p>USA</p>
                        <p>Phone:(00) 222 666 444</p>
                        <p>Fax: (000) 000 00 00 0</p>
                        <p>Email: <span><a href="mailto:@example.com">info@mycompany.com</a></span></p>
                        <p>Follow on: <span>Facebook</span>, <span>Twitter</span></p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="footer">
    <div class="wrap">
        <div class="section group">
            <div class="col_1_of_4 span_1_of_4">
                <h4>Information</h4>
                <ul>
                    <li><a href="about.html">About Us</a></li>
                    <li><a href="contact.html">Customer Service</a></li>
                    <li><a href="#">Advanced Search</a></li>
                    <li><a href="delivery.html">Orders and Returns</a></li>
                    <li><a href="contact.html">Contact Us</a></li>
                </ul>
            </div>
            <div class="col_1_of_4 span_1_of_4">
                <h4>Why buy from us</h4>
                <ul>
                    <li><a href="about.html">About Us</a></li>
                    <li><a href="contact.html">Customer Service</a></li>
                    <li><a href="#">Privacy Policy</a></li>
                    <li><a href="contact.html">Site Map</a></li>
                    <li><a href="#">Search Terms</a></li>
                </ul>
            </div>
            <div class="col_1_of_4 span_1_of_4">
                <h4>My account</h4>
                <ul>
                    <li><a href="contact.html">Sign In</a></li>
                    <li><a href="index.html">View Cart</a></li>
                    <li><a href="#">My Wishlist</a></li>
                    <li><a href="#">Track My Order</a></li>
                    <li><a href="contact.html">Help</a></li>
                </ul>
            </div>
            <div class="col_1_of_4 span_1_of_4">
                <h4>Contact</h4>
                <ul>
                    <li><span>+91-123-456789</span></li>
                    <li><span>+00-123-000000</span></li>
                </ul>
                <div class="social-icons">
                    <h4>Follow Us</h4>
                    <ul>
                        <li><a href="#" target="_blank"><img src="images/facebook.png" alt=""/></a></li>
                        <li><a href="#" target="_blank"><img src="images/twitter.png" alt=""/></a></li>
                        <li><a href="#" target="_blank"><img src="images/skype.png" alt=""/> </a></li>
                        <li><a href="#" target="_blank"> <img src="images/dribbble.png" alt=""/></a></li>
                        <li><a href="#" target="_blank"> <img src="images/linkedin.png" alt=""/></a></li>
                        <div class="clear"></div>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="copy_right">
        <p>&copy; 2013 home_shoppe. All rights reserved | Design by <a href="http://w3layouts.com/">W3layouts</a></p>
    </div>
</div>
<script type="text/javascript">
    $(document).ready(function () {
        $().UItoTop({easingType: 'easeOutQuart'});

    });
</script>
<a href="#" id="toTop"><span id="toTopHover"> </span></a>
<script src="js/errors.js"></script>

</body>

</html>
