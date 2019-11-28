let tranz = [[0,1,2],[3,4,5],[6,7,8]]

const set = (id, nr) => {
    let fx
    let fy
    for (x=0; x<3; x++){
        for (y=0; y<3; y++){
            if (tranz[x][y]==nr){
                fx = x
                fy = y
            }
        }
    }
    fetch("http://192.168.100.29:8080/api/ttt/set?gameid="+id+"&x="+fx+"&y="+fy)
	refresh(id)
}

const refresh = (id) => {
    fetch("http://192.168.100.29:8080/api/ttt/getAll?gameid=" + id)
        .then(resp => resp.json())
        .then(resp => {
            console.log("Game table:")
            let array  = resp
            console.log(array)
            document.getElementById("main").innerHTML = "<div id='table'></div>"
            let cells = ["tl", "t", "tr", "ml", "m", "mr", "dl", "d", "dr"]
            for(n=0; n<9; n++){
                document.getElementById("table").innerHTML +=
                    "<div class='cell " + cells[n] + "' id='cell"+n+"'></div>"
            }
            for (j=0; j<3; j++){
                for (i=0; i<3; i++) {
                    if (array[j][i] != "NON") {
                        document.getElementById("cell"+tranz[j][i]).innerHTML = array[j][i]
                    } else {
                        document.getElementById("cell"+tranz[j][i]).innerHTML = " "
                    }
                }
            }
            document.getElementById("main").innerHTML +=
                "<a class='but' id='refresh'>Refresh</a>"
            const refreshBut = document.getElementById("refresh")
                .addEventListener("click", _ => refresh(id))
            const cel0 = document.getElementById("cell0")
                .addEventListener("click", _ => set(id, 0))
            const cel1 = document.getElementById("cell1")
                .addEventListener("click", _ => set(id, 1))
            const cel2 = document.getElementById("cell2")
                .addEventListener("click", _ => set(id, 2))
            const cel3 = document.getElementById("cell3")
                .addEventListener("click", _ => set(id, 3))
            const cel4 = document.getElementById("cell4")
                .addEventListener("click", _ => set(id, 4))
            const cel5 = document.getElementById("cell5")
                .addEventListener("click", _ => set(id, 5))
            const cel6 = document.getElementById("cell6")
                .addEventListener("click", _ => set(id, 6))
            const cel7 = document.getElementById("cell7")
                .addEventListener("click", _ => set(id, 7))
            const cel8 = document.getElementById("cell8")
                .addEventListener("click", _ => set(id, 8))
        })
}

const joinGame2 = () => {
    const id = document.getElementById("numberGameInput").value
    refresh(id);
}

const createGame = () => {
    fetch("http://192.168.100.29:8080/api/ttt/createGame")
        .then(resp => resp.json())
        .then(resp => {
            console.log("Game id:");
            console.log(resp);
        })
}

const joinGame = () => {
    document.getElementById("main").innerHTML = "<h1>Tic Tac Toe</h1>" +
        "<h3>Join Game</h3>" +
        "<input type='number' id='numberGameInput' placeholder='Game ID'>" +
        "</br>" +
        "<a class='but' id='joinGameSub'>Join Game!</a>"
    const joinGameSub = document.getElementById("joinGameSub")
    joinGameSub.addEventListener("click", _ => joinGame2())
}

const searchGame = () => {

}

const click = () => {
    document.getElementById("main").innerHTML = "<h1>Tic Tac Toe</h1>" +
        "<a class='but' id='createGameBut'>Create Game</a>" +
        "<a class='but' id='joinGameBut'>Join Game</a>" +
        "<a class='but' id='searchGameBut'>Search Game</a>"
    const createGameBut = document.getElementById("createGameBut")
    const joinGameBut = document.getElementById("joinGameBut")
    const searchGameBut = document.getElementById("searchGameBut")
    createGameBut.addEventListener("click", _ => createGame())
    joinGameBut.addEventListener("click", _ => joinGame())
    searchGameBut.addEventListener("click", _ => searchGame())
}

window.onload = () => {
    document.body.innerHTML += "<div id='main'></div>"
    document.getElementById("main").innerHTML = "<h1>Tic Tac Toe</h1>"
    document.getElementById("main").innerHTML += "<a class='but' id='but'>Play</a>"
    const but = document.getElementById("but")
    but.addEventListener("click", _ => click())
}