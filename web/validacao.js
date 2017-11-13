function validarTexto(id) {
    var texto = document.getElementById(id).value;

    if (!justLetters(texto) || texto.trim() == "") {
        alert(id + " inválido");
        return false;

    }

    return true;

}

function validarNum(id) {
    var num = document.getElementById(id).value;

    if (!isNaN(num) && num.length > 0) return true;

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
