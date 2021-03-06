﻿/**
* jQuery EasyUI 1.3.6
* Copyright (c) 2009-2014 www.jeasyui.com. All rights reserved.
*
* Licensed under the GPL or commercial licenses
* To use it on other terms please contact author: info@jeasyui.com
* http://www.gnu.org/licenses/gpl.txt
* http://www.jeasyui.com/license_commercial.php
*
* jQuery EasyUI iconsData 1.0 beta
* jQuery EasyUI icons 图标样式完整库数据
* jeasyui.extensions.iconsData.all.js
* 二次开发 守护天使 李健
* 最近更新：2016-04-01
*
* 依赖项：
*   1、jquery.jdirk.js v1.0 beta late
*   2、jeasyui.extensions.js v1.0 beta late
 *   替换自身icon为fron
*
* Copyright (c) 2013-2014 ChenJianwei personal All rights reserved.
* http://www.chenjianwei.org
*/
(function ($, undefined) {

    $.util.namespace("$.easyui.icons");

    var html=[
            { iconCls: "fa fa-adjust"},
            { iconCls: "fa fa-anchor"},
            { iconCls: "fa fa-archive"},
            { iconCls: "fa fa-area-chart"},
            { iconCls: "fa fa-arrows"},
            { iconCls: "fa fa-arrows-h"},
            { iconCls: "fa fa-arrows-v"},
            { iconCls: "fa fa-asterisk"},
            { iconCls: "fa fa-at"},
            { iconCls: "fa fa-automobile"},
            { iconCls: "fa fa-balance-scale"},
            { iconCls: "fa fa-ban"},
            { iconCls: "fa fa-bank"},
            { iconCls: "fa fa-bar-chart"},
            { iconCls: "fa fa-bar-chart-o"},
            { iconCls: "fa fa-barcode"},
            { iconCls: "fa fa-bars"},
            { iconCls: "fa fa-battery-0"},
            { iconCls: "fa fa-battery-1"},
            { iconCls: "fa fa-battery-2"},
            { iconCls: "fa fa-battery-3"},
            { iconCls: "fa fa-battery-4"},
            { iconCls: "fa fa-battery-empty"},
            { iconCls: "fa fa-battery-full"},
            { iconCls: "fa fa-battery-half"},
            { iconCls: "fa fa-battery-quarter"},
            { iconCls: "fa fa-battery-three-quarters"},
            { iconCls: "fa fa-bed"},
            { iconCls: "fa fa-beer"},
            { iconCls: "fa fa-bell"},
            { iconCls: "fa fa-bell-o"},
            { iconCls: "fa fa-bell-slash"},
            { iconCls: "fa fa-bell-slash-o"},
            { iconCls: "fa fa-bicycle"},
            { iconCls: "fa fa-binoculars"},
            { iconCls: "fa fa-birthday-cake"},
            { iconCls: "fa fa-bluetooth"},
            { iconCls: "fa fa-bluetooth-b"},
            { iconCls: "fa fa-bolt"},
            { iconCls: "fa fa-bomb"},
            { iconCls: "fa fa-book"},
            { iconCls: "fa fa-bookmark"},
            { iconCls: "fa fa-bookmark-o"},
            { iconCls: "fa fa-briefcase"},
            { iconCls: "fa fa-bug"},
            { iconCls: "fa fa-building"},
            { iconCls: "fa fa-building-o"},
            { iconCls: "fa fa-bullhorn"},
            { iconCls: "fa fa-bullseye"},
            { iconCls: "fa fa-bus"},
            { iconCls: "fa fa-cab"},
            { iconCls: "fa fa-calculator"},
            { iconCls: "fa fa-calendar"},
            { iconCls: "fa fa-calendar-check-o"},
            { iconCls: "fa fa-calendar-minus-o"},
            { iconCls: "fa fa-calendar-o"},
            { iconCls: "fa fa-calendar-plus-o"},
            { iconCls: "fa fa-calendar-times-o"},
            { iconCls: "fa fa-camera"},
            { iconCls: "fa fa-camera-retro"},
            { iconCls: "fa fa-car"},
            { iconCls: "fa fa-caret-square-o-down"},
            { iconCls: "fa fa-caret-square-o-left"},
            { iconCls: "fa fa-caret-square-o-right"},
            { iconCls: "fa fa-caret-square-o-up"},
            { iconCls: "fa fa-cart-arrow-down"},
            { iconCls: "fa fa-cart-plus"},
            { iconCls: "fa fa-cc"},
            { iconCls: "fa fa-certificate"},
            { iconCls: "fa fa-check"},
            { iconCls: "fa fa-check-circle"},
            { iconCls: "fa fa-check-circle-o"},
            { iconCls: "fa fa-check-square"},
            { iconCls: "fa fa-check-square-o"},
            { iconCls: "fa fa-child"},
            { iconCls: "fa fa-circle"},
            { iconCls: "fa fa-circle-o"},
            { iconCls: "fa fa-circle-o-notch"},
            { iconCls: "fa fa-circle-thin"},
            { iconCls: "fa fa-clock-o"},
            { iconCls: "fa fa-clone"},
            { iconCls: "fa fa-close"},
            { iconCls: "fa fa-cloud"},
            { iconCls: "fa fa-cloud-download"},
            { iconCls: "fa fa-cloud-upload"},
            { iconCls: "fa fa-code"},
            { iconCls: "fa fa-code-fork"},
            { iconCls: "fa fa-coffee"},
            { iconCls: "fa fa-cog"},
            { iconCls: "fa fa-cogs"},
            { iconCls: "fa fa-comment"},
            { iconCls: "fa fa-comment-o"},
            { iconCls: "fa fa-commenting"},
            { iconCls: "fa fa-commenting-o"},
            { iconCls: "fa fa-comments"},
            { iconCls: "fa fa-comments-o"},
            { iconCls: "fa fa-compass"},
            { iconCls: "fa fa-copyright"},
            { iconCls: "fa fa-creative-commons"},
            { iconCls: "fa fa-credit-card"},
            { iconCls: "fa fa-credit-card-alt"},
            { iconCls: "fa fa-crop"},
            { iconCls: "fa fa-crosshairs"},
            { iconCls: "fa fa-cube"},
            { iconCls: "fa fa-cubes"},
            { iconCls: "fa fa-cutlery"},
            { iconCls: "fa fa-dashboard"},
            { iconCls: "fa fa-database"},
            { iconCls: "fa fa-desktop"},
            { iconCls: "fa fa-diamond"},
            { iconCls: "fa fa-dot-circle-o"},
            { iconCls: "fa fa-download"},
            { iconCls: "fa fa-edit"},
            { iconCls: "fa fa-ellipsis-h"},
            { iconCls: "fa fa-ellipsis-v"},
            { iconCls: "fa fa-envelope"},
            { iconCls: "fa fa-envelope-o"},
            { iconCls: "fa fa-envelope-square"},
            { iconCls: "fa fa-eraser"},
            { iconCls: "fa fa-exchange"},
            { iconCls: "fa fa-exclamation"},
            { iconCls: "fa fa-exclamation-circle"},
            { iconCls: "fa fa-exclamation-triangle"},
            { iconCls: "fa fa-external-link"},
            { iconCls: "fa fa-external-link-square"},
            { iconCls: "fa fa-eye"},
            { iconCls: "fa fa-eye-slash"},
            { iconCls: "fa fa-eyedropper"},
            { iconCls: "fa fa-fax"},
            { iconCls: "fa fa-feed"},
            { iconCls: "fa fa-female"},
            { iconCls: "fa fa-fighter-jet"},
            { iconCls: "fa fa-file-archive-o"},
            { iconCls: "fa fa-file-audio-o"},
            { iconCls: "fa fa-file-code-o"},
            { iconCls: "fa fa-file-excel-o"},
            { iconCls: "fa fa-file-image-o"},
            { iconCls: "fa fa-file-movie-o"},
            { iconCls: "fa fa-file-pdf-o"},
            { iconCls: "fa fa-file-photo-o"},
            { iconCls: "fa fa-file-picture-o"},
            { iconCls: "fa fa-file-powerpoint-o"},
            { iconCls: "fa fa-file-sound-o"},
            { iconCls: "fa fa-file-video-o"},
            { iconCls: "fa fa-file-word-o"},
            { iconCls: "fa fa-file-zip-o"},
            { iconCls: "fa fa-film"},
            { iconCls: "fa fa-filter"},
            { iconCls: "fa fa-fire"},
            { iconCls: "fa fa-fire-extinguisher"},
            { iconCls: "fa fa-flag"},
            { iconCls: "fa fa-flag-checkered"},
            { iconCls: "fa fa-flag-o"},
            { iconCls: "fa fa-flash"},
            { iconCls: "fa fa-flask"},
            { iconCls: "fa fa-folder"},
            { iconCls: "fa fa-folder-o"},
            { iconCls: "fa fa-folder-open"},
            { iconCls: "fa fa-folder-open-o"},
            { iconCls: "fa fa-frown-o"},
            { iconCls: "fa fa-futbol-o"},
            { iconCls: "fa fa-gamepad"},
            { iconCls: "fa fa-gavel"},
            { iconCls: "fa fa-gear"},
            { iconCls: "fa fa-gears"},
            { iconCls: "fa fa-gift"},
            { iconCls: "fa fa-glass"},
            { iconCls: "fa fa-globe"},
            { iconCls: "fa fa-graduation-cap"},
            { iconCls: "fa fa-group"},
            { iconCls: "fa fa-hand-grab-o"},
            { iconCls: "fa fa-hand-lizard-o"},
            { iconCls: "fa fa-hand-paper-o"},
            { iconCls: "fa fa-hand-peace-o"},
            { iconCls: "fa fa-hand-pointer-o"},
            { iconCls: "fa fa-hand-rock-o"},
            { iconCls: "fa fa-hand-scissors-o"},
            { iconCls: "fa fa-hand-spock-o"},
            { iconCls: "fa fa-hand-stop-o"},
            { iconCls: "fa fa-hashtag"},
            { iconCls: "fa fa-hdd-o"},
            { iconCls: "fa fa-headphones"},
            { iconCls: "fa fa-heart"},
            { iconCls: "fa fa-heart-o"},
            { iconCls: "fa fa-heartbeat"},
            { iconCls: "fa fa-history"},
            { iconCls: "fa fa-home"},
            { iconCls: "fa fa-hotel"},
            { iconCls: "fa fa-hourglass"},
            { iconCls: "fa fa-hourglass-1"},
            { iconCls: "fa fa-hourglass-2"},
            { iconCls: "fa fa-hourglass-3"},
            { iconCls: "fa fa-hourglass-end"},
            { iconCls: "fa fa-hourglass-half"},
            { iconCls: "fa fa-hourglass-o"},
            { iconCls: "fa fa-hourglass-start"},
            { iconCls: "fa fa-i-cursor"},
            { iconCls: "fa fa-image"},
            { iconCls: "fa fa-inbox"},
            { iconCls: "fa fa-industry"},
            { iconCls: "fa fa-info"},
            { iconCls: "fa fa-info-circle"},
            { iconCls: "fa fa-institution"},
            { iconCls: "fa fa-key"},
            { iconCls: "fa fa-keyboard-o"},
            { iconCls: "fa fa-language"},
            { iconCls: "fa fa-laptop"},
            { iconCls: "fa fa-leaf"},
            { iconCls: "fa fa-legal"},
            { iconCls: "fa fa-lemon-o"},
            { iconCls: "fa fa-level-down"},
            { iconCls: "fa fa-level-up"},
            { iconCls: "fa fa-life-bouy"},
            { iconCls: "fa fa-life-buoy"},
            { iconCls: "fa fa-life-ring"},
            { iconCls: "fa fa-life-saver"},
            { iconCls: "fa fa-lightbulb-o"},
            { iconCls: "fa fa-line-chart"},
            { iconCls: "fa fa-location-arrow"},
            { iconCls: "fa fa-lock"},
            { iconCls: "fa fa-magic"},
            { iconCls: "fa fa-magnet"},
            { iconCls: "fa fa-mail-forward"},
            { iconCls: "fa fa-mail-reply"},
            { iconCls: "fa fa-mail-reply-all"},
            { iconCls: "fa fa-male"},
            { iconCls: "fa fa-map"},
            { iconCls: "fa fa-map-marker"},
            { iconCls: "fa fa-map-o"},
            { iconCls: "fa fa-map-pin"},
            { iconCls: "fa fa-map-signs"},
            { iconCls: "fa fa-meh-o"},
            { iconCls: "fa fa-microphone"},
            { iconCls: "fa fa-microphone-slash"},
            { iconCls: "fa fa-minus"},
            { iconCls: "fa fa-minus-circle"},
            { iconCls: "fa fa-minus-square"},
            { iconCls: "fa fa-minus-square-o"},
            { iconCls: "fa fa-mobile"},
            { iconCls: "fa fa-mobile-phone"},
            { iconCls: "fa fa-money"},
            { iconCls: "fa fa-moon-o"},
            { iconCls: "fa fa-mortar-board"},
            { iconCls: "fa fa-motorcycle"},
            { iconCls: "fa fa-mouse-pointer"},
            { iconCls: "fa fa-music"},
            { iconCls: "fa fa-navicon"},
            { iconCls: "fa fa-newspaper-o"},
            { iconCls: "fa fa-object-group"},
            { iconCls: "fa fa-object-ungroup"},
            { iconCls: "fa fa-paint-brush"},
            { iconCls: "fa fa-paper-plane"},
            { iconCls: "fa fa-paper-plane-o"},
            { iconCls: "fa fa-paw"},
            { iconCls: "fa fa-pencil"},
            { iconCls: "fa fa-pencil-square"},
            { iconCls: "fa fa-pencil-square-o"},
            { iconCls: "fa fa-percent"},
            { iconCls: "fa fa-phone"},
            { iconCls: "fa fa-phone-square"},
            { iconCls: "fa fa-photo"},
            { iconCls: "fa fa-picture-o"},
            { iconCls: "fa fa-pie-chart"},
            { iconCls: "fa fa-plane"},
            { iconCls: "fa fa-plug"},
            { iconCls: "fa fa-plus"},
            { iconCls: "fa fa-plus-circle"},
            { iconCls: "fa fa-plus-square"},
            { iconCls: "fa fa-plus-square-o"},
            { iconCls: "fa fa-power-off"},
            { iconCls: "fa fa-print"},
            { iconCls: "fa fa-puzzle-piece"},
            { iconCls: "fa fa-qrcode"},
            { iconCls: "fa fa-question"},
            { iconCls: "fa fa-question-circle"},
            { iconCls: "fa fa-quote-left"},
            { iconCls: "fa fa-quote-right"},
            { iconCls: "fa fa-random"},
            { iconCls: "fa fa-recycle"},
            { iconCls: "fa fa-refresh"},
            { iconCls: "fa fa-registered"},
            { iconCls: "fa fa-remove"},
            { iconCls: "fa fa-reorder"},
            { iconCls: "fa fa-reply"},
            { iconCls: "fa fa-reply-all"},
            { iconCls: "fa fa-retweet"},
            { iconCls: "fa fa-road"},
            { iconCls: "fa fa-rocket"},
            { iconCls: "fa fa-rss"},
            { iconCls: "fa fa-rss-square"},
            { iconCls: "fa fa-search"},
            { iconCls: "fa fa-search-minus"},
            { iconCls: "fa fa-search-plus"},
            { iconCls: "fa fa-send"},
            { iconCls: "fa fa-send-o"},
            { iconCls: "fa fa-server"},
            { iconCls: "fa fa-share"},
            { iconCls: "fa fa-share-alt"},
            { iconCls: "fa fa-share-alt-square"},
            { iconCls: "fa fa-share-square"},
            { iconCls: "fa fa-share-square-o"},
            { iconCls: "fa fa-shield"},
            { iconCls: "fa fa-ship"},
            { iconCls: "fa fa-shopping-bag"},
            { iconCls: "fa fa-shopping-basket"},
            { iconCls: "fa fa-shopping-cart"},
            { iconCls: "fa fa-sign-in"},
            { iconCls: "fa fa-sign-out"},
            { iconCls: "fa fa-signal"},
            { iconCls: "fa fa-sitemap"},
            { iconCls: "fa fa-sliders"},
            { iconCls: "fa fa-smile-o"},
            { iconCls: "fa fa-soccer-ball-o"},
            { iconCls: "fa fa-sort"},
            { iconCls: "fa fa-sort-alpha-asc"},
            { iconCls: "fa fa-sort-alpha-desc"},
            { iconCls: "fa fa-sort-amount-asc"},
            { iconCls: "fa fa-sort-amount-desc"},
            { iconCls: "fa fa-sort-asc"},
            { iconCls: "fa fa-sort-desc"},
            { iconCls: "fa fa-sort-down"},
            { iconCls: "fa fa-sort-numeric-asc"},
            { iconCls: "fa fa-sort-numeric-desc"},
            { iconCls: "fa fa-sort-up"},
            { iconCls: "fa fa-space-shuttle"},
            { iconCls: "fa fa-spinner"},
            { iconCls: "fa fa-spoon"},
            { iconCls: "fa fa-square"},
            { iconCls: "fa fa-square-o"},
            { iconCls: "fa fa-star"},
            { iconCls: "fa fa-star-half"},
            { iconCls: "fa fa-star-half-empty"},
            { iconCls: "fa fa-star-half-full"},
            { iconCls: "fa fa-star-half-o"},
            { iconCls: "fa fa-star-o"},
            { iconCls: "fa fa-sticky-note"},
            { iconCls: "fa fa-sticky-note-o"},
            { iconCls: "fa fa-street-view"},
            { iconCls: "fa fa-suitcase"},
            { iconCls: "fa fa-sun-o"},
            { iconCls: "fa fa-support"},
            { iconCls: "fa fa-tablet"},
            { iconCls: "fa fa-tachometer"},
            { iconCls: "fa fa-tag"},
            { iconCls: "fa fa-tags"},
            { iconCls: "fa fa-tasks"},
            { iconCls: "fa fa-taxi"},
            { iconCls: "fa fa-television"},
            { iconCls: "fa fa-terminal"},
            { iconCls: "fa fa-thumb-tack"},
            { iconCls: "fa fa-thumbs-down"},
            { iconCls: "fa fa-thumbs-o-down"},
            { iconCls: "fa fa-thumbs-o-up"},
            { iconCls: "fa fa-thumbs-up"},
            { iconCls: "fa fa-ticket"},
            { iconCls: "fa fa-times"},
            { iconCls: "fa fa-times-circle"},
            { iconCls: "fa fa-times-circle-o"},
            { iconCls: "fa fa-tint"},
            { iconCls: "fa fa-toggle-down"},
            { iconCls: "fa fa-toggle-left"},
            { iconCls: "fa fa-toggle-off"},
            { iconCls: "fa fa-toggle-on"},
            { iconCls: "fa fa-toggle-right"},
            { iconCls: "fa fa-toggle-up"},
            { iconCls: "fa fa-trademark"},
            { iconCls: "fa fa-trash"},
            { iconCls: "fa fa-trash-o"},
            { iconCls: "fa fa-tree"},
            { iconCls: "fa fa-trophy"},
            { iconCls: "fa fa-truck"},
            { iconCls: "fa fa-tty"},
            { iconCls: "fa fa-tv"},
            { iconCls: "fa fa-umbrella"},
            { iconCls: "fa fa-university"},
            { iconCls: "fa fa-unlock"},
            { iconCls: "fa fa-unlock-alt"},
            { iconCls: "fa fa-unsorted"},
            { iconCls: "fa fa-upload"},
            { iconCls: "fa fa-user"},
            { iconCls: "fa fa-user-plus"},
            { iconCls: "fa fa-user-secret"},
            { iconCls: "fa fa-user-times"},
            { iconCls: "fa fa-users"},
            { iconCls: "fa fa-video-camera"},
            { iconCls: "fa fa-volume-down"},
            { iconCls: "fa fa-volume-off"},
            { iconCls: "fa fa-volume-up"},
            { iconCls: "fa fa-warning"},
            { iconCls: "fa fa-wheelchair"},
            { iconCls: "fa fa-wifi"},
            { iconCls: "fa fa-wrench"}
    ],hand=[
        { iconCls: "fa fa-hand-grab-o"},
        { iconCls: "fa fa-hand-lizard-o"},
        { iconCls: "fa fa-hand-o-down"},
        { iconCls: "fa fa-hand-o-left"},
        { iconCls: "fa fa-hand-o-right"},
        { iconCls: "fa fa-hand-o-up"},
        { iconCls: "fa fa-hand-paper-o"},
        { iconCls: "fa fa-hand-peace-o"},
        { iconCls: "fa fa-hand-pointer-o"},
        { iconCls: "fa fa-hand-rock-o"},
        { iconCls: "fa fa-hand-scissors-o"},
        { iconCls: "fa fa-hand-spock-o"},
        { iconCls: "fa fa-hand-stop-o"},
        { iconCls: "fa fa-thumbs-down"},
        { iconCls: "fa fa-thumbs-o-down"},
        { iconCls: "fa fa-thumbs-o-up"},
        { iconCls: "fa fa-thumbs-up"}
    ],mark=
        [
            { iconCls: "fa fa-500px"},
            { iconCls: "fa fa-adn"},
            { iconCls: "fa fa-amazon"},
            { iconCls: "fa fa-android"},
            { iconCls: "fa fa-angellist"},
            { iconCls: "fa fa-apple"},
            { iconCls: "fa fa-behance"},
            { iconCls: "fa fa-behance-square"},
            { iconCls: "fa fa-bitbucket"},
            { iconCls: "fa fa-bitbucket-square"},
            { iconCls: "fa fa-bitcoin"},
            { iconCls: "fa fa-black-tie"},
            { iconCls: "fa fa-bluetooth"},
            { iconCls: "fa fa-bluetooth-b"},
            { iconCls: "fa fa-btc"},
            { iconCls: "fa fa-buysellads"},
            { iconCls: "fa fa-cc-amex"},
            { iconCls: "fa fa-cc-diners-club"},
            { iconCls: "fa fa-cc-discover"},
            { iconCls: "fa fa-cc-jcb"},
            { iconCls: "fa fa-cc-mastercard"},
            { iconCls: "fa fa-cc-paypal"},
            { iconCls: "fa fa-cc-stripe"},
            { iconCls: "fa fa-cc-visa"},
            { iconCls: "fa fa-chrome"},
            { iconCls: "fa fa-codepen"},
            { iconCls: "fa fa-codiepie"},
            { iconCls: "fa fa-connectdevelop"},
            { iconCls: "fa fa-contao"},
            { iconCls: "fa fa-css3"},
            { iconCls: "fa fa-dashcube"},
            { iconCls: "fa fa-delicious"},
            { iconCls: "fa fa-deviantart"},
            { iconCls: "fa fa-digg"},
            { iconCls: "fa fa-dribbble"},
            { iconCls: "fa fa-dropbox"},
            { iconCls: "fa fa-drupal"},
            { iconCls: "fa fa-edge"},
            { iconCls: "fa fa-empire"},
            { iconCls: "fa fa-expeditedssl"},
            { iconCls: "fa fa-facebook"},
            { iconCls: "fa fa-facebook-f"},
            { iconCls: "fa fa-facebook-official"},
            { iconCls: "fa fa-facebook-square"},
            { iconCls: "fa fa-firefox"},
            { iconCls: "fa fa-flickr"},
            { iconCls: "fa fa-fonticons"},
            { iconCls: "fa fa-fort-awesome"},
            { iconCls: "fa fa-forumbee"},
            { iconCls: "fa fa-foursquare"},
            { iconCls: "fa fa-ge"},
            { iconCls: "fa fa-get-pocket"},
            { iconCls: "fa fa-gg"},
            { iconCls: "fa fa-gg-circle"},
            { iconCls: "fa fa-git"},
            { iconCls: "fa fa-git-square"},
            { iconCls: "fa fa-github"},
            { iconCls: "fa fa-github-alt"},
            { iconCls: "fa fa-github-square"},
            { iconCls: "fa fa-gittip"},
            { iconCls: "fa fa-google"},
            { iconCls: "fa fa-google-plus"},
            { iconCls: "fa fa-google-plus-square"},
            { iconCls: "fa fa-google-wallet"},
            { iconCls: "fa fa-gratipay"},
            { iconCls: "fa fa-hacker-news"},
            { iconCls: "fa fa-houzz"},
            { iconCls: "fa fa-html5"},
            { iconCls: "fa fa-instagram"},
            { iconCls: "fa fa-internet-explorer"},
            { iconCls: "fa fa-ioxhost"},
            { iconCls: "fa fa-joomla"},
            { iconCls: "fa fa-jsfiddle"},
            { iconCls: "fa fa-lastfm"},
            { iconCls: "fa fa-lastfm-square"},
            { iconCls: "fa fa-leanpub"},
            { iconCls: "fa fa-linkedin"},
            { iconCls: "fa fa-linkedin-square"},
            { iconCls: "fa fa-linux"},
            { iconCls: "fa fa-maxcdn"},
            { iconCls: "fa fa-meanpath"},
            { iconCls: "fa fa-medium"},
            { iconCls: "fa fa-mixcloud"},
            { iconCls: "fa fa-modx"},
            { iconCls: "fa fa-odnoklassniki"},
            { iconCls: "fa fa-odnoklassniki-square"},
            { iconCls: "fa fa-opencart"},
            { iconCls: "fa fa-openid"},
            { iconCls: "fa fa-opera"},
            { iconCls: "fa fa-optin-monster"},
            { iconCls: "fa fa-pagelines"},
            { iconCls: "fa fa-paypal"},
            { iconCls: "fa fa-pied-piper"},
            { iconCls: "fa fa-pied-piper-alt"},
            { iconCls: "fa fa-pinterest"},
            { iconCls: "fa fa-pinterest-p"},
            { iconCls: "fa fa-pinterest-square"},
            { iconCls: "fa fa-product-hunt"},
            { iconCls: "fa fa-qq"},
            { iconCls: "fa fa-ra"},
            { iconCls: "fa fa-rebel"},
            { iconCls: "fa fa-reddit"},
            { iconCls: "fa fa-reddit-alien"},
            { iconCls: "fa fa-reddit-square"},
            { iconCls: "fa fa-renren"},
            { iconCls: "fa fa-safari"},
            { iconCls: "fa fa-scribd"},
            { iconCls: "fa fa-sellsy"},
            { iconCls: "fa fa-share-alt"},
            { iconCls: "fa fa-share-alt-square"},
            { iconCls: "fa fa-shirtsinbulk"},
            { iconCls: "fa fa-simplybuilt"},
            { iconCls: "fa fa-skyatlas"},
            { iconCls: "fa fa-skype"},
            { iconCls: "fa fa-slack"},
            { iconCls: "fa fa-slideshare"},
            { iconCls: "fa fa-soundcloud"},
            { iconCls: "fa fa-spotify"},
            { iconCls: "fa fa-stack-exchange"},
            { iconCls: "fa fa-stack-overflow"},
            { iconCls: "fa fa-steam"},
            { iconCls: "fa fa-steam-square"},
            { iconCls: "fa fa-stumbleupon"},
            { iconCls: "fa fa-stumbleupon-circle"},
            { iconCls: "fa fa-tencent-weibo"},
            { iconCls: "fa fa-trello"},
            { iconCls: "fa fa-tripadvisor"},
            { iconCls: "fa fa-tumblr"},
            { iconCls: "fa fa-tumblr-square"},
            { iconCls: "fa fa-twitch"},
            { iconCls: "fa fa-twitter"},
            { iconCls: "fa fa-twitter-square"},
            { iconCls: "fa fa-usb"},
            { iconCls: "fa fa-viacoin"},
            { iconCls: "fa fa-vimeo"},
            { iconCls: "fa fa-vimeo-square"},
            { iconCls: "fa fa-vine"},
            { iconCls: "fa fa-vk"},
            { iconCls: "fa fa-wechat"},
            { iconCls: "fa fa-weibo"},
            { iconCls: "fa fa-weixin"},
            { iconCls: "fa fa-whatsapp"},
            { iconCls: "fa fa-wikipedia-w"},
            { iconCls: "fa fa-windows"},
            { iconCls: "fa fa-wordpress"},
            { iconCls: "fa fa-xing"},
            { iconCls: "fa fa-xing-square"},
            { iconCls: "fa fa-y-combinator"},
            { iconCls: "fa fa-y-combinator-square"},
            { iconCls: "fa fa-yahoo"},
            { iconCls: "fa fa-yc"},
            { iconCls: "fa fa-yc-square"},
            { iconCls: "fa fa-yelp"},
            { iconCls: "fa fa-youtube"},
            { iconCls: "fa fa-youtube-play"},
            { iconCls: "fa fa-youtube-square"}
    ],chart=[
        { iconCls: "fa fa-area-chart"},
        { iconCls: "fa fa-bar-chart"},
        { iconCls: "fa fa-bar-chart-o"},
        { iconCls: "fa fa-line-chart"},
        { iconCls: "fa fa-pie-chart"}
    ],bit=
        [
        { iconCls: "fa fa-bitcoin"},
        { iconCls: "fa fa-btc"},
        { iconCls: "fa fa-cny"},
        { iconCls: "fa fa-dollar"},
        { iconCls: "fa fa-eur"},
        { iconCls: "fa fa-euro"},
        { iconCls: "fa fa-gbp"},
        { iconCls: "fa fa-gg"},
        { iconCls: "fa fa-gg-circle"},
        { iconCls: "fa fa-ils"},
        { iconCls: "fa fa-inr"},
        { iconCls: "fa fa-jpy"},
        { iconCls: "fa fa-krw"},
        { iconCls: "fa fa-money"},
        { iconCls: "fa fa-rmb"},
        { iconCls: "fa fa-rouble"},
        { iconCls: "fa fa-rub"},
        { iconCls: "fa fa-ruble"},
        { iconCls: "fa fa-rupee"},
        { iconCls: "fa fa-shekel"},
        { iconCls: "fa fa-sheqel"},
        { iconCls: "fa fa-try"},
        { iconCls: "fa fa-turkish-lira"},
        { iconCls: "fa fa-usd"},
        { iconCls: "fa fa-won"},
        { iconCls: "fa fa-yen"}
    ],text=[
        { iconCls: "fa fa-align-center"},
        { iconCls: "fa fa-align-justify"},
        { iconCls: "fa fa-align-left"},
        { iconCls: "fa fa-align-right"},
        { iconCls: "fa fa-bold"},
        { iconCls: "fa fa-chain"},
        { iconCls: "fa fa-chain-broken"},
        { iconCls: "fa fa-clipboard"},
        { iconCls: "fa fa-columns"},
        { iconCls: "fa fa-copy"},
        { iconCls: "fa fa-cut"},
        { iconCls: "fa fa-dedent"},
        { iconCls: "fa fa-eraser"},
        { iconCls: "fa fa-file"},
        { iconCls: "fa fa-file-o"},
        { iconCls: "fa fa-file-text"},
        { iconCls: "fa fa-file-text-o"},
        { iconCls: "fa fa-files-o"},
        { iconCls: "fa fa-floppy-o"},
        { iconCls: "fa fa-font"},
        { iconCls: "fa fa-header"},
        { iconCls: "fa fa-indent"},
        { iconCls: "fa fa-italic"},
        { iconCls: "fa fa-link"},
        { iconCls: "fa fa-list"},
        { iconCls: "fa fa-list-alt"},
        { iconCls: "fa fa-list-ol"},
        { iconCls: "fa fa-list-ul"},
        { iconCls: "fa fa-outdent"},
        { iconCls: "fa fa-paperclip"},
        { iconCls: "fa fa-paragraph"},
        { iconCls: "fa fa-paste"},
        { iconCls: "fa fa-repeat"},
        { iconCls: "fa fa-rotate-left"},
        { iconCls: "fa fa-rotate-right"},
        { iconCls: "fa fa-save"},
        { iconCls: "fa fa-scissors"},
        { iconCls: "fa fa-strikethrough"},
        { iconCls: "fa fa-subscript"},
        { iconCls: "fa fa-superscript"},
        { iconCls: "fa fa-table"},
        { iconCls: "fa fa-text-height"},
        { iconCls: "fa fa-text-width"},
        { iconCls: "fa fa-th"},
        { iconCls: "fa fa-th-large"},
        { iconCls: "fa fa-th-list"},
        { iconCls: "fa fa-underline"},
        { iconCls: "fa fa-undo"},
        { iconCls: "fa fa-unlink"}
    ],der=
        [
        { iconCls: "fa fa-angle-double-down"},
        { iconCls: "fa fa-angle-double-left"},
        { iconCls: "fa fa-angle-double-right"},
        { iconCls: "fa fa-angle-double-up"},
        { iconCls: "fa fa-angle-down"},
        { iconCls: "fa fa-angle-left"},
        { iconCls: "fa fa-angle-right"},
        { iconCls: "fa fa-angle-up"},
        { iconCls: "fa fa-arrow-circle-down"},
        { iconCls: "fa fa-arrow-circle-left"},
        { iconCls: "fa fa-arrow-circle-o-down"},
        { iconCls: "fa fa-arrow-circle-o-left"},
        { iconCls: "fa fa-arrow-circle-o-right"},
        { iconCls: "fa fa-arrow-circle-o-up"},
        { iconCls: "fa fa-arrow-circle-right"},
        { iconCls: "fa fa-arrow-circle-up"},
        { iconCls: "fa fa-arrow-down"},
        { iconCls: "fa fa-arrow-left"},
        { iconCls: "fa fa-arrow-right"},
        { iconCls: "fa fa-arrow-up"},
        { iconCls: "fa fa-arrows"},
        { iconCls: "fa fa-arrows-alt"},
        { iconCls: "fa fa-arrows-h"},
        { iconCls: "fa fa-arrows-v"},
        { iconCls: "fa fa-caret-down"},
        { iconCls: "fa fa-caret-left"},
        { iconCls: "fa fa-caret-right"},
        { iconCls: "fa fa-caret-square-o-down"},
        { iconCls: "fa fa-caret-square-o-left"},
        { iconCls: "fa fa-caret-square-o-right"},
        { iconCls: "fa fa-caret-square-o-up"},
        { iconCls: "fa fa-caret-up"},
        { iconCls: "fa fa-chevron-circle-down"},
        { iconCls: "fa fa-chevron-circle-left"},
        { iconCls: "fa fa-chevron-circle-right"},
        { iconCls: "fa fa-chevron-circle-up"},
        { iconCls: "fa fa-chevron-down"},
        { iconCls: "fa fa-chevron-left"},
        { iconCls: "fa fa-chevron-right"},
        { iconCls: "fa fa-chevron-up"},
        { iconCls: "fa fa-exchange"},
        { iconCls: "fa fa-hand-o-down"},
        { iconCls: "fa fa-hand-o-left"},
        { iconCls: "fa fa-hand-o-right"},
        { iconCls: "fa fa-hand-o-up"},
        { iconCls: "fa fa-long-arrow-down"},
        { iconCls: "fa fa-long-arrow-left"},
        { iconCls: "fa fa-long-arrow-right"},
        { iconCls: "fa fa-long-arrow-up"},
        { iconCls: "fa fa-toggle-down"},
        { iconCls: "fa fa-toggle-left"},
        { iconCls: "fa fa-toggle-right"},
        { iconCls: "fa fa-toggle-up"}
    ],vedio=[
        { iconCls: "fa fa-arrows-alt"},
        { iconCls: "fa fa-backward"},
        { iconCls: "fa fa-compress"},
        { iconCls: "fa fa-eject"},
        { iconCls: "fa fa-expand"},
        { iconCls: "fa fa-fast-backward"},
        { iconCls: "fa fa-fast-forward"},
        { iconCls: "fa fa-forward"},
        { iconCls: "fa fa-pause"},
        { iconCls: "fa fa-pause-circle"},
        { iconCls: "fa fa-pause-circle-o"},
        { iconCls: "fa fa-play"},
        { iconCls: "fa fa-play-circle"},
        { iconCls: "fa fa-play-circle-o"},
        { iconCls: "fa fa-random"},
        { iconCls: "fa fa-step-backward"},
        { iconCls: "fa fa-step-forward"},
        { iconCls: "fa fa-stop"},
        { iconCls: "fa fa-stop-circle"},
        { iconCls: "fa fa-stop-circle-o"},
        { iconCls: "fa fa-youtube-play"}
    ],cl=[{ iconCls: "fa fa-circle-o-notch"},
        { iconCls: "fa fa-cog"},
        { iconCls: "fa fa-gear"},
        { iconCls: "fa fa-refresh"},
        { iconCls: "fa fa-spinner"}
    ],cc=
        [
        { iconCls: "fa fa-cc-amex"},
        { iconCls: "fa fa-cc-diners-club"},
        { iconCls: "fa fa-cc-discover"},
        { iconCls: "fa fa-cc-jcb"},
        { iconCls: "fa fa-cc-mastercard"},
        { iconCls: "fa fa-cc-paypal"},
        { iconCls: "fa fa-cc-stripe"},
        { iconCls: "fa fa-cc-visa"},
        { iconCls: "fa fa-credit-card"},
        { iconCls: "fa fa-credit-card-alt"},
        { iconCls: "fa fa-google-wallet"},
        { iconCls: "fa fa-paypal"}
    ],forms=[
        { iconCls: "fa fa-check-square"},
        { iconCls: "fa fa-check-square-o"},
        { iconCls: "fa fa-circle"},
        { iconCls: "fa fa-circle-o"},
        { iconCls: "fa fa-dot-circle-o"},
        { iconCls: "fa fa-minus-square"},
        { iconCls: "fa fa-minus-square-o"},
        { iconCls: "fa fa-plus-square"},
        { iconCls: "fa fa-plus-square-o"},
        { iconCls: "fa fa-square"},
        { iconCls: "fa fa-square-o"},
    ],files=
        [
        { iconCls: "fa fa-file"},
        { iconCls: "fa fa-file-archive-o"},
        { iconCls: "fa fa-file-audio-o"},
        { iconCls: "fa fa-file-code-o"},
        { iconCls: "fa fa-file-excel-o"},
        { iconCls: "fa fa-file-image-o"},
        { iconCls: "fa fa-file-movie-o"},
        { iconCls: "fa fa-file-o"},
        { iconCls: "fa fa-file-pdf-o"},
        { iconCls: "fa fa-file-photo-o"},
        { iconCls: "fa fa-file-picture-o"},
        { iconCls: "fa fa-file-powerpoint-o"},
        { iconCls: "fa fa-file-sound-o"},
        { iconCls: "fa fa-file-text"},
        { iconCls: "fa fa-file-text-o"},
        { iconCls: "fa fa-file-video-o"},
        { iconCls: "fa fa-file-word-o"},
        { iconCls: "fa fa-file-zip-o"},
    ],sex=[
        { iconCls: "fa fa-genderless"},
        { iconCls: "fa fa-intersex"},
        { iconCls: "fa fa-mars"},
        { iconCls: "fa fa-mars-double"},
        { iconCls: "fa fa-mars-stroke"},
        { iconCls: "fa fa-mars-stroke-h"},
        { iconCls: "fa fa-mars-stroke-v"},
        { iconCls: "fa fa-mercury"},
        { iconCls: "fa fa-neuter"},
        { iconCls: "fa fa-transgender"},
        { iconCls: "fa fa-transgender-alt"},
        { iconCls: "fa fa-venus"},
        { iconCls: "fa fa-venus-double"},
        { iconCls: "fa fa-venus-mars"},
    ],car=[
        { iconCls: "fa fa-ambulance"},
        { iconCls: "fa fa-automobile"},
        { iconCls: "fa fa-bicycle"},
        { iconCls: "fa fa-bus"},
        { iconCls: "fa fa-cab"},
        { iconCls: "fa fa-car"},
        { iconCls: "fa fa-fighter-jet"},
        { iconCls: "fa fa-motorcycle"},
        { iconCls: "fa fa-plane"},
        { iconCls: "fa fa-rocket"},
        { iconCls: "fa fa-ship"},
        { iconCls: "fa fa-space-shuttle"},
        { iconCls: "fa fa-subway"},
        { iconCls: "fa fa-taxi"},
        { iconCls: "fa fa-train"},
        { iconCls: "fa fa-truck"},
        { iconCls: "fa fa-wheelchair"},
    ];

    $.extend($.easyui.icons, {
        html:html,hand:hand,mark:mark,chart:chart,bit:bit,text:text,der:der,
        vedio:vedio,cl:cl,cc:cc,forms:forms,files:files,sex:sex,car:car
    });

    $.easyui.iconStyles = [
        { name: "html", style: "html", size: "16", sort: 2 },
        { name: "hand", style: "hand", size: "16", sort: 14 },
        { name: "mark", style: "mark", size: "16", sort: 4 },
        { name: "chart", style: "chart", size: "16", sort: 1 },
        { name: "bit", style: "bit", size: "16", sort: 12 },
        { name: "text", style: "text", size: "16", sort: 3 },
        { name: "der", style: "der", size: "16", sort: 5 },
        { name: "vedio", style: "vedio", size: "16", sort: 6 },
        { name: "cl", style: "cl", size: "16", sort: 7 },
        { name: "cc", style: "cc", size: "16", sort: 8 },
        { name: "forms", style: "forms", size: "16", sort: 9 },
        { name: "files", style: "files", size: "16", sort: 10 },
        { name: "sex", style: "sex", size: "16", sort: 13 },
        { name: "car", style: "car", size: "16", sort: 11 }
    ];

})(jQuery);