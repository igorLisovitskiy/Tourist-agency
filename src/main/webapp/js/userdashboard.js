// Tabs

function openLink(evt, linkName) {
    var i, x, tablinks;
    x = document.getElementsByClassName("myLink");
    for (i = 0; i < x.length; i++) {
        x[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablink");
    for (i = 0; i < x.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" user-red", "");
    }
    document.getElementById(linkName).style.display = "block";
    evt.currentTarget.className += " user-red";
}

$(document).ready(function() {
// Click on the first tablink on load
document.getElementsByClassName("tablink")[0].click();


$('.input-daterange input').each(function() {
	 var date = new Date("2013-07-15");
	
	
    $(this).datepicker({
        maxDate: date,
        dateFormat: "mm.dd.yy"
    });
    
    
});
});
