var locURL = window.location.href;

if(locURL.includes("time")){
	alert("This is the time template");
} else if (locURL.includes("date")){
	alert("This is the date template");
} else {
	console.log("no alert");
};