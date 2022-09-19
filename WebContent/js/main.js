window.onscroll = function() {
	if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
		document.getElementById("scroll_btn").style.display = "block";
	 } else {
		document.getElementById("scroll_btn").style.display = "none";
	 }
}

document.getElementById('scroll_btn').addEventListener("click", function(){
	 document.body.scrollTop = 0;
     document.documentElement.scrollTop = 0;
 });

console.log("main.js run success!");