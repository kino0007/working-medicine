fetch("http://localhost:8085/api/medicine/getall").then(
    res => {
        res.json().then(
            data => {
                console.log(data.data);
                var temp = "";
                data.forEach((itemData) => {
                    temp += "<tr>";
                    temp += "<td>" + itemData.id + "</td>";
                    temp += "<td>" + itemData.name + "</td>";
                    temp += "<td>" + itemData.stock + "</td>";
                    temp += "<td>" + itemData.price + "</td></tr>";
                });
                document.getElementById('mdata').innerHTML = temp;
            }
        )
    })