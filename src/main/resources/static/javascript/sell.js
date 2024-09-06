function getRecordByName(){
    element = document.getElementById('name').value;
   console.log(element);

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
                   temp += '<td style="text-align:center;"> Enter Sell Quantity<input type="text" id="'+itemData.id+'"><button class="\button sell"\ type="\submit"\ onclick="\sell(\'' + itemData.name + '\',\''+itemData.id+'\')"\>Sell</button></td>';
                   // temp +='<td>Enter add Quantity<input type="text" id="'+itemData.id+'">Enter price<input type="\text"\ id="'+itemData.name+'"><button type="\submit"\ onclick="\add(\'' + itemData.name + '\',\''+itemData.id+'\',\''+itemData.name+'\')"\>Add</button></td><tr>';
                   // temp +='<td>Enter add Quantity<input type="text" id="'+itemData.name+itemData.id+'">Enter price<input type="text" id="'+itemData.name+'"><button type="\submit"\ onclick="\add(\'' + itemData.name + '\',\''+itemData.id+'\')"\>Add</button></td><tr>';

                   
               });
             
               document.getElementById('data').innerHTML = temp;
           }
       )
   })

}  

async function sell(n, qa){

   console.log(qa);

  console.log(n); 

    q = document.getElementById(qa).value;

   console.log(q);
 let s = await fetch("http://localhost:8085/api/medicine/sellbyname/"+n+"/"+q, {
       method: "PUT"
   })

   s = await s.text();

   document.getElementById('sellh').innerHTML = s;
}