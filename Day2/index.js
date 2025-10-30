// Soln 3
var arr = ["apple","fruits","banana"];
arr.push("orange");
console.log("soln 3")
console.log(arr); 

// Soln 4

arr.shift();
console.log("soln 4")
console.log(arr);

// Soln 5

var number = [1,2,3,4,7,6,7,8,9];
number[4] = 5;
console.log("soln 5");
console.log(number);



// Soln 6

var nums = [1,2,3,4,5,6,7];
var numsUpdate = nums.map(num => num +2);
console.log("soln 6")
console.log(numsUpdate);

// Soln 7

var rdmNo = [2,3,1,4,8,7];
for(var i=0;i<rdmNo.length-1;i++){
    for(var j=i+1;j<rdmNo.length;j++){
        if(rdmNo[i] > rdmNo[j]){
            //Swap
            var temp1 = rdmNo[j];
            rdmNo[j] = rdmNo[i];
            rdmNo[i] = temp1;
        }
    }
}
console.log("soln 7")
console.log(rdmNo);

// Soln 8

var temp = [1,2,3,4,5,6,7];
var rev = [];
for(var i=temp.length-1; i>=0; i--){
    rev.push(temp[i]);
}
console.log("soln 8");
console.log(rev);

// Soln 9

var sol9 = [1,2,3,4,5,6,7];
var specificNo = 4;
sol9.forEach((idx,number) => {if (number == specificNo) console.log(`soln 9 -> ${idx}`)});

