// Soln 1
let sum = (a,b) => a + b;
console.log(sum(2,3));

// Soln 2
let greet = (name,message = 'Welcome') => { 
    console.log(`Hello ${name} ${message} to the CloudKeeper`);
};
greet("Manish");

// Soln 3
let formatString = (name,age) => {
    console.log(`Hello, my name is ${name} and i am ${age} year old.`);
}
formatString("manish",23);

// Soln 4
const person = {
    name : 'Alice',
    age : 25,
    address : {
        city : 'New York',
        country : 'NY'
    }
}

let fn = () => {
    let {name,address : {city}} = person;
    console.log(`${name} lives in ${city}.`);
}
fn();

// Soln 5
let sumAll = (...numbers) => {
    let sum = 0;
    for(let num of numbers){
        sum += num;
    }
    console.log(sum);
} 
sumAll(1,2,3,4,5,6,78,8,9);


// Soln 6
let filterEvens = (arr) => {
    return   arr.filter((el) => { return el% 2 == 0});
}
console.log(filterEvens([1,2,3,4,5,6]));

// Soln 7
let doubleValues = (arr) => {
    return arr.map((el) => { return el + el});
}
console.log(doubleValues([1,2,3]));

// Soln 8
let findMax = (arr) => {
    return Math.max(...arr);
}
console.log(findMax([1,2,3,4,5,6]));

// Soln 9
const data =[
  {
    name: "Bob",
    age: 24
  },
  {
    name: "Alice",
    age: 21
  }
]

let fn1 = () => {
    let [data1,data2] = data;
    return `${data2.name} age is ${data1.age}`;
}
console.log(fn1());

// Soln 10
let input =
[{
"id": 1,
"title": "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
"price": 109.95,
"description": "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
"category": "men's clothing",
"image": "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
"rating": {
"rate": 3.9,
"count": 120
}
}]

let fun10 = input.map((data) => {
  console.log(`${data.id}`);
  console.log(`${data.title}`);
  console.log(`${data.rating.rate}`);
  console.log(`${data.rating.count}`);
})
console.log(fun10);



// Soln 11
const fun = (name = "abc") => {
        if(name) {
          console.log("if", name);
        } else {
          console.log("else", name);
        }
      };
	  
fun(""); // else bcus empty string in Js is treated as false

// Soln 12
const obj = { a: 1, b: { c: 2 } };

// Deep Copy Using JSON
let deepClone = (obj) => {
  return JSON.parse(JSON.stringify(obj));
}

const clonedObj = deepClone(obj);
clonedObj.b.c = 42;
console.log(obj.b.c);

// Soln 13
flattenArray = [1, [2, [3, [4, 5]]]]
let fun13 = flattenArray.flat(Infinity);
console.log(fun13);