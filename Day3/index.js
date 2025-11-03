(function(){

var container = document.getElementById('container');

function Product(name, category, price, imgUrl){
    this.name = name;
    this.category = category;
    this.price = price;
    this.imgUrl = imgUrl;
}

Product.prototype.getDiscountPrice = function (percent){
    return this.price - (this.price * percent/100);
}

// Product details 
var products = [
    new Product("Watch","Analog",5000,"https://images.unsplash.com/photo-1523170335258-f5ed11844a49?ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8d2F0Y2h8ZW58MHx8MHx8fDA%3D&auto=format&fit=crop&q=60&w=500"),
    new Product("Cap","Sport",1000,"https://images.unsplash.com/photo-1521369909029-2afed882baee?ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8Y2FwfGVufDB8fDB8fHww&auto=format&fit=crop&q=60&w=500"),
    new Product("Bike","Vehicle",500000,"https://images.unsplash.com/photo-1558981403-c5f9899a28bc?ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8YmlrZXxlbnwwfHwwfHx8MA%3D%3D&auto=format&fit=crop&q=60&w=500"),
    new Product("Shoe","Footwear",10000,"https://images.unsplash.com/photo-1606107557195-0e29a4b5b4aa?ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Nnx8c2hvZXxlbnwwfHwwfHx8MA%3D%3D&auto=format&fit=crop&q=60&w=500"),
]

//find costliest price 
var prices = products.map((p) => p.price);
var costliest = Math.max.apply(null,prices);
var heading = document.createElement('h1');
heading.innerText = 'Price of costliest product is ' + costliest;
document.body.insertBefore(heading,container);



products.map(item => {
    var card = document.createElement('div');

    card.innerHTML = `
        <img src=${item.imgUrl}>
        <h3>${item.name}</h3>
        <p>Category: ${item.category}</p>
        <p>Price: ₹${item.price}</p>
        <p>Discounted (10% off): ₹${item.getDiscountPrice(10)}</p>

    `
    card.addEventListener("mouseover",function() {
        card.style.transform = "scale(1.05)";
        card.style.boxShadow = "0px 8px 20px rgba(0, 0, 0, 0.3)";
        card.style.transition = "all 0.3s ease";
    });

    card.addEventListener("mouseout",function() {
        card.style.transform = "scale(1)";
        card.style.boxShadow = "none";
        card.style.backgroundColor = "#ffffffff"; 
    });

    container.appendChild(card);
})

})();



