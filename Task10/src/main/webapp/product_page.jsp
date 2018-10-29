<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix='loc' tagdir='/WEB-INF/tags' %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/login.tld" prefix="log"%>

<!DOCTYPE HTML>

<head>
    <title>Free Home Shoppe Website Template | Home :: w3layouts</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="css/product.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="css/slider.css" rel="stylesheet" type="text/css" media="all"/>
    <script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="js/move-top.js"></script>
    <script type="text/javascript" src="js/easing.js"></script>
    <script type="text/javascript" src="js/startstop-slider.js"></script>
    <script type="text/javascript" src="js/2.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>


</head>
<body>
<div class="wrap">
    <div class="header">
       <div class="headertop_desc">
       			<div class="call">
       				 <p><span>Need help?</span> call us <span class="number">1-22-3456789</span></p>
       			</div>

           <fmt:setLocale value="${pageContext.request.locale}"/>
           <fmt:setBundle basename="loc"/>

       			<div class="account_desc">
       				<ul>

       					<li><a href="#">Delivery</a></li>
       					<li><a href="#">Checkout</a></li>
       					<li><a href="/basket">Basket</a></li>
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
                <p>Welcome to our Online Store! <span>Cart:</span>
                <div id="dd" class="wrapper-dropdown-2"> 0 item(s) - $0.00
                    <ul class="dropdown">
                        <li>you have no items in your Shopping cart</li>
                    </ul>
                </div>
                </p>
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
        <div class="header_bottom">
            <div class="menu">
                <ul>
                    <li><a href="index.jsp"><fmt:message key="home"/></a></li>
                    <li class="active"><a href="product_page.jsp"><fmt:message key="product"/></a></li>
                    <li><a href="about.html">About</a></li>
                    <li><a href="delivery.html"><fmt:message key="delivery"/></a></li>
                    <li><a href="news.html"><fmt:message key="news"/></a></li>
                    <li><a href="contact.html"><fmt:message key="contact"/></a></li>
                    <div class="clear"></div>
                </ul>
            </div>
            <div class="search_box">
                <form>
                    <input type="text" value="Search" onfocus="this.value = '';"
                           onblur="if (this.value == '') {this.value = 'Search';}"><input type="submit" value="">
                </form>
            </div>
            <div class="clear"></div>
        </div>


        <form name="myform" action="/product" method="get">
            <div class="header_bottom">
                <div class="menu">

                    <ul>
                        <li><a>
                            <fmt:message key="firm"/>:
                            <select name="firm" id="firm">
                                <option value="">Choose here</option>
                                <option value="Cannondale" ${requestScope.firm == 'Cannondale' ? 'selected' : ''} >
                                    Cannondale
                                </option>
                                <option value="Scott" ${requestScope.firm == 'Scott' ? 'selected' : ''} >Scott</option>
                                <option value="Specialized" ${requestScope.firm == 'Specialized' ? 'selected' : ''} >
                                    Specialized
                                </option>
                            </select>
                        </a></li>

                        <li><a>
                            <fmt:message key="category"/>:
                            <select name="category" id="category">
                                <option value="">Choose here</option>
                                <option value="MTB" ${requestScope.category == 'MTB' ? 'selected' : ''} >MTB</option>
                                <option value="STREET" ${requestScope.category == 'STREET' ? 'selected' : ''} >STREET
                                </option>
                                <option value="CYCLOCROSS" ${requestScope.category == 'CYCLOCROSS' ? 'selected' : ''} >
                                    CYCLOCROSS
                                </option>
                            </select>
                        </a></li>

                        <li><a>
                            <fmt:message key="pricefrom"/>
                            <input size="1" name="priceFrom" id="priceFrom" type="number" style="width: 70px"
                                   value="${requestScope.priceFrom}"/>
                            <fmt:message key="to"/>
                            <input size="1" name="priceTo" id="priceTo" type="number" style="width: 70px"
                                   value="${requestScope.priceTo}"/>
                        </a></li>

                        <li><a>
                            <select name="amountOnPage" id="amountOnPage">
                                <option value="3" ${requestScope.amountOnPage == '3' ? 'selected' : '3'} >3</option>
                                <option value="6" ${requestScope.amountOnPage == '6' ? 'selected' : ''} >6</option>
                                <option value="9" ${requestScope.amountOnPage == '9' ? 'selected' : ''} >9</option>
                            </select>
                            <fmt:message key="ITEMS"/>
                        </a></li>
                        <li><a>
                            Sort by name:
                            <select name="firm21" id="sortByName">
                                <option value="">no</option>
                                <option value="firm" ${requestScope.firm == 'firm' ? 'selected' : ''}>yes</option>
                            </select>
                        </a></li>

                        <li><a>
                            Sort by price:
                            <select name="price" id="sortByPrice">
                                <option value="">no</option>
                                <option value="price" ${requestScope.price == 'price' ? 'selected' : ''}>yes
                                </option>
                            </select>
                        </a></li>

                        <li><a>
                             Sort direction:
                               <select name="enumeration" id="enumeration">
                                  <option value="asc" ${requestScope.enumeration == 'asc' ? 'selected' : ''} >asc</option>
                                  <option value="desc" ${requestScope.enumeration == 'desc' ? 'selected' : ''} >desc</option>
                               </select>
                        </a></li>
                        <li><a><input type="button" name="dropFilters" value="drop filters" onclick="dropForm()"></a>
                        </li>
                        <input type="hidden" name="page" id="page">

                        <li><a><input type="submit" id="subm" value="submit"></a></li>

                        <div class="clear"></div>
                    </ul>
                </div>


                <div class="clear"></div>
            </div>
        </form>
    </div>


    <div class="main">
        <div class="content">
            <div class="section group">
                <p style="color: #cc3636">${requestScope.emptyList}</p>

                <c:if test="${empty requestScope.emptyList}">
                    <c:forEach var="product" items="${listProduct}">
                        <div class="grid_1_of_4 images_1_of_4">
                            <a href="#"><img src="${product.picture}" alt=""/></a>
                            <h2>"${product.firm}" "${product.model}" </h2>
                            <div class="price-details">
                                <div class="price-number">
                                    <p><span class="rupees">uah"${product.price}"</span></p>
                                </div>
                                <div class="add-cart">
                                    <h4><a id="addToBasket" onclick="addToBasket(${product.id})">Add to Cart</a></h4>
                                </div>
                                <div class="clear"></div>
                            </div>
                        </div>
                    </c:forEach>
                </c:if>
            </div>
        </div>
    </div>
</div>


<div class="one1" id="one1">
    <c:forEach var="i" begin="1" end="${countPage}">

        <input type="button" class="one" name="one" value="${i}" onclick="submitform(this.value)">
    </c:forEach>


    <script type="text/javascript">
        function submitform(x) {
            document.getElementById('page').value = x;
            document.myform.submit();
        }
    </script>

    <script type="text/javascript">
        function dropForm() {
            document.getElementById('firm').value = "";
            document.getElementById('category').value = "";
            document.getElementById('priceFrom').value = "";
            document.getElementById('priceTo').value = "";
            document.getElementById('amountOnPage').value = 3;
            document.getElementById('sortByName').value = "";
            document.getElementById('sortByPrice').value = "";
            document.getElementById('page').value = 1;
            document.getElementById('enumeration').value = 'asc';
        }
    </script>
    <script type="text/javascript">
        jQuery("#one1 .one").click(function () {
            jQuery("#one1 .one").removeClass('active');
            jQuery(this).toggleClass('active');
        });
    </script>
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

</body>
</html>
