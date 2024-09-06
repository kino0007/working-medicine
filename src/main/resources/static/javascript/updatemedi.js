async function update(){
    nam = document.getElementById('n').value;
    sto = document.getElementById('st').value;
    pri = document.getElementById('pr').value;

    const requestOptions = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(
            { 
                name: nam,
                stock: sto,
                price: pri
            }
        )
    };

  let am = await fetch("http://localhost:8085/api/medicine/create", requestOptions)

  am = await am.json();
  console.log(am);
  if(am != null){
    document.getElementById('update').innerHTML = "Medicine is Added"
  }
}