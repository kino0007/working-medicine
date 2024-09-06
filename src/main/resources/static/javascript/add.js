function getRecordByName(){
    element = document.getElementById('name').value;
   fetch("http://localhost:8085/api/medicine/getlike/"+element).then(
   res => {
       res.json().then(
           data => {
               
               console.log(data.data);
               var temp = "";
               data.forEach((itemData) => {
                   temp += "<tr>";
                   temp += "<td>" + itemData.id + "</td>";
                   temp += "<td>" + itemData.name+ "</td>";
                   temp += "<td>" + itemData.stock + "</td>";
                   temp += "<td>" + itemData.price + "</td>";
                   //  temp += '<td> Enter Sell Quantity<input type="\text"\+c+ id="\quantity"\><button type="\submit"\ onclick="\sell(\'' + itemData.name + '\')"\>Sell</button></td>';
                   // temp += '<td> Enter Sell Quantity<input type="text" id="'+itemData.id+'"><button type="\submit"\ onclick="\sell(\'' + itemData.name + '\',\''+itemData.id+'\')"\>Sell</button></td>';
                   // temp +='<td>Enter add Quantity<input type="text" id="'+itemData.id+'">Enter price<input type="\text"\ id="'+itemData.name+'"><button type="\submit"\ onclick="\add(\'' + itemData.name + '\',\''+itemData.id+'\',\''+itemData.name+'\')"\>Add</button></td><tr>';
                   temp +='<td>Enter add Quantity<input type="text" id="'+itemData.name+itemData.id+'">Enter price<input type="text" id="'+itemData.name+'"><button class = "\add"\ type="\submit"\ onclick="\add(\'' + itemData.name + '\',\''+itemData.id+'\')"\>Add</button></td><tr>';

                   
               });
               
               document.getElementById('data').innerHTML = temp;
           }
       )
   })

}  

async function add(a, st){

   console.log("name-",a);
   console.log("id-",st);

   aq = document.getElementById(a+st).value;
   p = document.getElementById(a).value;
   console.log("addq",aq);
   console.log("price",p);

   const requestOptions = {
       method: 'PUT',
       headers: { 'Content-Type': 'application/json' },
       body: JSON.stringify(
           { 
               stock: aq,
               price: p
           }
       )
   };

 let ar = await fetch("http://localhost:8085/api/medicine/updatebyname/"+a, requestOptions)
   ar = await ar.text();
   console.log(ar);
   document.getElementById('addstock').innerHTML = ar;
}