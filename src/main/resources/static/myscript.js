var addbtn = document.getElementById("addBtn");
var removeBtn = document.getElementById("removeBtn");
var input = document.getElementById("addInput");
var list = document.getElementById("lists");
var dlt = document.getElementsByClassName('listIcon');

addbtn.addEventListener("click", keepItemList);
list.addEventListener("click", deleteItem);

let Todolist = []

function addItem(input) {
    let data = input;
    let listCeate = document.createElement("li");
    let listText = document.createTextNode(data.value);
    listCeate.appendChild(listText);
    list.appendChild(listCeate);
    //Close icon
    let iconD = document.createElement("div");
    iconD.classList.add("listIcon");
    let closeIcon = document.createElement("Button");
    closeIcon.classList.add("rBTN");
    closeIcon.innerText = "X";
    iconD.appendChild(closeIcon);
    listCeate.appendChild(iconD);
    //Clear Input 
    data.value = "";
}

async function keepItemList() {
    let data = input;
    let response = await postFormDataAsJson({ "item": data.value }, "/insertData");

    data_insert = { "item": data.value, "id": response["id"] };
    addItem(data)

    Todolist.push(data_insert);
    console.log(Todolist);
}

async function delItem(data) {
    let id = 0;
    for (let i = 0; i < Todolist.length; i++) {
        if (Todolist[i]["item"] == data) {
            id = Todolist[i]["id"];
            break;
        }
    }
    data_new = { "id": id };
    let Response = await postFormDataAsJson(data_new, "/deleteData");
}
//Delete Items
function deleteItem(t) {
    let item = t.target;
    console.log(item)
    if (item.classList[0]) {
        const list = item.parentElement;
        delItem(list.innerText.slice(0, list.innerText.length - 2));
        //animation
        list.classList.add('falling');
        list.addEventListener('transitionend', function() {
            //remove item
            this.remove();
        });
    };
};


// Hide List
removeBtn.addEventListener('click', function() {
    let rBox = document.getElementById('listHolder');
    rBox.classList.toggle("rBox");
});



async function postFormDataAsJson(data, endpt) {
    var url = window.location.origin + endpt;

    const formDataJsonString = JSON.stringify(data);
    console.log(formDataJsonString);
    const fetchOptions = {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
            Accept: "application/json",
        },
        body: formDataJsonString,
    };

    const response = await fetch(url, fetchOptions);

    //console.log(url)
    //console.log(response)
    if (!response.ok) {
        const errorMessage = await response.text();
        alert("invaid username or password")
        throw new Error(errorMessage);
        window.location.href; //reloads page if error is found
    }
    return response.json();
}

async function getDataAsJson() {
    var url = window.location.origin + "/getData";
    const fetchOptions = {
        method: "GET",
        headers: {
            "Content-Type": "application/json",
            Accept: "application/json",
        },
    };

    const response = await fetch(url, fetchOptions);

    //console.log(url)
    //console.log(response)
    if (!response.ok) {
        const errorMessage = await response.text();
        alert("unable to reach server");
        throw new Error(errorMessage);
        window.location.href; //reloads page if error is found
    }
    return response.json();
}

async function handle() {
    try {
        const responseData = await getDataAsJson();
        console.log(responseData);
        for (let i = 0; i < responseData.length; i++) {
            addItemOnload(responseData[i]["item"]);
            console.log(responseData[i]["item"]);
            data_new = { "item": responseData[i]["item"], "id": responseData[i]["id"] };
            Todolist.push(data_new);
        }
    } catch (error) {
        console.error(error);
    }
}

function addItemOnload(data) {
    let listCeate = document.createElement("li");
    let listText = document.createTextNode(data);
    listCeate.appendChild(listText);
    list.appendChild(listCeate);
    //Close icon
    let iconD = document.createElement("div");
    iconD.classList.add("listIcon");
    let closeIcon = document.createElement("Button");
    closeIcon.classList.add("rBTN");
    closeIcon.innerText = "X";
    iconD.appendChild(closeIcon);
    listCeate.appendChild(iconD);
    //Clear Input 
    data.value = "";
}

window.addEventListener("load", handle);