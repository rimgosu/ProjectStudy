// 3) Tabs

var links = document.querySelectorAll('.tabs-list li a')
var items = document.querySelectorAll('.tabs-list li')
for (var i = 0; i < links.length; i++) {
    links[i].onclick = function(e) {
        e.preventDefault() ;
    }
}

for (var i = 0; i < items.length; i++) {
    items[i].onclick = function() {
        var tabId = this.querySelector("a").getAttribute('href') ;
        console.log(this.classList);
        document.querySelectorAll(".tabs-list li, .tabs div.tab").forEach(function(item) {
            item.classList.remove("active");
            console.log(item);
        });
        document.querySelector(tabId).classList.add("active");
        this.classList.add("active");
    }  
} 