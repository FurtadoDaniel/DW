function validarTexto(id) {
    var texto = document.getElementById(id).value;

    if (!justLetters(texto) || texto.trim() == "") {
        alert(id + " inválido");
        return false;

    }

    return true;

}

function validarNum(id, tam) {
    var num = document.getElementById(id).value;

    if (!isNaN(num) ) {
        if (tam < 0 || num.length == tam) return true;

    }

    alert(id + " inválido");
    return false;

}

function justLetters(palavra) {
    return (/^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ\s ]+$/.test(palavra));
}

function checkEmpty() {
    console.log(document.forms["cliente"]);
    elements = document.forms["cliente"].elements
    for ( i=0; i<elements.length ; i++) {
        //console.log(elements[i]);
        if (elements[i].value == '') alert(elements[i].name+ " inválido");
    }
}
