<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head> 
    <meta charset="utf-8">
    <title></title>
    <META name="viewport" content="width=device-width, height=device-height, initial-scale=1.0, user-scalable=no"> 
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.css" />
    <link rel="stylesheet" href="/css/reset.css"/>
    <style>
        * {
            box-sizing: border-box;
            margin:0;
            padding:0;
        }
        a {
            text-decoration: none;
        }
        .wrap {
            width:100%;
            margin : 0 auto;    /* 가운데 정렬 */
        }
        .header {
            width:1200px;
            margin : 0 auto;
            text-align: center;
            padding:10px 0;
        }
        .size {
            position: relative;
        }
        .login {
            position: absolute;
            right : 0;
            top : 0;
        }
        .menu {
            width:1200px;
            margin : 0 auto;
            height:40px;
        }
        .menu > ul {
            margin:0;
            padding:0;
            
        }
        .menu > ul > li {
            list-style: none;
            border:1px solid #000000;
            background-color:#ffffff;
            color:#000000;
            text-align: center;
            float:left;
            width:20%;
            height:40px;
            line-height:40px;
        }
        .menu > ul > li:hover {
            background-color:#ffffff;
        }
        .container {
            overflow: hidden;
            height:auto;
            width:1200px;
            margin : 0 auto;
            padding : 20px;
        }
        .container > .size {
            width:100%;
            text-align: center;
        }
        .container > .size > .section {
            width:31.3333%;
            float:left;
            margin:1%;
        }

        .footer {
            background-color:#2d2b28;
            color:#999;
            clear :both;
            padding:30px 0;
            width:100%;
        }
        .footer > .size {
            width:1200px;
            margin:0 auto;
        }
        .footer > .size > .info > p {
            line-height: 20px;
        }
        .footer > .size > .sns_area {
            position: absolute;
            top : 0;
            right : 0;
        }
        .sns_area > a {
            margin: 10px;
        }

        ul, li {
            list-style-type: none;
            position: relative;
        }
        .depth2 {
            z-index:10;
            position: absolute;
            text-align: center;
            width:100%;
            background-color: #ffffff;
            display:none;
        }
        .visual img {
            display: block; /* 이미지 하단 라인 제거 */
        }
        .visual {
            height:500px;
            width:100%;
            text-align: center;
            position: relative;
        }
        .swiper {
            height:500px;
        }
        .swiper-slide {
            background-position: center center;
            background-size: cover;
            background-repeat: no-repeat;
        }
        #popup {
            position: absolute;
            z-index:99999;
        }
        #quickMenu {
            position: absolute;
            z-index:99999;
            top:124px;
            left:1480px;
        }
        #goTop {
            cursor: pointer;
        }
        .info {
            width:1200px;
            margin:0 auto;
            overflow: hidden;
        }
        .info > .content {
            width : 50%;
            padding : 10px;
            float:left;
        }
        .info > .content > .board_area {
            width:100%;
            border:1px solid #999;
            padding:10px;
        }
        .info > .content > .board_area > .board_title {
            font-size: 25px;
            line-height : 50px;
            float:left;
            cursor: pointer;
            width:100px;
            margin-right: 5px;
            text-align: center;
        }
        .info > .content > .board_area > .board_title.on {
            background-color: #2d2b28;
            color : #fff;
        }
        .board_contents {
            clear:both;
        }
        .board_contents > ul:first-child {
            border-top:1px solid #999;
        }
        .board_contents > ul > li {
            line-height: 50px;
            font-size: 18px;
            border-bottom: 1px solid #999;
        }
        #board_data{display: none;}
        .board_contents > ul > li > span {
            float:right;
        }
    </style>
    <script>
        $(function(){
            $('.depth1 > li').on('mouseover',function(){
                $(this).find('.depth2').stop().slideDown();
            }).on('mouseleave',function(){
                $(this).find('.depth2').stop().slideUp();
            });

            // swiper
            var swiper = new Swiper('.swiper-visual',{
                autoplay : {
                    delay:3000
                },
                loop : true
            });

            // section
            // $('.section > img').mouseover(function() {
            //     $(this).css('margin','-3px');
            //     $(this).css('border','3px solid #999');
            // }).mouseout(function() {
            //     $(this).css('margin','0px');
            //     $(this).css('border','none');
            // });
            $("#popup").css({
                top:(($(window).height()-$("#popup").outerHeight())/2 + $(window).scrollTop())+'px',
                left:(($(window).width()-$("#popup").outerWidth())/2 + $(window).scrollLeft())+'px',
            });
            $("#popup").draggable();

            // 퀵메뉴
            var q_left = $(".menu >ul:first-child").position().left + 1200;
            var q_top = $(".menu >ul:first-child").position().top;
            $('#quickMenu').css({
                left : q_left,
                top : q_top
            });

            // 퀵메뉴 따라가게
            $(window).scroll(function(){
                var scrollTop = $(window).scrollTop();
                var q_top_new = scrollTop + q_top;
                // $('#quickMenu').css('top',q_top_new);
                $('#quickMenu').stop().animate({
                    top:q_top_new
                }, 500);
            });

            // top으로
            $("#goTop").click(function(){
                $('html').animate({scrollTop:0},300);
            });


        });

    </script>
</head> 
<body>
    <div id="popup">
        <img src="resources/img/event_popup.png">
    </div>
    <div class="wrap">
        <div class="header">
            <div class="size">
                <div><img src="resources/img/logo.png"></div>
                <div class="login">
                    <a href="">로그인</a> |
                    <a href="">회원가입</a>
                </div>
            </div>
        </div>
        <div class="menu">
            <ul class="depth1">
                <li>
                    <a href="">MENU1</a>
                    <ul class="depth2">
                        <li><a href="">MENU1-1</a></li>
                        <li><a href="">MENU1-2</a></li>
                        <li><a href="">MENU1-3</a></li>
                    </ul>
                </li>
                <li>
                    <a href="">MENU2</a>
                    <ul class="depth2">
                        <li><a href="">MENU2-1</a></li>
                        <li><a href="">MENU2-2</a></li>
                        <li><a href="">MENU2-3</a></li>
                    </ul>
                </li>
                <li>
                    <a href="">MENU3</a>
                    <ul class="depth2">
                        <li><a href="">MENU3-1</a></li>
                        <li><a href="">MENU3-2</a></li>
                        <li><a href="">MENU3-3</a></li>
                    </ul>
                </li>
                <li>
                    <a href="">MENU4</a>
                    <ul class="depth2">
                        <li><a href="">MENU4-1</a></li>
                        <li><a href="">MENU4-2</a></li>
                        <li><a href="">MENU4-3</a></li>
                    </ul>
                </li>
                <li>
                    <a href="">MENU5</a>
                    <ul class="depth2">
                        <li><a href="">MENU5-1</a></li>
                        <li><a href="">MENU5-2</a></li>
                        <li><a href="">MENU5-3</a></li>
                    </ul>
                </li>
            </ul>
        </div>
        <div class="visual">
            <div class="swiper swiper-visual">
                <div class="swiper-wrapper">
                    <div class="swiper-slide" style="background-image:url('resources/img/visual1.png');"></div>
                    <div class="swiper-slide" style="background-image:url('resources/img/visual2.png');"></div>
                    <div class="swiper-slide" style="background-image:url('resources/img/visual3.png');"></div>
                    <div class="swiper-slide" style="background-image:url('resources/img/visual4.png');"></div>
                </div>
            </div>
            
        </div>
        <div class="container">
            <div class="size">
                <div class="section">
                    <img src="resources/img/section1_1.png">
                </div>
                <div class="section">
                    <img src="resources/img/section1_2.png">
                </div>
                <div class="section">
                    <img src="resources/img/section1_3.png">
                </div>
                <div class="section">
                    <img src="resources/img/section1_4.png">
                </div>
                <div class="section">
                    <img src="resources/img/section1_5.png">
                </div>
                <div class="section">
                    <img src="resources/img/section1_6.png">
                </div>
            </div>
        </div>
        <div class="info">
            <div class="content">
                <div class="board_area">
                    <div class="board_title on">공지사항</div>
                    <div class="board_title">자료실</div>
                    <div class="board_contents" id="board_notice">
                        <ul>
                            <li>공지사항입니다.<span>2023-10-18</span></li>
                            <li>공지사항입니다.<span>2023-10-18</span></li>
                            <li>공지사항입니다.<span>2023-10-18</span></li>
                            <li>공지사항입니다.<span>2023-10-18</span></li>
                            <li>공지사항입니다.<span>2023-10-18</span></li>
                            <li>공지사항입니다.<span>2023-10-18</span></li>
                        </ul>
                    </div>
                    <div class="board_contents" id="board_data">
                        <ul>
                            <li>자료실입니다.<span>2023-10-18</span></li>
                            <li>자료실입니다.<span>2023-10-18</span></li>
                            <li>자료실입니다.<span>2023-10-18</span></li>
                            <li>자료실입니다.<span>2023-10-18</span></li>
                            <li>자료실입니다.<span>2023-10-18</span></li>
                            <li>자료실입니다.<span>2023-10-18</span></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="content">
                <div class="video_container">
                    <iframe width="100%" height="360" src="https://www.youtube.com/embed/4bIX8HsLm9c" title="Working Jazz - Unwind and Work - Jazz Music for Stress Relief and Concentration" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
                </div>
            </div>
        </div>
        <div class="footer">
            <div class="size">
                <div class="info">
                    <p>신한DS 금융 SW 아카데미</p>
                    <p>서울시 마포구 월드컵북로 4길 77</p>
                    <p>02-380-3333 | 02-380-4444</p>
                    <p>대표자 서민구 | 개인정보책임자 홍길동</p>
                    <p>사업자등록번호 111-02-1234</p>
                </div>
                <div class="sns_area">
                    <a href="" target="_blank"><img src="resources/img/blog_ico.png"></a>
                    <a href="" target="_blank"><img src="resources/img/facebook_ico.png"></a>
                    <a href="" target="_blank"><img src="resources/img/insta_ico.png"></a>
                </div>
            </div>
        </div>
        <div id="quickMenu">
            <div><img src="resources/img/quick_01.jpg"></div>
            <div><img src="resources/img/quick_02.jpg"></div>
            <div><img src="resources/img/quick_03.jpg"></div>
            <div><img src="resources/img/quick_04.jpg"></div>
            <div><img id="goTop" src="resources/img/quick_05.jpg"></div>
        </div>
    </div>
</body> 
</html>